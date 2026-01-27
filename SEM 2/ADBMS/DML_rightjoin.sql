SELECT P.ProductName, C.CategoryName, P.Price
FROM Products1 P
RIGHT JOIN Categories1 C
ON P.Category_ID = C.Category_ID
WHERE C.CategoryName = 'Clothing';