SET SERVEROUTPUT ON;
SET VERIFY OFF;

CREATE OR REPLACE FUNCTION circle_area(radius IN NUMBER)
RETURN NUMBER
IS
    pi   CONSTANT NUMBER := 3.14159;
    area NUMBER;
BEGIN
    area := pi * radius * radius;
    RETURN area;
END;
/

DECLARE
    r      NUMBER;
    result NUMBER;
BEGIN
    r := &r;
    result := circle_area(r);
    DBMS_OUTPUT.PUT_LINE('Radius    : ' || r);
    DBMS_OUTPUT.PUT_LINE('Area      : ' || result);
END;
/