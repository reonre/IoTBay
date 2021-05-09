CREATE TABLE "USER" (
    "ID"            INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 10000, INCREMENT BY 1),
    "NAME"          VARCHAR(255) NOT NULL,
    EMAIL          VARCHAR(255) NOT NULL,
    PASSWORD        VARCHAR(255) NOT NULL,
    GENDER          VARCHAR(255) NOT NULL,
    DOB             VARCHAR(255) NOT NULL,
    ACCOUNT_TYPE    CHARACTER,
    IS_ACTIVE       BOOLEAN,                 -- Used for the cancelled account feature 
    PRIMARY KEY(ID)
);

CREATE TABLE "CUSTOMER" (
    CUST_ID     INTEGER PRIMARY KEY REFERENCES "USER"(ID) ON DELETE CASCADE,
    ADDRESS     VARCHAR(255) NOT NULL
);

CREATE TABLE "STAFF" (
    STAFF_ID    INTEGER PRIMARY KEY REFERENCES "USER"(ID) ON DELETE CASCADE,
    "ROLE"      VARCHAR(255) NOT NULL
);

CREATE TABLE "ADMIN" (
    USERNAME  VARCHAR(255) NOT NULL PRIMARY KEY,
    PASSWORD  VARCHAR(255) NOT NULL
);

-- Insert User
INSERT INTO "USER" ("NAME", EMAIL, PASSWORD, GENDER, DOB, ACCOUNT_TYPE, IS_ACTIVE)
VALUES
-- Customer
('customer sample','customer@gmail.com','password','male','03/12/1989','C',TRUE),
('Janet A. Grajeda','janet@gmail.com','password','female','05/03/1999','C',TRUE),
('Isabella H Brodribb','isabella@gmail.com','password','female','07/02/1996','C',TRUE),
('Makayla C Thompson','mak@gmail.com','password','female','20/04/2000','C',TRUE),
('Jade J Cheyne','jade@gmail.com','password','female','01/12/1996','C',TRUE),
('Brianna I Fisher','bri@gmail.com','password','female','15/11/1991','C',TRUE),
('Adam A Pomeroy','adam@gmail.com','password','male','11/08/1994','C',TRUE),
('Bailey H Wolff','bailey@gmail.com','password','male','09/09/1998','C',TRUE),
('Marcus R Church','marcus@gmail.com','password','male','08/12/1997','C',TRUE),
('Brianna J Grey-Smith','bri1@gmail.com','password','male','20/06/1992','C',TRUE),
-- Staff
('staff sample','staff@gmail.com','password','male','10/07/1993','S',TRUE),
('Jacob L Rix','jacob@gmail.com','password','male','23/07/1996','S',TRUE),
('Zane C Vaughan','zane@gmail.com','password','male','31/03/1990','S',TRUE),
('Rory E Coe','rory@gmail.com','password','male','25/08/1992','S',TRUE),
('Imogen Z Edith','imo@gmail.com','password','female','27/04/1990','S',TRUE),
('Logan A Booty','logan@gmail.com','password','male','10/11/1994','S',TRUE),
('Hugo R Trumble','hugo@gmail.com','password','male','01/02/1998','S',TRUE),
('Joel H Flood','joel@gmail.com','password','male','23/12/1999','S',TRUE),
('Koby K Hogarth','koby@gmail.com','password','male','02/04/1997','S',TRUE),
('Matthew A Argyle','matt@gmail.com','password','male','26/05/1998','S',TRUE);

-- Insert customer
INSERT INTO "CUSTOMER"(CUST_ID, ADDRESS)
VALUES
(10000, '70 Treasure Island Avenue'),
(10001, '71 Hart Street'),
(10002, '71 Queen Street'),
(10003, '14 Cecil Street'),
(10004, '95 Sunnyside Road'),
(10005, '56 Dabinett Road'),
(10006, '62 Sunset Drive'),
(10007, '31 Burke Street'),
(10008, '3 Kelly Street'),
(10009, '21 Yorkshire Circle');

-- Insert staff
INSERT INTO "STAFF"(STAFF_ID, "ROLE")
VALUES
(10010, 'Team Member'),
(10011, 'Team Member'),
(10012, 'Team Member'),
(10013, 'Team Member'),
(10014, 'Team Member'),
(10015, 'Team Member'),
(10016, 'Sales Person'),
(10017, 'Sales Person'),
(10018, 'Sales Person'),
(10019, 'Manager');

-- INSERT ADMIN
INSERT INTO "ADMIN"(USERNAME, PASSWORD) VALUES ('admin','admin');