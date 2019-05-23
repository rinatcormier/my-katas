drop table if exists emp;
drop table if exists dept;

CREATE TABLE dept
(
    deptno char(50) NOT NULL PRIMARY KEY,
    dname  char(50) NOT NULL,
    loc    char(50) NOT NULL
);

CREATE TABLE emp
(
    empno    int      NOT NULL PRIMARY KEY,
    ename    char(50) NOT NULL,
    job      char(50) NOT NULL,
    mgr      int      NULL,
    hiredate date     NOT NULL,
    sal      int      NOT NULL,
    comm     int      NULL,
    depno    char(50) NOT NULL
);

ALTER TABLE emp
    ADD
        CONSTRAINT FK_emp_mgr FOREIGN KEY (mgr) REFERENCES emp (empno);

ALTER TABLE emp
    ADD
        CONSTRAINT FK_emp_dept FOREIGN KEY (depno) REFERENCES dept (deptno);

--
insert into dept (deptno, dname, loc) values ('10', 'ACCOUNTING', 'NEW YORK');
insert into dept (deptno, dname, loc) values ('20', 'RESEARCH', 'DALLAS');
insert into dept (deptno, dname, loc) values ('30', 'SALES', 'CHICAGO');
insert into dept (deptno, dname, loc) values ('40', 'OPERATIONS', 'BOSTON');

--
insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7839, 'KING', 'PRESIDENT', null, '1981-10-17', 5000, null, '10');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 2975, null, '20');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 2850, null, '30');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 2450, null, '10');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 3000, null, '10');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7369, 'SMITH', 'CLERK', 7902, '1980-12-17', 800, null, '20');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 1600, 300, '30');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 1250, 500, '30');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 1250, 1400, '30');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7788, 'SCOTT', 'ANALYST', 7566, '1982-12-09', 3000, null, '20');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 1500, 0, '30');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7876, 'ADAMS', 'CLERK', 7788, '1983-01-12', 1100, null, '20');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 950, null, '30');

insert into emp (empno, ename, job, mgr, hiredate, sal, comm, depno)
values (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 1300, null, '10');