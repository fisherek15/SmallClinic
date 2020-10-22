--
-- Table structure for table doctors
--
CREATE TABLE lekarze (
  id_lekarza INT NOT NULL,
  imie VARCHAR(30) NOT NULL,
  nazwisko VARCHAR(30) NOT NULL,
  telefon VARCHAR(13) NOT NULL,
  PRIMARY KEY  (id_lekarza)
);

--
-- Table structure for table patients
--
CREATE TABLE pacjenci (
  nr_ubezpieczenia INT NOT NULL,
  imie VARCHAR(30) NOT NULL,
  nazwisko VARCHAR(30) NOT NULL,
  adres VARCHAR(100) NOT NULL,
  telefon VARCHAR(13) NOT NULL,
  PRIMARY KEY  (nr_ubezpieczenia)
);

--
-- Table structure for table visits
--
CREATE TABLE wizyty (
  id_wizyty INT NOT NULL,
  nr_ubezpieczenia INT NOT NULL,
  id_lekarza INT NOT NULL,
  data_wizyty DATE NOT NULL,
  czas_wizyty VARCHAR(5) NOT NULL,
  objawy VARCHAR(200) NOT NULL,  
  notatka VARCHAR(200),
  PRIMARY KEY  (id_wizyty),
  CONSTRAINT fk_wizyty_lekarze FOREIGN KEY (id_lekarza) REFERENCES lekarze (id_lekarza) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_wizyty_pacjenci FOREIGN KEY (nr_ubezpieczenia) REFERENCES pacjenci (nr_ubezpieczenia) ON DELETE NO ACTION ON UPDATE CASCADE
);

--
-- Table structure for table disease
--
CREATE TABLE choroby (
  id_choroby INT NOT NULL,
  nazwa_choroby VARCHAR(50) NOT NULL,
  objawy VARCHAR(400) NOT NULL,
  leczenie VARCHAR(200) NOT NULL,
  PRIMARY KEY  (id_choroby)
);

--
-- Table structure for table medicines
--
CREATE TABLE lekarstwa (
  id_lekarstwa INT NOT NULL,
  nazwa_lekarstwa VARCHAR(70) NOT NULL,
  sklad VARCHAR(200) NOT NULL,
  przeciwwskazania VARCHAR(300),
  skutki_uboczne VARCHAR(300),
  PRIMARY KEY  (id_lekarstwa)
);

--
-- Table structure for table leczenie_choroby
--
CREATE TABLE leczenie_choroby(
  id_choroby INT NOT NULL,
  id_lekarstwa  INT NOT NULL,
  typowa_dawka VARCHAR(30),
  typowe_dawkowanie VARCHAR(200),
  typowy_okres VARCHAR(20),  
  PRIMARY KEY  (id_choroby,id_lekarstwa),
  CONSTRAINT fk_leczenie_choroby_choroby FOREIGN KEY (id_choroby) REFERENCES choroby (id_choroby) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_leczenie_choroby_lekarstwa FOREIGN KEY (id_lekarstwa) REFERENCES lekarstwa (id_lekarstwa) ON DELETE NO ACTION ON UPDATE CASCADE
);

--
-- Table structure for table przepisane_lekarstwa
--
CREATE TABLE przepisane_lekarstwa(
  id_wizyty INT NOT NULL,
  id_lekarstwa  INT NOT NULL,
  dawka VARCHAR(30) NOT NULL,
  dawkowanie VARCHAR(200) NOT NULL,
  okres VARCHAR(20) NOT NULL,
  PRIMARY KEY  (id_wizyty,id_lekarstwa),
  CONSTRAINT fk_przepisane_leki_wizyty FOREIGN KEY (id_wizyty) REFERENCES wizyty (id_wizyty) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_przepisane_leki_lekarstwa FOREIGN KEY (id_lekarstwa) REFERENCES lekarstwa (id_lekarstwa) ON DELETE NO ACTION ON UPDATE CASCADE
);

--
-- Table structure for table rozpoznanie
--
CREATE TABLE rozpoznanie_choroby(
  id_wizyty INT NOT NULL,
  id_choroby INT NOT NULL,  
  PRIMARY KEY  (id_wizyty, id_choroby),
  CONSTRAINT fk_rozpoznanie_choroby_wizyty FOREIGN KEY (id_wizyty) REFERENCES wizyty (id_wizyty) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_rozpoznanie_choroby_choroby FOREIGN KEY (id_choroby) REFERENCES choroby (id_choroby) ON DELETE NO ACTION ON UPDATE CASCADE
  );

