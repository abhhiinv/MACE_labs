SELECT sid
FROM Reserves
WHERE bid IN (
    SELECT bid
    FROM Boats
    WHERE color = 'red' OR color = 'green'
);

SELECT sname
FROM Sailors
WHERE sid IN (
    SELECT sid
    FROM Reserves
    WHERE bid = 102
);
