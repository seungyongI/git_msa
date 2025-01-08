-- group by 연습문제
-- 문제 1: 각 고객이 구매한 도서의 총 개수를 구하고, 구매한 도서 개수가 3개 이상인 고객의 이름과 구매 도서 개수를 출력하세요.
SELECT 
    name, COUNT(bookname) AS num_books
FROM
    book b
        INNER JOIN
    orders o ON o.bookid = b.bookid
        INNER JOIN
    customer c ON c.custid = o.custid
GROUP BY name
HAVING COUNT(o.bookid) >= 3;

SELECT 
    name, count(b.bookid)
FROM
    customer c
        INNER JOIN
    orders o ON c.custid = o.custid
        INNER JOIN
    book b ON o.bookid = b.bookid
GROUP BY name;

-- 문제 2: 각 출판사별로 출판된 도서 중 가장 비싼 도서의 이름과 가격을 출력하세요.
SELECT b.bookname, b.price
FROM book b
INNER JOIN (
    SELECT publisher, MAX(price) AS max_price
    FROM book
    GROUP BY publisher
) AS max_prices ON b.publisher = max_prices.publisher && b.price = max_prices.max_price order by price desc;

-- 문제 3: 가장 많은 고객이 구매한 도서의 이름과 구매 고객 수를 출력하세요. (단, 동일한 구매 고객 수를 가진 도서가 여러 권인 경우 모두 출력합니다.)

-- 문제 4: 가장 많은 도서를 주문한 고객의 ID와 주문한 도서의 개수를 출력하세요.

-- 문제 5: 가장 많은 도서를 주문한 고객의 이름과 주문한 도서의 개수를 출력하세요.
