drop database if exists bloodbank;
create database bloodbank;
use bloodbank;

create table blood(
bid int primary key,
bloodgroup varchar(4) not null,
qty int default '0'
);

create table donor(
did int primary key,
dfname varchar(20),
dlname varchar (20),
address varchar(200),
email varchar(50),
pincode varchar(6),
mob1 varchar(15),
mob2 varchar(15),
bid int references blood(bid),
lastdonation date
);

create table donortransactions(
did int,
donationdt date,
qty int,
primary key(did,donationdt)
);

create table patient(
pid int primary key,
pfname varchar(20),
plname varchar(20),
address varchar(200),
email varchar(50),
pincode varchar(6),
mob1 varchar(15),
mob2 varchar(15),
bid int references blood(bid)
);

create table patienttransactions(
pid int references patient(pid),
receivingdt date,
receivingtime int,
qty int,
primary key(pid,receivingdt,receivingtime)
);

create table log(
username varchar(20),
password varchar(20),
primary key(username,password) 
);

insert into log values(
'sourabh','password'
);

insert into blood values(
1,'A+',10);
insert into blood values(
2,'A-',10);
insert into blood values(
3,'B+',10);
insert into blood values(
4,'B-',10);
insert into blood values(
5,'AB+',10);
insert into blood values(
6,'AB-',10);
insert into blood values(
7,'O+',10);
insert into blood values(
8,'O-',10);

