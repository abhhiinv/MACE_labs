sqlplus system/manager;

CREATE USER abhinav IDENTIFIED BY 123;

SELECT username FROM dba_users; --WHERE username IN ('ABHINAV', 'SYSTEM');

GRANT CREATE SESSION TO abhinav;
GRANT SELECT, INSERT, UPDATE, DELETE ON Employee TO abhinav;

SELECT * FROM dba_tab_privs WHERE grantee = 'ABHINAV';

-- Connect as abhinav
CONNECT abhinav/123

SELECT * FROM sys.Employee;
INSERT INTO sys.Employee VALUES (201, 'Abhinav', 55000.00);
UPDATE sys.Employee SET Salary = 60000.00 WHERE ID = 201;
DELETE FROM sys.Employee WHERE ID = 201;

grant dba to abhinav;

create user user2 identified by 123;

grant create session to user2;
GRANT SELECT, INSERT ON sys.Employee TO user2;

select * from sys.Employee;
insert into sys.Employee values(201,'Abhinav',55000.00);
update sys.Employee set Salary = 60000.00 where ID = 201;

REVOKE SELECT, INSERT ON sys.Employee FROM user2;
revoke dba from user2;

drop user user2;