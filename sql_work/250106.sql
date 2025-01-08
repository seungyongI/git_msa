
select min(length) as 최소_영화_길이 from film;

select max(length) as 최대_영화_길이 from film;

select count(*) as 총_영화_수 from film;

select sum(amount) as 총_결제_금액 from payment;

select count(distinct rental_date) as 고유_대여_날짜_수 from rental;

select actor_id, group_concat(film_id separator ' | ') as 영화_ID_리스트
from film_actor group by actor_id;

select json_objectagg(actor_id, first_name) as actor_names
from actor limit 5;

select c.name as category, json_arrayagg(f.title) as movies
from category c
join film_category fc on c.category_id = fc.category_id
join film f on fc.film_id = f.film_id
group by c.category_id
limit 2;

-- 도시별 고객의 수 계산
select ci.city, count(cus.customer_id)
from city as ci
inner join address a on ci.city_id = a.city_id
inner join customer cus on a.address_id = cus.address_id
group by ci.city;

-- 직원별 총 판매 금액
select st.staff_id, sum(amount)
from staff st
inner join payment pay on st.staff_id = pay.staff_id
group by st.staff_id;

select c.name as 카테고리, f.title as 영화제목,
row_number() over (
					partition by c.name 
					order by f.title) as 영화순서
from film f
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id;

select c.name as 카테고리, f.title as 영화제목, f.rental_rate as 대여요금,
rank() over(
			partition by c.name 
			order by f.rental_rate desc) as 요금_순위
from film f
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id;

select c.name as 카테고리, f.title as 영화제목, f.rental_rate as 대여요금,
dense_rank() over(
					partition by c.name 
					order by f.rental_rate desc) as 요금순위
from film f
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id;

select c.name as 카테고리, f.title as 영화제목, f.rental_rate as 대여요금,
ntile(10) over(
				partition by c.name 
				order by f.length desc) as 등급
from film f
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id;

select customer_id, rental_date,
LAG(rental_date, 1) over (
							partition by customer_id 
							order by rental_date) as 이전_대여일자
from rental;

select customer_id, rental_date,
LEAD(rental_date, 1) over (
							partition by customer_id 
							order by rental_date) as 다음_대여일자
from rental;

select customer_id, payment_id, amount,
first_value(amount) over (
							partition by customer_id 
							order by payment_date asc) as first_payment_amount
from payment;

select customer_id, payment_id, amount,
last_value(amount) over (
							partition by customer_id 
							order by payment_date asc) as first_payment_amount
from payment;

SELECT customer_id, rental_date, inventory_id, 
sum(inventory_id) over(
						partition by customer_id
						order by rental_date) as cumulative_rentals
from rental
where customer_id = 2
order by rental_date;

select i.film_id, r.rental_date, r.return_date, datediff(r.return_date, r.rental_date) as rental_duration,
avg(datediff(r.return_date, r.rental_date)) over (
													partition by i.film_id 
                                                    order by r.rental_date 
                                                    rows between 4 preceding and current row)
as avg_last_3_rental_duration
from rental r
inner join inventory i on r.inventory_id = i.inventory_id
where r.return_date is not null
order by i.film_id, r.rental_date
limit 10;

select staff_id,
date(payment_date) as sale_date,
sum(amount) as daily_total,
avg(sum(amount)) over (
						partition by staff_id
						order by date(payment_date)
						range between interval 6 day preceding and current row
) as moving_avg_7days
from payment
group by staff_id, date(payment_date)
order by staff_id, sale_date;

select c.name as 카테고리, f.title as 영화제목,
row_number() over (
					partition by c.name 
					order by f.title
) as 영화순서
from film f
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id;

select c.name as 카테고리, f.title as 영화제목, f.rental_rate as 대여요금,
rank() over (
partition by c.name
order by f.rental_rate desc
) as 요금순위
from category c
inner join film_category fc on c.category_id = fc.category_id
inner join film f on fc.film_id = f.film_id;

-- 각 카테고리 내에서 영화의 대여 요금에 따른 밀집 순위(DENSE_RANK())를 구합니다.
select c.name as 카테고리, f.title as 영화제목, f.rental_rate as 대여요금,
dense_rank() over(
					partition by c.name 
					order by f.rental_rate desc) as 요금순위
from film f
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id;

-- 각 카테고리 내에서 영화를 4개의 그룹으로 나누어 등급을 매깁니다.
select c.name as 카테고리, f.title as 영화제목, f.rental_rate as 대여요금,
ntile(4) over(
				partition by c.name 
				order by f.rental_rate desc) as 등급
from film f
inner join film_category fc on f.film_id = fc.film_id
inner join category c on fc.category_id = c.category_id;

-- select a.actor_id, f.title from actor a
-- inner join film_actor fa on fa.actor_id = a.actor_id
-- inner join film f on fa.film_id = f.film_id
-- where a.actor_id = 1
-- union
-- select a.actor_id, f.title from actor a
-- inner join film_actor fa on fa.actor_id = a.actor_id
-- inner join film f on fa.film_id = f.film_id
-- where a.actor_id not in (1);

select f.film_id, f.title, '출연' as 출연여부
from film f
inner join film_actor fa on f.film_id = fa.film_id
where fa.actor_id = 1
union
select f.film_id, f.title, '미출연' as 출연여부
from film f
where f.film_id not in (select fa.film_id from film_actor fa where fa.actor_id = 1)
order by 출연여부 desc, title;

-- 고객과 직원의 이메일 주소를 하나의 데이터 셋으로 통합
-- 각 이메일 주소에서 도메인 부분 추출
-- 고객과 직원을 구분하여 각 그루별로 이메일 도메인 사용 현황 파악
-- 각 그룹(고객/직원) 내에서 가장 많이 사용되는 이메일 도메인부터 순서대로 점렬합니다.
-- 이 정보를 바탕으로 마케팅 전략 수립 및 내부 커뮤니케이션 개선에 활용할 수 있는 인사이트 얻기

select (select s.email from staff s
		union all
		select c.email from customer c) as all_email,
substring_index(all_email, '@', -1) as domain
;

select substring_index(email, '@', -1) as domain
from customer;

select r.type, substring_index(r.email, '@', -1) as domain, count(*) as count
from (
select 'Customer' as type, email
from customer
union all
select 'Staff' as type, email
from staff) as r
group by r.type, domain
order by r.type, count desc;

show index from customer;

select * from information_schema.statistics
where table_schema = 'sakira';

drop index idx_title on film;

show index from film;

-- 쿼리 실행 시간 측정 시작
SET profiling = 1;

select * from film where title like 'Job to%';

show profiles;

create index idx_title on film (title);

select * from film where title like 'Job to%';

show profiles;

create index idx_last on customer (last_name);

select last_name from customer;

create index idx_name on customer (first_name, last_name);

show index from customer;

select * from customer where first_name like 'a%' && last_name like 'b%';

show index from rental;

drop index rental_date on rental;

create index rental_date on rental (rental_date, inventory_id, customer_id);

