--movies
INSERT INTO movies(title,release_date,synopsis,genre,rating,thumbnail_link) VALUES ('The Godfather','1972-01-01','The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.','Drama','Restricted','https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SY1000_CR0,0,704,1000_AL_.jpg');
INSERT INTO movies(title,release_date,synopsis,genre,rating,thumbnail_link) VALUES ('The Good, the Bad and the Ugly','1966-01-02','A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.','Action','Restricted','https://m.media-amazon.com/images/M/MV5BOTQ5NDI3MTI4MF5BMl5BanBnXkFtZTgwNDQ4ODE5MDE@._V1_UX182_CR0,0,182,268_AL_.jpg');
INSERT INTO movies(title,release_date,synopsis,genre,rating,thumbnail_link) VALUES ('The Matrix','1999-01-03','A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.','Sci-Fi','Restricted','https://m.media-amazon.com/images/M/MV5BNzQzOTk3OTAtNDQ0Zi00ZTVkLWI0MTEtMDllZjNkYzNjNTc4L2ltYWdlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_UX182_CR0,0,182,268_AL_.jpg');
INSERT INTO movies(title,release_date,synopsis,genre,rating,thumbnail_link) VALUES ('Avengers: Endgame','2019-01-04','After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos'' actions and restore balance to the universe.','Adventure','Parents Strongly Cautioned','https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_UX182_CR0,0,182,268_AL_.jpg');
INSERT INTO movies(title,release_date,synopsis,genre,rating,thumbnail_link) VALUES ('Toy Story 4','2019-01-05','When a new toy called "Forky" joins Woody and the gang, a road trip alongside old and new friends reveals how big the world can be for a toy.','Animation','General Audience','https://m.media-amazon.com/images/M/MV5BMTYzMDM4NzkxOV5BMl5BanBnXkFtZTgwNzM1Mzg2NzM@._V1_UX182_CR0,0,182,268_AL_.jpg');
INSERT INTO movies(title,release_date,synopsis,genre,rating,thumbnail_link) VALUES ('Jumanji: The Next Level','2019-01-06','In Jumanji: The Next Level, the gang is back but the game has changed. As they return to rescue one of their own, the players will have to brave parts unknown from arid deserts to snowy mountains, to escape the world''s most dangerous game.','Comedy','Parents Strongly Cautioned','https://m.media-amazon.com/images/M/MV5BOTVjMmFiMDUtOWQ4My00YzhmLWE3MzEtODM1NDFjMWEwZTRkXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UX182_CR0,0,182,268_AL_.jpg');


--directors
INSERT INTO directors(name,surname) VALUES ('Francis', 'Coppola');
INSERT INTO directors(name,surname) VALUES ('Sergio', 'Leone');
INSERT INTO directors(name,surname) VALUES ('Lana', 'Wachowski');
INSERT INTO directors(name,surname) VALUES ('Lily', 'Wachowski');
INSERT INTO directors(name,surname) VALUES ('Anthony', 'Russo');
INSERT INTO directors(name,surname) VALUES ('Joe', 'Russo');
INSERT INTO directors(name,surname) VALUES ('Josh', 'Cooley');
INSERT INTO directors(name,surname) VALUES ('Jake', 'Kasdan');
INSERT INTO directors(name,surname) VALUES ('Joe', 'Johnston');


--movies-directors-relations
insert into movies_directors_relations values (
(select id from movies where title = 'The Godfather'),
(select id from directors where name = 'Francis' and surname = 'Coppola')
);

insert into movies_directors_relations values (
(select id from movies where title = 'The Good, the Bad and the Ugly'),
(select id from directors where name = 'Sergio' and surname = 'Leone')
);

insert into movies_directors_relations values (
(select id from movies where title = 'The Matrix'),
(select id from directors where name = 'Lana' and surname = 'Wachowski')
);

insert into movies_directors_relations values (
(select id from movies where title = 'The Matrix'),
(select id from directors where name = 'Lily' and surname = 'Wachowski')
);

insert into movies_directors_relations values (
(select id from movies where title = 'Avengers: Endgame'),
(select id from directors where name = 'Anthony' and surname = 'Russo')
);

insert into movies_directors_relations values (
(select id from movies where title = 'Avengers: Endgame'),
(select id from directors where name = 'Joe' and surname = 'Russo')
);

insert into movies_directors_relations values (
(select id from movies where title = 'Toy Story 4'),
(select id from directors where name = 'Josh' and surname = 'Cooley')
);

insert into movies_directors_relations values (
(select id from movies where title = 'Toy Story 4'),
(select id from directors where name = 'Jake' and surname = 'Kasdan')
);

insert into movies_directors_relations values (
(select id from movies where title = 'Jumanji: The Next Level'),
(select id from directors where name = 'Joe' and surname = 'Johnston')
);


--movie_goer
insert into movie_goers values ('demo', 'demo', 'demo', 'demo');