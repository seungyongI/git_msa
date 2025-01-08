-- 각 매장 고객 수 계산, 고객 수 기준 내림차순 정렬
select store_id, count(store_id) as customer_count
from customer
group by store_id
order by customer_count desc;

-- 직원이 처리한 총 지불 금액 계산 후, 내림차순 정렬
select sum(amount) as total_payment, staff_id
from payment
group by staff_id
order by total_payment desc;

select avg(length) from film;

select f.title, f.length
from film f
where f.length < (select avg(length) from film);

select rental_date
from rental
where customer_id =1
order by rental_date desc;

select c.*, (select rental_date
 			 from rental
             where customer_id = c.customer_id
             order by rental_date desc
             limit 1) as '최신 대여 날짜'
from customer c
where customer_id = 1;

select c.name as category, count(*) as total_rentals
from rental r
inner join inventory i on r.inventory_id = i.inventory_id
inner join film f on i.film_id = f.film_id
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id
group by c.name
having total_rentals > (
select avg(rentals) from (select count(*) as rentals from rental r
						   inner join inventory i on r.inventory_id = i.inventory_id
						   inner join film f on i.film_id = f.film_id
						   inner join film_category fc on f.film_id = fc.film_id
						   group by fc.category_id) as subquery
);

create table table1(
id int,
name varchar(50)
);
create table table2(
id int,
name varchar(50)
);
create table table3(
id int,
name varchar(50)
);

insert into table1(id, name) values(1, 'a');
insert into table1(id, name) values(2, 'b');
insert into table1(id, name) values(3, 'c');

insert into table2(id, name) values(1, 'b');
insert into table2(id, name) values(1, 'b');
insert into table2(id, name) values(1, 'c');

insert into table3(id, name) values(3, 'b');
insert into table3(id, name) values(3, 'c');
insert into table3(id, name) values(4, 'c');

select * from table1 a inner join table2 b on a.id = b.id;

select * from table1 a inner join table3 c on a.id = c.id;

select c.email, f.title
from customer c
inner join rental r on c.customer_id = r.customer_id
inner join inventory i on r.inventory_id = i.inventory_id
inner join film f on f.film_id = i.film_id
order by c.email;

select c.last_name, c.first_name, c.email
from customer c
left join rental r on c.customer_id = r.customer_id
where r.customer_id is null;