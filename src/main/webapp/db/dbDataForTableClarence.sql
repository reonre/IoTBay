-- The Invoice_ID and Order_ID need to completed before inserting these values.
-- INSERT INTO SHIPMENT(SHIPMENT_TRACKING_NO,SHIPMENT_DATE,SHIPMENT_DETAILS)
-- VALUES
-- ('JFRBQP7QIMLH','01/01/2021 11:04:27','No of Items: 1 | Total Weight: 200g  | Box Size: Small'),
-- ('4FKX5HQBQG2P','08/04/2021 04:31:47','No of Items: 5 | Total Weight: 1053g | Box Size: Large'),
-- ('0OHNK76OWR7R','07/03/2021 17:50:32','No of Items: 1 | Total Weight: 358g  | Box Size: Small'),
-- ('G7EGCD2OM5AP','14/02/2021 22:55:59','No of Items: 1 | Total Weight: 892g  | Box Size: Medium'),
-- ('GAUXOQMY9C7R','03/04/2021 02:04:04','No of Items: 2 | Total Weight: 658g  | Box Size: Small'),
-- ('F71KBIMV231K','03/04/2021 07:13:46','No of Items: 1 | Total Weight: 423g  | Box Size: Small'),
-- ('ZRHD8NX5S1BV','19/01/2021 11:02:46','No of Items: 1 | Total Weight: 991g  | Box Size: Large'),
-- ('H7CFI5BSUTA9','22/04/2021 14:24:37','No of Items: 3 | Total Weight: 450g  | Box Size: Medium'),
-- ('XCGAOH5M0GJ6','22/04/2021 06:30:07','No of Items: 1 | Total Weight: 87g   | Box Size: Medium'),
-- ('VO27LWVDE1PK','10/01/2021 23:51:18','No of Items: 2 | Total Weight: 2330g | Box Size: Small'),
-- ('JWD5UMIHC4US','08/03/2021 22:01:11','No of Items: 4 | Total Weight: 2000g | Box Size: Large'),
-- ('AEKF7FRMHJCR','18/01/2021 09:45:41','No of Items: 1 | Total Weight: 434g  | Box Size: Small'),
-- ('L5U2CEOW937I','09/04/2021 18:41:26','No of Items: 1 | Total Weight: 876g  | Box Size: Large'),
-- ('5TBFOKHDEDB5','11/04/2021 11:42:42','No of Items: 2 | Total Weight: 2132g | Box Size: Medium'),
-- ('4VUEPHTB4X70','06/01/2021 21:04:51','No of Items: 1 | Total Weight: 765g  | Box Size: Small'),
-- ('R071PKA7N5RQ','11/03/2021 05:36:06','No of Items: 1 | Total Weight: 2432g | Box Size: Medium'),
-- ('129VV3IDKJWR','04/03/2021 20:42:26','No of Items: 1 | Total Weight: 6898g | Box Size: Large'),
-- ('EK5CDCTHC38D','11/01/2021 02:50:11','No of Items: 1 | Total Weight: 634g  | Box Size: Small'),
-- ('RTLU5BM9AMWK','06/04/2021 19:17:32','No of Items: 2 | Total Weight: 953g  | Box Size: Large'),
-- ('53OIERPAA23P','22/02/2021 13:15:20','No of Items: 3 | Total Weight: 905g  | Box Size: Medium');

-- These names could be used for the CUSTOMER or STAFF
-- INSERT INTO PAYMENT(CREDIT_CARD_NO,EXPIRY_DATE,SECURITY_NO,OWNER_NAME)
-- VALUES
-- ('4929173930006460','08/21','313','Gilberto Boyd'),
-- ('4539739839449860','02/23','730','Mabel Osborne'),
-- ('5292168973269617','06/22','894','Frankie Wong'),
-- ('6011869167040429','07/22','828','Jenny Barton'),
-- ('373543407522463','08/22','232','Bert Cross'),
-- ('372670995228475','11/23','913','Jean Meyer'),
-- ('6011685489117996','01/24','039','Amos Bryan'),
-- ('5148885120269846','01/24','734','Archie Adkins'),
-- ('4556171645221465','04/23','705','Craig Austin'),
-- ('4539762109128519','08/24','489','Michael Steele'),
-- ('4024007138918270','10/25','996','Pamela Ford'),
-- ('6011296043284676','02/23','958','Beulah Curry'),
-- ('5499926173256135','09/22','966','Percy Chambers'),
-- ('5199004694447600','07/22','847','Daisy Baker'),
-- ('5460429054649267','05/21','416','Kara Gibson'),
-- ('6011551047373317','03/23','515','Micheal Colon'),
-- ('342275735127842','04/24','810','Nichole Perez'),
-- ('6011970342978788','05/22','865','Lela Jensen'),
-- ('343247561690929','03/22','284','Nadine Moran'),
-- ('349714273935797','07/23','602','Sheri Fletcher');

