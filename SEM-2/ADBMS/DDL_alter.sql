alter table Student_1 add Sem int;
alter table Student_1 rename column Sem to Semester;
alter table Student_1 drop column Year;
alter table Student_1 modify Name varchar(100);
UPDATE Sailors SET age=55.5 WHERE sid = 31;
UPDATE Sailors SET age=33.0 WHERE sid = 29;
UPDATE Sailors SET age=45.0 WHERE sid = 22;