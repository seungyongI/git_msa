-- ALL
EXPLAIN SELECT * FROM rental;
-- index
EXPLAIN SELECT rental_date FROM rental;
-- range
EXPLAIN SELECT * FROM rental WHERE rental_date <= '2005-05-28';
EXPLAIN SELECT * FROM rental WHERE customer_id < 10 && rental_date <= '2005-05-28';
EXPLAIN SELECT * FROM rental WHERE last_update <= '2005-05-28' && rental_date <= '2005-05-28';

-- 실습
EXPLAIN
SELECT 
    a.actor_id,
    a.first_name,
    a.last_name,
    (SELECT 
            MAX(f.length)
        FROM
            film f
                JOIN
            film_actor fa ON f.film_id = fa.film_id
        WHERE
            fa.actor_id = a.actor_id) AS max_film_length
FROM
    actor a
ORDER BY a.last_name , a.first_name;

-- 수정 전
EXPLAIN
SELECT actor_id, first_name, last_name FROM actor a
WHERE actor_id IN (
	SELECT actor_id FROM film_actor WHERE film_id = 1
	UNION
	SELECT actor_id FROM film_actor WHERE film_id = 2 && actor_id = a.actor_id
);
-- 수정 후
EXPLAIN
SELECT DISTINCT a.actor_id, a.first_name, a.last_name
FROM actor a
JOIN film_actor fa ON a.actor_id = fa.actor_id
WHERE fa.film_id = 1 && fa.film_id = 2;

-- set profiling = 1;
-- show profiles;
-- show profile for query [number];

-- 수정 전
EXPLAIN
SELECT c.customer_id, c.first_name, c.last_name
FROM customer c
WHERE c.customer_id = (
	SELECT r.customer_id
    FROM rental r
    WHERE r.customer_id = c.customer_id && r.rental_date > '2005-05-01'
    LIMIT 1
);

-- 수정 후
EXPLAIN
SELECT DISTINCT c.customer_id, c.first_name, c.last_name
FROM customer c
INNER JOIN rental r ON c.customer_id = r.customer_id
WHERE r.rental_date > '2005-05-01'
LIMIT 1;