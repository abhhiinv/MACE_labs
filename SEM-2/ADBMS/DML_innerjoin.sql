create table Categories1(
    Category_ID int PRIMARY KEY,
    CategoryName VARCHAR (50),
    Description VARCHAR (255)
);

create table Products1(
    Product_ID int PRIMARY KEY,
    ProductName VARCHAR (50),
    Category_ID int ,
    Price NUMBER (10,2),
    FOREIGN KEY (Category_ID) REFERENCES Categories1 (Category_ID)
);

INSERT INTO Categories1 VALUES (1, 'Electronics', 'Electronic items');
INSERT INTO Categories1 VALUES (2, 'Clothing', 'Apparel and garments');
INSERT INTO Categories1 VALUES (3, 'Furniture', 'Home and office furniture');

INSERT INTO Products1 VALUES (101, 'Laptop', 1, 55000.00);
INSERT INTO Products1 VALUES (102, 'Mobile Phone', 1, 25000.00);
INSERT INTO Products1 VALUES (103, 'T-Shirt', 2, 1200.00);
INSERT INTO Products1 VALUES (104, 'Jeans', 2, 2200.00);
INSERT INTO Products1 VALUES (105, 'Chair', 3, 3500.00);

SELECT P.ProductName, C.CategoryName, P.Price
FROM Products1 P
INNER JOIN Categories1 C
ON P.Category_ID = C.Category_ID
ORDER BY P.Price ASC;
