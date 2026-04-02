--PROG 32  Create a procedure named count_employees that counts
--the number of employees in a specific department. 
SET SERVEROUTPUT ON;
SET VERIFY OFF;

CREATE TABLE Employee (
    EmpId       NUMBER,
    EmpName     VARCHAR2(50),
    Department  VARCHAR2(50),
    Salary      NUMBER
);

INSERT INTO Employee VALUES (1, 'Arun Kumar',    'HR',      55000);
INSERT INTO Employee VALUES (2, 'Priya Nair',    'Finance', 72000);
INSERT INTO Employee VALUES (3, 'Suresh Menon',  'HR',      45000);
INSERT INTO Employee VALUES (4, 'Sneha Thomas',  'IT',      90000);
INSERT INTO Employee VALUES (5, 'Santhosh Kumar','IT',      60000);
INSERT INTO Employee VALUES (6, 'Anjali Dev',    'Finance', 48000);
INSERT INTO Employee VALUES (7, 'Rahul Pillai',  'HR',      52000);
COMMIT;

CREATE OR REPLACE PROCEDURE count_employees (
    dept_name  IN  VARCHAR2,
    emp_count  OUT NUMBER
)
IS
BEGIN
    SELECT COUNT(*)
    INTO emp_count
    FROM Employee
    WHERE Department = dept_name;

    DBMS_OUTPUT.PUT_LINE('Department    : ' || dept_name);
    DBMS_OUTPUT.PUT_LINE('Employee Count: ' || emp_count);
END;
/

DECLARE
    dept   VARCHAR2(50);
    count  NUMBER;
BEGIN
    dept := '&dept_name';
    count_employees(dept, count);
END;
/