-- this would be the SQL statement that would insert data into the User table 
INSERT INTO "USER"(EMAIL, "NAME", PASSWORD, GENDER, PHONE, DOB, ADDRESS, "ROLE", ACTIVATED)
VALUES
('customer@gmail.com', 'customer', 'password',  'male', '12345','9/11/2010', '1 Customer St', 'S', true),
('BOB@gmail.com', 'Gilberto Boyd', 'Passworeed',  'male', '12345','9/11/2021', '1 addel street', 'S', true),
('mabel@gmail.com', 'Mabel Osborne',  'Passwowerwrd', 'male', '12345','23/12/2000', '2 addel street', 'S', true),
('fank@gmail.com', 'Frankie Wong', 'P4%word', 'male', '12345', '19/1/1989', '3 addel street', 'S', true),
('jenny@gmail.com', 'Jenny Barton', '366YH5%', 'male', '12345', '23/12/1898', '4 addel street', 'S', true),
('JEANious@gmail.com', 'Jean Meyer', 'u4655', 'female', '12345', '11/11/2011', '5 addel street', 'S', true),
('Amos@gmail.com', 'Amos Bryan', 'Pass44word', 'female', '12345', '14/11/1666', '6 batman street', 'S', true),
('archie@gmail.com', 'Archie Adkins', 'passwrdq2', 'male', '12345', '11/1/2001', '12 elm street', 'S', true),
('007@gmail.com', 'Craig Austin', 'yey22#', 'male', '12345', '6/11/1989', '34 junk stree' , 'S', true),
('yea@gmail.com','Michael Steele', 'yesww34$$', 'female', '12345', '1/1/2000', '43 addell street', 'S', true),
('alderf2@gmail.com', 'Pamela Ford', '32sd235$', 'female', '12345', '11/11/1999', '45 teamFortress Steet', 'S', true),
('b322@gmail.com', 'Beulah Curry', '580jfj', 'male', '12345', '3/11/2000', '45 garden street', 'S', true),
('Percy34@gmail.com', 'Percy Chambers', '234dfjrn', 'male', '12345', '5/11/2000', '45 manwell street', 'C', true),
('daisey@gmail.com', 'Daisy Baker', 'yyed3#@22', 'female', '12345', '1/12/1990', '45 druid street', 'C', true),
('kmn45$gmial.com', 'Kara Gibson', 'rrwf234', 'male', '12345', '11/11/2000', '46 addrell street', 'C', true),
('thiIshell@gmail.com', 'Micheal Colon', 'ryyest$$#*6783', 'male', '12345', '11/11/2000', '67 patel street', 'C', true),
('gmail@gmail.com', 'Kayra bson',  'password123', 'male','12345', '11/11/2000', '4 book street', 'C', true),
('yes@gmail.com', 'Micheal Colon', 'pedc@2', 'male', '12345', '2/12/2000', '1 goodwell street', 'C', true),
('nic@gmail.com', 'Nichole Perez', 'peda5d', 'female','12345', '9/12/2000', '56 no street', 'C', true),
('LELA@gmail.con', 'Lela Jensen',  'peYuin3s', 'female', '12345', '11/11/2000', '34 boom street', 'C', true),
('nadinenic@gmail.com', 'Nadine Moran',  'pmin33', 'female', '12345', '11/12/2000', '23 nob street', 'C', true),
('add@gmail.com', 'Sheri Fletcher','peda32min', 'female', '12345', '11/11/1989', '12 nector street', 'C', true);

INSERT INTO "STAFF"(ID, "POSITION")
VALUES
(10000, 'Pedo');


