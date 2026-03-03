set SERVEROUTPUT on;
DECLARE
    a NUMBER ;
    b NUMBER ;
BEGIN
    a := &a;
    b := &b;
    IF a > b THEN
        DBMS_OUTPUT.PUT_LINE('Maximum number is: ' || a);
    ELSE
        DBMS_OUTPUT.PUT_LINE('Maximum number is: ' || b);
    END IF;
END;
/