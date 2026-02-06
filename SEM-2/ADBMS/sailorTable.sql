insert into Sailors values(31,'Lubber',8,55.5);
insert into Sailors values(32,'Andy',8,25.5);
insert into Sailors values(58,'Rusty',10,35.0);
insert into Sailors values(64,'Horatio',7,35.0);
insert into Sailors values(71,'Zorba',10,16.0);
insert into Sailors values(74,'Horatio',9,35.0);
insert into Sailors values(84,'Art',3,25.5);
insert into Sailors values(95,'Bob',3,63.5);
create table Boats(
    bid int primary key,
    bname varchar(30),
    color varchar(30)
);
insert into Boats values(101,'Interlake','blue');
insert into Boats values(102,'Interlake','red');
insert into Boats values(103,'Clipper','green');
insert into Boats values(104,'Marine','red');
create table Reserves(
    sid int ,
    bid int,
    day date,
    primary key (sid,bid,day),
    foreign KEY (sid) REFERENCES Sailors(sid),
    foreign KEY (bid) REFERENCES Boats(bid)
);
insert into Reserves values(22,101,'10-oct-1998');

insert into Reserves values(22,102,'10-oct-1998');
insert into Reserves values(22,103,'10-aug-1998');
insert into Reserves values(22,104,'10-jul-1998');
insert into Reserves values(31,102,'11-oct-1998');
insert into Reserves values(31,103,'11-jun-1998');
insert into Reserves values(31,104,'11-dec-1998');
insert into Reserves values(64,101,'09-may-1998');
insert into Reserves values(64,102,'09-aug-1998');
insert into Reserves values(74,103,'09-may-1998');
select * from Boat;