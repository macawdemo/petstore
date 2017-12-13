CREATE DATABASE IF NOT EXISTS productmysql;
USE productmysql;


DROP TABLE IF EXISTS ITEM;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS SUPPLIER;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS supplier;
DROP TABLE IF EXISTS item;
DROP TABLE IF EXISTS product;

use productmysql;

create table SUPPLIER (
    supplierid int not null,
    name varchar(80) null,
    status varchar(2) not null,
    addr1 varchar(80) null,
    addr2 varchar(80) null,
    city varchar(80) null,
    state varchar(80) null,
    zip varchar(5) null,
    phone varchar(80) null,
    primary key(supplierid)
)  ENGINE = InnoDB;

create table CATEGORY (
    categoryid varchar(10) not null,
	name varchar(80) null,
	description varchar(255) null,
      primary key (categoryid)
)ENGINE = InnoDB;


create table PRODUCT(
    productid varchar(10) not null,
    category varchar(10) not null,
    name varchar(80) null,
    description varchar(255) null,
	primary key (productid)
    ) ENGINE = InnoDB;
    
create table ITEM (
    itemid varchar(10) not null,
    productid varchar(10) not null,
    listprice decimal(10,2) null,
    unitcost decimal(10,2) null,
    supplier int null,
    status varchar(2) null,
    attr1 varchar(80) null,
    attr2 varchar(80) null,
    attr3 varchar(80) null,
    attr4 varchar(80) null,
    attr5 varchar(80) null,
	primary key (itemid)
	) ENGINE = InnoDB;