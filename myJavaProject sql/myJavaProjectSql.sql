drop database if exists sourabhlib;
create database sourabhlib;
use sourabhlib;

create table almirah(
alno int primary key,
alname varchar(20)
);

create table shelf(
alno int,
shno int,
primary key(alno,shno),
foreign key (alno) references almirah(alno)
);

create table author(
auno int primary key,
auname varchar(30),
email varchar (100)
);

create table book(
bno int primary key,
bname varchar(50),
price int,
auno int references author(auno),
alno int references almirah(alno),
shno int references shelf(shno),
status varchar(1) default 'Y'
);

create table member(
mno int primary key,
mname varchar(20),
address varchar(200),
email varchar(150),
mob1 varchar(15),
mob2 varchar(15),
status varchar(1) default 'Y'
);

create table issue(
bno int references book(bno),
mno int references member(mno),
isdate date,
duedate date
);

create table history(
bno int references book (bno),
mno int references member(mno),
isdate date references issue(isdate),
rtdate date,
fine int
);

create table logs(
username varchar(20),
password varchar(20),
primary key(username,password) 
);

insert into logs values(
'sourabh','password'
);
