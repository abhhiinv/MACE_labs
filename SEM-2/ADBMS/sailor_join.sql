--Find the name and age of the youngest sailor
SELECT S.sname, S.age
FROM Sailors S
INNER JOIN Sailors T
ON S.age = T.age
WHERE S.age = (
    SELECT MIN(age)
    FROM Sailors
);

--Find the names of sailors who have reserved ALL boats
SELECT sname 
FROM Sailors 
NATURAL JOIN Reserves 
GROUP BY sid, sname 
HAVING COUNT(DISTINCT bid) = (
    SELECT COUNT(*) FROM Boats 
);

--Find the ids of sailors who have reserved a red boat OR a green boat
SELECT DISTINCT R.sid
FROM Reserves R
LEFT JOIN Boats B
ON R.bid = B.bid
WHERE B.color = 'red'
   OR B.color = 'green';

--Find the names of sailors who have reserved boat 102
SELECT DISTINCT S.sname
FROM Sailors S
RIGHT JOIN Reserves R
ON S.sid = R.sid
WHERE R.bid = 102;

--Find the names of sailors who have reserved ALL boats
SELECT S.sname
FROM Sailors S
FULL OUTER JOIN Reserves R
ON S.sid = R.sid
GROUP BY S.sid, S.sname
HAVING COUNT(DISTINCT R.bid) = (
    SELECT COUNT(*) FROM Boats
);
