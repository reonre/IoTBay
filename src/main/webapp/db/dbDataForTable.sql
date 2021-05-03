


-- The Invoice_ID and Order_ID need to completed before inserting these values.
INSERT INTO SHIPMENT(SHIPMENT_TRACKING_NO,SHIPMENT_DATE,SHIPMENT_DETAILS)
VALUES
('JFRBQP7QIMLH','01/01/2021 11:04:27','No of Items: 1 | Total Weight: 200g  | Box Size: Small'),
('4FKX5HQBQG2P','08/04/2021 04:31:47','No of Items: 5 | Total Weight: 1053g | Box Size: Large'),
('0OHNK76OWR7R','07/03/2021 17:50:32','No of Items: 1 | Total Weight: 358g  | Box Size: Small'),
('G7EGCD2OM5AP','14/02/2021 22:55:59','No of Items: 1 | Total Weight: 892g  | Box Size: Medium'),
('GAUXOQMY9C7R','03/04/2021 02:04:04','No of Items: 2 | Total Weight: 658g  | Box Size: Small'),
('F71KBIMV231K','03/04/2021 07:13:46','No of Items: 1 | Total Weight: 423g  | Box Size: Small'),
('ZRHD8NX5S1BV','19/01/2021 11:02:46','No of Items: 1 | Total Weight: 991g  | Box Size: Large'),
('H7CFI5BSUTA9','22/04/2021 14:24:37','No of Items: 3 | Total Weight: 450g  | Box Size: Medium'),
('XCGAOH5M0GJ6','22/04/2021 06:30:07','No of Items: 1 | Total Weight: 87g   | Box Size: Medium'),
('VO27LWVDE1PK','10/01/2021 23:51:18','No of Items: 2 | Total Weight: 2330g | Box Size: Small'),
('JWD5UMIHC4US','08/03/2021 22:01:11','No of Items: 4 | Total Weight: 2000g | Box Size: Large'),
('AEKF7FRMHJCR','18/01/2021 09:45:41','No of Items: 1 | Total Weight: 434g  | Box Size: Small'),
('L5U2CEOW937I','09/04/2021 18:41:26','No of Items: 1 | Total Weight: 876g  | Box Size: Large'),
('5TBFOKHDEDB5','11/04/2021 11:42:42','No of Items: 2 | Total Weight: 2132g | Box Size: Medium'),
('4VUEPHTB4X70','06/01/2021 21:04:51','No of Items: 1 | Total Weight: 765g  | Box Size: Small'),
('R071PKA7N5RQ','11/03/2021 05:36:06','No of Items: 1 | Total Weight: 2432g | Box Size: Medium'),
('129VV3IDKJWR','04/03/2021 20:42:26','No of Items: 1 | Total Weight: 6898g | Box Size: Large'),
('EK5CDCTHC38D','11/01/2021 02:50:11','No of Items: 1 | Total Weight: 634g  | Box Size: Small'),
('RTLU5BM9AMWK','06/04/2021 19:17:32','No of Items: 2 | Total Weight: 953g  | Box Size: Large'),
('53OIERPAA23P','22/02/2021 13:15:20','No of Items: 3 | Total Weight: 905g  | Box Size: Medium')

-- These names could be used for the CUSTOMER or STAFF
INSERT INTO PAYMENT(CREDIT_CARD_NO,EXPIRY_DATE,SECURITY_NO,OWNER_NAME)
VALUES
('4929173930006460','08/21','313','Gilberto Boyd'),
('4539739839449860','02/23','730','Mabel Osborne'),
('5292168973269617','06/22','894','Frankie Wong'),
('6011869167040429','07/22','828','Jenny Barton'),
('373543407522463','08/22','232','Bert Cross'),
('372670995228475','11/23','913','Jean Meyer'),
('6011685489117996','01/24','039','Amos Bryan'),
('5148885120269846','01/24','734','Archie Adkins'),
('4556171645221465','04/23','705','Craig Austin'),
('4539762109128519','08/24','489','Michael Steele'),
('4024007138918270','10/25','996','Pamela Ford'),
('6011296043284676','02/23','958','Beulah Curry'),
('5499926173256135','09/22','966','Percy Chambers'),
('5199004694447600','07/22','847','Daisy Baker'),
('5460429054649267','05/21','416','Kara Gibson'),
('6011551047373317','03/23','515','Micheal Colon'),
('342275735127842','04/24','810','Nichole Perez'),
('6011970342978788','05/22','865','Lela Jensen'),
('343247561690929','03/22','284','Nadine Moran'),
('349714273935797','07/23','602','Sheri Fletcher')

