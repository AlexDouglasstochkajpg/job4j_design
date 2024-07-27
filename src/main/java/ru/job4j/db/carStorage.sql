create table car_bodies(
    id serial primary key,
    name text
);

create table car_engines(
    id serial primary key,
    name text
);

create table car_transmissions(
    id serial primary key,
    name text
);

create table cars(
    id serial primary key,
    name text,
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values ('седан'), ('хэтчбек'), ('пикап'), ('универсал'), ('минивэн');

insert into car_engines(name) values ('бензин'), ('газ'), ('электро');

insert into car_transmissions(name) values ('механика'), ('автомат'), ('робот');

insert into cars(name, body_id, engine_id, transmission_id) values ('Toyota', 3, 1, 2);
insert into cars(name, body_id, engine_id, transmission_id) values ('Lada', 2, 1, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('Porsche', 1, 3, 3);
insert into cars(name, body_id, engine_id, transmission_id) values ('Volkswagen', 5, 1, 2);

select c.name название, cb.name кузов, ce.name двигатель, ct.name as коробка_передач
from cars c
join car_bodies cb on c.body_id = cb.id
join car_engines ce on c.engine_id = ce.id
join car_transmissions ct on c.transmission_id = ct.id;

select cb.name
from car_bodies cb left join cars c
on cb.id = c.body_id
where c.body_id is null;

select ce.name
from car_engines ce left join cars c
on ce.id = c.engine_id
where c.engine_id is null;

select ct.name
from car_transmissions ct left join cars c
on ct.id = c.transmission_id
where c.transmission_id is null;