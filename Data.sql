INSERT INTO users VALUES ('man001','tharu','12','Tharush','Male','456587','12312','tha@gmail.com','flower road','Manager');
INSERT INTO users VALUES ('man002','sam','1456','Samuel','Male','45454587','1232','sam@gmail.com','lake road, viana','Manager');
INSERT INTO users VALUES ('csf001','cal','455','Callison','Male','788787','455','cal@gmail.com','cross road, cansas','Counter Staff');
INSERT INTO users VALUES ('csf002','lisa','11','Lisa','Female','4454587','1231245','lisa@gmail.com','meu street, wales','Counter Staff');
INSERT INTO users VALUES ('doc001','mike','1','Michael','Male','456586','789895','mike@gmail.com','31/45 B, rio place','Doctor');
INSERT INTO users VALUES ('doc002','ron','2','Ron','Male','456587','1231465','ron@gmail.com','78 V, roland ','Doctor');
INSERT INTO users VALUES ('cus001','dan','78','Daniel','Male','456587','1145555','dan@gmail.com','york avenue, texas','Customer');
INSERT INTO users VALUES ('cus002','sara','12','Sera','Female','456587','1211','sara@gmail.com','fraser street, new york','Customer');


INSERT INTO appointments VALUES ('app001','cus001','doc002','2019-04-18','0','Peniciln','take 3 times a day','good service','550.00','TRUE');
INSERT INTO appointments VALUES ('app006','cus002','doc002','2019-05-17','0','Peniciln','take 3 times a day','good service','450.00','TRUE');
INSERT INTO appointments(app_id,cus_id,doc_id,app_date,duration_left) VALUES ('app007','cus001','doc001','2019-05-31','12');
INSERT INTO appointments(app_id,cus_id,doc_id,app_date,duration_left) VALUES ('app008','cus001','doc001','2019-06-01','13');
INSERT INTO appointments(app_id,cus_id,doc_id,app_date,duration_left) VALUES ('app009','cus002','doc001','2019-05-25','6');