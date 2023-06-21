/*Δημιουργία της βάσης*/

DROP DATABASE IF EXISTS travel_agency;
CREATE DATABASE travel_agency;
USE travel_agency;

/*Create Tables*/

DROP TABLE IF EXISTS branch;
CREATE TABLE branch (  
    br_code INT(11) NOT NULL AUTO_INCREMENT ,
    br_street VARCHAR(30) DEFAULT 'unknown' NOT NULL,
    br_num INT(4) DEFAULT 0 NOT NULL,
    br_city VARCHAR(30) DEFAULT 'unknown' NOT NULL,
    PRIMARY KEY (br_code)
) ;

DROP TABLE IF EXISTS phones;
CREATE TABLE phones (  
    ph_br_code INT(11) NOT NULL ,
    ph_number CHAR(10)  DEFAULT 'unknown' NOT NULL,
    PRIMARY KEY (ph_br_code , ph_number),
    CONSTRAINT branch_Phone FOREIGN KEY (ph_br_code) REFERENCES branch(br_code)
    ON DELETE CASCADE ON UPDATE CASCADE
) ;

DROP TABLE IF EXISTS worker;
CREATE TABLE worker (  
    wrk_AT CHAR(10) NOT NULL ,
    wrk_name VARCHAR(20) DEFAULT 'unknown' NOT NULL,
    wrk_lname VARCHAR(20) DEFAULT 'unknown' NOT NULL,
    wrk_salary float(7,2)  DEFAULT 0 NOT NULL,
    wrk_br_code Int(11) NOT NULL,
    PRIMARY KEY (wrk_AT),
    CONSTRAINT branch_Worker FOREIGN KEY (wrk_br_code) REFERENCES branch(br_code)
    ON DELETE CASCADE ON UPDATE CASCADE
) ;

DROP TABLE IF EXISTS driver;
CREATE TABLE driver (  
    drv_AT CHAR(10) NOT NULL,
    drv_license ENUM('A','B', 'C' , 'D') NOT NULL,
    drv_route ENUM('LOCAL','ABROAD') NOT NULL,
    drv_experience TINYINT(4)  DEFAULT 0 NOT NULL ,
    PRIMARY KEY (drv_AT),
    CONSTRAINT Worker_Driver FOREIGN KEY ( drv_AT) REFERENCES worker(wrk_AT)
    ON DELETE CASCADE ON UPDATE CASCADE
) ;

