DROP TABLE IF EXISTS MUSEUM;
DROP TABLE IF EXISTS UPDATES;
DROP TABLE IF EXISTS PAINTING;
DROP TABLE IF EXISTS IDIOM;
DROP TABLE IF EXISTS COMMENT;
DROP TABLE IF EXISTS YOURPAINTING;

CREATE TABLE MUSEUM(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));
CREATE TABLE PAINTING(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));
CREATE TABLE UPDATES(desc VARCHAR(80));
CREATE TABLE IDIOM(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));
CREATE TABLE COMMENT(id INTEGER PRIMARY KEY AUTOINCREMENT, owner VARCHAR(20), comment VARCHAR(80), target VARCHAR(20));
CREATE TABLE YOURPAINTING(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));


INSERT INTO MUSEUM(name, year, location, desc) VALUES("Louvre Museum", 1973, "Paris", "The world's most visited museum");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("Museum of Modern Art", 1929, "New York", "Most influential museum of modern art in the world");
INSERT INTO PAINTING(name, year, location, desc) VALUES("Mona Lisa"				, 1519, "Leonardo da Vinci" , "The Mona Lisa (Monna Lisa or La Gioconda in Italian; La Joconde in French) is a half-length portrait of a woman " );
INSERT INTO PAINTING(name, year, location, desc) VALUES("Girl with a Mandolin"	, 1910, "Pablo Picasso" ,"...");
INSERT INTO IDIOM(name, year, location, desc) VALUES("Girl with a Mandolin"	, 1910, "Pablo Picasso" ,"...");
INSERT INTO YOURPAINTING(name, year, location, desc) VALUES("Mona Lisa"				, 1519, "Leonardo da Vinci" , "The Mona Lisa (Monna Lisa or La Gioconda in Italian; La Joconde in French) is a half-length portrait of a woman " );

INSERT INTO UPDATES(desc) VALUES("Created Application");
INSERT INTO UPDATES(desc) VALUES("Added Museums");
INSERT INTO UPDATES(desc) VALUES("Added Idioms");
INSERT INTO UPDATES(desc) VALUES("Added Paintings");     