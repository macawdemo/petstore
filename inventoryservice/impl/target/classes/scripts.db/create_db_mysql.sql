use inventorymysql;
DROP DATABASE IF EXISTS inventorymysql;
CREATE DATABASE IF NOT EXISTS inventorymysql;

DROP TABLE IF EXISTS INVENTORY;
DROP TABLE IF EXISTS inventory;


USE inventorymysql;

create table inventory (
    itemid varchar(80) not null,
    quantity BIGINT not null,
    primary key (itemid)
)  ENGINE = InnoDB;

