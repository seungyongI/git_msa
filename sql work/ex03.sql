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
<<<<<<< HEAD
SELECT 
    c.name
FROM
    customer c
        INNER JOIN
    orders o ON c.custid = o.custid
        INNER JOIN
    book b ON b.bookid = o.bookid
WHERE
    b.publisher IN (SELECT 
            b.publisher
        FROM
            book b
                INNER JOIN
            orders o ON b.bookid = o.bookid
                INNER JOIN
            customer c ON o.custid = c.custid
        WHERE
            name LIKE '박지성');

-- 2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
SELECT 
    c.name, COUNT(DISTINCT b.publisher)
FROM
    customer c
        INNER JOIN
    orders o ON c.custid = o.custid
        INNER JOIN
    book b ON o.bookid = b.bookid
GROUP BY c.name
HAVING COUNT(DISTINCT b.publisher) >= 2;

-- 3) 전체 고객의 30% 이상이 구매한 도서
SELECT 
    bookname
FROM
    book b
        INNER JOIN
    orders o ON o.bookid = b.bookid
GROUP BY bookname
HAVING COUNT(DISTINCT o.custid) >= (SELECT 
        0.3 * COUNT(*)
    FROM
        customer);

-- group by 연습 문제

-- 문제 1: 각 고객이 구매한 도서의 총 개수를 구하고, 구매한 도서 개수가 3개 이상인 고객의 이름과 구매 도서 개수를 출력하세요.
SELECT 
    c.name, COUNT(o.orderid) AS num_books
FROM
    customer c
        INNER JOIN
    orders o ON o.custid = c.custid
GROUP BY name
HAVING COUNT(o.orderid) >= 3;

-- 문제 2: 각 출판사별로 출판된 도서 중 가장 비싼 도서의 이름과 가격을 출력하세요.
SELECT 
    b.bookname, b.price
FROM
    book b
        INNER JOIN
    (SELECT -- inner join 뒤에 나오는 서브쿼리는 임시 테이블 기능도 함.
        b.publisher, MAX(b.price) AS max_price
    FROM
        book b
    GROUP BY publisher) AS max_prices ON b.publisher = max_prices.publisher
        AND b.price = max_prices.max_price; 
        
-- 문제 3: 가장 많은 고객이 구매한 도서의 이름과 구매 고객 수를 출력하세요. (단, 동일한 구매 고객 수를 가진 도서가 여러 권인 경우 모두 출력합니다.)
select 

-- 문제 4: 가장 많은 도서를 주문한 고객의 ID와 주문한 도서의 개수를 출력하세요.

-- 문제 5: 가장 많은 도서를 주문한 고객의 이름과 주문한 도서의 개수를 출력하세요.

=======
select c.name, b.publisher from customer c, book b, orders o 
where c.custid = o.custid && b.bookid = o.bookid && b.publisher in(
select b.publisher from customer c, book b, orders o
where c.custid = o.custid && b.bookid = o.bookid && name like '박지성');

-- 2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select c.name, count(distinct b.publisher) from book b
 inner join orders o on b.bookid = o.bookid
 inner join customer c on o.custid = c.custid group by c.name having count(distinct b.publisher) >= 2;

-- 3) 전체 고객의 30% 이상이 구매한 도서
SELECT b.bookname
FROM book b
INNER JOIN orders o ON b.bookid = o.bookid
GROUP BY b.bookname
HAVING COUNT(DISTINCT o.custid) >= (
    SELECT 0.3 * COUNT(*)
    FROM customer
);
>>>>>>> 96f28f1b9278e4596aa0912d64f408e84e8aea1f







select * from book;
select * from orders;
select * from customer;