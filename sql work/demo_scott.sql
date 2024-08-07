﻿/* madang 계정으로 접속 실행하면 Emp, Dept 테이블이 생성된다. */
/* 오라클 데이터베이스에서 scott 계정으로 많이 사용되는 샘플 데이터베이스이다. */

use madangdb;

drop table if exists emp ;
drop table if exists dept;
drop table if exists salgrade;

CREATE TABLE IF NOT EXISTS DEPT (
  DEPTNO integer NOT NULL, #부서번호
  DNAME varchar(14), #부서이름
  LOC varchar(13), #부서주소
  PRIMARY KEY (DEPTNO)
);

INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES (10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES(20, 'RESEARCH', 'DALLAS');
INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES(30, 'SALES', 'CHICAGO');
INSERT INTO DEPT (DEPTNO, DNAME, LOC) VALUES(40, 'OPERATIONS', 'BOSTON');

CREATE TABLE IF NOT EXISTS EMP (
  EMPNO integer NOT NULL PRIMARY KEY, #사원번호
  ENAME varchar(10), #사원이름
  JOB varchar(9), #직위,업무이름
  MGR integer, #팀장번호
  HIREDATE date, #고용날짜
  SAL integer, #월급
  COMM integer, #1년 성과금
  DEPTNO integer, #부서번호
  FOREIGN KEY (deptno) REFERENCES Dept(deptno)
);

INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7369, 'SMITH', 'CLERK', 7902, '1980-12-17 00:00:00', 800, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20 00:00:00', 1600, 300, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22 00:00:00', 1250, 500, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7566, 'JONES', 'MANAGER', 7839, '1981-04-02 00:00:00', 2975, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28 00:00:00', 1250, 1400, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01 00:00:00', 2850, NULL, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09 00:00:00', 2450, NULL, 10);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19 00:00:00', 3000, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17 00:00:00', 5000, NULL, 10);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08 00:00:00', 1500, 0, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7876, 'ADAMS', 'CLERK', 7788, '1987-05-23 00:00:00', 1100, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03 00:00:00', 950, NULL, 30);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03 00:00:00', 3000, NULL, 20);
INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-01-23 00:00:00', 1300, NULL, 10);

CREATE TABLE IF NOT EXISTS SALGRADE(
	GRADE INTEGER, #등급
	LOSAL INTEGER, #최저임금
	HISAL INTEGER #최고임금
	);

INSERT INTO SALGRADE VALUES (1, 700, 1200);
INSERT INTO SALGRADE VALUES (2, 1201, 1400);
INSERT INTO SALGRADE VALUES (3, 1401, 2000);
INSERT INTO SALGRADE VALUES (4, 2001, 3000);
INSERT INTO SALGRADE VALUES (5, 3001, 9999);

-- 1) 사원의 이름과 직위를 출력하세요. 단 사원의 이름은 '사원이름', 직위는 '사원직위' 머리글이 나오도록 출력하세요.
select ename as 사원이름, job as 사원직위 from emp;

-- 2) 30번 부서에 근무하는 모든 사원의 이름과 급여를 출력하세요.
select ename as 사원이름, sal as 급여 from emp, dept dep where dep.deptno = 30;

-- 3) 사원번호와 이름, 현재 급여, 10% 인상된 급여(열 이름은 '인상된 급여'), 증가한 급여분(열 이름은 '증가액')을 사원번호순으로 출력하세요.
select empno, ename, sal, (sal*1.1) as '인상된 급여', (sal*0.1) as "증가액" from emp order by empno;

-- 4) 'S'로 시작하는 모든 사원과 부서번호를 출력하세요.
select e.ename, d.deptno from emp e, dept d where ename like 'S%' and dname like 'S%';

-- 5) 모든 사원의 최대 및 최소 급여, 합계 및 평균 급여를 출력하세요. 열 이름은 각각 MAX, MIN, SUM, AVG로 합니다. 단, 소수점 이하는 반올림하여 정수로 출력하세요.
select max(sal) MAX,min(sal) MIN, sum(sal) SUM, round(avg(sal)) SUM from emp;

-- 6) 업무 이름과 업무별로 동일한 업무를 하는 사원의 수를 출력하세요. 열 이름은 각각 '업무'와 '업무별 사원수'로 합니다.
select job as 업무, count(empno) as '업무별 사원수' from emp group by 업무;

-- 7) 사원의 최대 급여와 최소 급여의 차액을 출력하세요.
select (HISAL-LOSAL) 급여차액 from salgrade;

-- 8) 30번 부서의 구성원 수와 사원들 급여의 합계와 평균을 출력하세요.
select count(*) '부서 구성원 수', sum(sal) 합계, avg(sal) 평균 from emp where deptno = 30;

-- 9) 평균 급여가 가장 높은 부서의 번호를 출력하세요.
select deptno, round(avg(sal)) as avg_sal from emp group by deptno having round(avg(sal)) in (select max(round(avg(sal))) from emp);

-- 10) 세일즈맨(SALESMAN)을 제외하고, 업무별 사원의 급여가 3,000 이상인 각 업무에 대해서, 업무명과 업무별 평균 급여를 출력하세요. 단 평균 급여는 내림차순으로 출력합니다.
select job, avg(sal) from emp where job not in ('salesman') && sal >= 3000 group by job order by avg(sal) desc;

-- 11) 전체 사원 가운데 직속상관이 있는 사원의 수를 출력하세요.
select count(*) from emp ;

-- 12) EMP테이블에서 이름, 겹여, 커미션(COMM)금액, 총액(SAL+COMM)을 구하여 총액이 많은 순서대로 출력하세요. 단 커미션이 NULL인 사람은 제외합니다.


-- 13) 부서별로 같은 업무를 하는 사람의 인원수를 구하여 부서번호, 업무이름, 인원수를 출력하세요.


-- 14) 사원이 한 명도 없는 부서의 이름을 출력하세요.


-- 15) 같은 업무를 하는 사람의 수가 4명 이상인 업무와 인원수를 출력하세요.


-- 16) 사원번호가 7400이상 7600이하인 사원의 이름을 출력하세요.

-- 17) 사원의 이름과 사원의 부서를 출력하세요.

-- 18) 사원의 이름과 팀장의 이름을 출력하세요.

-- 19) 사원 scott 보다 급여를 많이 받는 사람의 이름을 출력하세요.

-- 20) 사원 scott이 일하는 부서번호 혹은 dallas에 있는 부서번호를 출력하세요.


select * from emp;
select * from dept;
select * from salgrade;