-- INSERT 20 instances into PRODUCT table
INSERT INTO PRODUCT(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_DESC, PRODUCT_TYPE, PRODUCT_QUANT)
VALUES
('Google Home',50.14,'Google Home, the connected voice controller from Google. Besides controlling your home it also comes with Google Assistant, helping with lists, translation, news, music, calendar and many many more.','Home Appliances',56),
('Amazon Echo Voice Controller',79.99,'Amazon Echo, the connected voice controller from Amazon, can give you information, music, news, weather, add things to todo lists, wake you up and, of course, control your home.','Home Appliances',67),
('Smart Coffee Maker',329.98,'Mr. Coffee 10-Cup Smart Optimal Brew Coffeemaker makes it easy to schedule, monitor, and modify your brew from anywhere.','Kitchen Appliances',21),
('Philips Hue Go',137.99,'With Hue Go the possibilities are endless. Connect light to your daily life and move it around the way you like it. Lift your gaming experience to the next level via third party apps.','Indoor Lighting',39),
('Bluetooth Tracking Sensor',19.98,'Linquet is the cloud powered tracking device you can attach to anything. Link them to the app and share their location with those interested so nothing gets left behind.','Home Security and Safetly',40),
('BB8 SE Droid with force band',30.00,'BB-8 is the loyal droid of Resistance pilot Poe Dameron. Control it with the force band or with your smart device and see it roll just like on screen. Immerse yourself in the Star Wars galaxy.','Information and Entertainment',8),
('Smart Thermostat',99.99,'The Nest Thermostat learns what temperature you like and builds a schedule around yours. Also, it will send you an alert when the temperatures are threatening to ruin your belongings and appliances.','Home Automation',11),
('Smart button controller',20.00,'POP Home Switch lets everyone in the home control smart lighting, music, and more with the push of a button. Program each switch with up to three custom commands to add creativity throughout your smart home.','Home Automation',40),
('Nest Outdoor Camera',90.99,'With one app for all your Nest products, the unique magnetic mount, full 1080p HD video streaming and advanced Night Vision, Nest Cam Outdoor enables you to take care of what matters 24/7.','Home Security and Safetly',33),
('Awair Smart Air Quality Monitor',110.00,'Awair is the first complete device to let you communicate with your air. Awair analyzes your indoor air quality, learns your routines and can communicate with other home devices to help you achieve optimal air quality.','Home Automation',12),
('Nest Protect Smoke and CO detector',60.00,'Nest Protect is the smoke alarm other alarms look up to. With an industrial-grade smoke sensor, automatic self testing, its the first home alarm you can hush from your phone without any extra hardware.','Home Security and Safetly',27),
('Navdy Smart navigation system',47.98,'Navdy combines a high quality projection display with voice and gesture controls to create a safer driving experience. Drivers no longer need to use their phone to navigate, communicate or control their music.','Automotive',41),
('Sync Smartband Activity Tracker',50.00,'Sync Smartband is the chic solution that appeals to families and adults as well, with a variety of health tracking functions, including a fitness tracker and sleep tracker, in addition to location tracking.','Health and Fitness',62),
('June Intelligent oven',219.99,'June is a modern oven prepared to fit in every kitchen in order to satisfy even the most exquisite tastes. It saves a lot of the time youd normally spend cooking when connected to your phone.','Kitchen Appliances',22),
('Nest Cam Indoor camera',44.99,'Nest Cam Outdoor is the monitoring tool youve been waiting for. It brings all the benefits of modern streaming technology and a sleek design so you can watch your home from anywhere.','Home Security and Safetly',55),
('Withings Blood Pressure Monitor',39.99,'Wireless Blood Pressure Monitor makes it easy to check your blood pressure & heart rate, anytime and anywhere with an instant feedback and access to all your readings.','Health and Fitness',19),
('Fitbit Surge Smart Watch',60.00,'Reach your peak performance with built-in GPS, continuous heart rate and all-day activity tracking and sleep monitoring. And stay connected with text & call notifications, music control and more.','Health and Fitness',34),
('August Smart lock',89.99,'Be always in control of your door no matter where you are, right from your smartphone. Lock and unlock as you please and enjoy the safety of your home.','Home Security and Safetly',7),
('Eero Home WiFi System',49.99,'eero is the worlds first home WiFi system. A set of three eeros covers the typical home. They work in perfect unison to deliver hyper-fast, super-stable WiFi to every square foot of your house.','Information and Entertainment',23),
('Edyn Garden sensor',39.99,'Garden sensor which keeps you connected to your garden. It tracks light, nutrition, moisture, humidity and temperature. It is Wi-Fi connected and it sends notifications to your phone.','Home Appliances',1);

