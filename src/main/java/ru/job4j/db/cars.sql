create table cars(
    id serial primary key,
    model text,
    price integer,
    european_car boolean
);
insert into cars(model, price, european_car) values('BMW', 8000000, true);
select * from cars;
update cars set model = 'Toyota', price = 4500000, european_car = false;
select * from cars;
delete from cars;
select * from cars;