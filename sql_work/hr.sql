-- 1. Employees와 Departments 테이블에 저장된 행의 갯수를 출력하세요.
select (select count(*) from Employees),
(select count(*) from Departments)
from dual;

-- 2. Employees 테이블에 대한 employee_id, last_name, job_id, hire_date를 출력하세요.
SELECT 
    e.employee_id, e.last_name, j.job_title, e.hire_date
FROM
    Employees e, jobs j
where
	e.job_id = j.job_id;

-- 3. Employees 테이블에서 salary가 12,000 이상인 직원의 last_name과 salary를 출력하세요.
SELECT 
    last_name, salary
FROM
    Employees
WHERE
    salary >= 12000;

-- 4. 부서번호 (department_id)가 20 혹은 50인 직원의 last_name과 department_name을 last_name에 대하여 오름차순으로 출력하세요.
SELECT 
    e.last_name, d.department_name
FROM
    Employees e,
    Departments d
WHERE
    e.department_id IN (20 , 50) and e.department_id = d.department_id
ORDER BY last_name;

-- 5. last_name의 세 번째에 a가 들어가는 직원의 last_name을 출력하세요.
SELECT 
    last_name
FROM
    employees
WHERE
    last_name LIKE '__a%';

-- 6. 같은 일(job)을 하는 사람의 수를 세어 출력하세요.
SELECT 
    job_id, COUNT(*)
FROM
    employees
GROUP BY job_id
HAVING COUNT(job_id) >= 2;

select * from employees;

-- 7. 급여(salary)의 최대값과 최소값의 차이를 구하세요.
SELECT
    max(salary) - min(salary)
FROM
    employees;

-- 8. Toronto(city)에서 일하는 직원의 last_name, job, department_id, department_name을 출력하세요.
SELECT 
    e.last_name,
    j.job_title AS job,
    d.department_id,
    d.department_name
FROM
    employees e,
    departments d,
    locations lo,
    jobs j
WHERE
    e.job_id = j.job_id
        AND e.department_id = d.department_id
        AND lo.location_id = d.location_id
        AND lo.city LIKE 'Toronto';
    
-- 1. Create a report to display the last name, job_id, and start date for the employees whose last names areMatos and Talyor. Order the query in ascending order by start date.
-- 1. 성(last name)이 Matos와 Taylor인 직원의 성, 직무 ID(job_id), 시작 날짜(start date)를 출력하는 보고서를 작성하세요. 쿼리를 시작 날짜 기준 오름차순으로 정렬하세요.
select e.last_name as '성', e.job_id as '직무 ID', e.hire_date as '시작 날짜' from employees e where e.last_name in ('Matos', 'Taylor') order by e.hire_date;

-- 2. The HR department needs a report that displays the last nae and hire date for all employees who were hired in 1994.
-- 2. 1994년에 고용된 모든 직원의 성(last name)과 입사 날짜(hire date)를 출력하는 보고서가 인사부서에 필요합니다.
select last_name, hire_date from employees where year(hire_date) like 1994;
select last_name, hire_date from employees where date_format(hire_date, '%Y') like '1994';

-- 3 Display the last name, job and salary for all employees whose job is either that of a sales represntative or a stock clerk, and whose salary is not equal to $2,500, $3,500, or $7,000.
-- 3. 직무가 영업 대표(sales representative) 또는 재고 사원(stock clerk)인 모든 직원의 성(last name), 직무(job), 급여(salary)를 출력하며, 급여가 $2,500, $3,500 또는 $7,000가 아닌 직원들을 포함하세요.
select e.last_name, j.job_title, e.salary from employees e, jobs j where job_id in ('sales_representative', 'stock_clerk') or salary in (2500,3500,7000);

-- 4. Determine the number of managers without listing them. Label the column Number of Managers.
-- 4. 매니저 수만 구하세요. 열 이름을 '매니저 수(Number of Managers)'로 표시하세요.
select count(manager_id) as '매니저 수' from employees;
select * from employees;

-- 5. Create a report to display the manager number and the salary of the lowestpaid employee for that manager. Exclude anyone whose manager is not known. Exclude any groups where the minimum salary is $6,000 or less. Sort the output in descending order of salary.
-- 5. 매니저의 번호(manager number)와 해당 매니저 밑에서 가장 낮은 급여를 받는 직원의 급여를 출력하는 보고서를 작성하세요. 매니저가 알려지지 않은 경우와 최소 급여가 $6,000 이하인 그룹은 제외하세요. 출력 값을 급여 내림차순으로 정렬하세요.


-- 6. Create a report to display the last name and employee number of employees along with their manager's last name and manger number. Label the columns Employee, Emp#, Manager, and Mgr#, respectively.
-- 6. 직원의 성(last name)과 직원 번호(employee number), 그리고 그들의 매니저의 성(last name)과 매니저 번호(manager number)를 함께 출력하는 보고서를 작성하세요. 열 이름은 각각 'Employee', 'Emp#', 'Manager', 'Mgr#'로 표시하세요.


-- 7. Create a report for the HR department that displays employee last names, department numbers, and all the employees who work in the same department as a given employee.
-- 7. 주어진 직원과 같은 부서에서 일하는 모든 직원의 성(last name), 부서 번호(department number)를 출력하는 보고서를 인사부서에 작성하세요.


-- 8. Create a report for the HR department that displays the department number, last name, and job_id for every  employee in the Executive department.
-- 8. 임원 부서(Executive department)에 있는 모든 직원의 부서 번호(department number), 성(last name), 직무 ID(job_id)를 출력하는 보고서를 작성하세요.


-- 9. Create a report for the HR department that displays the last name, and salary of every employee who reports to King.
-- 9. King에게 보고하는 모든 직원의 성(last name)과 급여(salary)를 출력하는 보고서를 작성하세요.


-- 10. The HR department needs a list of department IDs for departments that do not contain the job_id 'ST_CLERK'.
-- 10. 'ST_CLERK' 직무 ID를 포함하지 않는 부서의 부서 ID 목록이 인사부서에 필요합니다.


select * from countries;
select * from departments;
select * from employees;
select * from job_grades;
select * from job_history;
select * from jobs;
select * from locations;
select * from regions;