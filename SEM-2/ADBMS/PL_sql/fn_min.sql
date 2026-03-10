SET SERVEROUTPUT ON;
SET VERIFY OFF;

CREATE OR REPLACE PROCEDURE find_min(
    a       IN  NUMBER,
    b       IN  NUMBER,
    min_val OUT NUMBER
)
IS
BEGIN
    IF a < b THEN
        min_val := a;
    ELSE
        min_val := b;
    END IF;
END;
/

DECLARE
    x      NUMBER;
    y      NUMBER;
    result NUMBER;
BEGIN
    x := &x;
    y := &y;
    find_min(x, y, result);
    DBMS_OUTPUT.PUT_LINE('First Number  : ' || x);
    DBMS_OUTPUT.PUT_LINE('Second Number : ' || y);
    DBMS_OUTPUT.PUT_LINE('Minimum Value : ' || result);
END;
/