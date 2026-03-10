SET SERVEROUTPUT ON;
SET VERIFY OFF;

CREATE OR REPLACE FUNCTION find_max(a IN NUMBER, b IN NUMBER)
RETURN NUMBER
IS
    max_val NUMBER;
BEGIN
    IF a > b THEN
        max_val := a;
    ELSE
        max_val := b;
    END IF;
    RETURN max_val;
END;
/

DECLARE
    x      NUMBER;
    y      NUMBER;
    result NUMBER;
BEGIN
    x := &x;
    y := &y;
    result := find_max(x, y);
    -- DBMS_OUTPUT.PUT_LINE('First Number  : ' || x);
    -- DBMS_OUTPUT.PUT_LINE('Second Number : ' || y);
    DBMS_OUTPUT.PUT_LINE('Maximum Value : ' || result);
END;
/