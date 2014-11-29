DROP TABLE IF EXISTS MUSEUM;
DROP TABLE IF EXISTS LOCATION;
DROP TABLE IF EXISTS UPDATES;
DROP TABLE IF EXISTS PAINTING;
DROP TABLE IF EXISTS IDIOM;
DROP TABLE IF EXISTS COMMENT;
DROP TABLE IF EXISTS YOURPAINTING;

CREATE TABLE MUSEUM(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));
CREATE TABLE LOCATION(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), city VARCHAR(20), desc VARCHAR(80));
CREATE TABLE PAINTING(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));
CREATE TABLE UPDATES(desc VARCHAR(80));
CREATE TABLE IDIOM(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));
CREATE TABLE COMMENT(id INTEGER PRIMARY KEY AUTOINCREMENT, owner VARCHAR(20), comment VARCHAR(80), target VARCHAR(20));
CREATE TABLE YOURPAINTING(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));


INSERT INTO MUSEUM(name, year, location, desc) VALUES("Louvre Museum", 1973, "Paris", "The world's most visited museum");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("Museum of Modern Art", 1929, "New York", "Most influential museum of modern art in the world");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("National Gallery", 1824, "London", "It houses a collection of over 2,300 paintings dating from the mid-13th century to 1900");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("The Mauritshuis", 1822, "The Hauge", "The museum houses the Royal Cabinet of Paintings which consists of 841 objects");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("Rijksmuseum", 1800, "Amsterdam", "Netherlands national museum dedicated to arts and history");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("Museo Reina Sofia", 1992, "Madrid", "Spain's national museum of 20th-century art");
INSERT INTO LOCATION(name, city, desc) VALUES("The Sistine Chapel", "Vatican City", "The Sistine Chapel is a large and renowned chapel in the Apostolic Palace, the official residence of the Pope" );
INSERT INTO LOCATION(name, city, desc) VALUES("Santa Maria delle Grazie Monastery", "Milan", "Santa Maria delle Grazie is a church and Dominican convent in Milan, northern Italy" );
INSERT INTO PAINTING(name, year, location, desc) VALUES("Mona Lisa"				, 1519, "Leonardo da Vinci" , "The Mona Lisa (Monna Lisa or La Gioconda in Italian; La Joconde in French) is a half-length portrait of a woman " );
INSERT INTO PAINTING(name, year, location, desc) VALUES("Girl with a Mandolin"	, 1910, "Pablo Picasso" ,"...");
INSERT INTO IDIOM(name, year, location, desc) VALUES("Girl with a Mandolin"	, 1910, "Pablo Picasso" ,"...");
INSERT INTO YOURPAINTING(name, year, location, desc) VALUES("Mona Lisa"				, 1519, "Leonardo da Vinci" , "The Mona Lisa (Monna Lisa or La Gioconda in Italian; La Joconde in French) is a half-length portrait of a woman " );

INSERT INTO UPDATES(desc) VALUES("Created Application");
INSERT INTO UPDATES(desc) VALUES("Added Museums");
INSERT INTO UPDATES(desc) VALUES("Added Idioms");
INSERT INTO UPDATES(desc) VALUES("Added Paintings");     