-- PROG 33: Create a procedure for calculating total marks of 
-- three subjects and store the value in the sessional_Exam table.
SET SERVEROUTPUT ON;
SET VERIFY OFF;

CREATE TABLE sessional_Exam (
    StudentId   NUMBER,
    StudentName VARCHAR2(50),
    Sub1        NUMBER,
    Sub2        NUMBER,
    Sub3        NUMBER,
    TotalMarks  NUMBER
);

INSERT INTO sessional_Exam (StudentId, StudentName, Sub1, Sub2, Sub3)
VALUES (1, 'Arun Kumar',   78, 85, 90);
INSERT INTO sessional_Exam (StudentId, StudentName, Sub1, Sub2, Sub3)
VALUES (2, 'Priya Nair',   65, 72, 88);
INSERT INTO sessional_Exam (StudentId, StudentName, Sub1, Sub2, Sub3)
VALUES (3, 'Suresh Menon', 90, 95, 80);
COMMIT;

CREATE OR REPLACE PROCEDURE calc_total_marks (
    s_id  IN NUMBER
)
IS
    s_name  VARCHAR2(50);
    s1      NUMBER;
    s2      NUMBER;
    s3      NUMBER;
    total   NUMBER;
BEGIN
    SELECT StudentName, Sub1, Sub2, Sub3
    INTO s_name, s1, s2, s3
    FROM sessional_Exam
    WHERE StudentId = s_id;

    total := s1 + s2 + s3;

    UPDATE sessional_Exam
    SET TotalMarks = total
    WHERE StudentId = s_id;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Student ID   : ' || s_id);
    DBMS_OUTPUT.PUT_LINE('Student Name : ' || s_name);
    DBMS_OUTPUT.PUT_LINE('Sub1         : ' || s1);
    DBMS_OUTPUT.PUT_LINE('Sub2         : ' || s2);
    DBMS_OUTPUT.PUT_LINE('Sub3         : ' || s3);
    DBMS_OUTPUT.PUT_LINE('Total Marks  : ' || total);
END;
/

DECLARE
    sid NUMBER;
BEGIN
    sid := &student_id;
    calc_total_marks(sid);
END;
/