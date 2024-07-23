create table class(
    id serial primary key,
    name text
);

create table students(
    id serial primary key,
    name text,
    class_id int references class(id)
);

insert into class(name) values ('1A');
insert into class(name) values ('1B');
insert into class(name) values ('1C');
insert into class(name) values ('1D');

insert into students(name, class_id) values ('John', 1);
insert into students(name, class_id) values ('James', 2);
insert into students(name, class_id) values ('Jack', 3);
insert into students(name, class_id) values ('Joe', 4);

select * from students join class
on students.class_id = class.id;

select s.name, c.name from students as s join class as c
on s.class_id = c.id;

select s.name Имя, c.name as "Номер класса" from students s join class c
on s.class_id = c.id;


