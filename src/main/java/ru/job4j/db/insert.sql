insert into roles(name) values ('programmer');
insert into users(name, roles_id) values ('John', 1);
insert into rules(name) values ('admin');
insert into roles_rules(roles_id, rules_id) values (1, 1);
insert into categories(name) values ('new category');
insert into states(name) values ('new');
insert into items(name, users_id, categories_id, states_id) values ('first item', 1, 1, 1);
insert into comments(name, items_id) values ('first comment', 1);
insert into attachs(name, items_id) values ('first file', 1);