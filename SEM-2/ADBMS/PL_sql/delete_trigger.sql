-- PROG 34: Write an AFTER DELETE trigger to insert the deleted records
-- into a BACKUP_EMPLOYEES table.

SET SERVEROUTPUT ON;

CREATE TABLE EMPLOYEES (
    EmpId       NUMBER,
    EmpName     VARCHAR2(50),
    Department  VARCHAR2(50),
    Salary      NUMBER
);

CREATE TABLE BACKUP_EMPLOYEES (
    EmpId        NUMBER,
    EmpName      VARCHAR2(50),
    Department   VARCHAR2(50),
    Salary       NUMBER,
    DeletedAt    TIMESTAMP
);

INSERT INTO EMPLOYEES VALUES (1, 'Arun Kumar',    'HR',      55000);
INSERT INTO EMPLOYEES VALUES (2, 'Priya Nair',    'Finance', 72000);
INSERT INTO EMPLOYEES VALUES (3, 'Suresh Menon',  'IT',      45000);
INSERT INTO EMPLOYEES VALUES (4, 'Sneha Thomas',  'IT',      90000);
INSERT INTO EMPLOYEES VALUES (5, 'Santhosh Kumar','HR',      60000);
COMMIT;

CREATE OR REPLACE TRIGGER trg_backup_deleted_emp
AFTER DELETE ON EMPLOYEES
FOR EACH ROW
BEGIN
    INSERT INTO BACKUP_EMPLOYEES (EmpId, EmpName, Department, Salary, DeletedAt)
    VALUES (:OLD.EmpId, :OLD.EmpName, :OLD.Department, :OLD.Salary, SYSTIMESTAMP);

    DBMS_OUTPUT.PUT_LINE('Backup created for: ' || :OLD.EmpName);
END;
/

-- Delete a record to test the trigger
DELETE FROM EMPLOYEES WHERE EmpId = 3;
COMMIT;

-- View backup table
SELECT * FROM BACKUP_EMPLOYEES;