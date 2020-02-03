CREATE DATABASE IF NOT EXISTS movie_review;

CREATE TABLE movies
(
    id           INT          NOT NULL AUTO_INCREMENT,
    title        varchar(30)  NOT NULL,
    release_date DATE         NOT NULL,
    synopsis     varchar(400) NOT NULL,
    genre        varchar(30)  NOT NULL,
    rating       varchar(10)  NOT NULL,
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

CREATE TABLE actions
(
    code        varchar(15) NOT NULL UNIQUE,
    description varchar(50),
    PRIMARY KEY (code)
);

CREATE TABLE movies_directors_relations
(
    movie_id    INT NOT NULL,
    director_id INT NOT NULL,
    PRIMARY KEY (movie_id, director_id)
);

CREATE TABLE action_logs
(
    id               INT         NOT NULL AUTO_INCREMENT,
    movie_goer_email varchar(50) NOT NULL,
    movie_id         INT         NOT NULL,
    action_code      varchar(15) NOT NULL,
    action_value     varchar(255),
    time_stamp       TIMESTAMP   NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE movies_directors_relations
    ADD CONSTRAINT movies_directors_relations_fk0 FOREIGN KEY (movie_id) REFERENCES movies (id);

ALTER TABLE movies_directors_relations
    ADD CONSTRAINT movies_directors_relations_fk1 FOREIGN KEY (director_id) REFERENCES directors (id);

ALTER TABLE action_logs
    ADD CONSTRAINT action_logs_fk0 FOREIGN KEY (movie_goer_email) REFERENCES movie_goers (email);

ALTER TABLE action_logs
    ADD CONSTRAINT action_logs_fk1 FOREIGN KEY (movie_id) REFERENCES movies (id);

ALTER TABLE action_logs
    ADD CONSTRAINT action_logs_fk2 FOREIGN KEY (action_code) REFERENCES actions (code);


INSERT INTO actions
    (code, description)
VALUES ('ADD_MOVIE', 'Add new movie'),
       ('ADD_RATING', 'Add rating'),
       ('COMMENT_MOVIE', 'Comment movie'),
       ('UPDATE_MOVIE', 'Update movie info');