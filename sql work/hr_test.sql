-- 문자열 처리 문제
-- 1. 사원의 이름이 8자 이상인 사원의 정보를 출력하세요.
select * from employees where (length(first_name) + length(last_name)) >=8;

-- 2. 이름의 첫 글자가 대문자인 사원의 정보를 출력하세요.
select * from employees where last_name regexp '^[A-Z]';

-- 3. 사원의 성의 2번째 문자가 'c'인 사원의 이름과 이름의 길이를 출력하세요.
select first_name, length(first_name) from employees where last_name like '_c%';

-- 4. 주소 중 거리의 이름의 문자가 길이가 최소인 지역(locations)을 출력하세요.
select min(sa) 
from (select trim(street_address) as sa from locations) as t
;
select length(trim(street_address)), street_address from locations order by length(street_address);
-- 5. 이름이 'A','J', 'M'으로 시작하는 사원의 이름과 이름의 길이를 출력하세요.
select first_name, length(first_name) from employees where first_name like 'A%' or first_name like 'J%' or first_name like 'M%'; -- ?

select * from employees;

-- Date 타입 처리 문제
-- 1. 1987년에 입사한 사원의 이름을 출력하세요.


-- 2. 사원의 이름, 입사년도, 근무년수를 출력하세요.


-- 3. '1987-06-01'과 '1987-07-30'사이에 입사한 사원의 이름과 입사일을 출력하세요.


-- 4. 6월에 입사한 사원의 이름과 성을 출력하세요.


-- 5. 부서별, 연도별 입사한 사원의 수를 구하세요. 
