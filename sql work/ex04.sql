-- SQL 내장 함수

-- abs 절댓값 구하기, 테이블에서 구하는 게 아님
select abs(-78), abs(78) as '절댓값';
-- round 반올림하기 ex) (a,b)면 a인 실수를 b 자리까지 출력
select round(4.875) as '반올림';
select c.name as '고객이름', round(avg(o.saleprice), -2) as '평균금액' from orders o inner join customer c on c.custid = o.custid group by c.name;
select concat('마당',' 서점') as '가게 이름';
select lower('MR.SCOTT') as '소문자';
select upper('mr.scott')as '대문자';
select lpad('page 1', 10, "*");
select rpad('abc',5,'*');
select replace('JACK & JUE', 'J','BL');
select substr('ABCDEFG',3,4);
select trim('=' from "= A= B= C= D= E =") as '양쪽 지정 문자 삭제';
select ascii('D') as '아스키코드';
select length('asdfasdf');
select char_length('asdasddff');

-- ex) 도서 제목에 야구가 포함된 도서를 농구로 변경한 후 도서 목록을 나타내세요.
select replace (b.bookname,'야구','농구') from book b;
-- ex) 굿스포츠에서 출판된 도서의 제목과 제목의 바이트수와 문자수를 출력하세요.
select b.bookname, length(b.bookname) as '바이트 수', char_length(b.bookname) as '문자수' 
from book b where b.publisher like '굿스포츠' order by b.bookname;
-- ex) 마당서점의 고객 중에서 성이 같은 사람이 몇명이나 되는지 알고 싶다. 성별 인원수를 구하시오.
select substr(c.name, 1, 1) as 성, count(*) as '인원' from customer c group by 성;

select adddate('2024-07-01', interval -5 day) before5,
	   adddate('2024-07-01', interval +5 day) after5;

select b.bookname as '주문도서', o.orderdate as '주문일자', adddate(o.orderdate, interval 10 day) 확정일자 
from orders o, book b where b.bookid = o.bookid order by b.bookname;

-- 2024년 7월 4일 주문받은 도서를 모두 나타내세요. 단, 주문일은 240704 형태로.
-- 주문일((jul = &b) 04 2024), 주문일(24-07-04 (thu = %a)),
select o.orderid as '주문번호', date_format(o.orderdate,'%y%m%d') as '주문일', date_format(o.orderdate,'%b %m %Y') as '주문일', date_format(o.orderdate,'%y-%m-%d %a') as '주문일', o.custid as '고객번호', o.bookid as '도서번호' 
from book b, orders o where o.orderdate = '2024-07-04' && o.orderid = b.bookid;

-- view: 가상의 테이블이고 물리적인 공간은 차지함 insert 못함
create view vorders as select orderid, o.custid, name, o.bookid, bookname, saleprice, orderdate
from customer c, orders o, book b
where c.custid=o.custid and b.bookid= o.bookid;
select * from vorders;

create view vw_customers as select * from customer where address like '대한민국%';
select * from vw_customers;

create view vW_order as select name, bookname, orderid, saleprice 
from orders o inner join customer c on c.custid = o.custid inner join book b on o.bookid = b.bookid;
select * from vW_order where name like '김연아';

create or replace view vw_customers as select custid, name, address from customer where address like '영국%';
select * from vw_customers;

-- null 값이 포함된 칼럼은 집계에서 제외
select count(phone) from customer;

create table mybook(
bookid integer not null,
price integer
);

insert into mybook values(1, 10000);
insert into mybook values(2, 20000);
insert into mybook values(3, null);
insert into mybook(bookid) values(4);

alter table mybook add primary key (bookid);

select price + 100 from mybook where bookid = 3;

select sum(price), round(avg(price)), count(*), count(price)
from mybook;

select count(*), count(price) from mybook;

select sum(price), round(avg(price))
from mybook;

select sum(price), round(avg(price)), count(*), count(price)
from mybook where bookid >= 4;

select count(*) from mybook where price is null;
select * from mybook where price = 0;

select name '이름', ifnull(phone, '연락처없음') '전화번호' from customer;
select bookid '도서 번호', ifnull(price, '가격 미입력') '가격' from mybook;










select * from mybook;

select * from orders;
select * from book;
select * from customer;