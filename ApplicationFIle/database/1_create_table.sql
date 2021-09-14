create table user(
	id bigint not null primary key auto_increment,
    name varchar(255) null,
    fullname varchar(255) null,
    password varchar(255) null,
    createddate timestamp null
);

create table role(
	id bigint not null primary key ,
    name varchar(100) null
);

create table listenguideline(
	id bigint not null primary key auto_increment,
    title varchar(512) null,
    image varchar(255) null,
    content text null,
    createddate timestamp null,
    modifieddate timestamp null
);

create table comment(
	id bigint not null primary key auto_increment,
    content text null,
    userid bigint null,
    listenguidelineid bigint null,
    createddate timestamp null
)