--
-- Table structure for table leki_konfliktowe
--
CREATE TABLE lekarstwa_konfliktowe(
  id_lekarstwa1 INT NOT NULL,
  id_lekarstwa2 INT NOT NULL,
  opis VARCHAR(200),
  PRIMARY KEY (id_lekarstwa1,id_lekarstwa2),
  CONSTRAINT fk_lekarstwa_kinfliktowe1 FOREIGN KEY (id_lekarstwa1) REFERENCES lekarstwa (id_lekarstwa) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT fk_lekarstwa_konfliktowe2 FOREIGN KEY (id_lekarstwa2) REFERENCES lekarstwa (id_lekarstwa) ON DELETE NO ACTION ON UPDATE CASCADE
  );

  
  
 --------------- GENERATORY I TRIGGERY -----------------------------

--- GENERATOR lekarze ---
CREATE SEQUENCE GEN_LEKARZE_ID;
ALTER SEQUENCE GEN_LEKARZE_ID RESTART WITH 100;

--- TRIGGER lekarze ---
SET TERM !! ;
CREATE TRIGGER LEKARZE_BI FOR LEKARZE
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID_LEKARZA IS NULL) THEN
    NEW.ID_LEKARZA = GEN_ID(GEN_LEKARZE_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_LEKARZE_ID, 0);
    if (tmp < new.ID_LEKARZA) then
      tmp = GEN_ID(GEN_LEKARZE_ID, new.ID_LEKARZA-tmp);
  END
END!!
SET TERM ; !!


--- GENERATOR lekarstwa ---
CREATE SEQUENCE GEN_LEKARSTWA_ID;
ALTER SEQUENCE GEN_LEKARSTWA_ID RESTART WITH 100;

--- TRIGGER lekarstwa ---
SET TERM !! ;
CREATE TRIGGER LEKARSTWA_BI FOR LEKARSTWA
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID_LEKARSTWA IS NULL) THEN
    NEW.ID_LEKARSTWA = GEN_ID(GEN_LEKARSTWA_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_LEKARSTWA_ID, 0);
    if (tmp < new.ID_LEKARSTWA) then
      tmp = GEN_ID(GEN_LEKARSTWA_ID, new.ID_LEKARSTWA-tmp);
  END
END!!
SET TERM ; !!


--- GENERATOR choroby ---
CREATE SEQUENCE GEN_CHOROBY_ID;
ALTER SEQUENCE GEN_CHOROBY_ID RESTART WITH 100;

--- TRIGGER choroby ---
SET TERM !! ;
CREATE TRIGGER CHOROBY_BI FOR CHOROBY
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID_CHOROBY IS NULL) THEN
    NEW.ID_CHOROBY = GEN_ID(GEN_CHOROBY_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_CHOROBY_ID, 0);
    if (tmp < new.ID_CHOROBY) then
      tmp = GEN_ID(GEN_CHOROBY_ID, new.ID_CHOROBY-tmp);
  END
END!!
SET TERM ; !!


--- GENERATOR wizyty ---
CREATE SEQUENCE GEN_WIZYTY_ID;
ALTER SEQUENCE GEN_WIZYTY_ID RESTART WITH 1000;

--- TRIGGER wizyty ---
SET TERM !! ;
CREATE TRIGGER WIZYTY_BI FOR WIZYTY
ACTIVE BEFORE INSERT POSITION 0
AS
DECLARE VARIABLE tmp DECIMAL(18,0);
BEGIN
  IF (NEW.ID_WIZYTY IS NULL) THEN
    NEW.ID_WIZYTY = GEN_ID(GEN_WIZYTY_ID, 1);
  ELSE
  BEGIN
    tmp = GEN_ID(GEN_WIZYTY_ID, 0);
    if (tmp < new.ID_WIZYTY) then
      tmp = GEN_ID(GEN_WIZYTY_ID, new.ID_WIZYTY-tmp);
  END
END!!
SET TERM ; !!

--- TRIGGER przepisane_lekarstwa ---
SET TERM !! ;
CREATE TRIGGER PRZEPISANE_LEKARSTWA_BI FOR PRZEPISANE_LEKARSTWA
ACTIVE BEFORE INSERT POSITION 0
AS
BEGIN
  IF (NEW.ID_WIZYTY IS NULL) THEN
    NEW.ID_WIZYTY = GEN_ID(GEN_WIZYTY_ID, 0);
END!!
SET TERM ; !!

--- TRIGGER rozpoznanie_choroby ---
SET TERM !! ;
CREATE TRIGGER ROZPOZNANIE_CHOROBY_BI FOR ROZPOZNANIE_CHOROBY
ACTIVE BEFORE INSERT POSITION 0
AS
BEGIN
  IF (NEW.ID_WIZYTY IS NULL) THEN
    NEW.ID_WIZYTY = GEN_ID(GEN_WIZYTY_ID, 0);
END!!
SET TERM ; !!
