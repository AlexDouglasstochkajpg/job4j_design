create table departments(
    id serial primary key,
    name text
);

create table employees(
    id serial primary key,
    name text,
    department_id int references departments(id)
);

insert into departments(name) values ('department 1');
insert into departments(name) values ('department 2');
insert into departments(name) values ('department 3');
insert into departments(name) values ('department 4');

insert into employees(name, department_id) values ('employee 1', 1);
insert into employees(name, department_id) values ('employee 2', 1);
insert into employees(name, department_id) values ('employee 3', 1);
insert into employees(name, department_id) values ('employee 4', 2);
insert into employees(name, department_id) values ('employee 5', 2);
insert into employees(name, department_id) values ('employee 6', 3);
insert into employees(name, department_id) values ('employee 7', null);

select * from departments d left join employees e
on d.id = e.department_id;

select * from employees e right join departments d
on e.department_id = d.id;

select * from departments d full join employees e
on d.id = e.department_id;

select * from departments d cross join employees e;

select * from departments d left join employees e
on d.id = e.department_id
where e.department_id is null;

select * from departments d left join employees e
on d.id = e.department_id;

select * from departments d right join employees e
on e.department_id = d.id;

create table teens(
    id serial primary key,
    name text,
    gender varchar(255)
);

insert into teens(name, gender) values ('Вася', 'М');
insert into teens(name, gender) values ('Маша', 'Ж');
insert into teens(name, gender) values ('Дима', 'М');
insert into teens(name, gender) values ('Коля', 'М');
insert into teens(name, gender) values ('Настя', 'Ж');
insert into teens(name, gender) values ('Света', 'Ж');

select distinct t1.name a, t2.name b, concat(t1.gender, t2.gender) "couple"
from teens t1 cross join teens t2 where t1.gender != t2.gender and t1.gender != 'Ж';