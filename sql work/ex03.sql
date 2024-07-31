create table NewBook(
bookid integer,
bookname varchar(40),
publisher varchar(40),
price integer
);

-- id_1 대분류 -> 0: 회원관련
-- id_2 중분류 -> 0: 회원가입 1: 로그인/로그아웃
-- id_3 소분류 -> 0: 성공
-- msg 출력될 내용

-- create table tblCode (
-- id_1 char(2) not null,
-- id_2 char(2) not null,
-- id_3 char(3) not null,
-- msg varchar(60) not null,
-- 중복키 (아래 세 가지 칼럼을 합쳤을 때 행끼리 중복이 되지 않게)
-- primary key (id_1,id_2,id_3)
-- );

-- insert into tblCode values ('00','00','000','회원가입을 환영합니다.');
-- insert into tblCode values ('00','01','001','로그인 되었습니다.');
-- insert into tblCode values ('00','01','002','로그아웃 되었습니다.');
-- insert into tblCode values ('00','00','001','중복된 아이디입니다.');

create table NewCustomer(
custid integer primary key,
name varchar(40),
address varchar(40),
phone varchar(30)
);

create table NewOrders(
orderid integer primary key,
custid integer not null,
bookid integer not null,
saleprice integer,
orderdate date,
FOREIGN KEY (custid)
	REFERENCES NewCustomer(custid) on delete cascade
);

describe newbook;

alter table NewBook add isbn varchar(13);

-- modify는 수정
alter table newbook modify isbn integer;

alter table newbook drop isbn;

alter table newbook modify bookname varchar(20) not null;

alter table newbook add primary key (bookname, publisher);

drop table newbook;

insert into book(bookid, bookname, publisher, price)
values(11, '스포츠 의학', '한솔의학서적', 90000);

-- 1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select c.name, b.publisher from customer c, book b, orders o 
where c.custid = o.custid && b.bookid = o.bookid && b.publisher in(
select b.publisher from customer c, book b, orders o
where c.custid = o.custid && b.bookid = o.bookid && name like '박지성');

select c.name from customer c inner join orders o on c.custid = o.custid inner join book b on b.bookid = o.bookid where b.publisher in 
(select b.publisher from book b inner join orders o on b.bookid = o.bookid inner join customer c on o.custid = c.custid where name like '박지성');

-- 2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
-- 서로 다른 출판사 : custid와 비교해서 중복 없이 두 개 이상의 출판사의 책을 구매한 고객
select c.name, count(distinct b.publisher) from customer c inner join orders o on c.custid = o.custid inner join book b on o.bookid = b.bookid group by c.name having count(distinct b.publisher) >=2;

 select c.name, b.publisher from customer c inner join orders o on c.custid = o.custid inner join book b on o.bookid = b.bookid where b.publisher in 
 (select b.publisher from book b inner join orders o on b.bookid = o.bookid inner join customer c on o.custid = c.custid group by b.publisher having count(distinct b.publisher) >= 2); 

select b.publisher from book b inner join orders o on b.bookid = o.bookid inner join customer c on o.custid = c.custid group by b.publisher having count(distinct b.publisher) >= 2;
select b.publisher from book b inner join orders o on b.bookid = o.bookid inner join customer c on o.custid = c.custid group by b.publisher having count(distinct b.publisher) >= 2;

select c.name, count(distinct b.publisher) from book b
 inner join orders o on b.bookid = o.bookid
 inner join customer c on o.custid = c.custid group by c.name having count(distinct b.publisher) >= 2;
 
 

-- 3) 전체 고객의 30% 이상이 구매한 도서










select * from book;