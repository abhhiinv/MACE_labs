SET SERVEROUTPUT ON;
SET VERIFY OFF;

DECLARE
    n          NUMBER;
    factorial  NUMBER := 1;
    i          NUMBER;
BEGIN
    n := &n;
    
    IF n < 0 THEN
        DBMS_OUTPUT.PUT_LINE('Factorial is not defined for negative numbers.');
    ELSIF n = 0 THEN
        DBMS_OUTPUT.PUT_LINE('Factorial of 0 is: 1');
    ELSE
        FOR i IN 1..n LOOP
            factorial := factorial * i;
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('Factorial of ' || n || ' is: ' || factorial);
    END IF;
END;
/