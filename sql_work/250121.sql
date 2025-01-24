-- 함수 기반 인덱스
create index idx_customer_last_name_upper on customer((upper(last_name)));
drop index idx_customer_last_name_upper on customer;

show index from customer;

explain
select *
from customer
where upper(last_name) = 'SMITH';

-- 정렬 인덱스
create index idx_payment_amount_date on payment(amount asc, payment_date desc);
drop index idx_payment_amount_date on payment;

explain
select *
from payment
order by amount asc, payment_date desc limit 10;

create index idx_film_length_title on film((length(title)));
drop index idx_film_length_title on film;

explain
select film_id, title
from film
where length(title) between 10 and 11;

create index idx_rental_rate_duration on film(film_id, rental_rate desc, rental_duration asc, title);
drop index idx_rental_rate_duration on film;

explain
select f.title, f.rental_rate, f.rental_duration, count(f.film_id)
from film f use index for join(idx_rental_rate_duration)
join inventory i on f.film_id = i.film_id
join rental r on i.inventory_id = r.inventory_id
group by f.film_id
order by f.rental_rate desc, f.rental_duration asc;


-- 카디널리티

-- 개선 전 쿼리
explain
select f.title, f.release_year
from film f
join film_actor fa on f.film_id = fa.film_id
join actor a on fa.actor_id = a.actor_id
where a.first_name = 'PENELOPE' and a.last_name = 'GUINESS';

-- 카디널리티 분석 : 복합인덱스의 경우 높은 카디널리티 칼럼부터 사용
select count(distinct first_name) as first_count, count(distinct last_name) as last_count
from actor;

create index idx_first_last on actor(first_name, last_name);
drop index idx_first_last on actor;
show index from actor;

-- 개선 후 쿼리
explain
select f.title, f.release_year
from film f
join film_actor fa on f.film_id = fa.film_id
join actor a on fa.actor_id = a.actor_id
where a.first_name = 'PENELOPE' and a.last_name = 'GUINESS';

-- 카디널리티 분석 후 쿼리 향상
show index from payment;

select count(distinct customer_id), count(distinct payment_date) from payment;

create index idx_customer_payment_date on payment(customer_id, payment_date desc);
drop index idx_customer_payment_date on payment;

explain
select payment_id, customer_id, payment_date, amount
from payment
where customer_id = 1
order by payment_date desc;

create index idx_customer_id_rental on rental(customer_id, rental_date, return_date);
drop index idx_customer_id_rental on rental;

explain
select rental_id, rental_date, return_date
from rental force index(idx_customer_id_rental)
where customer_id = 1;

create index idx_customer_id on payment(customer_id);
drop index idx_customer_id on payment;

explain
select customer_id, sum(amount) as total_amount
from payment use index for group by(idx_customer_id)
group by customer_id;

create index idx_first_name on customer(first_name);
create index idx_last_name on customer(last_name);

-- using intersection(first_name, last_name) 인덱스 모두 사용
explain
select * from customer
where first_name = 'MARY' and last_name = 'SMITH';

show index from rental;

drop index idx_first_name on customer;
drop index idx_last_name on customer;

create index idx_rental_date on rental(rental_date);
create index idx_customer_id on rental(customer_id);

-- using union(rental_date, customer_id) 인덱스 각각 사용하여 결과 찾은 후 병합
explain
select * from rental
where rental_date = '2005-05-25' or customer_id = 1;

create index idx_rental_date on rental(rental_date);

explain select * from rental
where (rental_date = '2024-06-20 19:48:26' and inventory_id = 3849)
or staff_id = 1;

drop index idx_rental_date on rental;