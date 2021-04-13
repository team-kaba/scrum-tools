create table account
(
    account_id varchar(50),
    account_name varchar(100),
    password varchar(1000),
    primary key(account_id)
);

create table host
(
    host_id serial,
    account_id varchar(32),
    primary key(event_id),
    foreign key (account_id) references postgres.account
);

create table poker_event
(
    event_id serial,
    host_id serial,
    create_at timestamp with time zone,
    primary key(event_id),
    foreign key (host_id) references postgres.host

);

create table guest
(
    event_id serial,
    guest_id serial,
    account_id varchar(50),
    is_available boolean,
    primary key(event_id),
    foreign key (host_id) references postgres.host

);

create table product_backlog_item
(
    story_point varchar(3),
    confident_degree integer,
    name varchar(50),
    access_at timestamp with time zone
);





