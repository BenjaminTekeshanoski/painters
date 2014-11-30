DROP TABLE IF EXISTS MUSEUM;
DROP TABLE IF EXISTS LOCATION;
DROP TABLE IF EXISTS UPDATES;
DROP TABLE IF EXISTS PAINTING;
DROP TABLE IF EXISTS IDIOM;
DROP TABLE IF EXISTS COMMENT;
DROP TABLE IF EXISTS AWARD;
DROP TABLE IF EXISTS PMEDÝA;
DROP TABLE IF EXISTS YOURPAINTING;
DROP TABLE IF EXISTS CRITICS;
DROP TABLE IF EXISTS REVIEWER;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS PAINTER;
DROP TABLE IF EXISTS EXHIBITION;
DROP TABLE IF EXISTS PAINTINGSTYLE;

CREATE TABLE USERS(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(25), surname VARCHAR(30),nickname VARCHAR(30), password varchar(250),AccessLevel INTEGER);
CREATE TABLE CRITICS(id INTEGER PRIMARY KEY AUTOINCREMENT, REVIEWERID INTEGER, CRITIC VARCHAR(1000),SUBJECT INT);
CREATE TABLE REVIEWER(id INTEGER PRIMARY KEY AUTOINCREMENT, FULLNAME VARCHAR(70));
CREATE TABLE MUSEUM(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));
CREATE TABLE LOCATION(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), city VARCHAR(20), desc VARCHAR(80));
CREATE TABLE PAINTING(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, painter VARCHAR(20), desc VARCHAR(80), place VARCHAR(80), idiom VARCHAR(30));
CREATE TABLE UPDATES(id INTEGER PRIMARY KEY AUTOINCREMENT, desc VARCHAR(80));
CREATE TABLE IDIOM(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(500));
CREATE TABLE COMMENT(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(1000), owner INTEGER, target VARCHAR(20));
CREATE TABLE AWARD(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, owner VARCHAR(20));
CREATE TABLE PMEDÝA(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), desc VARCHAR(1000));
CREATE TABLE YOURPAINTING(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20), desc VARCHAR(80));
CREATE TABLE PAINTER(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), age INTEGER, country VARCHAR(20), biography VARCHAR(1000), paintname VARCHAR(1000));
CREATE TABLE EXHIBITION(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), year INTEGER, location VARCHAR(20));
CREATE TABLE PAINTINGSTYLE(id INTEGER PRIMARY KEY AUTOINCREMENT, stylename VARCHAR(100),  year INTEGER, paintname VARCHAR(20), desc VARCHAR(80));

INSERT INTO  CRITICS(REVIEWERID,CRITIC,SUBJECT) VALUES(1,"One of best painting in the world",1);
INSERT INTO  CRITICS(REVIEWERID,CRITIC,SUBJECT) VALUES(2,"I think girl had a trafic acsident",2);

INSERT INTO REVIEWER(FULLNAME) VALUES ("Mr. Brown");
INSERT INTO REVIEWER(FULLNAME) VALUES ("James smith");

INSERT INTO USERS(NAME,SURNAME,NICKNAME,PASSWORD,ACCESSLEVEL) VALUES("GÖKAY","ÞÝMÞEK","gokay","123456",3);
INSERT INTO USERS(NAME,SURNAME,NICKNAME,PASSWORD,ACCESSLEVEL) VALUES("Hasan Can","Aydan","aydanh","123456",3);

