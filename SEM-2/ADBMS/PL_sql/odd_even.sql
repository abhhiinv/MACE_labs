set SERVEROUTPUT on;
set verify off;
DECLARE
    num NUMBER;
BEGIN
    num := &num;
    IF MOD(num, 2) = 0 THEN
        DBMS_OUTPUT.PUT_LINE(num || ' is an EVEN number');
    ELSE
        DBMS_OUTPUT.PUT_LINE(num || ' is an ODD number');
    END IF;
END;
/