create table Products(
    Prod_ID int PRIMARY KEY,
    Name varchar(100),
    Category varchar(100),
    MFG_Date date,
    Quantity int,
    Price number(6,2)
);

insert into Products values(1,'Pen','Stationary','12-JUN-2025',10,10.0);
insert into Products values(2,'Milk','Dairy','21-JAN-2026',5,45.0);
insert into Products values(3,'Book','Stationary','23-JUL-2025',20,40.0);

select distinct Category from Products;