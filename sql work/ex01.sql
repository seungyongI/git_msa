create database madangdb;

use madangdb;

CREATE TABLE Book (
    bookid INTEGER PRIMARY KEY,
    bookname VARCHAR(40),
    publisher VARCHAR(40),
    price INTEGER
);

CREATE TABLE Customer (
    custid INTEGER PRIMARY KEY,
    name VARCHAR(40),
    address VARCHAR(50),
    phone VARCHAR(20)
);

CREATE TABLE Orders (
    orderid INTEGER PRIMARY KEY,
    custid INTEGER,
    bookid INTEGER,
    saleprice INTEGER,
    orderdate DATE,
    FOREIGN KEY (custid)
        REFERENCES Customer (custid),
    FOREIGN KEY (bookid)
        REFERENCES Book (bookid)
);

INSERT INTO Book VALUES(1, '축구의 역사', '굿스포츠', 7000);
INSERT INTO Book VALUES(2, '축구 아는 여자', '나무수', 13000);
INSERT INTO Book VALUES(3, '축구의 이해', '대한미디어', 22000);
INSERT INTO Book VALUES(4, '골프 바이플', '대한미디어', 35000);
INSERT INTO Book VALUES(5, '피겨 교본', '굿스포츠', 8000);
INSERT INTO Book VALUES(6, '배구 단계별기술', '굿스포츠', 6000);
INSERT INTO Book VALUES(7, '야구의 추억', '이상미디어', 20000);
INSERT INTO Book VALUES(8, '야구를 부탁해', '이상미디어', 13000);
INSERT INTO Book VALUES(9, '올림픽 이야기', '삼성당', 7500);
INSERT INTO Book VALUES(10, 'Olympic Champions', 'Pearson', 13000);

select * from book;

insert into Customer values(1, '박지성', '영국 맨체스타', '000-5000-0001');
insert into Customer values(2, '김연아', '대한민국 서울', '000-6000-0001');
insert into Customer values(3, '김연경', '대한민국 경기도', '000-7000-0001');
insert into Customer values(4, '추신수', '미국 클리블랜드', '000-8000-0001');
insert into Customer values(5, '박세리', '대한민국 대전', null);

select * from Customer;