INSERT INTO MUSEUM(name, year, location, desc) VALUES("Louvre Museum", 1973, "Paris", "The world's most visited museum");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("Museum of Modern Art", 1929, "New York", "Most influential museum of modern art in the world");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("National Gallery", 1824, "London", "It houses a collection of over 2,300 paintings dating from the mid-13th century to 1900");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("The Mauritshuis", 1822, "The Hauge", "The museum houses the Royal Cabinet of Paintings which consists of 841 objects");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("Rijksmuseum", 1800, "Amsterdam", "Netherlands national museum dedicated to arts and history");
INSERT INTO MUSEUM(name, year, location, desc) VALUES("Museo Reina Sofia", 1992, "Madrid", "Spain's national museum of 20th-century art");
INSERT INTO LOCATION(name, city, desc) VALUES("The Sistine Chapel", "Vatican City", "The Sistine Chapel is a large and renowned chapel in the Apostolic Palace, the official residence of the Pope" );
INSERT INTO LOCATION(name, city, desc) VALUES("Santa Maria delle Grazie Monastery", "Milan", "Santa Maria delle Grazie is a church and Dominican convent in Milan, northern Italy" );

INSERT INTO PAINTING(name, year, painter, desc, place, idiom) VALUES("Mona Lisa", 1519, "Leonardo da Vinci" , "The Mona Lisa (Monna Lisa or La Gioconda in Italian; La Joconde in French) is a half-length portrait of a woman ","Louvre Museum",  "Allegory");
INSERT INTO PAINTING(name, year, painter, desc, place, idiom) VALUES("Girl with a Mandolin"	, 1910, "Pablo Picasso" ,"...", "muzeadi","Bodegón");