DROP TABLE IF EXISTS guide;
CREATE TABLE guide (  
    gui_AT CHAR(10) NOT NULL,
    gui_cv TEXT NOT NULL,
    PRIMARY KEY (gui_AT),
    CONSTRAINT Worker_Guide FOREIGN KEY (gui_AT) REFERENCES worker(wrk_AT)
    ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS languages;
CREATE TABLE languages (  
    lng_gui_AT CHAR(10) NOT NULL,
    lng_language varchar(30),
    PRIMARY KEY (lng_gui_AT , lng_language),
    CONSTRAINT Guide_Languages FOREIGN KEY (lng_gui_AT) REFERENCES guide( gui_AT)
    ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS admin;
CREATE TABLE admin (
    adm_AT CHAR(10) NOT NULL,
    adm_type ENUM('LOGISTICS' ,'ADMINISTRATIVE', 'ACCOUNTING') NOT NULL ,
    adm_diploma VARCHAR(200) DEFAULT 'unknown' NOT NULL,
    PRIMARY KEY (adm_AT),
    CONSTRAINT Worker_admin FOREIGN KEY (adm_AT) REFERENCES worker(wrk_AT)
    ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS manages;
CREATE TABLE manages (
    mng_adm_AT CHAR(10) NOT NULL,
    mng_br_code INT(11) NOT NULL,
    PRIMARY KEY (mng_adm_AT , mng_br_code),
    CONSTRAINT Admin_Managers FOREIGN KEY (mng_adm_AT) REFERENCES admin(adm_AT)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT Branch_Managers FOREIGN KEY (mng_br_code) REFERENCES branch(br_code)
    ON DELETE CASCADE ON UPDATE CASCADE
);

DROP TABLE IF EXISTS trip;
create table trip (
tr_id int(11) not null auto_increment,
tr_departure datetime not null,
tr_return datetime not null,
tr_maxseats tinyint(4),
tr_cost float(7,2) not null default 0,
tr_br_code int(11) not null,
tr_gui_AT char(10),
tr_drv_AT char(10) not null,

primary key(tr_id),
constraint BRCH
foreign key(tr_br_code)
references branch(br_code)
on delete cascade on update cascade,

constraint DRVR
foreign key(tr_drv_AT)
references driver(drv_AT)
on delete cascade on update cascade,

constraint GUID
foreign key(tr_gui_AT)
references guide(gui_AT)
on delete cascade on update cascade
);
DROP TABLE IF EXISTS event;
create table event(
ev_tr_id int(11),
ev_start datetime not null,
ev_end datetime not null,
ev_descr text,

primary key(ev_tr_id, ev_start),
constraint TRIP
foreign key(ev_tr_id)
references trip(tr_id)
on delete cascade
on update cascade
);

DROP TABLE IF EXISTS destination;
create table destination(
dst_id int(11) auto_increment ,
dst_name varchar(50) not null,
dst_dscr text,
dst_rtype enum('LOCAL', 'ABROAD') not null,
dst_language varchar(30) not null,
dst_location int(11) ,

primary key(dst_id),
constraint LOC
foreign key(dst_location)
references destination(dst_id)
on delete cascade 
on update cascade 
);

DROP TABLE IF EXISTS travel_to;
create table travel_to(
to_tr_id int(11),
to_dst_id int(11),
to_arrival datetime,
to_departure datetime, 

primary key(to_tr_id, to_dst_id),
constraint TRP
foreign key(to_tr_id)
references trip(tr_id)
on delete cascade on update cascade,

constraint DEST
foreign key(to_dst_id)
references destination(dst_id)
on delete cascade on update cascade
);

DROP TABLE IF EXISTS reservation;
create table reservation(
res_tr_id int(11),
res_seatnum tinyint(4) not null,
res_name varchar(20) not null default 'unknown',
res_lname varchar(20) not null default 'unknown',
res_isadult enum('ADULT','MINOR') not null,

primary key(res_tr_id, res_seatnum),
constraint TR
foreign key(res_tr_id)
references trip(tr_id)
on delete cascade on update cascade 
);

DROP TABLE IF EXISTS it_admin;
create table it_admin(
it_at CHAR(10) NOT NULL,
it_password CHAR(10) not null default 'password',
it_start_date datetime not null,
it_end_date datetime null,
primary key(it_at),
constraint ITADMWORK foreign key(it_at)
references worker(wrK_AT)
on delete cascade on update cascade 
);

DROP TABLE IF EXISTS log_trip;
CREATE TABLE log_trip (  
log_type ENUM('INSERT', 'UPDATE', 'DELETE') NOT NULL,
log_it_lname VARCHAR(20) DEFAULT 'unknown' NOT NULL,
log_timestamp DATETIME NOT NULL,
log_tr_id int(11) not null,
log_tr_departure datetime not null,
log_tr_return datetime not null,
log_tr_maxseats tinyint(4),
log_tr_cost float(7,2) not null,
log_tr_br_code int(11) not null,
log_tr_gui_AT char(10),
log_tr_drv_AT char(10) not null
);

DROP TABLE IF EXISTS log_reservation;
CREATE TABLE log_reservation(
log_type ENUM('INSERT', 'UPDATE', 'DELETE') NOT NULL,
log_it_lname VARCHAR(20) DEFAULT 'unknown' NOT NULL,
log_timestamp DATETIME NOT NULL,
log_res_tr_id INT(11),
log_res_seatnum TINYINT(4) NOT NULL,
log_res_name VARCHAR(20) NOT NULL,
log_res_lname VARCHAR(20) NOT NULL,
log_res_isadult enum('ADULT','MINOR') NOT NULL
);

DROP TABLE IF EXISTS log_event;
CREATE TABLE log_event(
log_type ENUM('INSERT', 'UPDATE', 'DELETE') NOT NULL,
log_it_lname VARCHAR(20) DEFAULT 'unknown' NOT NULL,
log_timestamp DATETIME NOT NULL,
log_ev_tr_id INT(11),
log_ev_start DATETIME NOT NULL,
log_ev_end DATETIME NOT NULL,
log_ev_descr TEXT
);

DROP TABLE IF EXISTS log_travel_to;
CREATE TABLE log_travel_to(
log_type ENUM('INSERT', 'UPDATE', 'DELETE') NOT NULL,
log_it_lname VARCHAR(20) DEFAULT 'unknown' NOT NULL,
log_timestamp DATETIME NOT NULL,
log_to_tr_id INT(11),
log_to_dst_id INT(11),
log_to_arrival DATETIME,
log_to_departure DATETIME
);

DROP TABLE IF EXISTS log_destination;
CREATE TABLE log_destination(
log_type ENUM('INSERT', 'UPDATE', 'DELETE') NOT NULL,
log_it_lname VARCHAR(20) DEFAULT 'unknown' NOT NULL,
log_timestamp DATETIME NOT NULL,
log_dst_id INT(11),
log_dst_name VARCHAR(50) NOT NULL,
log_dst_dscr TEXT,
log_dst_rtype enum('LOCAL', 'ABROAD') NOT NULL,
log_dst_language varchar(30) NOT NULL,
log_dst_location INT(11)
);

DROP TABLE IF EXISTS offers;
create table offers(
offer_id int(11) AUTO_INCREMENT,
offer_trip_start_date datetime not null,
offer_trip_end_date datetime not null,
Price_per_Person int(6),
offer_dst_id int(11) ,
primary key(offer_id),
constraint DSTOFFERS foreign key(offer_dst_id)
references destination(dst_id)
on delete cascade on update cascade 
);

DROP TABLE IF EXISTS reservation_offers;
create table reservation_offers(
rsv_id int(11) AUTO_INCREMENT,
rsv_name varchar(20) not null default 'unknown',
rsv_lastname varchar(20) not null default 'unknown' ,
deposit_amount int(11),
rsv_offer_id int(11) ,
primary key(rsv_id),
constraint RSVOFFE foreign key(rsv_offer_id)
references offers(offer_id)
on delete cascade on update cascade 
);

/*Insert*/

INSERT INTO branch VALUES
(null , 'Kifisias ', 355 , 'Athens'),
(null , 'Amarisias Artemidos' , 5 , 'Athens'),
(null , 'Mezonos', 44 , 'Patra'),
(null , 'Aristomenous' , 5 , 'Kalamata'),
(null , 'Tsimiskh' , 55 , 'Thesalonikh');

INSERT INTO phones VALUES
(1 , '2101111111'),
(1 ,  '2101222222'),
(2 , '2102222222'),
(2 , '2102333333'),
(3 , '2103333333'),
(4 ,  '2104444444'),
(5 ,  '2105555555');

INSERT INTO worker VALUES
('AK10311111' , 'Giannhs' , 'Vasiliou' ,'1547.55' ,1),
('AK10322222' , 'Artemis' ,'Papadopoulou' ,'1800.34',1),
('AK10333333' ,  'Georgia' ,'Makri' ,'2000',1),
('AK10344444' ,  'Greg' ,'Stephanopoulos' ,'1600',2),
('AK10355555' ,  'Iason', 'Raikos','1800.99',2),
('AK10366666' ,  'Maria', 'Papadopoulou' ,'2000',2),
('AK10377777' ,  'Orestis', 'Makris' , '1600.69',3),
('AK10388888' ,  'Damianos' , 'Papadopoulos' , '1500',3),
('AK10399999' , 'Iris' , 'Oikonomou' , '1400.55',3),
('AK10310000' ,  'John' ,'Politis','1400.55',4 ),
('AK10310111' ,  'Alkis' , 'Eleftheriadis' ,'1200.35',4 ),
('AK10310222' ,  'Andreas' , 'Georgiou' ,'1000.21',4),
('AK10310333' ,  'Giannhs', 'Stathopoulos' , '1900.56',5),
('AK10310444' ,  'Sofia' , 'Politi','1400.86',5),
('AK10310555' , 'Nikos' , 'Vasiliou','1600.96',5),
('AM10410000' , 'Antonis' , 'Kokinos','1000',1),
('AM10410111' , 'Antonis' , 'Eleftheriadis','1100',1),
('AM10410222' , 'Nora' , 'Raikou','750',2),
('AM10410333' , 'John' , 'Oikonomou','1150',2),
('AM10410444' , 'Dimitrios' , 'Gongas','1500',3),
('AM10410555' , 'Fotios' , 'Patrios','1400',4),
('AM10410666' , 'Maria' , 'Papadopoulou','1000',5),
('AM10410777' , 'Andreas' , 'Makris','750',5),
('AN10520010' , 'Damianos' , 'Diasakos','1200',1),
('AN10520020' , 'Greg' , 'Delimpaltadakis','1000',2),
('AN10520030' , 'Orestis' , 'Delimpaltadakis','1000',2),
('AN10520040' , 'Iason' , 'Makris','1200',3),
('AN10520050' , 'Orestis' , 'Diasakos','1000',4),
('AN10520060' , 'Damianos' , 'Delimpaltadakis','1200',5);

INSERT INTO admin VALUES
('AK10311111' , 'LOGISTICS' , 'Dimploma: Logistics Athens School of Business'),
('AK10322222' , 'ACCOUNTING' ,'Dimploma: Accounting Athens School of Business'),
('AK10333333' ,  'ADMINISTRATIVE' ,'Dimploma: Economics and Business Administration Athens School of Business'),
('AK10344444' ,  'LOGISTICS' ,'Dimploma: Economics Ionnina School of Busine'),
('AK10355555' ,  'ACCOUNTING', 'Dimploma: Economics Thesalonikh School of Business'),
('AK10366666' ,  'ADMINISTRATIVE', 'Dimploma: Tour Guide EKPA'),
('AK10377777' ,  'ADMINISTRATIVE', 'Dimploma: Tour Guide Patra School of Business'),
('AK10388888' ,  'ACCOUNTING' , 'Dimploma: Mathematics Thesalonikh APTH'),
('AK10399999' , 'LOGISTICS' , 'Dimploma: Volos Logistics School of Busines'),
('AK10310000' ,  'ADMINISTRATIVE' ,'Dimploma: Business Administration Patra School of Business'),
('AK10310111' ,  'ACCOUNTING' , 'Dimploma: Lamia School of Busines'),
('AK10310222' ,  'LOGISTICS' , 'Dimploma: Mathematics Athens School of Business'),
('AK10310333' ,  'ADMINISTRATIVE', 'Dimploma: Economics and Business Administration Lamia School of Business'),
('AK10310444' ,  'LOGISTICS' , 'Dimploma: Physics Thesalonikh'),
('AK10310555' , 'ACCOUNTING' , 'Dimploma: 53 Lykio Thesalonikhs');

INSERT INTO manages VALUES
('AK10311111' , 1),
('AK10322222' , 1),
('AK10333333' , 1),
('AK10344444' , 2),
('AK10355555' , 2),
('AK10366666' , 2),
('AK10377777' , 3),
('AK10388888' , 3),
('AK10399999' , 3),
('AK10310000' , 4),
('AK10310111' , 4),
('AK10310222' , 4),
('AK10310333' , 5),
('AK10310444' , 5),
('AK10310555' , 5);

insert into driver values 
('AM10410000','D','LOCAL',9),
('AM10410111','D','ABROAD',10),
('AM10410222','D','LOCAL',7),
('AM10410333','D','ABROAD',11),
('AM10410444','D','LOCAL',20),
('AM10410555','D','LOCAL',15),
('AM10410666','D','LOCAL',8),
('AM10410777','B','ABROAD',3);

insert into guide values 
('AK10311111', 'Employment History:\n\t\t1997 - 2000 Accountant at Logistiko Grafeio "H Lysi"
\n\t\t2000 - 2010 Travel Guide at "Joy Tours"'),
('AN10520010', 'Employment History:\n\t\t1999 - 2005 Travel Guide at "Pimenidis Travel"'),
('AN10520020', 'Employment History:\n\t\t1995 - 2002 Travel Guide at "TEMPI HOLIDAY"
\n\t\t2002 - 2011 Travel Guide at "KAVVADIAS TOURS"
\n\t\t2011 - 2017 Travel Guide at "ART TOURS"'),
('AN10520030','Employment History:\n\t\t2005 - 2016 Travel Guide at "DIOTOURS N.G & RED ELEPHANT"'),
('AN10520040','Employment History:\n\t\t2001 - 2019 Travel Guide at "Rania TOURS"'),
('AN10520050','Employment History:\n\t\t1990 - 2002 Travel Guide at "Penguin Travel Tours"'),
('AK10310444','Employment History:\n\t\t1999 - 2006 Accountant at "PANIDIS PAYLOS LOGISTIKO GRAFEIO"
\n\t\t2010 - 2018 Travel Guide at "Herodotus TOURS"'),
('AN10520060','Employment History:\n\t\t1989 - 1999 Travel Guide at "Mazi Travel & Events"
\n\t\t2000 - 2010 Travel Guide at "Prima Holidays"');

insert into languages values 
('AK10311111','Greek,English,French'),
('AN10520010','Greek,English,French,Italian'),
('AN10520020','Greek,English,German'),
('AN10520030','Greek,German,French,Italian'),
('AN10520040','Greek,English,Italian'),
('AN10520050','Greek,English,German,Italian'),
('AK10310444','Greek,English'),
('AN10520060','Greek,English,German,Italian');

INSERT INTO trip VALUES
(null, '2022-03-05 15:30:00', '2022-03-08 12:30:00', 30, 300, 1, 'AK10311111', 'AM10410000'),
(null, '2022-03-10 15:00:00', '2022-03-16 17:00:00', 30, 500, 1, 'AK10311111', 'AM10410000'),
(null, '2022-04-15 17:30:00', '2022-04-17 01:30:00', 60, 1000.65, 1, 'AK10311111', 'AM10410000'),
(null, '2022-03-08 15:00:00', '2022-03-27 13:00:00', 20, 200.85, 1, 'AN10520010', 'AM10410111'),
(null, '2022-04-03 17:00:00', '2022-04-19 22:00:00', 30, 500.52, 1, 'AN10520010', 'AM10410111'),
(null, '2022-06-18 22:30:00', '2022-06-29 18:30:00', 30, 900, 1, 'AN10520010', 'AM10410111'),
(null, '2022-07-05 18:30:00', '2022-07-15 16:30:00', 70, 1500, 2, 'AN10520020', 'AM10410222'),
(null, '2022-07-18 18:30:00', '2022-07-19 22:00:00', 30, 800, 2, 'AN10520020', 'AM10410222'),
(null, '2022-08-02 15:30:00', '2022-08-03 21:30:00', 30, 300, 2, 'AN10520020', 'AM10410222'),
(null, '2022-07-12 16:00:00', '2022-07-29 19:30:00', 30, 2000, 2, 'AN10520030', 'AM10410333'),
(null, '2022-08-10 18:30:00', '2022-08-23 19:00:00', 50, 100, 2, 'AN10520030', 'AM10410333'),
(null, '2022-09-09 18:30:00', '2022-09-26 12:00:00', 30, 700.88, 2, 'AN10520030', 'AM10410333'),
(null, '2022-01-05 13:30:00', '2022-01-21 03:30:00', 20, 1600, 3, 'AN10520040', 'AM10410444'),
(null, '2022-01-22 17:30:00', '2022-01-24 20:00:00', 30, 560, 3, 'AN10520040', 'AM10410444'),
(null, '2022-02-13 19:30:00', '2022-02-24 08:00:00', 30, 300.99, 3, 'AN10520040', 'AM10410444'),
(null, '2022-03-17 18:30:00', '2022-03-18 21:30:00', 60, 890, 3, 'AN10520040', 'AM10410444'),
(null, '2022-03-20 16:30:00', '2022-03-27 15:30:00', 30, 230, 3, 'AN10520040', 'AM10410444'),
(null, '2022-04-24 19:00:00', '2022-04-28 21:30:00', 45, 670, 3, 'AN10520040', 'AM10410444'),
(null, '2022-06-18 19:30:00', '2022-06-22 21:30:00', 30, 300, 4, 'AN10520050', 'AM10410555'),
(null, '2022-06-23 17:30:00', '2022-06-30 18:00:00', 30, 600, 4, 'AN10520050', 'AM10410555'),
(null, '2022-07-23 12:45:00', '2022-07-28 22:45:00', 100, 2030.45, 4, 'AN10520050', 'AM10410555'),
(null, '2022-08-08 08:30:00', '2022-08-10 19:30:00', 30, 380, 4, 'AN10520050', 'AM10410555'),
(null, '2022-09-14 18:00:00', '2022-09-26 10:45:00', 80, 3500, 4, 'AN10520050', 'AM10410555'),
(null, '2022-10-08 16:30:00', '2022-10-09 22:00:00', 30, 360.32, 4, 'AN10520050', 'AM10410555'),
(null, '2022-08-18 05:30:00', '2022-08-22 21:00:00', 20, 9000.74, 5, 'AK10310444', 'AM10410666'),
(null, '2022-10-20 14:30:00', '2022-10-27 21:00:00', 90, 1800.23, 5, 'AK10310444', 'AM10410666'),
(null, '2022-11-11 15:15:00', '2022-11-26 21:00:00', 30, 800, 5, 'AK10310444', 'AM10410666'),
(null, '2022-12-05 12:30:00', '2022-12-21 20:30:00', 7, 3400, 5, 'AN10520060', 'AM10410777'),
(null, '2023-02-17 19:45:00', '2023-02-26 18:00:00', 7, 3900.43, 5, 'AN10520060', 'AM10410777'),
(null, '2023-06-12 18:30:00', '2023-06-29 10:30:00', 7, 700, 5, 'AN10520060', 'AM10410777');

INSERT INTO destination VALUES
(null, 'Santorini', 'The awesome island of Santorini with the magnificent volcano.', 'LOCAL', 'Greek', null),
(null, 'Mykonos', 'The awesome island of Mykonos with the magnificent windmills.', 'LOCAL', 'Greek', null),
(null, 'Paros', 'The awesome island of Paros with the magnificent seas.', 'LOCAL', 'Greek', null),
(null, 'Zakynthos', 'The awesome island of Zakynthos with the magnificent night clubs.', 'LOCAL', 'Greek', null),
(null, 'Kalavryta', 'The awesome village of Kalavryta with the magnificent mountains.', 'LOCAL', 'Greek', null),
(null, 'Kalavryta ski resort', 'The awesome ski resort of Kalavryta is perfect to have fun.', 'LOCAL', 'Greek', 5),
(null, 'Arachova', 'The awesome village of Arachova with the magnificent trees.', 'LOCAL', 'Greek', null),
(null, 'Parnassos', 'The awesome mountain Parnassos with the magnificent cliffs.', 'LOCAL', 'Greek', 7),
(null, 'Heraklion', 'The awesome island of Crete with the magnificent Heraklion.', 'LOCAL', 'Greek', null),
(null, 'Mani', 'The awesome Peloponnese with the magnificent Mani.', 'LOCAL', 'Greek', null),
(null, 'Rhodes', 'The awesome island of Rhodes with the biggest water park in Europe.', 'LOCAL', 'Greek', null),
(null, 'Nafpaktos', 'The awesome Nafpaktos with the magnificent buildings.', 'LOCAL', 'Greek', null),
(null, 'Ano Hora', 'The awesome village of Ano Hora near Nafpaktos with the magnificent view.', 'LOCAL', 'Greek', 12),
(null, 'London', 'The capital of Great Britain with the magnificent Big Ben.', 'ABROAD', 'English', null),
(null, 'Paris', 'The capital of France with the magnificent Eiffel Tower.', 'ABROAD', 'French', null),
(null, 'Rome', 'The capital of Italy with the magnificent Colosseum.', 'ABROAD', 'Italian', null),
(null, 'Milan', 'A city of Italy with the magnificent cathedral.', 'ABROAD', 'Italian', null),
(null, 'Berlin', 'The capital of Germany with the magnificent Reichstag.', 'ABROAD', 'German', null);

INSERT INTO travel_to VALUES
(1, 1, '2022-03-05 22:00:00', '2022-03-08 06:00:00'),
(2, 2, '2022-03-10 20:00:00', '2022-03-16 12:00:00'),
(3, 3, '2022-04-15 21:00:00', '2022-04-16 22:00:00'),
(4, 14, '2022-03-15 12:00:00', '2022-03-20 16:00:00'),
(5, 15, '2022-04-07 21:30:00', '2022-04-15 17:30:00'),
(6, 16, '2022-06-21 18:00:00', '2022-06-26 23:00:00'),
(7, 4, '2022-07-05 22:00:00', '2022-07-15 13:00:00'),
(8, 5, '2022-07-18 20:30:00', '2022-07-19 12:00:00'),
(8, 6, '2022-07-19 13:00:00', '2022-07-19 20:00:00'),
(9, 7, '2022-08-02 17:00:00', '2022-08-03 12:00:00'),
(9, 8, '2022-08-03 13:00:00', '2022-08-03 20:00:00'),
(10, 17, '2022-07-15 18:00:00', '2022-07-26 17:30:00'),
(11, 18, '2022-08-13 23:30:00', '2022-08-20 14:00:00'),
(12, 15, '2022-09-13 15:30:00', '2022-09-22 15:00:00'),
(13, 9, '2022-01-05 22:00:00', '2022-01-20 19:00:00'),
(14, 10, '2022-01-22 20:30:00', '2022-01-24 17:00:00'),
(15, 11, '2022-02-14 12:30:00', '2022-02-23 15:00:00'),
(16, 12, '2022-03-17 20:00:00', '2022-03-18 15:00:00'),
(16, 13, '2022-03-18 16:00:00', '2022-03-18 20:00:00'),
(17, 1, '2022-03-20 21:00:00', '2022-03-27 11:00:00'),
(18, 2, '2022-04-24 22:30:00', '2022-04-28 18:00:00'),
(19, 3, '2022-06-18 23:30:00', '2022-06-22 17:30:00'),
(20, 4, '2022-06-23 22:30:00', '2022-06-30 13:00:00'),
(21, 9, '2022-07-23 22:45:00', '2022-07-28 12:45:00'),
(22, 10, '2022-08-08 12:00:00', '2022-08-10 16:00:00'),
(23, 11, '2022-09-14 23:45:00', '2022-09-26 05:00:00'),
(24, 5, '2022-10-08 19:30:00', '2022-10-09 19:00:00'),
(25, 7, '2022-08-18 11:30:00', '2022-08-22 15:00:00'),
(26, 3, '2022-10-20 23:30:00', '2022-10-27 12:00:00'),
(27, 4, '2022-11-11 21:15:00', '2022-11-26 15:00:00'),
(28, 16, '2022-12-08 17:00:00', '2022-12-18 16:00:00'),
(29, 17, '2023-02-20 19:45:00', '2023-02-26 18:00:00'),
(30, 18, '2023-06-16 15:00:00', '2023-06-25 14:00:00');

INSERT INTO event VALUES
(1,'2022-03-06 10:00:00', '2022-03-06 14:00:00', 'Mpanio stin Kokkini Paralia.'),
(2, '2022-03-11 09:00:00','2022-03-11 13:00:00', 'Mpanio stin paralia Platys Gualos.'),
(3, '2022-04-16 15:00:00', '2022-04-16 19:00:00', 'Volta stin Naousa.'),
(4, '2022-03-16 14:00:00', '2022-03-16 18:00:00', 'Episkepsi sto Bretaniko Mouseio.'),
(5, '2022-04-08 18:00:00', '2022-04-08 20:00:00', 'Episkepsi ston Pyrgo tou Eiffel.'),
(6, '2022-06-22 11:00:00', '2022-06-22 15:00:00', 'Episkepsi sto Kolossaio.'),
(7, '2022-07-07 10:00:00', '2022-07-07 14:00:00', 'Tour sto Nauagio kai sto Turtle Island.'),
(7, '2022-07-08 17:00:00', '2022-07-08 22:00:00', 'Volta stin Xwra.'),
(8, '2022-07-18 21:00:00', '2022-07-18 00:00:00', 'Deipno stin taverna "O Elatos".'),
(8, '2022-07-19 13:00:00', '2022-07-19 19:00:00', 'Ski kai xalarwsi sto sale.'),
(9, '2022-08-02 18:00:00', '2022-08-02 22:00:00', 'Volta sto xwrio.'),
(9, '2022-08-03 13:00:00', '2022-08-03 19:00:00', 'Ski kai xalarwsi sto sale.'),
(10, '2022-07-16 12:00:00', '2022-07-16 16:00:00', 'Volta sto kentro tis polis.'),
(11, '2022-08-14 16:00:00', '2022-08-14 17:30:00', 'Episkepsi sto toixos tou Berolinou.'),
(11, '2022-08-15 15:00:00', '2022-08-15 16:30:00', 'Episkepsi stin Pyli tou Bradenvourgou.'),
(12, '2022-09-14 14:00:00', '2022-09-14 18:00:00', 'Episkepsi sto Loubro.'),
(13, '2022-01-07 17:30:00', '2022-01-07 20:00:00', 'Episkepsi sto Istoriko Mouseio Tis Kritis.'),
(14, '2022-01-22 09:00:00', '2022-01-22 12:00:00', 'Episkepsi stin spilia Dirou.'), 
(15, '2022-01-22 10:00:00', '2022-01-22 14:00:00', 'Episkepsi sto Water Park.'),
(16, '2022-03-18 11:00:00', '2022-03-18 13:30:00', 'Episkepsi sto kastro tis Naupaktou.'),
(16, '2022-03-18 16:00:00', '2022-03-18 19:00:00', 'Pezoporia Ksenios-Agia Paraskeui-Ksenios.'),
(17,'2022-03-23 13:00:00', '2022-03-23 16:00:00','Tour me barka kai episkepsi sto ifaistio.'),
(18,'2022-04-27 14:30:00', '2022-04-27 15:30:00','Episkepsi stous anemomilous.'),
(19,'2022-06-19 14:00:00', '2022-06-19 19:30:00','Mpanio stin Santa Maria.'),
(20,'2022-06-28 14:00:00', '2022-06-28 19:00:00','Tour sto Nauagio kai sta Blue Caves'),
(21,'2022-07-25 14:45:00', '2022-07-25 15:45:00','Episkepsi sto anaktoro ths Knosou.'),
(22,'2022-08-09 12:00:00', '2022-08-09 16:00:00','Episkepsi sto Gytheio.'),
(23,'2022-09-22 20:00:00', '2022-09-22 22:00:00','Episkepsi sto kastro.'),
(24,'2022-10-09 12:00:00', '2022-10-09 14:00:00','Pezoporeia sta giro bouna.'),
(25,'2022-08-20 10:30:00', '2022-08-20 12:30:00','Pezoporeia sta giro bouna.'),
(26,'2022-10-23 12:30:00', '2022-10-23 14:30:00','Volta stin Naousa.'),
(27,'2022-11-22 15:15:00', '2022-11-22 18:15:00','Volta stin Xwra.'),
(28,'2022-12-16 13:00:00', '2022-12-16 15:00:00','Episkepsi sto Kolossaio.'),
(29,'2023-02-23 15:00:00', '2023-02-23 17:00:00','Episkepsi ston kentriko kathedriko nao.'),
(30,'2023-06-16 20:00:00', '2023-06-16 22:00:00','Episkepsi sto Reichstag.');

INSERT INTO reservation VALUES
(1,20,'Iris','Agelopoulou', 'ADULT'),
(2,24,'Iasonas','Agelopoulos', 'ADULT'),
(3,55,'Atticus','Makris', 'ADULT'),
(4,27,'Theo','Papadopoulos', 'ADULT'),
(5,28,'Gregory','Diasakos', 'ADULT'),
(6,29,'Achilles','Tsaltakis', 'ADULT'),
(7,70,'Daphne','Leonh', 'ADULT'),
(8,22,'Vasilis','Makris', 'ADULT'),
(9,2,'Alkis','Manouras', 'ADULT'),
(10,1,'Orestis','Bouras', 'ADULT'),
(1,13,'Nikolas','Papadakis', 'ADULT'),
(2,20,'Leonidas','Papakonstantinou', 'ADULT'),
(3,10,'Maria','Makri', 'ADULT'),
(4,20,'Alexia','Papadopoulou', 'ADULT'),
(5,18,'Alexandra','Diasakou', 'ADULT'),
(6,20,'Kostantina','Tsaltakh', 'ADULT'),
(7,17,'Apostolis','Nikolopoulos', 'ADULT'),
(8,20,'Marina','Makri', 'ADULT'),
(9,8,'Marios','Pavlidis', 'ADULT'),
(10,10,'Fotini','Boura', 'ADULT'),
(1,12,'Apollon','Savvidis', 'ADULT'),
(2,15,'Kyriakos','Akritidis', 'ADULT'),
(3,9,'Thanos','Makris', 'MINOR'),
(4,6,'Ioannis','Papadopoulos', 'MINOR'),
(5,2,'Hercules','Diasakos', 'MINOR'),
(6,19,'Nektarios','Tsaltakis', 'MINOR'),
(7,67,'Ambrosia','Akritidou', 'ADULT'),
(8,28,'Stavroula','Makri', 'MINOR'),
(9,9,'Triantafylos','Stefanidis', 'ADULT'),
(10,8,'Cleopatra','Boura', 'MINOR'),
(11, 5, 'Giannis', 'Kokas', 'ADULT'),
(11, 6, 'Maria', 'Koka', 'ADULT'),
(11, 7, 'Alexandros', 'Kokas', 'MINOR'),
(12, 5, 'Thanasis', 'Alexiou', 'ADULT'),
(12, 6, 'Zoi', 'Likou', 'ADULT'),
(12, 7, 'Tzina', 'Pseutou', 'ADULT'),
(13, 5, 'Nikos', 'Kolas', 'ADULT'),
(13, 6, 'Eleni', 'Kappa', 'ADULT'),
(13, 7, 'Oresths', 'Kappa', 'MINOR'),
(14, 5, 'Andreas', 'Ntivakias', 'ADULT'),
(14, 6, 'Anastasia', 'Ntivakia', 'ADULT'),
(14, 7, 'Xara', 'Ntivakia', 'MINOR'),
(15, 5, 'Grigoris', 'Manifavas', 'MINOR'),
(15, 6, 'Kleanthi', 'Manifava', 'ADULT'),
(15, 7, 'Anastasia', 'Manifava', 'MINOR'),
(16, 5, 'Iason', 'Alexakhs', 'ADULT'),
(16, 6, 'Eleni', 'Alexakh', 'ADULT'),
(16, 7, 'Dimitris', 'Alexakhs', 'MINOR'),
(17, 5, 'Tzoulia', 'Alexandratou', 'ADULT'),
(17, 6, 'Alkhs', 'Alexandratos', 'ADULT'),
(17, 7, 'Manos', 'Manolos', 'ADULT'),
(18, 5, 'Giorgos', 'Georgiou', 'ADULT'),
(18, 6, 'Anakin', 'Skywalker', 'ADULT'),
(18, 7, 'Padme', 'Skywalker', 'ADULT'),
(19, 5, 'Damianos', 'Tate', 'ADULT'),
(19, 6, 'Roumpini', 'Tate', 'ADULT'),
(19, 7, 'Xarhs', 'Tate', 'MINOR'),
(20, 5, 'Apollonas', 'Prifths', 'ADULT'),
(20, 6, 'Marios', 'Prifths', 'ADULT'),
(20, 7, 'Platonas', 'Prifths', 'MINOR'),
(21, 13, 'Alexandros', 'Gkogkas', 'ADULT'),
(21, 14, 'Anastasia', 'Gkogkas', 'ADULT'),
(21, 15, 'Marios', 'Gkogas', 'MINOR'),
(22, 5, 'Marios', 'Skourlis', 'ADULT'),
(22, 6, 'Grigoris', 'Papadakis', 'ADULT'),
(22, 7, 'Giorgos', 'Papadopoulos', 'ADULT'),
(23, 9, 'Vasiliana', 'Konstantakopoulou', 'ADULT'),
(23, 10, 'Dimitris', 'Konstantakopoulos', 'ADULT'),
(23, 11, 'Asimakis', 'Konstantakopoulos', 'MINOR'),
(24, 30, 'Giannis', 'Koutsogiannis', 'ADULT'),
(24, 31, 'Panagiota', 'Koutsogianni', 'ADULT'),
(24, 32, 'Sofoklis', 'Koutsogiannis', 'MINOR'),
(25, 1, 'Grigoris', 'Aleksiou', 'MINOR'),
(25, 2, 'Vasiliki', 'Aleksiou', 'ADULT'),
(25, 3, 'Antreas', 'Aleksiou', 'MINOR'),
(26, 12, 'Konstantinos', 'Alexopoulos', 'ADULT'),
(26, 13, 'Eleni', 'Alexopoulou', 'ADULT'),
(26, 14, 'Dimitris', 'Alexopulos', 'MINOR'),
(27, 12, 'Maria', 'Papaioannou', 'ADULT'),
(27, 13, 'Marios', 'Daskalakis', 'ADULT'),
(27, 14, 'Pantelis', 'Manolos', 'ADULT'),
(28, 2, 'Giorgos', 'Makris', 'ADULT'),
(28, 3, 'Grigoris', 'Lagaros', 'ADULT'),
(28, 4, 'Despoina', 'Aritzaki', 'ADULT'),
(29, 5, 'Orestis', 'Oikonomou', 'ADULT'),
(29, 6, 'Kalinikos', 'Oikonomou', 'ADULT'),
(29, 7, 'Dioni', 'Oikonomou', 'MINOR'),
(30, 1, 'Virginia', 'Papaderou', 'ADULT'),
(30, 2, 'Xara', 'Papaderou', 'ADULT'),
(30, 3, 'Konstantinos', 'Papaderos', 'MINOR');

INSERT INTO  offers VALUES
(null ,'2023-02-06 14:00:00','2023-02-18 22:00:00' ,400,'5'),
(null ,'2023-04-06 07:00:00','2023-04-18 22:00:00' ,1200,'14'),
(null ,'2023-08-06 07:00:00','2023-08-18 22:00:00' ,700,'1');

/*Procedures*/

-- procedure 3.1.3.1
DROP PROCEDURE IF EXISTS insert_driver;
DELIMITER $
CREATE PROCEDURE insert_driver(IN AT char(10),IN name varchar(20),IN lname varchar(20),IN salary float(7,2),IN license ENUM('A','B','C','D'),IN route ENUM('LOCAL','ABROAD'),IN experience tinyint(4))
BEGIN
DECLARE code INT;

SELECT br_code INTO code FROM (SELECT branch.br_code,IFNULL(count(wrk_AT),0) AS 'Number of Drivers' FROM driver INNER JOIN worker ON drv_AT=wrk_AT RIGHT JOIN branch ON br_code=wrk_br_code GROUP BY br_code ORDER BY IFNULL(count(wrk_AT),0) ASC LIMIT 1) AS minimum_drivers;

INSERT INTO worker VALUES (AT,name,lname,salary,code);

INSERT INTO driver VALUES (AT,license,route,experience);
END$
DELIMITER ;

-- procedure 3.1.3.2
DROP PROCEDURE IF EXISTS search_trip;
DELIMITER $
CREATE PROCEDURE search_trip(IN code INT,IN start_date datetime,IN end_date datetime)
BEGIN 
    DECLARE trip_id INT;
    DECLARE dep DATETIME;
    DECLARE ret DATETIME;
    DECLARE maxseats TINYINT;
    DECLARE cost FLOAT(7,2);
    DECLARE br_code INT;
    DECLARE guide_AT CHAR(10);
    DECLARE driver_AT CHAR(10);
    DECLARE finishedFlag INT;
    DECLARE no_of_reservations INT; #arithmos reservations gia to kathe trip
    DECLARE driver_name VARCHAR(20); #o driver tou trip
    DECLARE driver_lname VARCHAR(20);
    DECLARE guide_name VARCHAR(20); #o guide tou trip
    DECLARE guide_lname VARCHAR(20);
    DECLARE empty_seats INT;
    /*cursor ston trips*/
    DECLARE tripCurs CURSOR FOR
    SELECT * FROM trip
    WHERE tr_departure>=start_date 
    AND tr_departure<=end_date
    AND tr_br_code = code;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finishedFlag=1;
    OPEN tripCurs;
    SET finishedFlag=0;
    FETCH tripCurs INTO trip_id, dep, ret, maxseats, cost,
    br_code, guide_AT, driver_AT;
    WHILE(finishedFlag=0) DO
        /*get the number of reservations*/
        SELECT COUNT(*) INTO no_of_reservations 
        FROM reservation 
        INNER JOIN trip ON res_tr_id=trip_id
        WHERE tr_departure >= start_date 
        AND tr_departure <= end_date
        AND tr_br_code = code AND res_tr_id = tr_id;
        /*get the driver of the trip*/
        SELECT wrk_name, wrk_lname INTO driver_name, driver_lname
        FROM trip 
        INNER JOIN worker
        ON tr_drv_AT = wrk_AT
        WHERE tr_id = trip_id;
        /*get the guide of the trip*/
        SELECT wrk_name, wrk_lname INTO guide_name, guide_lname
        FROM trip 
        INNER JOIN worker
        ON tr_gui_AT = wrk_AT
        WHERE tr_id = trip_id;
        SET empty_seats = maxseats-no_of_reservations;
        /*final select*/
        SELECT trip_id AS 'Trip Id',cost AS 'Cost',maxseats AS 'Maxseats',
        no_of_reservations AS 'Number of Reservations', empty_seats AS 'Empty Seats',
        driver_lname AS 'Driver Lastname', driver_name AS 'Driver Name', 
        guide_lname AS 'Guide Lastname', guide_name AS 'Guide Name' ,dep AS 'Departure',
        ret AS 'Return';
        FETCH tripCurs INTO trip_id, dep, ret, maxseats, cost,
        br_code, guide_AT, driver_AT;
    END WHILE;
    CLOSE tripCurs;
END$
DELIMITER ;

/*procedure 3.1.3.3*/
DROP PROCEDURE IF EXISTS delete_worker;
DELIMITER $
CREATE PROCEDURE delete_worker(IN name varchar(20),IN lname varchar(20))
BEGIN
IF exists(SELECT * FROM worker INNER JOIN admin ON wrk_AT=adm_AT WHERE wrk_lname=lname AND wrk_name=name AND adm_type="ADMINISTRATIVE")
THEN
SELECT "This person is an admin in a branch therefore the deletion is restricted!" AS Error;
ELSEIF exists(SELECT * FROM worker WHERE wrk_lname=lname AND wrk_name=name) 
THEN 
DELETE FROM worker WHERE wrk_lname=lname AND wrk_name=name;
ELSE 
SELECT "This person isn't a worker in any branch!" AS Error;
END IF;
END$
DELIMITER ;

/*index */
DROP INDEX res_ind ON reservation_offers;
CREATE INDEX res_ind ON reservation_offers(deposit_amount, rsv_lastname, rsv_offer_id);

-- procedure 3.1.3.4 a)
DROP PROCEDURE IF EXISTS res_range;
DELIMITER $
CREATE PROCEDURE res_range(IN r1 INT, IN r2 INT)
BEGIN
    SELECT rsv_name AS 'Firstname', rsv_lastname AS 'Lastname'
    FROM reservation_offers
    WHERE deposit_amount >= r1 AND deposit_amount<=r2;
END$
DELIMITER ;

-- procedure 3.1.3.4 b)
DROP PROCEDURE IF EXISTS res_names;
DELIMITER $
CREATE PROCEDURE res_names(IN lname VARCHAR(20))
BEGIN
    DECLARE flag INT; 
    DECLARE offer_id INT;
    DECLARE no_of_res INT;
    DECLARE finishedFlag INT;
    DECLARE multResCurs CURSOR FOR
    SELECT rsv_offer_id, COUNT(rsv_offer_id)
    FROM reservation_offers
    WHERE rsv_lastname=lname
    GROUP BY rsv_offer_id
    HAVING COUNT(rsv_offer_id)>1
    ORDER BY rsv_offer_id;

    DECLARE singleResCurs CURSOR FOR
    SELECT rsv_offer_id, COUNT(rsv_offer_id)
    FROM reservation_offers
    WHERE rsv_lastname=lname
    GROUP BY rsv_offer_id
    HAVING COUNT(rsv_offer_id)=1
    ORDER BY rsv_offer_id;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finishedFlag=1;
    OPEN multResCurs;
    SET finishedFlag=0;
    FETCH multResCurs INTO offer_id, no_of_res;
    SET flag = 0;
    WHILE(finishedFlag=0) DO
        IF(flag = 0) THEN
            SELECT 'Reserved offers for last name' AS '', lname AS '';
        END IF;
        SELECT offer_id AS 'Offer Id', no_of_res AS 'Number of reserved offers';
        FETCH multResCurs INTO offer_id,no_of_res; 
        SET flag =  1;
    END WHILE;
    CLOSE multResCurs;
    OPEN singleResCurs;
    SET finishedFlag=0;
    SET flag = 0;
    FETCH singleResCurs INTO offer_id, no_of_res;
    WHILE(finishedFlag=0) DO
        IF(flag = 0) THEN
            SELECT 'Reserved offers with one reservation per offer' AS '';
        END IF;
        SELECT rsv_name, rsv_lastname, rsv_offer_id
        FROM reservation_offers
        WHERE rsv_offer_id = offer_id AND rsv_lastname = lname;
        SET flag = 1;
        FETCH singleResCurs INTO offer_id,no_of_res;
    END WHILE;
END$
DELIMITER ;

/*Procedure pou dhmioyrgei enan neo user gia tin vasi travel_agency. Prepei na tin kalesoume afou kanoume insert enan it_admin*/
DROP PROCEDURE IF EXISTS create_user;
DELIMITER $
CREATE PROCEDURE create_user(IN it_username VARCHAR(20),IN it_password CHAR(10))
BEGIN
    /*prepei na xrisimopoiisw tin CONCAT() giati den mas epitrepei na ektelesoume tin CREATE USER me metavlites*/

    SET @cr_user = CONCAT
    ('
    CREATE USER "',it_username,'"@"localhost" IDENTIFIED BY "',it_password,'" '
    );
    PREPARE cr FROM @cr_user;
    EXECUTE cr;
    DEALLOCATE PREPARE cr;

    /*omoiws gia to GRANT PRIVILEGES*/
    
    SET @gr_user = CONCAT
    ('
    GRANT ALL ON travel_agency.* TO "',it_username,'"@"localhost" '
    );
    PREPARE gr FROM @gr_user;
    EXECUTE gr;
    DEALLOCATE PREPARE gr;

    /*gia na mporei na kanei select kai delete to user ston pinaka mysql.db*/

    SET @gr_user = CONCAT
    ('
    GRANT SELECT,DELETE ON mysql.db TO "',it_username,'"@"localhost" '
    );
    PREPARE gr FROM @gr_user;
    EXECUTE gr;
    DEALLOCATE PREPARE gr;

    /*gia na mporei na kanei create user*/

    SET @gr_cr_user = CONCAT
    ('
    GRANT CREATE USER ON *.* TO "',it_username,'"@"localhost" '
    );
    PREPARE gr_cr FROM @gr_cr_user;
    EXECUTE gr_cr;
    DEALLOCATE PREPARE gr_cr;

    SET @flush = "FLUSH PRIVILEGES";
    PREPARE stmt FROM @flush;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;

END$
DELIMITER ;

/*user mono me select privilages*/

DROP PROCEDURE IF EXISTS create_select_user;
DELIMITER $
CREATE PROCEDURE create_select_user(IN it_username VARCHAR(20),IN it_password CHAR(10))
BEGIN
    #prepei na xrisimopoiisw tin CONCAT() giati den mas epitrepei na ektelesoume tin CREATE USER me metavlites
    SET @cr_user = CONCAT
    ('
    CREATE USER "',it_username,'"@"localhost" IDENTIFIED BY "',it_password,'" '
    );
    PREPARE cr FROM @cr_user;
    EXECUTE cr;
    DEALLOCATE PREPARE cr;
    
    /*PRIVILEGES SELECT kai EXECUTE gia na mporei na kalei procedures*/

    SET @gr_user = CONCAT
    ('
    GRANT EXECUTE, SELECT ON travel_agency.* TO "',it_username,'"@"localhost" '
    );
    PREPARE gr FROM @gr_user;
    EXECUTE gr;
    DEALLOCATE PREPARE gr;

    /*gia na mporei na kanei select kai delete to user ston pinaka mysql.db*/

    SET @gr_user = CONCAT
    ('
    GRANT SELECT ON mysql.db TO "',it_username,'"@"localhost" '
    );
    PREPARE gr FROM @gr_user;
    EXECUTE gr;
    DEALLOCATE PREPARE gr;

    SET @flush = "FLUSH PRIVILEGES";
    PREPARE stmt FROM @flush;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;

END$
DELIMITER ;

/*Procedure που βλέπει για κάθε υποκατάστημα τα στοιχεία του, το ονοματεπώνυμο του διευθυντή του, το σύνολο κρατήσεων και το σύνολο εσόδων (κράτηση επί κόστος ταξιδιού)*/
DROP PROCEDURE IF EXISTS branch_info;
DELIMITER $
CREATE PROCEDURE branch_info()
BEGIN 
DECLARE branch_code INT(11); 
DECLARE branch_street VARCHAR(30); 
DECLARE branch_num INT(4);
DECLARE branch_city VARCHAR(30);
DECLARE finishedFlag INT;
DECLARE admin_name VARCHAR(20); 
DECLARE admin_lname VARCHAR(20);
DECLARE total_of_reservations INT;
DECLARE income FLOAT;

DECLARE branchCurs CURSOR FOR SELECT * FROM branch;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET finishedFlag=1;

OPEN branchCurs;

SET finishedFlag=0;

FETCH branchCurs INTO branch_code,branch_street,branch_num,branch_city;
WHILE(finishedFlag=0) 
DO
SELECT COUNT(*) INTO total_of_reservations FROM reservation INNER JOIN trip ON res_tr_id=tr_id WHERE tr_br_code=branch_code;

SELECT wrk_name,wrk_lname INTO admin_name,admin_lname FROM admin INNER JOIN worker ON adm_AT=wrk_AT WHERE wrk_br_code=branch_code AND adm_type='ADMINISTRATIVE';

SET income=(SELECT SUM(tr_cost*res_count) FROM trip JOIN (SELECT res_tr_id, COUNT(*) as res_count FROM reservation GROUP BY res_tr_id) as res_counts ON trip.tr_id = res_counts.res_tr_id WHERE tr_br_code = branch_code);

SELECT branch_code AS 'Branch code',branch_street AS 'Street',branch_num AS 'Number',branch_city AS 'City',admin_name AS 'Admin name',admin_lname AS 'Admin last name',total_of_reservations AS 'Total of Reservations',income AS 'Income';

FETCH branchCurs INTO branch_code,branch_street,branch_num,branch_city;
END WHILE;

CLOSE branchCurs;
END$
DELIMITER ;

/*insert tous it_admins edw epeidi xreiazomoun to create_user() procedure*/

INSERT INTO worker VALUES
('AK12000001' , 'Artemis' , 'Padadimitriou','1500',1),
('AK12000002' , 'Maria' , 'Prodromou','1500',1),
('AK12000003' , 'John' , 'Stathopoulos','1500',1),
('AK12000004' , 'Andreas' , 'Vasiladiotis','1500',2),
('AK12000005' , 'Iason' , 'Raikos','1500',2),
('AK12000006' , 'Orestis' , 'Makris','1500',3),
('AK12000007' , 'Grigotis' , 'Delibaltadakis','1500',3),
('AK12000008' , 'Alexandros' ,  'Alexandrou','1500',4),
('AK12000009' , 'Nikolas' , 'Karavlidis','1500',5),
('AK12000010' , 'Viki' , 'Aleksiou','1500',5);

INSERT INTO it_admin (it_at,it_start_date)VALUES
('AK12000001'  ,'2015-02-06 14:00:00'),
('AK12000002'  ,'2012-01-26 14:00:00'),
('AK12000004'  , '2008-02-06 14:00:00'),
('AK12000010' , '2017-11-11 10:00:00');

INSERT INTO it_admin (it_at,it_password,it_start_date)VALUES
('AK12000003' , 'John' ,'2010-02-06 14:00:00'),
('AK12000005' , '1234' ,'2007-01-31 14:00:00'),
('AK12000006' , '1444' ,'2019-03-06 12:00:00'),
('AK12000007' , 'ff' ,'2012-05-06 10:00:00'),
('AK12000008' , 'AlexAlex' ,'2010-09-06 10:00:00'),
('AK12000009' , 'Nik', '2016-02-04 10:00:00');

call create_user('Padadimitriou','password');
call create_user('Prodromou','password');
call create_user('Stathopoulos','John');
call create_user('Vasiladiotis','password');
call create_user('Raikos','1234');
call create_user('Makris','1444');
call create_user('Delibaltadakis','ff');
call create_user('Alexandrou','AlexAlex');
call create_user('Karavlidis','Nik');
call create_user('Aleksiou','password');

/*Triggers*/

/*trigger 3.1.4.1*/

/*triggers gia ton log_trip*/
DROP TRIGGER IF EXISTS log_trip_insert;
DELIMITER $
CREATE TRIGGER log_trip_insert AFTER INSERT ON trip
FOR EACH ROW
BEGIN
    INSERT INTO log_trip VALUES
    ('INSERT',CURRENT_USER(),NOW(),NEW.tr_id,NEW.tr_departure,NEW.tr_return,
    NEW.tr_maxseats,NEW.tr_cost,NEW.tr_br_code,NEW.tr_gui_AT,NEW.tr_drv_AT);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_trip_update;
DELIMITER $
CREATE TRIGGER log_trip_update AFTER UPDATE ON trip
FOR EACH ROW
BEGIN
    INSERT INTO log_trip VALUES
    ('UPDATE',CURRENT_USER(),NOW(),OLD.tr_id,OLD.tr_departure,OLD.tr_return,
    OLD.tr_maxseats,OLD.tr_cost,OLD.tr_br_code,OLD.tr_gui_AT,OLD.tr_drv_AT);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_trip_delete;
DELIMITER $
CREATE TRIGGER log_trip_delete AFTER DELETE ON trip
FOR EACH ROW
BEGIN
    INSERT INTO log_trip VALUES
    ('DELETE',CURRENT_USER(),NOW(),OLD.tr_id,OLD.tr_departure,OLD.tr_return,
    OLD.tr_maxseats,OLD.tr_cost,OLD.tr_br_code,OLD.tr_gui_AT,OLD.tr_drv_AT);
END$
DELIMITER ;

/*triggers gia ton log_reservation*/
DROP TRIGGER IF EXISTS log_reservation_insert;
DELIMITER $
CREATE TRIGGER log_reservation_insert AFTER INSERT ON reservation
FOR EACH ROW
BEGIN
    INSERT INTO log_reservation VALUES
    ('INSERT',CURRENT_USER(),NOW(),NEW.res_tr_id,NEW.res_seatnum,
    NEW.res_name,NEW.res_lname,NEW.res_isadult);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_reservation_update;
DELIMITER $
CREATE TRIGGER log_reservation_update AFTER UPDATE ON reservation
FOR EACH ROW
BEGIN
    INSERT INTO log_reservation VALUES
    ('UPDATE',CURRENT_USER(),NOW(),OLD.res_tr_id,OLD.res_seatnum,
    OLD.res_name,OLD.res_lname,OLD.res_isadult);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_reservation_delete;
DELIMITER $
CREATE TRIGGER log_reservation_delete AFTER DELETE ON reservation
FOR EACH ROW
BEGIN
    INSERT INTO log_reservation VALUES
    ('DELETE',CURRENT_USER(),NOW(),OLD.res_tr_id,OLD.res_seatnum,
    OLD.res_name,OLD.res_lname,OLD.res_isadult);
END$
DELIMITER ;

/*triggers gia ton log_event*/
DROP TRIGGER IF EXISTS log_event_insert;
DELIMITER $
CREATE TRIGGER log_event_insert AFTER INSERT ON event
FOR EACH ROW
BEGIN
    INSERT INTO log_event VALUES
    ('INSERT',CURRENT_USER(),NOW(),NEW.ev_tr_id,NEW.ev_start, 
    NEW.ev_end,NEW.ev_descr);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_event_update;
DELIMITER $
CREATE TRIGGER log_event_update AFTER UPDATE ON event
FOR EACH ROW
BEGIN
    INSERT INTO log_event VALUES
    ('UPDATE',CURRENT_USER(),NOW(),OLD.ev_tr_id,OLD.ev_start, 
    OLD.ev_end,OLD.ev_descr);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_event_delete;
DELIMITER $
CREATE TRIGGER log_event_delete AFTER DELETE ON event
FOR EACH ROW
BEGIN
    INSERT INTO log_event VALUES
    ('DELETE',CURRENT_USER(),NOW(),OLD.ev_tr_id,OLD.ev_start, 
    OLD.ev_end,OLD.ev_descr);
END$
DELIMITER ;

/*triggers gia ton log_travel_to*/
DROP TRIGGER IF EXISTS log_travel_to_insert;
DELIMITER $
CREATE TRIGGER log_travel_to_insert AFTER INSERT ON travel_to
FOR EACH ROW
BEGIN
    INSERT INTO log_travel_to VALUES
    ('INSERT',CURRENT_USER(),NOW(),NEW.to_tr_id,NEW.to_dst_id,
    NEW.to_arrival,NEW.to_departure);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_travel_to_update;
DELIMITER $
CREATE TRIGGER log_travel_to_update AFTER UPDATE ON travel_to
FOR EACH ROW
BEGIN
    INSERT INTO log_travel_to VALUES
    ('UPDATE',CURRENT_USER(),NOW(),OLD.to_tr_id,OLD.to_dst_id,
    OLD.to_arrival,OLD.to_departure);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_travel_to_delete;
DELIMITER $
CREATE TRIGGER log_travel_to_delete AFTER DELETE ON travel_to
FOR EACH ROW
BEGIN
    INSERT INTO log_travel_to VALUES
    ('DELETE',CURRENT_USER(),NOW(),OLD.to_tr_id,OLD.to_dst_id,
    OLD.to_arrival,OLD.to_departure);
END$
DELIMITER ;

/*triggers gia ton log_destination*/
DROP TRIGGER IF EXISTS log_destination_insert;
DELIMITER $
CREATE TRIGGER log_destination_insert AFTER INSERT ON destination
FOR EACH ROW
BEGIN
    INSERT INTO log_destination VALUES
    ('INSERT',CURRENT_USER(),NOW(),NEW.dst_id,NEW.dst_name,NEW.dst_dscr,
    NEW.dst_rtype,NEW.dst_language,NEW.dst_location);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_destination_update;
DELIMITER $
CREATE TRIGGER log_destination_update AFTER UPDATE ON destination
FOR EACH ROW
BEGIN
    INSERT INTO log_destination VALUES
    ('UPDATE',CURRENT_USER(),NOW(),OLD.dst_id,OLD.dst_name,OLD.dst_dscr,
    OLD.dst_rtype,OLD.dst_language,OLD.dst_location);
END$
DELIMITER ;

DROP TRIGGER IF EXISTS log_destination_delete;
DELIMITER $
CREATE TRIGGER log_destination_delete AFTER DELETE ON destination
FOR EACH ROW
BEGIN
    INSERT INTO log_destination VALUES
    ('DELETE',CURRENT_USER(),NOW(),OLD.dst_id,OLD.dst_name,OLD.dst_dscr,
    OLD.dst_rtype,OLD.dst_language,OLD.dst_location);
END$
DELIMITER ;

/*trigger 3.1.4.2*/
DROP TRIGGER IF EXISTS check_reservations;
DELIMITER $
CREATE TRIGGER check_reservations BEFORE UPDATE ON trip
FOR EACH ROW
BEGIN
IF exists(SELECT * FROM reservation WHERE res_tr_id=OLD.tr_id)
THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='This trip already has reservations therefore updates are restricted!';
END IF;
END$
DELIMITER ;

/*trigger 3.1.4.3*/
DROP TRIGGER IF EXISTS check_salary;
DELIMITER $
CREATE TRIGGER check_salary BEFORE UPDATE ON worker
FOR EACH ROW
BEGIN
IF OLD.wrk_salary>=NEW.wrk_salary
THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='The new salary must be greater than the older!';
END IF;
END$
DELIMITER ;

/*trigger 3.1.4.2*/
DROP TRIGGER IF EXISTS check_reservations;
DELIMITER $
CREATE TRIGGER check_reservations BEFORE UPDATE ON trip
FOR EACH ROW
BEGIN
IF exists(SELECT * FROM reservation WHERE res_tr_id=OLD.tr_id)
THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='This trip already has reservations therefore updates are restricted!';
END IF;
END$
DELIMITER ;

/*trigger 3.1.4.3*/
DROP TRIGGER IF EXISTS check_salary;
DELIMITER $
CREATE TRIGGER check_salary BEFORE UPDATE ON worker
FOR EACH ROW
BEGIN
IF OLD.wrk_salary>=NEW.wrk_salary
THEN
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT='The new salary must be greater than the older!';
END IF;
END$
DELIMITER ;