--Find the name and the age of the youngest sailor
SELECT Sname, Age
FROM Sailors
WHERE Age = (SELECT MIN(Age) FROM Sailors);

SELECT Rating, AVG(Age) AS Average_Age
FROM Sailors
GROUP BY Rating
ORDER BY Rating;

SELECT COUNT(DISTINCT Sname) AS Different_Names
FROM Sailors;

SELECT AVG(Rating) AS Avg_Rating, 
       MIN(Rating) AS Min_Rating, 
       MAX(Rating) AS Max_Rating
FROM Sailors;

SELECT Sname
FROM Sailors
WHERE Sname LIKE 'P%i';

SELECT Sname
FROM Sailors
WHERE Sname LIKE '%ya%';

SELECT Sname, Age
FROM Sailors
WHERE Age LIKE '%2%';

SELECT Sname
FROM Sailors
WHERE Sname LIKE 'Na__na';

SELECT Sname
FROM Sailors
WHERE Sname NOT LIKE 'Priya';
