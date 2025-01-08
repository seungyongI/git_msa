-- 영화 제목 길이 내림차순
select title, length(title) as title_length
from film
order by title_length desc;

-- 이름 오름차순
select first_name, last_name
from customer
order by concat(last_name, ', ', first_name) asc;

-- 두 번째 열 오름차순, 1번째 열 오름차순 : 출력되는 열의 위치값
select first_name, last_name
from actor
order by 2, 1;

-- 배우 목록을 last_name이 먼저 오름차순으로 정렬되고, 동일한 last_name에 대해서는 first_name이 오름차순으로 정렬된 형태롤 조회
select *
from actor
order by last_name, first_name;

-- 모든 영화의 rental_rate를 기준으로 오름차순 정렬된 영화 목록을 출력
select *
from film
order by rental_rate;

-- 최신 입고된 영화 재고(last_update)를 내림차순으로 정렬하고 동일한 입고날짜의 영화는 대여소 ID(store_id) 순으로 오름차순 정렬 조회
select *
from inventory
order by last_update desc, store_id;

-- 배우별 영화 출연한 횟수
select actor_id, count(*) as film_count
from film_actor
group by actor_id;

select film_id, count(*) as inventory_count
from inventory
group by film_id
having inventory_count >= 5;



