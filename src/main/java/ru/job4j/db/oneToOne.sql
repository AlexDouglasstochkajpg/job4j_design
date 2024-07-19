create table numbers(
    id serial primary key,
    region int,
    number int
);

create table cars(
    id serial primary key,
    name varchar(255)
);

create table numbers_cars(
    id serial primary key,
    number_id int references number(id) unique,
    car_id int references car(id) unique
);