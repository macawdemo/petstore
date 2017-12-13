use usersmysql;
DROP DATABASE IF EXISTS usersmysql;
CREATE DATABASE IF NOT EXISTS usersmysql;

DROP TABLE IF EXISTS ACCOUNT;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS BANNERDATA;
DROP TABLE IF EXISTS CREDENTIALS;
DROP TABLE IF EXISTS PROFILE;
DROP TABLE IF EXISTS bannerdata;
DROP TABLE IF EXISTS profile;
DROP TABLE IF EXISTS credentials;


USE usersmysql;

create table CREDENTIALS (
    username varchar(25) not null,
    password varchar(25)  not null,
  primary key (username)
)  ENGINE = InnoDB;

create table ACCOUNT (
    userid varchar(80) not null,
    email varchar(80) not null,
    firstname varchar(80) not null,
    lastname varchar(80) not null,
    status varchar(2)  null,
    addr1 varchar(80) not null,
    addr2 varchar(40) null,
    city varchar(80) not  null,
    state varchar(80) not null,
    zip varchar(20) not null,
    country varchar(20) not null,
    phone varchar(80) not null,
   primary key (userid)
)  ENGINE = InnoDB;

create table PROFILE (
    userid varchar(80) not null,
    langpref varchar(80) not null,
    favcategory varchar(30),
    mylistopt bool,
    banneropt bool,
  primary key (userid)
)  ENGINE = InnoDB;

create table BANNERDATA (
    favcategory varchar(80) not null,
    bannername varchar(255)  null,
     primary key (favcategory)
)  ENGINE = InnoDB;



