-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

insert into partner (id, companyName, address, zip, city, country)
values (1, 'IBM Danmark Aps', 'Prøvensvej 1', '2605', 'Brøndby', 'Danmark');

insert into partner (id, companyName, address, zip, city, country)
values (2, 'HP Kontorer Denmark', 'Engholm Parkvej 8', '3450', 'Allerød', 'Danmark');

insert into partner (id, companyName, address, zip, city, country)
values (3, 'Zebra', 'Hummeltoftevej 49', '2830', 'Virum', 'Danmark');

insert into partner (id, companyName, address, zip, city, country)
values (4, 'admin', 'Sejrøgade 11', '2100', 'København Ø', 'Danmark');



insert into user (id, username, password, partnerid, firstname, lastname, email, phone, address, zip, city, country, role)
values (1, 'oscarnielsen', '$2y$12$tmaDbmMcs.EsSkP1udVM9eyNLR9LyM4wNzPC8m7erVEGjktF3.hTm', 1, 'Oscar', 'Nielsen', 'onilsen@gmail.com', '+4599887766', 'Amalienborg Slotsplads 5', '1257', 'København K', 'Danmark', 'USER');

insert into user (id, username, password, partnerid, firstname, lastname, email, phone, address, zip, city, country, role)
values (2, 'josefineandersen', '$2y$12$tmaDbmMcs.EsSkP1udVM9eyNLR9LyM4wNzPC8m7erVEGjktF3.hTm', 1, 'Josefine', 'Andersen', 'jandersen@gmail.com', '+4555664433', 'Ryesgade 53', '2100', 'København', 'Danmark', 'USER');

insert into user (id, username, password, partnerid, firstname, lastname, email, phone, address, zip, city, country, role)
values (3, 'admin', '$2y$12$kxojZ0aA/xdNU42KerOxvOfcJNGGmmM2kYjx2IKkDqhWkTNn.g/bC', 4, 'Dorthe', 'Larsen', 'admin@gmail.com', '+4511223344', 'Sejrøgade 11', '2100', 'København Ø', 'Danmark', 'ADMIN');


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
