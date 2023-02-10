create database rsvp;

use rsvp;

create table rsvp (
	id int not null auto_increment,
	full_name varchar(20) not null,
    email varchar(50) not null,
    phone decimal(8) not null,
    confirmation_date date,
    comments varchar(100),
    constraint pk_id primary key (id)
);