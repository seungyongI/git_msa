-- 진행순서 1.from(어디서 가져올지) 2. where(조건) 3. group by(칼럼 필터링) 4.having(집계함수 필터링) 5.select(집계) 6.order by(정렬) 7.limit(몇 개 가져올지)
-- 대한미디어에서 출판한 도서를 구매한 고객의 이름을 출력하세요.
select name, publisher from customer, orders, book where customer.custid = orders.custid && book.bookid = orders.bookid && book.publisher like '대한미디어'; -- join 해결방법
select name from customer where custid in (select custid from orders where bookid in (select bookid from book where publisher like '대한미디어')); -- 서브쿼리 해결방법

-- learn
SELECT 
    c.name, b.bookname
FROM
    customer c,
    book b,
    orders o
WHERE
    c.custid = o.custid
        AND b.bookid = o.bookid
ORDER BY c.name;

-- new
SELECT 
    c.name, b.bookname
FROM
    customer c,
    book b
WHERE
    (c.custid , b.bookid) IN (SELECT custid, bookid FROM orders)
ORDER BY c.name;

-- different
SELECT 
    c.name, b.bookname
FROM
    customer c,
    book b
WHERE
    c.custid IN (SELECT custid FROM orders)
        AND b.bookid IN (SELECT bookid FROM orders);
        
-- 대한민국에 거주하는 고객리스트 출력
select c.name, c.address from customer c 
where address like '대한민국%';

-- 도서를 주문한 고객리스트 출력 (서브쿼리)
select c.name from customer c
where c.custid
in (select o.custid from orders o);

-- 대한민국에 거주하는 고객의 이름과 도서를 주문한 고객의 이름을 출력하세요.
-- 두 가지 출력을 한 번에 하려면 union 사용
select c.name from customer c 
where address like '대한민국%' 
union
select c.name from customer c
where c.custid
in (select o.custid from orders o);

select * from customer
union all
select * from book;

-- 주문이 있는 고객의 이름과 주소를 나타내시오
select c.name, c.address from customer c
where exists
(select * from orders o
where c.custid = o.custid);

select * from orders;
select * from customer;
select * from book;
