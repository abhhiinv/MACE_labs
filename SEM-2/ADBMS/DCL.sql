sqlplus system/manager;

CREATE USER abhinav IDENTIFIED BY 123;

SELECT username FROM dba_users; --WHERE username IN ('ABHINAV', 'SYSTEM');

GRANT CREATE SESSION TO abhinav;
GRANT SELECT, INSERT, UPDATE, DELETE ON Employee TO abhinav;

SELECT * FROM dba_tab_privs WHERE grantee = 'ABHINAV';

-- Connect as abhinav
CONNECT abhinav/123

SELECT * FROM Employee;
INSERT INTO system.Employee VALUES (201, 'Abhinav', 55000.00);
UPDATE system.Employee SET Salary = 60000.00 WHERE ID = 201;
DELETE FROM system.Employee WHERE ID = 201;
