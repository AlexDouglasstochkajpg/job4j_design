CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers(first_name, last_name, age, country)
values ('Boris', 'Krasnov', 35, 'Russia');
insert into customers(first_name, last_name, age, country)
values ('Bill', 'Addams', 29, 'USA');
insert into customers(first_name, last_name, age, country)
values ('Thomas', 'Smith', 32, 'Great Britain');
insert into customers(first_name, last_name, age, country)
values ('Tadeusz', 'Kalinowski', 24, 'Poland');
insert into customers(first_name, last_name, age, country)
values ('Leonardo', 'Esposito', 37, 'Italy');

select * from customers
where age in (select min(age) from customers);

CREATE TABLE orders
(
    id          serial primary key,
    amount      int,
    customer_id int references customers (id)
);

insert into orders(amount, customer_id) values(1000, 1);
insert into orders(amount, customer_id) values(5000, 2);
insert into orders(amount, customer_id) values(2500, 4);
insert into orders(amount, customer_id) values(3500, 5);

select * from customers
where id not in (select customer_id from orders);