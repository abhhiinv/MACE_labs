set SERVEROUTPUT on;
set verify off;
DECLARE
    original_str  VARCHAR2(100):='';
    reversed_str  VARCHAR2(100) := '';
    str_length    NUMBER;
BEGIN
    original_str := '&original_str';
    str_length := LENGTH(original_str);

    FOR i IN REVERSE 1..str_length LOOP
        reversed_str := reversed_str || SUBSTR(original_str, i, 1);
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Original String : ' || original_str);
    DBMS_OUTPUT.PUT_LINE('Reversed String : ' || reversed_str);
END;
/