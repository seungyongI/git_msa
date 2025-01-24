create table payment_test as select * from payment;



alter table payment_test
add column total_amount_with_tax decimal(10,2) as (amount * 1.1) stored,
add column payment_year int as (year(payment_date)) stored,
add column payment_month int as (month(payment_date)) stored;

select total_amount_with_tax, payment_date, payment_year, payment_month
from payment_test
limit 10;

select payment_year, payment_month, sum(total_amount_with_tax) as total_amount
from payment_test
group by payment_year, payment_month;

SELECT c.customer_id, c.first_name, c.last_name, a.address, ci.city, co.country
FROM customer c
    JOIN address a ON c.address_id = a.address_id
    JOIN city ci ON a.city_id = ci.city_id
    JOIN country co ON ci.country_id = co.country_id
WHERE c.last_name = 'SMITH';

create table denormal_customer as select c.customer_id, a.address, ci.city, co.country
FROM customer c
    JOIN address a ON c.address_id = a.address_id
    JOIN city ci ON a.city_id = ci.city_id
    JOIN country co ON ci.country_id = co.country_id;
    
alter table denormal_customer
add primary key(customer_id);

select * from denormal_customer;

set profiling = 1;
show profiles;

create table orders_test(order_id int not null,
customer_id int,
order_date date,
amount decimal(10, 2),
primary key (customer_id, order_date)
)
partition by range (to_days(order_date)) (
partition p1 values less than (to_days('2023-04-01')),
partition p2 values less than (to_days('2023-07-01')),
partition p3 values less than (to_days('2023-10-01')),
partition p4 values less than (to_days('2024-01-01')),
partition p5 values less than (to_days('9999-12-31'))
);

select partition_name, table_name, partition_ordinal_position, partition_method, subpartition_method, partition_description, partition_expression
from information_schema.partitions
where table_name = 'orders_test';

explain select * from orders_test where order_date <= '2023-07-01 00:00:00';