INSERT INTO IDIOM(name, year, location, desc) VALUES("Allegory"	, 1910, "Pablo Picasso" ,"...");
INSERT INTO IDIOM(name, year, location, desc) VALUES("Bodegón"	, 1914, "Leonardo davinci" ,".45..");
INSERT INTO YOURPAINTING(name, year, location, desc) VALUES("Mona Lisa"				, 1519, "Leonardo da Vinci" , "The Mona Lisa (Monna Lisa or La Gioconda in Italian; La Joconde in French) is a half-length portrait of a woman " );
INSERT INTO PAINTER(name, age, country, biography, paintname) VALUES("Leonardo da Vinci", 67, "Italy", "Leonardo da Vinci was a leading artist and intellectual of the Italian Renaissance who's known for his enduring works ", "Mona Lisa");
INSERT INTO PAINTER(name, age, country, biography, paintname) VALUES("Pablo Picasso", 91, "Spain", " Picasso is to Art History a giant earthquake with eternal aftermaths. With the possible exception of Michelangelo (who focused his greatest efforts in sculpture and architecture), no other artist had such ambitions at the time of placing his oeuvre in the history of art. Picasso created the avant-garde.", "Accordionist");
INSERT INTO PAINTER(name, age, country, biography, paintname) VALUES("Giotto di Bondone", 70, "Italy", "Giotto di Bondone (1266/7 – January 8, 1337), known as Giotto (Italian:  was an Italian painter and architect from Florence in the late Middle Ages. He is generally considered the first in a line of great artists who contributed to the Italian Renaissance.", "Ognissanti Madonna");
INSERT INTO PAINTER(name, age, country, biography, paintname) VALUES("Rembrandt van Rijn", 63, "Netherlands", "Rembrandt's greatest creative triumphs are exemplified especially in his portraits of his contemporaries, self-portraits and illustrations of scenes from the Bible. His self-portraits form a unique and intimate biography, in which the artist surveyed himself without vanity and with the utmost sincerity ", "Self portrait");
INSERT INTO PAINTER(name, age, country, biography, paintname) VALUES("Caravaggio", 38, "Milan", " Caravaggio trained as a painter in Milan under Simone Peterzano who had himself trained under Titian.", "Boy peeling a fruit");
INSERT INTO EXHIBITION(name, year, location) VALUES("Sigmar Polke", 2014, "London");
INSERT INTO EXHIBITION(name, year, location) VALUES("Rembrandt", 2014, "London");
INSERT INTO EXHIBITION(name, year, location) VALUES("Oil on board", 1957, "Moscow");
INSERT INTO EXHIBITION(name, year, location) VALUES("WAYNE QUILLIAM - Photography", 2014, "Berlin");
INSERT INTO EXHIBITION(name, year, location) VALUES("Bella figura", 2013, "Berlin");
INSERT INTO EXHIBITION(name, year, location) VALUES("Broken lights", 2013, "Berlin");
INSERT INTO PAINTINGSTYLE(stylename, year, paintname, desc) VALUES("Impressionism", 1863 , "The artist's studio", "The figures in the painting are allegorical representations of various influences on Courbet's artistic life.");
INSERT INTO PAINTINGSTYLE(stylename, year, paintname, desc) VALUES("Outsider art", 1972  , "Deaths Waiting Room", "The term is sometimes misapplied as a catch-all marketing label for art created by people outside the mainstream art world, regardless of their circumstances or the content of their work.");
INSERT INTO PAINTINGSTYLE(stylename, year, paintname, desc) VALUES("Abstract styles", 1929, "oil painting wall", "Action painting, sometimes called gestural abstraction, is a style of painting in which paint is spontaneously dribbled, splashed or smeared onto the canvas, rather than being carefully applied.");
INSERT INTO PAINTINGSTYLE(stylename, year, paintname, desc) VALUES("Photorealism", 1960, "Parisian Street Scene", "Photorealism is the genre of painting based on using the camera and photographs to gather information and then from this information, creating a painting that appears to be very realistic like a photograph.");
INSERT INTO COMMENT(name, owner, target) VALUES("yorumun kendisi", 11, "Mona Lisa");
INSERT INTO COMMENT(name, owner, target) VALUES("yorum yaptým.", 12, "Guernica");
INSERT INTO PMEDÝA(name,  desc) VALUES("Oil",  "Oil painting is the process of painting with pigments that are bound with a medium of drying oil—especially in early modern Europe, linseed oil. Often an oil such as linseed was boiled with a resin such as pine resin or even frankincense; these were called 'varnishes' and were prized for their body and gloss. Oil paint eventually became the principal medium used for creating artworks as its advantages became widely known. The transition began with Early Netherlandish painting in northern Europe, and by the height of the Renaissance oil painting techniques had almost completely replaced tempera paints in the majority of Europe.");
INSERT INTO PMEDÝA(name,  desc) VALUES("Pastel", "Pastel is a painting medium in the form of a stick, consisting of pure powdered pigment and a binder.[11] The pigments used in pastels are the same as those used to produce all colored art media, including oil paints; the binder is of a neutral hue and low saturation. The color effect of pastels is closer to the natural dry pigments than that of any other process.[12] Because the surface of a pastel painting is fragile and easily smudged, its preservation requires protective measures such as framing under glass; it may also be sprayed with a fixative. Nonetheless, when made with permanent pigments and properly cared for, a pastel painting may endure unchanged for centuries. Pastels are not susceptible, as are paintings made with a fluid medium, to the cracking and discoloration that result from changes in the color, opacity, or dimensions of the medium as it dries.");
INSERT INTO AWARD(name, year, owner) VALUES("Louvre Museum Award", 1973, "Mona Lisa");
INSERT INTO AWARD(name, year, owner) VALUES("Museum of Modern Art Award", 1929, "eros and psyche");

INSERT INTO UPDATES(desc) VALUES("Created Application");
INSERT INTO UPDATES(desc) VALUES("Added Museums");
INSERT INTO UPDATES(desc) VALUES("Added Idioms");
INSERT INTO UPDATES(desc) VALUES("Added Paintings");
INSERT INTO UPDATES(desc) VALUES("Added Painters"); 
INSERT INTO UPDATES(desc) VALUES("Added Exhibitions"); 
INSERT INTO UPDATES(desc) VALUES("Added Awards"); 
INSERT INTO UPDATES(desc) VALUES("Added Painting Medias"); 
INSERT INTO UPDATES(desc) VALUES("Added Add Your Paintings"); 
INSERT INTO UPDATES(desc) VALUES("Added Painting Styles");    