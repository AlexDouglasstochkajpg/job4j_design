create table players(
    id serial primary key,
    name varchar(255)
);

create table games(
    id serial primary key,
    name varchar(255)
);

create table players_games(
    id serial primary key,
    player_id int references players(id),
    game_id int references games(id)
);

insert into players(name) values ('John');
insert into players(name) values ('James');
insert into players(name) values ('Jack');

insert into games(name) values ('Counter-Strike');
insert into games(name) values ('Dota 2');
insert into games(name) values ('Minecraft');

insert into players_games(player_id, game_id) values (1, 1);
insert into players_games(player_id, game_id) values (1, 3);
insert into players_games(player_id, game_id) values (2, 1);
insert into players_games(player_id, game_id) values (2, 2);
insert into players_games(player_id, game_id) values (2, 3);
insert into players_games(player_id, game_id) values (3, 2);