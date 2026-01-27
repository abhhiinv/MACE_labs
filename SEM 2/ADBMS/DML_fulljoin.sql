SELECT MIN(P.Price) AS Min_Price
FROM Products1 P
FULL JOIN Categories1 C
ON P.Category_ID = C.Category_ID;
