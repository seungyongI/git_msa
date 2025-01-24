DELIMITER //

DROP PROCEDURE IF EXISTS example_procedure //
CREATE PROCEDURE example_procedure()
BEGIN
	DECLARE CONTINUE HANDLER FOR SQLSTATE '23000'
	BEGIN
		-- 중복 키 오류 처리
		SELECT 'Duplicate key error occurred' AS message;
	END;
	
	DECLARE EXIT HANDLER FOR SQLEXCEPTION
	BEGIN
		-- 기타 SQL 예외 처리
		SELECT 'An SQL exception occurred' AS message;
		-- 필요한 경우 롤백
		ROLLBACK;
	END;
	
	-- 프로시저 본문
	-- ...
	SIGNAL SQLSTATE '23000';
	select '...';
	SIGNAL SQLSTATE '23001';
END //

DELIMITER ;

call example_procedure();


CREATE TABLE `error_log` (
  `error_log_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT COMMENT '에러 로그 ID',
  `proc_name` varchar(100) NOT NULL COMMENT '프로시저 이름',
  `proc_step` tinyint(3) unsigned NOT NULL COMMENT '프로시저 내에서 에러가 발생한 스텝 번호',
  `sql_state` varchar(5) NOT NULL COMMENT 'SQLSTATE',
  `error_no` int(11) NOT NULL COMMENT '에러 번호',
  `error_msg` text NOT NULL COMMENT '에러 메세지',
  `call_stack` text COMMENT '프로시저 호출 파라미터',
  `proc_call_date` datetime NOT NULL COMMENT '프로시저 호출 일자',
  `log_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '로그 적재 일자',
  PRIMARY KEY (`error_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='DB 런타임 에러 로그';

-- --------------------------
-- 영화 대여 프로시저
-- --------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS rent_movie //
CREATE PROCEDURE rent_movie(IN p_customer_id INT, IN p_film_id INT)
BEGIN
    DECLARE v_inventory_id INT;
    DECLARE v_rental_count INT;
    DECLARE v_rental_limit INT DEFAULT 5;
  
    -- 대여 한도 초과 핸들러
    DECLARE EXIT HANDLER FOR SQLSTATE '45000'
    BEGIN
        INSERT INTO error_log (proc_name, proc_step, sql_state, error_no, error_msg, call_stack, proc_call_date)
        VALUES ('rent_movie', 1, '45000', 50000, 'Customer has exceeded their rental limit', 
                CONCAT('Customer ID: ', p_customer_id, ', Film ID: ', p_film_id),
                NOW());
        
        SELECT 'Customer has exceeded their rental limit' AS error_message;
    END;

    -- 재고 부족 핸들러
    DECLARE EXIT HANDLER FOR SQLSTATE '45001'
    BEGIN
        INSERT INTO error_log (proc_name, proc_step, sql_state, error_no, error_msg, call_stack, proc_call_date)
        VALUES ('rent_movie', 2, '45001', 50001, 'Requested film is out of stock', 
                CONCAT('Customer ID: ', p_customer_id, ', Film ID: ', p_film_id),
                NOW());
        
        SELECT 'Requested film is out of stock' AS error_message;
    END;

    -- 기타 SQL 예외 핸들러
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        GET DIAGNOSTICS CONDITION 1
            @sqlstate = RETURNED_SQLSTATE, @errno = MYSQL_ERRNO, @text = MESSAGE_TEXT;
        
        INSERT INTO error_log (proc_name, proc_step, sql_state, error_no, error_msg, call_stack, proc_call_date)
        VALUES ('rent_movie', 0, @sqlstate, @errno, @text, 
                CONCAT('Customer ID: ', p_customer_id, ', Film ID: ', p_film_id),
                NOW());
        
        SELECT @text AS error_message;
    END;

    -- 고객의 현재 대여 수 확인
    SELECT COUNT(*) INTO v_rental_count
    FROM rental
    WHERE customer_id = p_customer_id AND return_date IS NULL;

    -- 대여 한도 확인
    IF v_rental_count >= v_rental_limit THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Customer has exceeded their rental limit';
    END IF;

    -- 재고 확인 및 선택
    SELECT inventory_id INTO v_inventory_id
    FROM inventory
    WHERE film_id = p_film_id AND inventory_id NOT IN (
        SELECT inventory_id FROM rental WHERE return_date IS NULL
    )
    LIMIT 1;

    -- 재고 부족 확인
    IF v_inventory_id IS NULL THEN
        SIGNAL SQLSTATE '45001'
            SET MESSAGE_TEXT = 'Requested film is out of stock';
    END IF;

    -- 대여 처리
    INSERT INTO rental (rental_date, inventory_id, customer_id, staff_id)
    VALUES (NOW(), v_inventory_id, p_customer_id, 1);

    SELECT 'Movie rented successfully' AS result;
END //

DELIMITER ;


-- --------------------------
-- 테스트 : 프로시저 호출
-- --------------------------
-- 정상 대여 테스트
CALL rent_movie(1, 1);

-- 대여 한도 초과 테스트 (같은 고객으로 여러 번 호출)
CALL rent_movie(1, 2);
CALL rent_movie(1, 3);
CALL rent_movie(1, 4);
CALL rent_movie(1, 5);
CALL rent_movie(1, 6);

-- 재고 부족 테스트 (존재하지 않는 film_id 사용)
CALL rent_movie(2, 1000000000);

-- 기타 sql 테스트
CALL rent_movie(0, 6);
CALL rent_movie(-1, 6);

-- 에러 로그 확인
SELECT * FROM error_log order by error_log_id desc;

-- 대여 상태 조회 및 삭제
select * from rental where customer_id=1 and return_date is null;
delete from rental where customer_id=1 and return_date is null;



-- ==============================================================

-- --------------------------
-- 영화 대여 프로시저
-- --------------------------
DELIMITER //
DROP PROCEDURE IF EXISTS rent_movie //
CREATE PROCEDURE rent_movie(IN p_customer_id INT, IN p_film_id INT)
BEGIN
    DECLARE v_inventory_id INT;
    DECLARE v_rental_count INT;
    DECLARE v_rental_limit INT DEFAULT 5;
  
    -- 공통 오류 핸들러
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        GET DIAGNOSTICS CONDITION 1
            @sqlstate = RETURNED_SQLSTATE, @errno = MYSQL_ERRNO, @text = MESSAGE_TEXT;
        
        INSERT INTO error_log (proc_name, proc_step, sql_state, error_no, error_msg, call_stack, proc_call_date)
        VALUES ('rent_movie', 
                CASE 
                    WHEN @errno = 50000 THEN 1  -- 대여 한도 초과
                    WHEN @errno = 50001 THEN 2  -- 재고 부족
                    ELSE 0
                END, 
                @sqlstate, @errno, @text, 
                CONCAT('Customer ID: ', p_customer_id, ', Film ID: ', p_film_id),
                NOW());
        
        -- 오류 메시지 반환 및 프로시저 종료
        CASE @sqlstate
            WHEN '45000' THEN
                -- 대여 한도 초과 처리
                SELECT 'Rental limit exceeded' AS error_message;
            WHEN '45001' THEN
                -- 다른 사용자 정의 오류 처리
                SELECT 'Other custom error' AS error_message;
            ELSE
                -- 기본 오류 처리
                SELECT CONCAT('Unexpected error: ', @text) AS error_message;
        END CASE;
    END;

    -- 고객의 현재 대여 수 확인
    SELECT COUNT(*) INTO v_rental_count
    FROM rental
    WHERE customer_id = p_customer_id AND return_date IS NULL;

    -- 대여 한도 확인
    IF v_rental_count >= v_rental_limit THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Customer has exceeded their rental limit',
                MYSQL_ERRNO = 50000;
    END IF;

    -- 재고 확인 및 선택
    SELECT inventory_id INTO v_inventory_id
    FROM inventory
    WHERE film_id = p_film_id AND inventory_id NOT IN (
        SELECT inventory_id FROM rental WHERE return_date IS NULL
    )
    LIMIT 1;

    -- 재고 부족 확인
    IF v_inventory_id IS NULL THEN
        SIGNAL SQLSTATE '45001'
            SET MESSAGE_TEXT = 'Requested film is out of stock',
                MYSQL_ERRNO = 50001;
    END IF;

    -- 대여 처리
    INSERT INTO rental (rental_date, inventory_id, customer_id, staff_id)
    VALUES (NOW(), v_inventory_id, p_customer_id, 1);

    SELECT 'Movie rented successfully' AS result;
END //

DELIMITER ;
-- --------------------------
-- 테스트 : 프로시저 호출
-- --------------------------
-- 정상 대여 테스트
CALL rent_movie(1, 1);

-- 대여 한도 초과 테스트 (같은 고객으로 여러 번 호출)
CALL rent_movie(1, 2);
CALL rent_movie(1, 3);
CALL rent_movie(1, 4);
CALL rent_movie(1, 5);
CALL rent_movie(1, 6);

-- 재고 부족 테스트 (존재하지 않는 film_id 사용)
CALL rent_movie(2, 1000000000);

-- 에러 로그 확인
SELECT * FROM error_log order by error_log_id desc;

-- 대여 상태 조회 및 삭제
select * from rental where customer_id=1 and return_date is null;
delete from rental where customer_id=1 and return_date is null;

-- 5년 이상 된 대여 기록을 매주 아카이브 테이블(rental_archive)로 이동
-- 메인 rental 테이블에서 오래된 기록 삭제
-- rental_archive 테이블은 rental 테이블 구조와 동일하고
-- 아카이브 등록일(archived_date)칼럼을 추가한다.

CREATE TABLE rental_archive LIKE rental;
ALTER TABLE rental_archive ADD archived_date datetime;

SHOW VARIABLES LIKE 'event_scheduler';
SET GLOBAL event_scheduler = ON;

DELIMITER // 
CREATE EVENT weekly_rental_archive
ON SCHEDULE EVERY 1 WEEK
STARTS CURRENT_TIMESTAMP
DO
BEGIN
	INSERT INTO rental_archive SELECT *, NOW() AS archived_date FROM rental WHERE rental_date < DATE_SUB(NOW(), INTERVAL 5 YEAR);
	DELETE FROM rental WHERE rental_date < DATE_SUB(NOW(), INTERVAL 5 YEAR);
END //
DELIMITER ;

SELECT * FROM rental_archive;