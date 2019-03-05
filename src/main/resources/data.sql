-- Drop tables is exist
DROP TABLE BREWERY IF EXISTS;
DROP TABLE BEER IF EXISTS;

-- Create tables and set up constraints
CREATE TABLE BREWERY (
BREWERY_ID SMALLINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
BREWERY_NAME VARCHAR(175));

CREATE TABLE BEER (
BEER_ID SMALLINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
BEER_NAME VARCHAR(60) NOT NULL,
STYLE VARCHAR(25) NOT NULL,
VOLUME SMALLINT NOT NULL,
QUANTITY SMALLINT NOT NULL,
BOTTLE_DATE DATE NOT NULL,
LOCATION VARCHAR(25) NOT NULL,
BREWERY_ID SMALLINT NOT NULL
);

ALTER TABLE BEER ADD FOREIGN KEY (BREWERY_ID) REFERENCES BREWERY(BREWERY_ID);

-- Insert test Data
-- INSERT INTO BREWERY
INSERT INTO BREWERY VALUES (1, 'TEST');
INSERT INTO BREWERY VALUES (2, 'TEST2');
INSERT INTO BREWERY VALUES (3, 'TEST3');
INSERT INTO BREWERY VALUES (4, 'TEST4');

-- INSERT INTO BEER
INSERT INTO BEER VALUES (1, 'TESTNAME', 'IPA', 12, 1, '2016-08-04', 'TEST_LOC', 1);
INSERT INTO BEER VALUES (2, 'TESTNAME2', 'STOUT', 12, 2, '2016-08-04', 'TEST_LOC', 2);
INSERT INTO BEER VALUES (3, 'TESTNAME', 'IPA', 12, 4, '2016-08-04', 'TEST_LOC', 3);
INSERT INTO BEER VALUES (4, 'TESTNAME2', 'STOUT', 12, 3, '2016-08-04', 'TEST_LOC', 4);