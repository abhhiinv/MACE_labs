SELECT MAX(P.Price) AS MaxPrice
FROM Products1 P
NATURAL JOIN Categories1 C;
