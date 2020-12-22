# TODO: Table Client
DROP TABLE  IF EXISTS T_CLIENT;
CREATE TABLE T_CLIENT (
    P_ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    DOCUMENT INTEGER NOT NULL,
    PHONE INTEGER NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL
);
# TODO: Table Product
DROP TABLE  IF EXISTS T_PRODUCT;
CREATE TABLE T_PRODUCT (
    P_ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    DESCRIPTION VARCHAR(255) NOT NULL,
    VALUE INTEGER NOT NULL,
    QUANTITY INTEGER NOT NULL
);
# TODO: Table Transaction
DROP TABLE  IF EXISTS T_TRANSACTION;
CREATE TABLE T_TRANSACTION (
    P_ID INT AUTO_INCREMENT PRIMARY KEY,
    STATE_ORDER VARCHAR(255) NOT NULL,
    DATE_ORDER TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    P_ID_CLIENT INT NOT NULL,
    P_ID_SELLER INT NOT NULL,
    F_ID_TRANSACTION_PRODUCT INT NOT NULL,
    foreign key (F_ID_TRANSACTION_PRODUCT) references T_TRANSACTION_PRODUCT(P_ID)
);
# TODO: Table TransactionProduct
DROP TABLE  IF EXISTS T_TRANSACTION_PRODUCT;
CREATE TABLE T_TRANSACTION_PRODUCT (
    P_ID INT AUTO_INCREMENT PRIMARY KEY,
    VALUE INTEGER NOT NULL,
    P_ID_PRODUCT INT NOT NULL,
    QUANTITY INTEGER NOT NULL
);
# TODO: Table Seller
DROP TABLE  IF EXISTS T_SELLER;
CREATE TABLE T_SELLER (
    P_ID INT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    LAST_NAME VARCHAR(255) NOT NULL,
    DOCUMENT INTEGER NOT NULL,
    PHONE INTEGER NOT NULL
);
# TODO: Insert Data to T_CLIENT
insert into T_CLIENT(NAME, LAST_NAME, DOCUMENT, PHONE, ADDRESS) VALUES ('Roy', 'Briceno', 95863789, 1188889994, 'Av. Corriente 8965 11-C');
insert into T_CLIENT(NAME, LAST_NAME, DOCUMENT, PHONE, ADDRESS) VALUES ('Leo', 'Scalone', 95863788, 1188889993, 'Av. Corriente 8965 13-C');
insert into T_CLIENT(NAME, LAST_NAME, DOCUMENT, PHONE, ADDRESS) VALUES ('Horas', 'Davis', 95863787, 1188889992, 'Av. Corriente 8965 12-C');
insert into T_CLIENT(NAME, LAST_NAME, DOCUMENT, PHONE, ADDRESS) VALUES ('Maria', 'Smith', 95863786, 1188889991, 'Av. Corriente 8965 14-C');
# TODO: Insert Data to T_SELLER
insert into T_SELLER(NAME, LAST_NAME, DOCUMENT, PHONE) VALUES ();
# TODO: Insert Data to T_PRODUCT
insert into T_PRODUCT(NAME, DESCRIPTION, VALUE, QUANTITY) VALUES ();
# TODO: Insert Data to T_TRANSACTION
insert into T_TRANSACTION(P_ID, STATE_ORDER, DATE_ORDER, P_ID_CLIENT, P_ID_SELLER, F_ID_TRANSACTION_PRODUCT) VALUES ();
# TODO: Insert Data to T_TRANSACTION_PRODUCT
insert into T_TRANSACTION_PRODUCT(P_ID, VALUE, P_ID_PRODUCT, QUANTITY) VALUES ();
