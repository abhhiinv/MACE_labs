create table Employee(
    ID int primary key,
    Name varchar(30),
    Salary number(10,2)
);

--commit
INSERT INTO Employee VALUES (101, 'John', 50000.00);
INSERT INTO Employee VALUES (102, 'Alice', 45000.00);
INSERT INTO Employee VALUES (103, 'Bob', 55000.00);
COMMIT;

SELECT * FROM Employee;

--savepoint
SAVEPOINT sp1;

INSERT INTO Employee VALUES (104, 'David', 48000.00);
INSERT INTO Employee VALUES (105, 'Eve', 52000.00);

SELECT * FROM Employee;

--rollback
ROLLBACK to sp1;
select * from Employee;

INSERT INTO Employee VALUES (106, 'Frank', 60000.00);
INSERT INTO Employee VALUES (107, 'Grace', 47000.00);
INSERT INTO Employee VALUES (108, 'Henry', 53000.00);
COMMIT;

SELECT * FROM Employee;

--savepoint 2
SAVEPOINT sp2;

INSERT INTO Employee VALUES (109, 'Ivy', 49000.00);
INSERT INTO Employee VALUES (110, 'Jack', 51000.00);
INSERT INTO Employee VALUES (111, 'Kate', 54000.00);
INSERT INTO Employee VALUES (112, 'Leo', 46000.00);

ROLLBACK TO sp2;

SELECT * FROM Employee;
