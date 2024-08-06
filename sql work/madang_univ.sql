create database madangUniv; 

use madangUniv;

CREATE TABLE professor (
    ssn VARCHAR(40) NOT NULL PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    age TINYINT,
    ranks VARCHAR(20) NOT NULL,
    specialty VARCHAR(20) NOT NULL
);

CREATE TABLE department (
    dno INT NOT NULL PRIMARY KEY,
    dname VARCHAR(40) NOT NULL,
    office VARCHAR(20),
    depthead_ID varchar(40) NOT NULL,
    FOREIGN KEY (depthead_ID)
        REFERENCES professor (ssn)
);

CREATE TABLE graduate (
    ssn VARCHAR(40) NOT NULL PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    age TINYINT,
    deg_prog CHAR(1) NOT NULL,
    major INT NOT NULL,
    advisor VARCHAR(40),
    FOREIGN KEY (major)
        REFERENCES department (dno),
    foreign key (advisor)
		references graduate (ssn)
);

CREATE TABLE project (
    pid varchar(20) NOT NULL PRIMARY KEY,
    sponsor VARCHAR(40),
    start_date DATE,
    end_date DATE,
    budget INT NOT NULL,
    manager varchar(40) not null,
    foreign key (manager) references professor(ssn)
);

CREATE TABLE work_dept (
    p_ssn VARCHAR(40) NOT NULL,
    dno INT NOT NULL,
    pct_time INT NOT NULL,
    foreign key (p_ssn) references professor (ssn),
    foreign key (dno) references department (dno),
    PRIMARY KEY (p_ssn , dno)
);

-- 공동연구자
CREATE TABLE work_in (
    pid varchar(20) NOT NULL,
    p_ssn VARCHAR(40) NOT NULL,
    FOREIGN KEY (pid)
        REFERENCES project (pid),
    FOREIGN KEY (p_ssn)
        REFERENCES professor (ssn),
    PRIMARY KEY (pid , p_ssn)
);

-- 프로젝트 참여 대학원생
CREATE TABLE work_prog (
    pid varchar(20) NOT NULL,
    g_ssn VARCHAR(40) NOT NULL,
    FOREIGN KEY (g_ssn)
        REFERENCES graduate (ssn),
    FOREIGN KEY (pid)
        REFERENCES project (pid),
	primary key (pid, g_ssn)
);

-- drop table ;



select * from professor;
select * from department;
select * from graduate;
select * from project;
select * from work_dept;
select * from work_in;
select * from work_prog;