create table cars(
	id serial primary key,
	name text,
	price integer,
	transmission text
);

insert into cars(name, price, transmission)
values('BMW', 5000000, 'automatic');
insert into cars(name, price, transmission)
values('Lada', 1000000, 'mechanic');
insert into cars(name, price, transmission)
values('Porsche', 10000000, 'robot');
insert into cars(name, price, transmission)
values('Toyota', 4000000, 'automatic');
insert into cars(name, price, transmission)
values('Kia', 2500000, 'automatic');