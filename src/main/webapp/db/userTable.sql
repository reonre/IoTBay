CREATE TABLE "USER" (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 10000, INCREMENT BY 1),
    EMAIL VARCHAR(255) NOT NULL,
    "USERNAME" VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(255) NOT NULl,
    GENDER VARCHAR(255) NOT NULL,
    DOB VARCHAR(255) NOT NULl,
    PRIMARY KEY(ID)
);