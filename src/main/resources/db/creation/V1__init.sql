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
  time_stamp tinyblob not null,
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
  (1, 1, '2017-05-11 12:22', default, default),
  (2, 2, '2014-05-11 12:22', 150, 200),
  (3, 3, '2016-05-11 12:22', 14000, 1835435),
  (4, 4, '2011-05-11 12:22', 1231230, 5000)




