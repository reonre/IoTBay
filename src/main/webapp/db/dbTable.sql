CREATE TABLE "CUSTOMER" (
    CUST_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 10000, INCREMENT BY 1),
    "NAME" VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    PHONE VARCHAR(255) NOT NULL,
    GENDER VARCHAR(255) NOT NULL,
    DOB VARCHAR(255) NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL,
    PRIMARY KEY(CUST_ID)
);

CREATE TABLE "STAFF" (
    STAFF_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 20000, INCREMENT BY 1),
    "NAME" VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULL,
    GENDER VARCHAR(255) NOT NULL,
    PHONE VARCHAR(255) NOT NULL,
    DOB VARCHAR(255) NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL,
    "ROLE" VARCHAR(255) NOT NULL,
    PRIMARY KEY(STAFF_ID)
);

CREATE TABLE "ACCESS_LOG" (
    DATE VARCHAR(255) NOT NULL,
    USER_ID INTEGER NOT NULL
);

CREATE TABLE "PRODUCT" (
    PROD_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    PRODUCT_NAME VARCHAR(255) NOT NULL,
    PRODUCT_PRICE DOUBLE NOT NULL,
    PRODUCT_DESC VARCHAR(255) NOT NULL,
    PRODUCT_TYPE VARCHAR(255) NOT NULL,
    PRODUCT_QUANT INTEGER NOT NULL,
    PRIMARY KEY(PROD_ID)
);

CREATE TABLE "ORDER" (
    ORDER_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    CUST_ID INTEGER NOT NULL,
    DATE_ORDER_PLACED VARCHAR(255) NOT NULL,
    ORDER_DETAILS VARCHAR(255) NOT NULL,
    ORDERER_NAME VARCHAR(255) NOT NULL,
    ADDRESS VARCHAR(255) NOT NULL,
    PRIMARY KEY(ORDER_ID),
    CONSTRAINT ORDER_FK FOREIGN KEY (CUST_ID) REFERENCES CUSTOMER(CUST_ID)
);

CREATE TABLE "ORDER_LINE" (
    ORDER_LINE_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    PROD_ID INTEGER NOT NULL,
    ORDER_ID INTEGER NOT NULL,
    ORDER_LINE_PRICE DOUBLE NOT NULL,
    ORDER_LINE_QUANT INTEGER NOT NULL,
    PRIMARY KEY(ORDER_LINE_ID),
    CONSTRAINT ORDER_LINE_FK FOREIGN KEY (PROD_ID) REFERENCES PRODUCT(PROD_ID),
    CONSTRAINT ORDER_LINE_FK2 FOREIGN KEY (ORDER_ID) REFERENCES "ORDER"(ORDER_ID)
);

CREATE TABLE "INVOICE" (
    INVOICE_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    ORDER_ID INTEGER NOT NULL,
    ORDER_LINE_ID INTEGER NOT NULL,
    INVOICE_DATE VARCHAR(255) NOT NULL,
    INVOICE_DETAILS VARCHAR(255) NOT NULL,
    PRIMARY KEY(INVOICE_ID),
    CONSTRAINT INVOICE_FK FOREIGN KEY (ORDER_LINE_ID) REFERENCES ORDER_LINE(ORDER_LINE_ID),
    CONSTRAINT INVOICE_FK2 FOREIGN KEY (ORDER_ID) REFERENCES "ORDER"(ORDER_ID)
);

CREATE TABLE "PAYMENT" (
    PAY_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    INVOICE_ID INTEGER NOT NULL,
    PAYMENT_METHOD VARCHAR(255) NOT NULL,
    CREDIT_CARD_NO VARCHAR(255) NOT NULL,
    EXPIRY_DATE VARCHAR(255) NOT NULL,
    SECURITY_NO VARCHAR(255) NOT NULL,
    OWNER_NAME VARCHAR(255) NOT NULL,
    DATE_PAID VARCHAR(255) NOT NULL,
    PRIMARY KEY(PAY_ID),
    CONSTRAINT PAYMENT_FK FOREIGN KEY (INVOICE_ID) REFERENCES INVOICE(INVOICE_ID)
);

CREATE TABLE "SHIPMENT" (
    SHIP_ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100, INCREMENT BY 1),
    INVOICE_ID INTEGER NOT NULL,
    ORDER_ID INTEGER NOT NULL,
    SHIPMENT_TRACKING_NO VARCHAR(255) NOT NULL,
    SHIPMENT_DATE VARCHAR(255) NOT NULL,
    SHIPMENT_DETAILS VARCHAR(255) NOT NULL,
    PRIMARY KEY(SHIP_ID),
    CONSTRAINT SHIPMENT_FK FOREIGN KEY (ORDER_ID) REFERENCES "ORDER"(ORDER_ID),
    CONSTRAINT SHIPMENT_FK2 FOREIGN KEY (INVOICE_ID) REFERENCES INVOICE(INVOICE_ID)
);