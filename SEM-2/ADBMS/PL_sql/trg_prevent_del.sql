-- PROG 35: Write a trigger that prevents deleting a department from
-- the DEPARTMENTS table if there are employees assigned to it.

SET SERVEROUTPUT ON;

CREATE TABLE DEPARTMENTS (
    DeptId    NUMBER PRIMARY KEY,
    DeptName  VARCHAR2(50)
);

CREATE TABLE DEPT_EMPLOYEES (
    EmpId     NUMBER,
    EmpName   VARCHAR2(50),
    DeptId    NUMBER
);

INSERT INTO DEPARTMENTS VALUES (1, 'HR');
INSERT INTO DEPARTMENTS VALUES (2, 'Finance');
INSERT INTO DEPARTMENTS VALUES (3, 'IT');
INSERT INTO DEPARTMENTS VALUES (4, 'Admin');

INSERT INTO DEPT_EMPLOYEES VALUES (1, 'Arun Kumar',    1);
INSERT INTO DEPT_EMPLOYEES VALUES (2, 'Priya Nair',    2);
INSERT INTO DEPT_EMPLOYEES VALUES (3, 'Suresh Menon',  3);
INSERT INTO DEPT_EMPLOYEES VALUES (4, 'Sneha Thomas',  3);
COMMIT;

CREATE OR REPLACE TRIGGER trg_prevent_dept_delete
BEFORE DELETE ON DEPARTMENTS
FOR EACH ROW
DECLARE
    emp_count NUMBER;
BEGIN
    SELECT COUNT(*)
    INTO emp_count
    FROM DEPT_EMPLOYEES
    WHERE DeptId = :OLD.DeptId;

    IF emp_count > 0 THEN
        RAISE_APPLICATION_ERROR(-20001,
            'Cannot delete department ' || :OLD.DeptName ||
            '. It has ' || emp_count || ' employee(s) assigned to it.');
    END IF;
END;
/

-- Test 1: Try deleting IT department (has employees) - should fail
DELETE FROM DEPARTMENTS WHERE DeptId = 3;

-- Test 2: Try deleting Admin department (no employees) - should succeed
DELETE FROM DEPARTMENTS WHERE DeptId = 4;
COMMIT;