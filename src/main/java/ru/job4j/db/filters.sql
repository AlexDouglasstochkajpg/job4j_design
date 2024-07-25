create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price int
);

insert into type(name) values ('Мясо'), ('Рыба'), ('Молочные'), ('Овощи'), ('Фрукты'), ('Сыр'), ('Мороженое');
insert into product(name, type_id, expired_date, price) values
('Говядина', 1, '2024-08-10', 500), ('Свинина', 1, '2024-08-12', 700);
insert into product(name, type_id, expired_date, price) values
('Форель', 2, '2024-08-01', 1500), ('Палтус', 2, '2024-08-05', 1000);
insert into product(name, type_id, expired_date, price) values
('Творог', 3, '2024-10-01', 150), ('Кефир', 3, '2024-08-20', 100);
insert into product(name, type_id, expired_date, price) values
('Помидор', 4, '2024-07-24', 80), ('Огурец', 4, '2024-08-03', 70);
insert into product(name, type_id, expired_date, price) values
('Апельсин', 5, '2024-08-08', 120), ('Груша', 5, '2024-08-06', 110);
insert into product(name, type_id, expired_date, price) values
('Сыр с орехами', 6, '2024-09-25', 300), ('Сыр с плесенью', 6, '2024-09-05', 1200);
insert into product(name, type_id, expired_date, price) values
('Мороженое Эскимо', 7, '2024-11-15', 250), ('Мороженое Фруктовый лёд', 7, '2024-12-15', 220);

select * from product p join type t
on p.type_id = t.id
where type_id = 6;

select * from product where name like '%Мороженое%';

select * from product where expired_date < current_date;

select * from product where price = (select max(price) from product);

select t.name, count(p.type_id)
from product p join type t
on p.type_id = t.id
group by t.name;

select p.name
from product p join type t
on p.type_id = t.id
where t.name = 'Сыр' or t.name = 'Молочные';

select t.name, count(p.type_id)
from product p join type t
on p.type_id = t.id
group by t.name
having count(p.type_id) < 10;

select * from product p join type t
on p.type_id = t.id;