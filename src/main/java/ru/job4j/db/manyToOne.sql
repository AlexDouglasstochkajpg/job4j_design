create table assessment(
    id serial primary key,
    name varchar(255)
);

create table students(
    id serial primary key,
    name varchar(255),
    assessment_id int references assessment(id)
);

insert into assessment(name) values ('five');
insert into students(name, assessment_id) VALUES ('John', 1);

select * from students;
select * from assessment where id in (select assessment_id from students)