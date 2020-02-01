CREATE TABLE movie (
	id INT NOT NULL AUTO_INCREMENT,
	name varchar(30) NOT NULL,
	description varchar(400) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE movie_goers (
	id INT NOT NULL AUTO_INCREMENT,
	name varchar(30) NOT NULL,
	surname varchar(30) NOT NULL,
	email varchar(50) NOT NULL UNIQUE,
	password varchar(30) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE director (
	id INT NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    surname varchar(30) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE genre (
	id INT NOT NULL AUTO_INCREMENT,
	name varchar(20) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE actions (
	id INT NOT NULL AUTO_INCREMENT,
	code varchar(15) NOT NULL UNIQUE,
	description varchar(50),
	PRIMARY KEY (id)
);

CREATE TABLE movies_genres_relations (
	id INT NOT NULL AUTO_INCREMENT,
	movie_id INT NOT NULL,
	genre_id INT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE movies_directors_relations (
	id INT NOT NULL AUTO_INCREMENT,
	movie_id INT NOT NULL,
	director_id INT NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE action_logs (
	id INT NOT NULL AUTO_INCREMENT,
	movie_goer_id INT NOT NULL,
	movie_id INT NOT NULL,
	action_id INT NOT NULL,
	action_value varchar(255),
	time_stamp TIMESTAMP NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE movies_genres_relations ADD CONSTRAINT movies_genres_relations_fk0 FOREIGN KEY (movie_id) REFERENCES movie(id);

ALTER TABLE movies_genres_relations ADD CONSTRAINT movies_genres_relations_fk1 FOREIGN KEY (genre_id) REFERENCES genre(id);

ALTER TABLE movies_directors_relations ADD CONSTRAINT movies_directors_relations_fk0 FOREIGN KEY (movie_id) REFERENCES movie(id);

ALTER TABLE movies_directors_relations ADD CONSTRAINT movies_directors_relations_fk1 FOREIGN KEY (director_id) REFERENCES director(id);

ALTER TABLE action_logs ADD CONSTRAINT action_logs_fk0 FOREIGN KEY (movie_goer_id) REFERENCES movie_goers(id);

ALTER TABLE action_logs ADD CONSTRAINT action_logs_fk1 FOREIGN KEY (movie_id) REFERENCES movie(id);

ALTER TABLE action_logs ADD CONSTRAINT action_logs_fk2 FOREIGN KEY (action_id) REFERENCES actions(id);

