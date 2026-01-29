SELECT P.ProductName, C.CategoryName, P.Price 
FROM Products1 P 
LEFT JOIN Categories1 C 
ON P.Category_ID = C.Category_ID 
WHERE P.ProductName = 'Laptop'; 
