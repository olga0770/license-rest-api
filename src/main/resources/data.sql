-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

insert into partner (id, companyName, address, zip, city, country)
values (1, 'Volvo', 'address', 'zip', 'city', 'country');

insert into partner (id, companyName, address, zip, city, country)
values (2, 'Honda', 'address', 'zip', 'city', 'country');

insert into partner (id, companyName, address, zip, city, country)
values (3, 'DHL', 'address', 'zip', 'city', 'country');

insert into partner (id, companyName, address, zip, city, country)
values (4, 'admin', 'address', 'zip', 'city', 'country');



insert into user (id, username, password, partnerid, firstname, lastname, email, phone, address, zip, city, country, role)
values (1, 'olyalo', '$2y$12$tmaDbmMcs.EsSkP1udVM9eyNLR9LyM4wNzPC8m7erVEGjktF3.hTm', 1, 'Olga', 'Batrakova', 'olga@gmail.com', '22334455', 'Taarbæk Strandvej 59L st tv', '2930', 'Klampenborg', 'Denmark', 'USER');

insert into user (id, username, password, partnerid, firstname, lastname, email, phone, address, zip, city, country, role)
values (2, 'ejbo', '$2y$12$tmaDbmMcs.EsSkP1udVM9eyNLR9LyM4wNzPC8m7erVEGjktF3.hTm', 1, 'Ejner', 'Borgbjerg', 'ejner@gmail.com', '22334455', 'Taarbæk Strandvej 59L st tv', '2930', 'Klampenborg', 'Denmark', 'USER');

insert into user (id, username, password, partnerid, firstname, lastname, email, phone, address, zip, city, country, role)
values (3, 'admin', '$2y$12$kxojZ0aA/xdNU42KerOxvOfcJNGGmmM2kYjx2IKkDqhWkTNn.g/bC', 4, 'admin', 'admin', 'admin@gmail.com', '22334455', 'Taarbæk Strandvej 59L st tv', '2930', 'Klampenborg', 'Denmark', 'USER');


insert into customer (id, name)
values (1, 'xxx');
insert into customer (id, name)
values (2, 'zzz');
insert into customer (id, name)
values (3, 'aaa');
insert into customer (id, name)
values (4, 'bbb');
insert into customer (id, name)
values (5, 'ccc');
insert into customer (id, name)
values (6, 'ddd');
insert into customer (id, name)
values (7, 'eee');
insert into customer (id, name)
values (8, 'fff');
insert into customer (id, name)
values (9, 'ggg');
insert into customer (id, name)
values (10, 'hhh');
insert into customer (id, name)
values (11, 'jjj');
insert into customer (id, name)
values (12, 'kkk');
insert into customer (id, name)
values (13, 'lll');
insert into customer (id, name)
values (14, 'mmm');
insert into customer (id, name)
values (15, 'lll');
insert into customer (id, name)
values (16, 'nnn');
insert into customer (id, name)
values (17, 'ooo');
insert into customer (id, name)
values (18, 'ppp');
insert into customer (id, name)
values (19, 'qqq');
insert into customer (id, name)
values (20, 'rrr');
insert into customer (id, name)
values (21, 'sss');
insert into customer (id, name)
values (22, 'ttt');
insert into customer (id, name)
values (23, 'uuu');
insert into customer (id, name)
values (24, 'vvv');
insert into customer (id, name)
values (25, 'www');
