CREATE DATABASE library;

USE library;
CREATE TABLE USER_AUTHENTICATION (
  USER_ID  INT         NOT NULL,
  USERNAME VARCHAR(20) NOT NULL,
  PASSWORD VARCHAR(20) NOT NULL,
  ENABLED  BOOLEAN     NOT NULL,
  PRIMARY KEY (USER_ID)
)
  DEFAULT CHARSET =utf8;

INSERT INTO USER_AUTHENTICATION VALUES (1, 'user', 'user', TRUE);
INSERT INTO USER_AUTHENTICATION VALUES (2, 'root', 'root', TRUE);


CREATE TABLE USER_AUTHORIZATION (
  USER_ROLE_ID INT         NOT NULL,
  USER_ID      INT         NOT NULL,
  ROLE         VARCHAR(20) NOT NULL,
  PRIMARY KEY (USER_ROLE_ID)
)
  DEFAULT CHARSET =utf8;

INSERT INTO USER_AUTHORIZATION VALUES (1, 1, 'ROLE_USER');
INSERT INTO USER_AUTHORIZATION VALUES (2, 2, 'ROLE_ADMIN');


CREATE TABLE genres (
  id    INT      NOT NULL,
  genre CHAR(20) NOT NULL,
  PRIMARY KEY (id)
)
  DEFAULT CHARSET =utf8;


CREATE TABLE books (
  id    INT       NOT NULL,
  name  CHAR(100) NOT NULL,
  descr TEXT,
  date  CHAR(10)  NOT NULL,
  price INT(11)   NOT NULL,
  genre INT(11)   NOT NULL,
  PRIMARY KEY (id)
)
  DEFAULT CHARSET =utf8;

CREATE TABLE author (
  id   INT       NOT NULL AUTO_INCREMENT,
  name CHAR(100) NOT NULL,
  PRIMARY KEY (id)
)
  DEFAULT CHARSET =utf8;


INSERT INTO author (name) VALUES ('Mihalych');
INSERT INTO author (name) VALUES ('Petrovich');
INSERT INTO author (name) VALUES ('Eugenich');

CREATE TABLE books_author (
  books_id  INT NOT NULL,
  author_id INT NOT NULL,
  PRIMARY KEY (books_id, author_id)
)
  DEFAULT CHARSET =utf8;

INSERT INTO books_author VALUES (1, 2);
INSERT INTO books_author VALUES (2, 1);
INSERT INTO books_author VALUES (2, 2);
INSERT INTO books_author VALUES (3, 3);
INSERT INTO books_author VALUES (3, 1);


INSERT INTO genres (id, genre) VALUES (1, 'Fantastic');
INSERT INTO genres (id, genre) VALUES (2, 'Detectiv');
INSERT INTO genres (id, genre) VALUES (3, 'History');

INSERT INTO books (id, name, descr, date, price, genre)
VALUES (1, 'Elementary Java', 'More about Java', '10.06.2014', 1200, 1);
INSERT INTO books (id, name, descr, date, price, genre)
VALUES (2, 'Enterprise Java', 'More about enterprise Java', '11.07.2014', 20000, 1);
INSERT INTO books (id, name, descr, date, price, genre)
VALUES (3, 'Server&Pages Java', 'Web-Java', '20.07.2014', 30050, 2);
INSERT INTO books (id, name, descr, date, price, genre)
VALUES (4, 'Development Practise', 'Java Practise', '15.06.2014', 120, 3);
INSERT INTO books (id, name, descr, date, price, genre) VALUES (5, 'Running man', 'Good Book', '11.07.2012', 1000, 3);
INSERT INTO books (id, name, descr, date, price, genre)
VALUES (6, 'Filosophy Java', 'Web-Java', '10.07.2014', 30050, 2);