-- INSERT 20 instances into ORDER table
INSERT INTO "ORDER"(ID, DATE_ORDER_PLACED, ORDER_DETAILS, ORDERER_NAME, ADDRESS)
VALUES
(10000,'27/04/2021 10:41:46','','Adam M Addis','84 Avondale Drive'),
(10000,'18/04/2021 09:44:03','','Adam M Addis','84 Avondale Drive'),
(10000,'11/03/2021 17:53:31','','Adam M Addis','84 Avondale Drive'),
(10000,'10/01/2021 16:23:37','','Adam M Addis','84 Avondale Drive'),
(10001,'16/03/2021 07:47:18','','Chloe T Mayo','45 Tennyson Road'),
(10001,'22/02/2021 15:13:54','','Chloe T Mayo','45 Tennyson Road'),
(10001,'26/04/2021 00:30:07','','Chloe T Mayo','45 Tennyson Road'),
(10002,'08/02/2021 01:07:23','','Bailey L Eden','85 Lapko Road'),
(10002,'10/04/2021 05:26:15','','Bailey L Eden','85 Lapko Road'),
(10002,'05/03/2021 22:46:11','','Bailey L Eden','85 Lapko Road'),
(10003,'13/02/2021 18:56:10','','Edward E Gall','94 Argyle Street'),
(10003,'17/03/2021 02:40:12','','Edward E Gall','94 Argyle Street'),
(10003,'14/03/2021 08:43:19','','Edward E Gall','94 Argyle Street'),
(10003,'13/01/2021 07:20:41','','Edward E Gall','94 Argyle Street'),
(10003,'24/02/2021 05:14:36','','Edward E Gall','94 Argyle Street'),
(10004,'17/04/2021 18:27:31','','Nate B Elizabeth','21 Mills Street'),
(10008,'13/01/2021 23:43:35','','Levi A Howitt','10 Bayview Road'),
(10008,'05/03/2021 15:38:34','','Levi A Howitt','10 Bayview Road'),
(10012,'09/04/2021 20:10:31','','Christian C Kay','56 Brentwood Drive'),
(10009,'10/02/2021 19:10:33','','Dominic A Were','3 Barker Street');

--INSERT 20 instances into ACCESS_LOG table
-- INSERT INTO ACCESS_LOG("DATE", USER_ID)
-- VALUES
-- ('02/03/2021', 1000),
-- ('02/03/2021', 1001),
-- ('02/03/2021', 1002),
-- ('02/03/2021', 1003),
-- ('02/03/2021', 1004),
-- ('02/03/2021', 1005),
-- ('04/03/2021', 1000),
-- ('04/03/2021', 1002),
-- ('04/03/2021', 1005),
-- ('04/04/2021', 1004),
-- ('04/04/2021', 1002),
-- ('04/04/2021', 1008),
-- ('04/04/2021', 1009),
-- ('28/04/2021', 1000),
-- ('28/04/2021', 1002),
-- ('28/04/2021', 1003),
-- ('28/04/2021', 1004),
-- ('28/04/2021', 1005),
-- ('28/04/2021', 1006),
-- ('28/04/2021', 1007);

--INSERT 20 ORDERS IN ORDERLINE 
INSERT INTO ORDER_LINE(PROD_ID,ORDER_ID,ORDER_LINE_PRICE,ORDER_LINE_QUANT)
VALUES
(100,101,50.14,1),
(100,110,100.28,2),
(101,119,79.99,1),
(101,106,799.9,10),
(100,109,50.14,1),
(100,105,50.14,1),
(113,102,219.99,1),
(115,104,39.99,1),
(118,108,49.99,1),
(101,110,799.9,10),
(100,118,50.14,1),
(103,112,137.99,1),
(113,105,219.99,1),
(115,107,39.99,1),
(117,111,89.99,1),
(113,112,219.99,1),
(113,116,219.99,1),
(115,103,39.99,1),
(104,112,19.98,1),
(109,101,110,1);


--INSERT 20 INVOICE SUBSTANCE CHANGE ORDERID TO THE SAME AS ORDERLINE
INSERT INTO INVOICE(ORDER_ID,ORDER_LINE_ID,INVOICE_DATE,INVOICE_DETAILS)
VALUES
(101,100,'28/04/2021',''),
(110,101,'28/04/2021',''),
(119,102,'29/04/2021',''),
(106,103,'29/04/2021',''),
(109,104,'29/04/2021',''),
(105,105,'30/04/2021',''),
(102,106,'30/04/2021',''),
(104,107,'30/04/2021',''),
(108,108,'02/05/2021',''),
(110,109,'02/05/2021',''),
(118,110,'02/05/2021',''),
(112,111,'02/05/2021',''),
(105,112,'04/05/2021',''),
(107,113,'04/05/2021',''),
(111,114,'06/05/2021',''),
(112,115,'07/05/2021',''),
(116,116,'07/05/2021',''),
(103,117,'07/05/2021',''),
(112,118,'09/05/2021',''),
(101,119,'12/05/2021','');