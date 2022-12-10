create database hms;
show databases;
use hms;

create table login(username varchar(25), password varchar(25));

insert into login values('admin', '12345');

select * from login;

create table room(roomnumber varchar(10), availability varchar(20), cleaning_status varchar(20), price varchar(20), bed_type varchar(20));

select * from room;

INSERT INTO room values (2,"Available","Clean",2000,"Queen");

select * from room;

create table customer(document varchar(20), number varchar(30), name varchar(30), gender varchar(15), country varchar(20), room varchar(10), checkintime varchar(80), deposit varchar(20));
/* All the Customer data will be added to the Databse from the java application */
select * from customer ;
