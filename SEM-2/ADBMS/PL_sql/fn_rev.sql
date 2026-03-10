SET SERVEROUTPUT ON;
SET VERIFY OFF;

CREATE OR REPLACE FUNCTION rev_string(og_str IN VARCHAR2)
RETURN VARCHAR2
IS
    rev_str VARCHAR2(100) := '';
    str_len   NUMBER;
BEGIN
    str_len := LENGTH(og_str);
    FOR i IN REVERSE 1..str_len LOOP
        rev_str := rev_str || SUBSTR(og_str, i, 1);
    END LOOP;
    RETURN rev_str;
END;
/

DECLARE
    input_str  VARCHAR2(100) := '&input_str';
    result     VARCHAR2(100);
BEGIN 
    result := rev_string(input_str);
    DBMS_OUTPUT.PUT_LINE('Original String : ' || input_str);
    DBMS_OUTPUT.PUT_LINE('Reversed String : ' || result);
END;
/