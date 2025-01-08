/*
그린 중/고등학교 수행평가 일정 및 점수 관리시스템

나이스 : 미리제공정보 끌어다 사용
(학생 학교, 학년, 학반, 학번, 학생이름)
(선생님 소속된 학교, 과목명, 담당학년, 수업명, 해당학년, 해당학기, 담당반)

사용자 : 학생, 선생님

회원가입 : 학생, 선생님
로그인ㅇ : 학생, 선생님

선생님 기능 : 학생정보, 학사일정, 수행평가일정등록, 제출, 수행평가점수등록, 선생님정보관리(과목, 수업)

학생 기능 : 수행평가제출, 점수조회, 이의신청, 수행평가일정조회

요구사항분석

1) 나이스
선생님 : 회원가입(o-정교사, 기간제교사, 산학교사 등등), 아이디, 비번,담당과목, 담당수업
학생 : 소속학교, 올해의 학년, 학반, 학번, 회원가입(x), 바로 로그인 한 직후 비번변경, 로그인

2) 선생님 기능
- 수행평가일정등록 : 수행평가날짜(시작일시, 종료일시), 수행평가과목/수업, 과제/시험, 평가기준, 수행평가내용
- 내가 등록한 수행평가 리스트 보기, 수정, 삭제
- 점수 입력, 확정, 수정
- 선생님 정보 관리

3) 학생 기능
- 일정보기, 내 점수조회, 이의신청, 점수확정

4) 테이블
학생정보
선생님
수업
수강생정보
수행평가
점수

5) 학생테이블
p.k: 연도+학년+학반+학번
학생이름 : varchar(20), NN
연도 : varchar(4), NN, default value(올해로)
학년 : varchar(1), NN
학번 : varchar(2), NN
학반 : varchar(2), NN
패스워드 : varchar(10), NN, default value(P.K / 1234 / 1111)

6) 선생님테이블
아이디 : P.K. varchar(10), NN
패스워드 : varchar(20), NN
이름 : varchar(20), NN
과목 : varchar(20), NN
교사상태 : char(1) - 0: 정교사 / 1: 기간제교사 / 2: 방과후교사 / 3: 산학교사 / 4: 기타, N, default value(기타 등등)

선생님 - 수업 - 수업 - 학생
7) 수업테이블 : 체육 등 한 선생님이 모든 반 수업이 있는 경우 / 수학과목처럼 모든 요일에 수업이 있는 경우
ID : 
수업명 : 
개설연도 : 
개설학기 : 
개설학년 : 
개설학반 : 
수업요일 : 
수업시간 : 
교실 : 
F.K : 교사ID - 교사명 / 해당과목

8) 수강생테이블
F.K : 수업테이블ID
F.K : 학생ID - 학생이름(수강생이름)

9) 수행평가테이블
ID : 
-- 수행평가수업 : 
수행평가제목 : 
수행평가시작일시 : 
수행평가종료일시 : 
수행평가타입 : 과제형, 시험형 등등
수행평가내용 : 
-- 수행평가담당선생님 : 
수행평가채점기준 : 

F.K : 수업ID -> 수행평가수업, 수행평가 담당 선생님
F.K : 수행평가에 해당된느 학생 정보(?)

10) 점수 : 점수이의신청, 점수확정 -> 변동이력을 남길지 말지
F.K : 수행평가 ID : 
F.K : 학생 ID : 
점수 : 
확정여부 : 
확정일시 : 

*/

create database highschool;
use highschool;

CREATE TABLE Student (
    s_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    year INT DEFAULT 2024 NOT NULL,
    grade TINYINT NOT NULL,
    class TINYINT NOT NULL,
    stu_num TINYINT NOT NULL,
    password VARCHAR(10) DEFAULT 1111 NOT NULL
);

CREATE TABLE teacher (
    tch_ID VARCHAR(10) NOT NULL PRIMARY KEY,
    password VARCHAR(10) NOT NULL,
    name VARCHAR(20) NOT NULL,
    subject VARCHAR(20) NOT NULL,
    role CHAR(1) DEFAULT '4'
);

CREATE TABLE class (
    c_ID INT AUTO_INCREMENT PRIMARY KEY,
    tch_ID VARCHAR(10) NOT NULL,
    name VARCHAR(20) NOT NULL,
    year INT NOT NULL,
    semester CHAR(1) NOT NULL,
    grade TINYINT NOT NULL,
    class TINYINT NULL,
    date CHAR(1) NOT NULL,
    time VARCHAR(10) NOT NULL,
    room VARCHAR(20) NULL,
    FOREIGN KEY (tch_ID)
        REFERENCES teacher(tch_ID)
);

CREATE TABLE chulsuk (
    s_id INT NOT NULL,
    c_ID INT NOT NULL,
    PRIMARY KEY (s_id , C_ID),
    FOREIGN KEY (s_id)
        REFERENCES student (s_id),
    FOREIGN KEY (C_ID)
        REFERENCES class (C_ID)
);

CREATE TABLE perform (
    p_id INT AUTO_INCREMENT PRIMARY KEY,
    p_title VARCHAR(100) NOT NULL,
    p_type CHAR(1) NULL,
    p_content TINYINT NOT NULL,
    p_kijun VARCHAR(100) NOT NULL,
    p_startdate DATE NOT NULL,
    p_enddate DATE NOT NULL,
    c_ID INT NOT NULL,
    FOREIGN KEY (c_ID)
        REFERENCES class (c_ID)
);

CREATE TABLE evaluation (
    s_id INT NOT NULL,
    p_id INT NOT NULL,
    e_score INT NOT NULL,
    e_check char(1) null,
    e_checkdate date null,
    PRIMARY KEY (p_id , s_id),
    FOREIGN KEY (s_id)
        REFERENCES student (s_id),
    FOREIGN KEY (p_id)
        REFERENCES perform (p_id)
);

