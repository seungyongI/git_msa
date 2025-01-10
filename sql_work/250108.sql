START transaction;
update inventory set last_update = now() where film_id = 1;
commit;
-- 2. 트랜젝션 2 시작
START transaction;
-- 4. film_actor 베타적 락 획득
update film_actor set last_update = now() where actor_id = 1;
-- 6. 트랜젝션 1 acotr 테이블 락으로 인해 대기
update actor set last_update = now() where actor_id = 1;
commit;

START transaction;
select * from film where film_id = 2 for update;
update film SET last_update = now() where film_id = 1;
commit;

SET session transaction isolation level read uncommitted;
start transaction;
update customer set last_name = "Smart" where customer_id = 1;
rollback;
commit;