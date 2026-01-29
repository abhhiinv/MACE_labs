alter table Student_1 add Sem int;
alter table Student_1 rename column Sem to Semester;
alter table Student_1 drop column Year;
alter table Student_1 modify Name varchar(100);