drop database if exists store;
create database store;
use store;


create table compartments(
compno int auto_increment primary key,
compname varchar(20)
);

create table shelftype(
typeno int auto_increment primary key,
typename varchar(20)
);

create table shelf(
compno int references compartments(compno),
typeno int references shelftype(typeno),
shelfno int,
primary key (compno,shelfno,typeno)
);

create table packeditems(
pino int auto_increment primary key,
itemname varchar(30)
);

create table dealers(
did int auto_increment primary key,
dname varchar(50),
address varchar(200),
email varchar(100),
mob1 varchar(15),
mob2 varchar(15)
);

create table pisources(
did int references dealers(did),
pIno int references packeditems(pino),
primary key(did,pino)
);

create table orders(
orderno int auto_increment primary key,
did int references dealers(did),
orderdate date,
orderamount float
);

create table orderdetails(
orderno int references orders(orderno),
pino int references packeditems(pino),
cp1unit float,
qtyordered int,
qtyreceived int default '0',
qtycp float,
status varchar(1) default 'N'
);

create table packeditemdetails(
pino int references packeditems(pino),
cp1unit float,
qtyathand int,
qtythreshold int,
compno int references compartments(compno),
typeno int references shelftype(typeno),
shelfno int references shelf(shelfno),
sp1unit float,
primary key(pino,cp1unit)
);

create table bills(
billno int auto_increment primary key,
customername varchar(50),
customermob1 varchar(15),
billdate date,
billamount float
);

create table billdetails(
billno int references bills(billno),
pino int references packeditems(pino),
cp1unit float references packeditemdetails(cp1unit),
qtysold int,
sp1unit float references packeditemdetails(sp1unit),
qtysp float
);

create table login(
user varchar(20),
pass varchar(20)
);

insert into login values('sourabh','password');

