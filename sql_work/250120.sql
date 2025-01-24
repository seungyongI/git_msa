-- 서브쿼리를 제거하고 조인을 사용하여 쿼리를 최적화합니다.

-- DERIVED
EXPLAIN
SELECT a.actor_id, a.first_name, a.last_name, m.max_film_length
FROM actor a
JOIN (
	SELECT fa.actor_id, MAX(f.length) AS max_flim_length
    FROM film f
    JOIN film_actor fa ON f.film_id = fa.film_id
    GROUP BY fa.actor_id
) m ON a.actor_id = m.actor_id
ORDER BY a.last_name, a.first_name;

-- 수정 후
EXPLAIN
SELECT a.actor_id, CONCAT(a.first_name, ' ', a.last_name) AS name, MAX(f.length) AS max_film_length
FROM actor a
INNER JOIN film_actor fa ON a.actor_id = fa.actor_id
INNER JOIN film f ON fa.film_id = f.film_id
GROUP BY a.actor_id
ORDER BY name;

SELECT count(*) FROM rental WHERE MONTH(rental_date) = 6 AND YEAR(rental_date) = 2024;

SELECT count(*) FROM rental WHERE rental_date >= '2024-06-01 00:00:00' AND rental_date <= '2024-06-30 23:59:59';
SELECT count(*) FROM rental WHERE rental_date BETWEEN '2024-06-01' AND '2024-06-30';

SELECT * FROM film
WHERE rating = 'G' OR rating = 'PG' OR rating = 'PG-13';

SELECT * FROM film
WHERE rating IN ('G', 'PG', 'PG-13');

CREATE INDEX idx_film_length_rating ON film(length, rating);
DROP INDEX idx_film_length_rating ON film;

EXPLAIN SELECT title FROM film WHERE length > 120 AND rating = 'PG';

CREATE INDEX idx_city_address ON address(city_id);
CREATE INDEX idx_city_city_id ON city(city);
CREATE INDEX idx_address_id_active_email ON customer(address_id, active, email);

DROP INDEX idx_city_city_id ON city;
DROP INDEX idx_city_address ON address;
DROP INDEX idx_address_id_active_email ON customer;

EXPLAIN
SELECT c.email
FROM customer c
JOIN address a ON c.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
WHERE ci.city = 'London' AND c.active = 1;

-- 복합 인덱스
-- GROUP BY 절을 최적화 하는 복합 인덱스 생성하여 집계 쿼리 성능 향상
-- 국가별 고객 수 집계
-- 인덱스 최적화 쿼리 실행 단축

CREATE INDEX idx_country ON country(country);
DROP INDEX idx_country ON country;
CREATE INDEX idx_city ON city(country_id, city);
DROP INDEX idx_city ON city;

EXPLAIN
SELECT co.country, ci.city, COUNT(*) AS customer_count
FROM customer cu
JOIN address a ON cu.address_id = a.address_id
JOIN city ci ON a.city_id = ci.city_id
JOIN country co ON ci.country_id = co.country_id
GROUP BY co.country, ci.city;