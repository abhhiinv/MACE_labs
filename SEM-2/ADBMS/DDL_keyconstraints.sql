create table Department(
    Dept_ID int PRIMARY KEY,
    Dept_Name varchar(40) not NULL,
    HOD varchar(40)
);

create table Employee(
    Emp_ID int PRIMARY KEY,
    Name VARCHAR(40) UNIQUE,
    Dept_ID int,
    Salary number(8,2) check(Salary>0),
    foreign key (Dept_ID) REFERENCES Department (Dept_ID)
);