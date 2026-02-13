SET SERVEROUTPUT on;
DECLARE
    message varchar(20):= 'Hello World!';
begin
    dbms_output.put_line(message);
end;
/
