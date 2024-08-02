set @seq:=0;
select (@seq:=@seq+1) 순번, custid, name, phone from customer where @seq < 4;

select sum(saleprice)
from orders
where custid = 
	(select custid 
    from customer 
    where name = '박지성');
    
-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 나타내세요

select o.orderid, o.custid, o.saleprice from orders o where o.saleprice > (select avg(saleprice) from orders);

-- 각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 나타내시오
select o.orderid, o.custid, o.saleprice from orders o where o.saleprice > (select avg(saleprice) from orders od where o.custid and od.custid);

select orderid, saleprice from orders
where saleprice > all (select saleprice from orders where custid = 3);

select sum(saleprice) total
from orders od
where exists (select * from customer c where address like '대한민국%' and c.custid = od.custid);

SELECT 
    (SELECT 
            name
        FROM
            customer c
        WHERE
            c.custid = o.custid) 'name',
    SUM(saleprice) 'total'
FROM
    orders o
GROUP BY o.custid;

SELECT 
    c.name, SUM(o.saleprice) 'total'
FROM
    (SELECT 
        custid, name
    FROM
        customer
    WHERE
        custid <= 2) c,
    orders o
WHERE
    c.custid = o.custid
GROUP BY c.name;

-- index를 만들 때 unique 값들 위주로만 걸어라.

create index ix_book on book(bookname);

create index ix_book2 on book(publisher, price);

-- drop index ix_book2;  