INSERT INTO Orders VALUES (1, 1, 1, 6000, STR_TO_DATE('2024-07-01','%Y-%m-%d'));
INSERT INTO Orders VALUES (2, 1, 3, 21000, STR_TO_DATE('2024-07-03','%Y-%m-%d'));
INSERT INTO Orders VALUES (3, 2, 5, 8000, STR_TO_DATE('2024-07-03','%Y-%m-%d'));
INSERT INTO Orders VALUES (4, 3, 6, 6000, STR_TO_DATE('2024-07-04','%Y-%m-%d'));
INSERT INTO Orders VALUES (5, 4, 7, 20000, STR_TO_DATE('2024-07-05','%Y-%m-%d'));
INSERT INTO Orders VALUES (6, 1, 2, 12000, STR_TO_DATE('2024-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (7, 4, 8, 13000, STR_TO_DATE( '2024-07-07','%Y-%m-%d'));
INSERT INTO Orders VALUES (8, 3, 10, 12000, STR_TO_DATE('2024-07-08','%Y-%m-%d'));
INSERT INTO Orders VALUES (9, 2, 10, 7000, STR_TO_DATE('2024-07-09','%Y-%m-%d'));
INSERT INTO Orders VALUES (10, 3, 8, 13000, STR_TO_DATE('2024-07-10','%Y-%m-%d'));

select * from Orders;

select * from test.student; /*다른 데이터베이스에 있는 테이블도 볼 수 있음*/

-- 원하는 칼럼 보기
SELECT 
    bookname, publisher
FROM
    Book;
    
SELECT 
    name, address
FROM
    Customer;

-- where 써서 필터링 걸어서 찾기

-- 어디든 축구만 있으면 찾음
SELECT 
    bookname, publisher
FROM
    Book
WHERE
    bookname LIKE '%축구%'
-- 축구의 역사만 찾음
SELECT 
    bookname, publisher
FROM
    Book
WHERE
    bookname LIKE '축구의 역사'
-- 앞에 축구라는 단어가 있으면 찾음
SELECT 
    bookname, publisher
FROM
    Book
WHERE
    bookname LIKE '축구%'
-- 뒤에 축구라는 단어가 있으면 찾음
SELECT 
    bookname, publisher
FROM
    Book
WHERE
    bookname LIKE '%축구'

set global general_log = 1;
set global log_output = 'table';

SELECT 
    *
FROM
    mysql.general_log;

SELECT 
    phone
FROM
    customer
WHERE
    name LIKE '김연아';
    
SELECT 
    name, phone
FROM
    customer
WHERE
    name LIKE '김연아';
    
SELECT 
    name, phone
FROM
    customer;
    
SELECT 
    name, phone, address
FROM
    customer
WHERE
    name LIKE '김연아';

SELECT 
    publisher, bookname
FROM
    book
WHERE
    price >= 10000;
    
SELECT 
    custid
FROM
    orders
WHERE
    saleprice >= 10000;
    
SELECT 
    custid, orderdate
FROM
    orders
WHERE
    saleprice >= 10000;
    
SELECT 
    custid, saleprice
FROM
    orders
WHERE
    orderdate BETWEEN '2024-07-05' AND '2024-07-08'; 

SELECT 
    name
FROM
    customer
WHERE
    address LIKE '%대한민국%';
    
SELECT 
    publisher, bookname
FROM
    book
WHERE
    price >= 10000 && price <= 20000;
    
SELECT 
    publisher, bookname
FROM
    book
WHERE
    price >= 10000 AND price <= 20000;
    
SELECT 
    name
FROM
    customer
WHERE
    phone LIKE '%0001%';
    
SELECT 
    name
FROM
    customer
WHERE
    phone IS NULL;
    
SELECT 
    name
FROM
    customer
WHERE
    phone IS NOT NULL;

select orderid 
from orders 
where bookid <= 5;

select publisher
from book;
-- 중복 빼고 
select distinct publisher
from book;

select name 
from customer
where phone is null;

select bookname
from book
where publisher like '굿스포츠' and price between 10000 and 20000;

select bookname,price
from book
where publisher like '이상미디어' and price between 10000 and 20000;

select *
from book
where publisher like '굿스포츠' and price between 10000 and 20000;

select *
from book
where (publisher like '굿스포츠') or (publisher like '대한미디어');

select *
from book
where publisher like '굿스포츠' || publisher like '대한미디어';

select *
from book
where publisher in ('굿스포츠','대한미디어');

select * 
from book
where publisher not in ('굿스포츠','대한미디어');

select * from book;

update book
set bookname='그 여자의 축구'
where bookid=2;

select * from book;

update book
set price=7000
where bookid=1;

select * from book;

select *
from book
where bookname like '_구%';

delete 
from book
where bookid=2;

select * from book;

select *
from book
order by bookname;

select *
from customer
order by address;

select *
from book
order by bookname desc;

select *
from customer
order by name;

select *
from customer
order by phone;

select *
from orders
order by saleprice;

select *
from book
order by price;

select *
from book
order by price desc,bookname;

select sum(saleprice) from orders; 

select avg(saleprice) from orders;

select count(saleprice) from orders;

select max(saleprice) from orders;

select min(saleprice) from orders;

select price as '판매가격' from book;

SELECT 
    SUM(saleprice) AS total,
    AVG(saleprice) AS average,
    MAX(saleprice) AS maximum,
    MIN(saleprice) AS minimum
FROM
    orders;

SELECT 
    COUNT(*)
FROM
    orders;
    
SELECT 
    custid,
    COUNT(*) AS 'total',
    SUM(saleprice) AS 'total_saleprice'
FROM
    orders
GROUP BY custid;
    
SELECT 
    custid,
    COUNT(*) AS 'total',
    SUM(saleprice) AS 'total_saleprice'
FROM
    orders
GROUP BY custid
HAVING custid = 1;

SELECT 
    custid AS 'customer',
    COUNT(bookid) AS 'total_book',
    SUM(saleprice) AS 'total_price'
FROM
    orders
WHERE
    saleprice >= 8000
GROUP BY custid;
-- HAVING COUNT(bookid) >= 2

SELECT 
    custid AS 'customer',
    COUNT(*) AS 'total_book',
    SUM(saleprice) AS 'total_price'
FROM
    orders
WHERE
    saleprice >= 8000
GROUP BY custid
HAVING COUNT(*) >= 2;

-- join 기본문법
SELECT * FROM customer, orders;

-- join 조건문
select * from customer, orders
where customer.custid = orders.custid
order by orders.orderdate;

SELECT 
    name, SUM(saleprice)
FROM
    customer,
    orders
WHERE
    customer.custid = orders.custid
GROUP BY customer.name
ORDER BY customer.name;

-- 진행순서 1.from(어디서 가져올지) 2. where(조건) 3. group by(칼럼 필터링) 4.having(집계함수 필터링) 5.select(집계) 6.order by(정렬) 7.limit(몇 개 가져올지)
SELECT 
    name AS 'customer',
    COUNT(*) AS 'total_book',
    sum(saleprice) AS 'total_price'
FROM
    customer,
    orders
WHERE
    customer.custid = orders.custid and saleprice >= 8000
GROUP BY customer.name
HAVING COUNT(*) >= 2
ORDER BY customer.name;

SELECT 
    name AS 'customer',
    COUNT(*) AS 'total_book',
    sum(saleprice) AS 'total_price'
FROM
    customer,
    orders
WHERE
    customer.custid = orders.custid 
GROUP BY customer.name
HAVING COUNT(*) >= 2 and sum(saleprice) >= 20000
ORDER BY customer.name;

SELECT 
    customer.name,
    customer.phone,
    book.bookname,
    book.price,
    orders.orderdate
FROM
    customer,
    orders,
    book
WHERE
    customer.custid = orders.custid
        && orders.bookid = book.bookid && price >= 20000
GROUP BY customer.name , customer.phone , book.bookname , book.price , orders.orderdate
ORDER BY book.bookname;

-- 1) 도서번호가 1인 도서의 이름
select book.bookname from book where bookid = 1;

-- 2) 가경이 2만원 이상인 도서의 이름
select book.bookname, book.price from book where price >= 20000;

