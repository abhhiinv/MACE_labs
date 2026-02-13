set SERVEROUTPUT on;
declare
    num1 NUMBER := 100;
    num2 number := 27;
    result number;
begin 
    result := num1 + num2;

    dbms_output.put_line(' The sum of '|| num1 ||' and '|| num2 ||' is '||result);
end;
/