SET SERVEROUTPUT ON;
SET VERIFY OFF;

CREATE OR REPLACE PROCEDURE compute_square(
    num IN OUT NUMBER
)
IS
BEGIN
    num := num * num;
END;
/

DECLARE
    n NUMBER;
BEGIN
    n := &n;
    DBMS_OUTPUT.PUT_LINE('Original Value : ' || n);
    compute_square(n);
    DBMS_OUTPUT.PUT_LINE('Square Value   : ' || n);
END;
/