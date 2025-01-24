set profiling = 1;
show profiles;
-- RANGE 파티션
create table orders_test(
order_id int not null,
customer_id int,
order_date date,
amount decimal(10, 2),
primary key (customer_id, order_date)
)
partition by range (TO_DAYS(order_date)) (
partition p1 values less than (to_days('2023-04-01')),
partition p2 values less than (to_days('2023-07-01')),
partition p3 values less than (to_days('2023-10-01')),
partition p4 values less than (to_days('2024-01-01')),
partition p5 values less than (to_days('9999-12-31'))
);

explain
select *
from orders_test
where order_date < '2023-04-30 23:59:59' and order_date > '2023-04-01 23:59:59';

explain
select *
from orders_test
where order_date = '2023-04-01 00:00:00';

-- LIST 파티션
DROP TABLE IF EXISTS customers_test;
CREATE TABLE customers_test (
customer_id int not null,
customer_name varchar(100),
region varchar(50),
primary key (customer_id, region)
)
PARTITION BY LIST COLUMNS (region) (
partition pNorthAmerica values in ('미국', '캐나다'),
partition pEurope values in ('영국', '프랑스', '독일'),
partition pAsia values in ('한국', '일본', '중국'),
partition pOther values in ('기타')
);

explain
select *
from customers_test
where region = '한국';

-- hash 파티션
DROP TABLE customers_test;
create table customers_test (
	customer_id int not null,
	first_name varchar(50),
	last_name varchar(50),
	email varchar(100),
	registration_date date,
	primary key (customer_id, registration_date)
)
-- partition by hash (customer_id)
partition by hash (customer_id % 4)
-- partition by hash (customer_id + TO_DAYS(registration_date))
partitions 4;

explain
select *
from customers_test
where customer_id = 2;

-- key 파티션
DROP TABLE customers_test;
create table customers_test(
	customer_id int not null,
	first_name varchar(50),
	last_name varchar(50),
	email varchar(100),
	registration_date date,
	primary key (customer_id)
)
partition by key (customer_id)
partitions 4;

explain
select *
from customers_test
where customer_id = 4;

-- columns 파티션

-- range columns partition
DROP TABLE customers_test;
CREATE TABLE customers_test (
	customer_id int not null,
	first_name varchar(50),
	last_name varchar(50),
	email varchar(100),
	registration_date date,
	primary key (customer_id, registration_date)
)
partition by range columns (customer_id, registration_date) (
partition p1 values less than (10000, '2023-01-01'),
partition p2 values less than (20000, '2024-01-01'),
partition p3 values less than (30000, '2025-01-01'),
partition p4 values less than (40000, '2026-01-01')
);

insert into customers_test values (10000, 'aa', 'aa', 'a@a', '2023-03-05');
insert into customers_test values (19999, 'aa', 'aa', 'a@a', '2024-03-05');
insert into customers_test values (39999, 'aa', 'aa', 'a@a', '2027-06-05');
insert into customers_test values (23456, 'aa', 'aa', 'a@a', '2025-06-05');
insert into customers_test values (32399, 'aa', 'aa', 'a@a', '2022-06-05');
insert into customers_test values (32599, 'aa', 'aa', 'a@a', '2028-06-05');


explain
select *
from customers_test
where customer_id = 10000;

-- list columns partition
DROP TABLE IF EXISTS customers_test;
CREATE TABLE customers_test (
customer_id int not null,
customer_name varchar(100),
region varchar(50),
customer_type varchar(50),
primary key (region, customer_type)
)
PARTITION BY LIST COLUMNS (region, customer_type) (
partition pNorthAmerica values in (('USA', 'Retail'), ('Canada', 'Retail')),
partition pEurope values in (('UK', 'Retail'), ('France', 'Retail')),
partition pAsia values in (('Japan', 'Wholesale'), ('China', 'Wholesale')),
partition pOther values in (('Other', 'Other'))
);

insert into customers_test values (1, 'a', 'France', 'Retail');
insert into customers_test values (2, 'b', 'China', 'Wholesale');
insert into customers_test values (3, 'c', 'USA', 'Retail');

explain
select * 
from customers_test
where region = 'USA';

-- payment 테이블 복사 후 range 파티셔닝
DROP TABLE payment_part;
CREATE TABLE payment_part (
    payment_id int not null,
    customer_id int,
    staff_id int,
    rental_id INT,
    amount DECIMAL(5,2),
    payment_date DATETIME,
    last_update TIMESTAMP,
    PRIMARY KEY (payment_id, payment_date)
)
partition by range (year(payment_date)) (
partition p1 values less than (2005),
partition p2 values less than (2006),
partition p3 values less than (2007),
partition p4 values less than (maxvalue)
);

insert into payment_part select * from payment;

explain
select *
from payment_part
where payment_id = 5;