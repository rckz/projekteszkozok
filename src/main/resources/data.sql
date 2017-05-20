INSERT INTO MUser (ID,DATE_CREATED,IS_DELETED,ADDRESS,EMAIL,NAME,PASSWORD) values(1,'2017-05-20',0,'1145 Budapest, József Attila u. 29','prezentalas@gmail.com','Prezentáló','prezentalo');
INSERT INTO MUser (ID,DATE_CREATED,IS_DELETED,ADDRESS,EMAIL,NAME,PASSWORD) values(2,'2017-05-20',0,'újpestanegyedem','krisztian.harkai@guyswithmediumdicks.com','Harkai Krisztián','ilovedicks');
INSERT INTO MUser (ID,DATE_CREATED,IS_DELETED,ADDRESS,EMAIL,NAME,PASSWORD) values(3,'2017-05-20',0,'noideabutshouldbepsychward','fodorlaci@guyswithsmalldicks.com','Fodor László','ilovetakingitintheass');
INSERT INTO MUser (ID,DATE_CREATED,IS_DELETED,ADDRESS,EMAIL,NAME,PASSWORD) values(4,'2017-05-20',0,'angyalföld','sando@guyswithsmalldicks.com','Andó Sándor','rumlibátya');

INSERT INTO SURPRISE (ID,DATE_CREATED,IS_DELETED,COLOR,CONSISTENCY,IMAGE_URL,PRICE,PRODUCT_NAME) values(1,'2017-05-20',0,'sárga',0,'',1337,'melegsósfos');
INSERT INTO SURPRISE (ID,DATE_CREATED,IS_DELETED,COLOR,CONSISTENCY,IMAGE_URL,PRICE,PRODUCT_NAME) values(2,'2017-05-20',0,'barna',1,'',3600,'Ünnepi előmelegített vacsora szivárvány színű unikornisokkal');
INSERT INTO SURPRISE (ID,DATE_CREATED,IS_DELETED,COLOR,CONSISTENCY,IMAGE_URL,PRICE,PRODUCT_NAME) values(3,'2017-05-20',0,'fekete',1,'',7200,'Party szemüveg héliumos állatfigurás lufikkal');
INSERT INTO SURPRISE (ID,DATE_CREATED,IS_DELETED,COLOR,CONSISTENCY,IMAGE_URL,PRICE,PRODUCT_NAME) values(4,'2017-05-20',0,'piros',1,'',5400,'Ajándék kristálypoharak');
INSERT INTO SURPRISE (ID,DATE_CREATED,IS_DELETED,COLOR,CONSISTENCY,IMAGE_URL,PRICE,PRODUCT_NAME) values(5,'2017-05-20',0,'zöld',1,'',70000,'Teljes meglepetésbuli szervezés');

INSERT INTO MORDER (ID,DATE_CREATED,IS_DELETED,ADDRESS,DESCRIPTION,CUSTOMER_ID,SURPRISE_ID) values(1,'2017-05-20',0,'1074 Budapest, Dohány u. 2','szeretettel',2,2);
INSERT INTO MUSER_ORDERS (MUSER_ID,ORDERS_ID) VALUES (1,1);