set SERVEROUTPUT on;
declare
radius number(10,2) := &radius;
area NUMBER(20,2);
begin 
area := 3.14*radius*radius;
dbms_output.put_line('Area of circle with radius '||radius||' is '||area);
end;
/