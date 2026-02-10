SELECT R.sid 
FROM Reserves R, Boats B 
WHERE R.bid = B.bid AND B.color = 'red' 
UNION 
SELECT R.sid 
FROM Reserves R, Boats B 
WHERE R.bid = B.bid AND B.color = 'green'; 

SELECT S.sname 
FROM Sailors S, Reserves R 
WHERE S.sid = R.sid 
AND R.bid = 102;

SELECT S.sname
FROM Sailors S
WHERE NOT EXISTS (
    (SELECT bid FROM Boats)
    MINUS
    (SELECT bid FROM Reserves WHERE sid = S.sid)
);