-- this would be the SQL statement that would insert data into the User table 
INSERT INTO "USER" (EMAIL, "NAME",PHONE, PASSWORD, GENDER, DOB, ADDRESS)
VALUES
('BOB@gmail.com', 'Gilberto Boyd', ' 123 213 212', 'Passworeed', 'male', '9/11/2021', '1 addel street'),
('mabel@gmail.com', 'Mabel Osborne', '451 342 212', 'Passwowerwrd', 'male','23/12/2000', '2 addel street'),
('fank@gmail.com', 'Frankie Wong', '324 213 212', 'P4%word', 'male', '19/1/1989', '3 addel street'),
('jenny@gmail.com', 'Jenny Barton', '1128 213 212', '366YH5%', 'male', '23/12/1898', '4 addel street'),
('JEANious@gmail.com', 'Jean Meyer', '882 213 212', 'u4655', 'female', '11/11/2011', '5 addel street'),
('Amos@gmail.com', 'Amos Bryan', '678 213 212', 'Pass44word', 'female', '14/11/1666', '6 batman street'),
('archie@gmail.com', 'Archie Adkins', '045 633 798', 'passwrdq2', 'male', '11/1/2001', '12 elm street'),
('007@gmail.com', 'Craig Austin', '070 323 441', 'yey22#', 'male', '6/11/1989', '34 junk stree' ),
('yea@gmail.com','Michael Steele',  '034 234 245', 'yesww34$$', 'female', '1/1/2000', '43 addell street'),
('alderf2@gmail.com', 'Pamela Ford',  '322 232 232', '32sd235$', 'female', '11/11/1999', '45 teamFortress Steet'),
('b322@gmail.com', 'Beulah Curry', '042 154 124', '580jfj', 'male', '3/11/2000', '45 garden street'),
('Percy34@gmail.com', 'Percy Chambers','053 224 123', '234dfjrn', 'male', '5/11/2000', '45 manwell street'),
('daisey@gmail.com', 'Daisy Baker', '023 444 225', 'yyed3#@22', 'female', '1/12/1990', '45 druid street'),
('kmn45$gmial.com', 'Kara Gibson', '325 233 443', 'rrwf234', 'male', '11/11/2000', '46 addrell street'),
('thiIshell@gmail.com', 'Micheal Colon', '233 252 512', 'ryyest$$#*6783', 'male', '11/11/2000', '67 patel street'),
('gmail@gmail.com', 'Kayra bson', '324 234 255', 'password123', 'male','11/11/2000', '4 book street'),
('yes@gmail.com', 'Micheal Colon', '055 133 123', 'pedc@2', 'male', '2/12/2000', '1 goodwell street'),
('nic@gmail.com', 'Nichole Perez', '022 322 222', 'peda5d', 'female','9/12/2000', '56 no street'),
('LELA@gmail.con', 'Lela Jensen', '022 234 234', 'peYuin3s', 'female', '11/11/2000', '34 boom street'),
('nadinenic@gmail.com', 'Nadine Moran', '033 322 222', 'pmin33', 'female', '11/12/2000', '23 nob street'),
('add@gmail.com', 'Sheri Fletcher', '055 322 222', 'peda32min', 'female', '11/11/1989', '12 nector street')