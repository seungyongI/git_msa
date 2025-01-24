delimiter //
CREATE PROCEDURE GetAllActors()
BEGIN select * from actor;
END //
delimiter ;

CALL GetAllActors();

SHOW PROCEDURE STATUS WHERE DB = 'sakira';

SHOW CREATE PROCEDURE GetAllActors;

DROP PROCEDURE IF EXISTS GetAllActors;

-- 1번 고객의 최근 대여 정보 조회
-- 대여 날짜, 영화 제목, 대여 요금 포함
-- 대여 날짜 desc 정렬
-- limit 5
-- 고객 ID만으로 간편 조회 가능

DROP PROCEDURE IF EXISTS getCustomerInfo;

delimiter //
CREATE procedure GetRentalInfo(IN p_customer_id int)
begin
	select concat(c.first_name,' ', c.last_name) as name, r.rental_date, f.title, f.rental_rate
    from customer c
    inner join rental r on c.customer_id = r.customer_id
    inner join inventory i on r.inventory_id = i.inventory_id
    inner join film f on i.film_id = f.film_id
    where c.customer_id = p_customer_id
    order by r.rental_date desc
    limit 5;
    
end //
delimiter ;

call GetRentalInfo(1);

delimiter //
drop procedure if exists get_customer_rentals //
create procedure get_customer_rentals(
in p_customer_id int,
out p_rental_count int,
inout p_last_rental_date date)
begin
	-- 고객의 총 대여 횟수 계산
    select count(*) into p_rental_count
    from rental
    where customer_id = p_customer_id;
    
    -- 고객의 마지막 대여 날짜 조회
    select max(rental_date) into p_last_rental_date
    from rental
    where customer_id = p_customer_id;
    
    -- inout 매개변수 사용 예시: 더 최근 날짜 선택
    if p_last_rental_date is null or p_last_rental_date < curdate() then
		set p_last_rental_date = curdate();
	end if ;
end //
delimiter ;

-- 프로시저 호출부
set @in_customer_id = 1;
set @out_rental_count = 0;
set @inout_last_rental = '2000-01-01';

call get_customer_rentals(@in_customer_id, @out_rental_count, @inout_last_rental);

select @out_rental_count as total_rentals, @inout_last_rental as last_rental_date;

delimiter //
drop procedure if exists check_movie_price //
create procedure check_movie_price(in p_film_id int)
begin
	declare v_rental_rate decimal(4, 2);
	
	-- 영화 대여 가격 조회
	select rental_rate into v_rental_rate
	from film
	where film_id = p_film_id;
	
	-- 조건문 사용하여 메시지 출력
	if v_rental_rate < 1 then
	 select '저예산 영화' as movie_category;
	elseif v_rental_rate < 3 then
     select '일반 영화' as movie_category;
	else 
	 select '프리미엄 영화' as movie_category;
	end if;
end //
delimiter ;

call check_movie_price(1);

select rental_duration from film where film_id = 1;

-- 새로운 영화 정보 쉽게 추가
-- 모든 필수 영화 정보 (제목, 설명, 개봉연도, 언어, 대여 기간, 대여 요금, 길이, 교체 비용, 등급)를 포함
-- 데이터 무결성 유지 위해 데이터 타입과 제약 조건 준수
-- 새로 추가된 영화의 ID를 즉시 반환하여 후속 작업에 활용할 수 있게 한다.
	-- select last_insert_id() as new_film_id;
-- 프로시저를 통해 영화 추가 과정을 표준화하여 일관성 유지

insert into film(title, description, release_year, language_id, rental_rate, length, replacement_cost, rating)
values ("극한직업", "마약반 개그 영화", 2019, 1, 2.99, 111, 20.99, PG);

delimiter //
drop procedure if exists insert_movie //
create procedure insert_movie(
								in p_title varchar(128),
                                in p_description text,
                                in p_release_year year,
                                in p_language_id tinyint unsigned,
                                in p_rental_duration tinyint unsigned,
                                in p_rental_rate decimal(4, 2),
                                in p_length smallint unsigned,
                                in p_replacement_cost decimal(5, 2),
                                in p_rating enum('G', 'PG', 'PG-13', 'R', 'NC-17'))
begin
	insert into film(title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating)
	values (p_title, p_description, p_release_year, p_language_id, p_rental_duration, p_rental_rate, p_length, p_replacement_cost, p_rating);
    select last_insert_id() as new_film_id;
end //
delimiter ;

call insert_movie("극한직업", "마약반 개그 영화", 2019, 1, 5, 2.99, 111, 20.99, "PG");