-- 3) 박지성의 총 구매금액
select name, sum(saleprice) from customer, orders where customer.custid = orders.custid && name like '박지성' group by customer.name having sum(saleprice);

-- 4) 박지성이 구매한 도서의 수
select name, count(*) from customer, orders where customer.custid = orders.custid && name like '박지성' group by customer.name;

-- 5) 박지성이 구매한 도서의 출판사 수
select name, count(publisher) from customer, orders, book where customer.custid = orders.custid && name like '박지성' && orders.bookid = book.bookid group by customer.name;

-- 6) 박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이
select name, bookname, price, saleprice, (price-saleprice) from orders, customer, book where customer.custid = orders.custid && name like '박지성' && orders.bookid = book.bookid;

-- 7) 박지성이 구매하지 않은 도서의 이름
select book.bookname from customer, orders, book where customer.custid = orders.custid && name not in ('박지성') && orders.bookid = book.bookid order by book.bookname;

-- 8) 마당서점 도서의 총 갯수
select count(bookid) from book;

-- 9) 마당서점에 도서를 납품하는 출판사의 총 갯수
select count(distinct publisher) from book;

-- 10) 모든 고객의 이름, 주소
select name, address from customer;

-- 11) 2024년 7월 4일부터 2024년 7월 7일 사이에 주문한 도서의 목록
select bookname, orderdate from orders, book where book.bookid = orders.bookid && orderdate between '2024-07-04' and '2024-07-07';

-- 12) 성이 김씨인 고객의 이름과 주소
select name, address from customer where name like '김%';

-- 13) 성이 김씨이고 이름이 아로 끝나는 고객의 이름과 주소
select name, address from customer where name like '김%아';

-- 14) 주문 금액의 총액과 평균금액
select sum(saleprice), avg(saleprice) from orders;

-- 15) 고객의 이름과 고객별 구매액
select name, sum(saleprice) from customer, orders where customer.custid = orders.custid group by customer.name;

-- 16) 고객의 이름과 고객이 구매한 도서목록
select customer.name, book.bookname from customer, orders, book where customer.custid = orders.custid && book.bookid = orders.bookid group by customer.name, book.bookname order by customer.name;

select bookname, price from book
where price = (select max(price) from book);

-- 도서를 구매한 이력이 있는 고객명:서브쿼리
select name from customer
where customer.custid in (select custid from orders) order by name;

-- 도서를 구매한 이력이 있는 고객명, 가격:join
select distinct name, sum(saleprice) from customer, orders
where customer.custid = orders.custid group by customer.name having sum(saleprice) order by name;



select * from orders;
select * from customer;
select * from book;