-------------------------
-- InnoDB 스토리지 엔진에서 풀텍스트 인덱스 정보 조회 테이블 지정
SHOW VARIABLES LIKE '%innodb_ft_aux_table%';
SHOW VARIABLES LIKE '%innodb_optimize_%';
SET GLOBAL innodb_ft_aux_table = 'sakira/newspaper';
SET GLOBAL innodb_optimize_fulltext_only=ON;
-- 실습용 테이블 생성
create table newspaper (
  id int auto_increment primary key,
  title varchar(15) not null,
  description varchar(1000)
) ;
-- 데이터 등록
INSERT INTO newspaper VALUES
  (NULL, '광해, 왕이 된 남자','왕위를 둘러싼 권력 다툼과 당쟁으로 혼란이 극에 달한 광해군 8년'),
  (NULL, '간첩','남한 내에 고장간첩 5만 명이 암약하고 있으며 특히 권력 핵심부에도 침투해있다.'),
  (NULL, '피에타',' 더 나쁜 남자가 온다! 잔혹한 방법으로 돈을 뜯어내는 악마같은 남자 스토리.'),
  (NULL, '레지던트 이블 5','인류 구원의 마지막 퍼즐, 이 여자가 모든 것을 끝낸다.'),
  (NULL, '파괴자들','사랑은 모든 것을 파괴한다! 한 여자를 구하기 위한, 두 남자의 잔인한 액션 본능!'),
  (NULL, '킹콩을 들다',' 역도에 목숨을 건 시골소녀들이 만드는 기적 같은 신화.'),
  (NULL, '테드','지상최대 황금찾기 프로젝트! 500년 전 사라진 황금도시를 찾아라!'),
  (NULL, '타이타닉','비극 속에 침몰한 세기의 사랑, 스크린에 되살아날 영원한 감동'),
  (NULL, '8월의 크리스마스','시한부 인생 사진사와 여자 주차 단속원과의 미묘한 사랑'),
  (NULL, '늑대와 춤을','늑대와 친해져 모닥불 아래서 함께 춤을 추는 전쟁 영웅 이야기'),
  (NULL, '국가대표','동계올림픽 유치를 위해 정식 종목인 스키점프 국가대표팀이 급조된다.'),
  (NULL, '쇼생크 탈출','그는 누명을 쓰고 쇼생크 감옥에 감금된다. 그리고 역사적인 탈출.'),
  (NULL, '인생은 아름다워','귀도는 삼촌의 호텔에서 웨이터로 일하면서 또 다시 도라를 만난다.'),
  (NULL, '사운드 오브 뮤직','수녀 지망생 마리아는 명문 트랩가의 가정교사로 들어간다'),
  (NULL, '매트릭스',' 2199년.인공 두뇌를 가진 컴퓨터가 지배하는 세계.');
-- 풀텍스트 인덱스 생성 : Built-In 파서
CREATE FULLTEXT INDEX fulltext_desc ON newspaper(description);
-- 인덱스 단어들이 조회(파서에 따라서 등록된 단어가 다르다), 업데이트가 느리면 인덱스 삭제후 재등록
SELECT word, doc_count, doc_id, position FROM information_schema.innodb_ft_index_table;
-- 인덱스 삭제
DROP INDEX fulltext_desc on newspaper;
-- 풀텍스트 인덱스 생성 : ngram 파서
CREATE FULLTEXT INDEX fulltext_desc ON newspaper(description) with parser ngram;
-- 인덱스 단어들이 조회(파서에 따라서 등록된 단어가 다르다), 업데이트가 느리면 인덱스 삭제후 재등록
SELECT word, doc_count, doc_id, position FROM information_schema.innodb_ft_index_table;
-- 등록전 단어인 '용병'으로 검색
SELECT word, doc_count, doc_id, position FROM information_schema.innodb_ft_index_table where word = '용병';
-- 새로운 기사 등록
INSERT INTO newspaper VALUES (NULL, '데드풀','전직 특수부대 출신의 용병 ‘웨이드 윌슨(라이언 레놀즈)’은 암 치료를 위한 비밀 실험에 참여 후, 강력한 힐링팩터를 지닌 슈퍼히어로 ‘데드풀’로 거듭난다. 탁월한 무술실력과 거침없는 유머감각을 지녔지만 흉측하게 일그러진 얼굴을 갖게 된 데드풀은 자신의 삶을 완전히 망가뜨린 놈들을 찾아 뒤쫓기 시작하는데…
');
-- 등록후 업데이트전 인덱스 단어 확인
SELECT word, doc_count, doc_id, position FROM information_schema.innodb_ft_index_table where word = '용병';
-- 인덱스 단어 업데이트
OPTIMIZE TABLE newspaper;
-- 업데이트된 인덱스 단어 확인
SELECT word, doc_count, doc_id, position FROM information_schema.innodb_ft_index_table where word = '용병';