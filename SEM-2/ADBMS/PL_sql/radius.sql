set SERVEROUTPUT on;
declare
radius number := &radius;
area NUMBER;
pi CONSTANT NUMBER := 3.14159;
begin 
area := pi*radius*radius;
dbms_output.put_line('Area of circle with radius '||radius||' is '||area);
end;
/