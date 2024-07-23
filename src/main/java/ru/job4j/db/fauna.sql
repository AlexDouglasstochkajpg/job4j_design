create table fauna(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('fish', 10, '1151-07-01');
insert into fauna(name, avg_age, discovery_date) values ('medusa', 12000, '1351-07-01');
insert into fauna(name, avg_age, discovery_date) values ('bear', 30, '1551-07-01');
insert into fauna(name, avg_age, discovery_date) values ('lion', 12, '1751-07-01');
insert into fauna(name, avg_age, discovery_date) values ('wolf', 10, 'null');
insert into fauna(name, avg_age, discovery_date) values ('tiger', 14, '1951-07-01');

select * from fauna;
select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '01.01.1950';