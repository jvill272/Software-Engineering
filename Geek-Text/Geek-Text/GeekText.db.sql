/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Artur
 * Created: Feb 5, 2022
 */
drop database GeekTextDB;
drop user GeekTextAdmin;
create user GeekTextAdmin with password '1234';
create database GeekTextDB with template=template0 owner=GeekTextAdmin;
/connect GeekTextDB;
alter default privileges grant all on tables to GeekTextAdmin;
alter default privileges grant all on sequences to GeekTextAdmin;

create table users (
user_id integer primary key not null;
first_name varchar(30) not null;
last_name varchar(30) not null,
email varchar(50) not null,
password text not null
);

create table categories (
category_id integer primary key not null;
category_users_fk foreign key (user_id) references users(user_id)
user_id integer not null,
title varchar(20) not null,
description varchar(50) not null
); 

create table transactions(
transaction_id integer primary key not null,
category_id integer not null,
user_id integer not null,
amount numeric(10,2) not null,
note varchar(50) not null,
transaction_date bigint not null
);

alter table transactions add constraint transaction_category_fk
foreign key (category_id) references categories(category_id);

alter table transactions add constraint transaction_users_fk
foreign key (user_id) references users(user_id);


create table books (
book_isbn integer primary key not null;
book_title varchar(30) not null;
book_description text not null,
book_genre varchar(10) not null,
book_author varchar (50) not null,
book_publisher varchar (50) not null,
book_price decimal (10,2) not null;
book_publication_date date not null;
book_copies_cold integar not null;
book_rating decimal(1,2),
);

create sequence users_seq increment 1 start 1;
create sequence categories_seq increment 1 start 1;
create sequence transactions_seq increment 1 start 1000;
create sequence books_seq increment 1 start 1;