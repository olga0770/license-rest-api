-- noinspection SqlNoDataSourceInspectionForFile

-- noinspection SqlDialectInspectionForFile

insert into partner (id, companyName)
values (1, 'Volvo');

insert into partner (id, companyName)
values (2, 'Honda');



insert into user (id, username, partnerid)
values (1, 'olga', 1);

insert into user (id, username, partnerid)
values (2, 'ejner', 1);


insert into customer (id, name)
values (1, 'xxx');

insert into customer (id, name)
values (2, 'zzz');