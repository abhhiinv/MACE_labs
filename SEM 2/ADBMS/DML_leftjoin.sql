SELECT P.ProductName, C.CategoryName, P.Price
FROM Products1 P
LEFT JOIN Categories1 C
ON P.Category_ID = C.Category_ID
WHERE P.ProductName = 'Laptop';

SELECT P.ProductName, C.CategoryName, P.Price
FROM Products1 P
RIGHT JOIN Categories1 C
ON P.Category_ID = C.Category_ID
WHERE C.CategoryName = 'Clothing';

SELECT MIN(P.Price) AS Min_Price
FROM Products1 P
FULL JOIN Categories1 C
ON P.Category_ID = C.Category_ID;
