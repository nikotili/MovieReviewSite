CREATE DATABASE IF NOT EXISTS movie_review;

CREATE TABLE movies
(
    id           INT          NOT NULL AUTO_INCREMENT,
    title        varchar(30)  NOT NULL,
    release_date DATE         NOT NULL,
    synopsis     varchar(400),
    genre        varchar(30)  NOT NULL,
    rating       varchar(30)  NOT NULL,
    thumbnail_link varchar(1000),
    PRIMARY KEY (id)
);

CREATE TABLE movie_goers
(
    name     varchar(30) NOT NULL,
    surname  varchar(30) NOT NULL,
    email    varchar(50) NOT NULL,
    password varchar(30) NOT NULL,
    PRIMARY KEY (email)
);

CREATE TABLE directors
(
    id      INT         NOT NULL AUTO_INCREMENT,
    name    varchar(30) NOT NULL,
    surname varchar(30) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE movies_directors_relations
(
    movie_id    INT NOT NULL,
    director_id INT NOT NULL,
    PRIMARY KEY (movie_id, director_id)
);

CREATE TABLE ratings
(
    movie_goer_email VARCHAR(50)  NOT NULL,
    movie_id         INT          NOT NULL,
    rating           INT          NOT NULL,
    comment          varchar(100),
    PRIMARY KEY (movie_goer_email, movie_id)
);



ALTER TABLE movies_directors_relations
    ADD CONSTRAINT movies_directors_relations_fk0 FOREIGN KEY (movie_id) REFERENCES movies (id);

ALTER TABLE movies_directors_relations
    ADD CONSTRAINT movies_directors_relations_fk1 FOREIGN KEY (director_id) REFERENCES directors (id);

ALTER TABLE rating
    ADD CONSTRAINT ratings_fk0 FOREIGN KEY (movie_goer_email) REFERENCES movie_goers (email);

ALTER TABLE rating
    ADD CONSTRAINT ratings_fk1 FOREIGN KEY (movie_id) REFERENCES movies (id);

ALTER TABLE `movies` CHANGE `thumbnail_link` `thumbnail_link` VARCHAR(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL;