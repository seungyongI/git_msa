-- 베타적 락을 이용해서 동시 업데이트 제어
START transaction;
select * from film where film_id = 1 for update;
update film SET title = "공룡학교" where film_id = 1;
commit;

-- 공유 락을 이용한 다른 세션 읽기
START transaction;
select * from inventory where film_id = 1 for share;
select sleep(10);
commit;

-- deadlock 실험1
-- 데드락 자동 감지 비활성화(off)
set global innodb_deadlock_detect = off;
-- 1. 트랜젝션 1 시작
START transaction;
-- 3. actor 베타적 락 획득
update actor set last_update = now() where actor_id = 1;
-- 5. 트랜젝션 2 film_actor 테이블 락으로 인해 대기
update film_actor set last_update = now() where actor_id = 1;
commit;

show processlist;

-- deadlock 실험2
START transaction;
select * from film where film_id = 1 for update;
update film SET last_update = now() where film_id = 2;
commit;

-- isolation level 실험1
SET session transaction isolation level read uncommitted;
start transaction;
select first_name, last_name from customer where customer_id = 1;
commit;

-- isolation level 실험2
SET session transaction isolation level read committed;
select @@transaction_isolation;
start transaction;
select first_name, last_name from customer where customer_id = 2;
commit;

-- isolation level 실험3
SET session transaction isolation level repeatable read;
select @@transaction_isolation;
start transaction;
select film_id, title, rental_rate from film where rental_rate = 0.99 order by film_id desc;
commit;

-- isolation level 실험4
SET session transaction isolation level serializable;
select @@transaction_isolation;
start transaction;
select count(*) from rental where return_date is null;
commit;
