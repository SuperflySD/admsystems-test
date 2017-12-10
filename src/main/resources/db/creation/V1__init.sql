drop schema if exists traffic_db;
CREATE SCHEMA traffic_db;
USE traffic_db;

create table subscriber
(
  id int auto_increment primary key,
  subscriber_name varchar(255) not null
);

create table traffic
(
  id int auto_increment primary key,
  subscriber_id int not null,
  time_stamp TIMESTAMP not null,
  traffic_downlink bigint null,
  traffic_uplink bigint null,
  constraint fk_traffic_subscriber foreign key (subscriber_id) references subscriber (id)
);

create index traffic_index
  on traffic (subscriber_id);

insert into subscriber values
  (1, 'Ivanov'),
  (2, 'Petrov'),
  (3, 'Vodkin'),
  (4,' Smith' );

insert into traffic values
  (default, 1, '2017-05-11 12:22:34', default, default),
  (default, 1, '2017-12-12 12:22:34', 4564635634, 57656756757),
  (default, 2, '2014-05-11 12:22:23', 363453453453, 543634634),
  (default, 2, '2016-09-11 12:22:23', 4326726780, 123557690870),
  (default, 2, '2017-11-12 12:22:23', 3234626234, 878566),
  (default, 3, '2016-05-11 12:22:56', 46578686, 183543546745),
  (default, 3, '2016-12-2 12:22:56', 45654356, 456464536),
  (default, 4, '2017-05-11 12:22:12', 12314564356230, 546545654),
  (default, 4, '2017-12-3 12:22:12', 4578568568, 345346456634);




