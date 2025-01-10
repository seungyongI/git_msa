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

SET session transaction isolation level read committed;
select @@transaction_isolation;
start transaction;
update customer set last_name = "Jhonthn" where customer_id = 2;
commit;

SET session transaction isolation level repeatable read;
select @@transaction_isolation;
start transaction;
insert into film (title, description, release_year, language_id, rental_duration,
				rental_rate, length, replacement_cost, rating)
values ("New Movie2", "A brand new movie", 2023, 1, 3, 0.99, 120, 19.99, 'PG');
commit;

SET session transaction isolation level serializable;
select @@transaction_isolation;
start transaction;
insert into rental (rental_date, inventory_id, customer_id, staff_id)
values (NOW(), 1, 1, 1);
commit;