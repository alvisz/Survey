DROP DATABASE IF EXISTS survey;

CREATE DATABASE survey;

\c survey;

CREATE TABLE SECTORS(
                        SECTOR_ID INTEGER NOT NULL PRIMARY KEY,
                        CHILDREN INTEGER[],
                        NAME VARCHAR(64) NOT NULL
);

CREATE TABLE RESULTS(
                        RESULT_ID SERIAL PRIMARY KEY,
                        NAME VARCHAR(64) NOT NULL,
                        SECTORS INTEGER[5] NOT NULL,
                        AGREE_TERMS BOOLEAN NOT NULL
);

CREATE SEQUENCE hibernate_sequence START 1;

CREATE INDEX name_index ON RESULTS (NAME);