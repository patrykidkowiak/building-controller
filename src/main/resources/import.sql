INSERT INTO APPLICATION_USER(ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD,ACTIVATED) VALUES (1, 'admin@buildingcontroller.com', 'witam', 'witam', '$2a$12$iTpt3e8xH5.xDi0SYPaFxOYQmaMR4dn5WOYMUa6aaXzt6KL4CeI7q',true);
INSERT INTO APPLICATION_USER(ID, EMAIL, FIRST_NAME, LAST_NAME, PASSWORD,ACTIVATED) VALUES (2, 'pat.idk@gmail.com', 'Pat', 'Idk', '$2a$12$iTpt3e8xH5.xDi0SYPaFxOYQmaMR4dn5WOYMUa6aaXzt6KL4CeI7q',true);

INSERT INTO HOME(ID,HOME_NAME,USER_ID) VALUES(1,'dom 1',1);
INSERT INTO HOME(ID,HOME_NAME,USER_ID) VALUES(4,'dom 2',1);
INSERT INTO HOME(ID,HOME_NAME,USER_ID) VALUES(5,'dom 3',1);
INSERT INTO HOME(ID,HOME_NAME,USER_ID) VALUES(6,'dom 6',1);
INSERT INTO HOME(ID,HOME_NAME,USER_ID) VALUES(2,'dom 4',2);
INSERT INTO HOME(ID,HOME_NAME,USER_ID) VALUES(3,'dom 5',2);

INSERT INTO ROOM(ID,NAME,HOME_ID) VALUES (1,'LAZIENKA',1);
INSERT INTO ROOM(ID,NAME,HOME_ID) VALUES (2,'SYPIALNIA',1);

INSERT INTO ROOM(ID,NAME,HOME_ID) VALUES (3,'KORYTARZ',2);
INSERT INTO ROOM(ID,NAME,HOME_ID) VALUES (4,'SALON',2);


INSERT INTO BULB(ID,BULB_NAME,ROOM_ID,AUTO_MODE_ACTIVE,AUTO_TIME_OFFM,AUTO_TIME_OFFH,AUTO_TIME_ONH,AUTO_TIME_ONM,OFF_AT_DAY,ON_AT_NIGHT,ON_OFF,SILENT_INTENSITY,SILENT_MODE_ACTIVE,SILENT_TIME_OFFH,SILENT_TIME_OFFM,SILENT_TIME_ONH,SILENT_TIME_ONM) VALUES(1,'PRZY WEJŚCIU',1,false,12,0,13,0,false,false,false,3,false,12,0,13,0);
INSERT INTO BULB(ID,BULB_NAME,ROOM_ID,AUTO_MODE_ACTIVE,AUTO_TIME_OFFM,AUTO_TIME_OFFH,AUTO_TIME_ONH,AUTO_TIME_ONM,OFF_AT_DAY,ON_AT_NIGHT,ON_OFF,SILENT_INTENSITY,SILENT_MODE_ACTIVE,SILENT_TIME_OFFH,SILENT_TIME_OFFM,SILENT_TIME_ONH,SILENT_TIME_ONM) VALUES(2,'PRZY WYJSCIU',1,false,12,0,13,0,false,false,false,3,false,12,0,13,0);
INSERT INTO BULB(ID,BULB_NAME,ROOM_ID,AUTO_MODE_ACTIVE,AUTO_TIME_OFFM,AUTO_TIME_OFFH,AUTO_TIME_ONH,AUTO_TIME_ONM,OFF_AT_DAY,ON_AT_NIGHT,ON_OFF,SILENT_INTENSITY,SILENT_MODE_ACTIVE,SILENT_TIME_OFFH,SILENT_TIME_OFFM,SILENT_TIME_ONH,SILENT_TIME_ONM) VALUES(3,'near exit',2,false,12,0,13,0,false,false,false,3,false,12,0,13,0);
INSERT INTO BULB(ID,BULB_NAME,ROOM_ID,AUTO_MODE_ACTIVE,AUTO_TIME_OFFM,AUTO_TIME_OFFH,AUTO_TIME_ONH,AUTO_TIME_ONM,OFF_AT_DAY,ON_AT_NIGHT,ON_OFF,SILENT_INTENSITY,SILENT_MODE_ACTIVE,SILENT_TIME_OFFH,SILENT_TIME_OFFM,SILENT_TIME_ONH,SILENT_TIME_ONM) VALUES(4,'near enter',2,false,12,0,13,0,false,false,false,3,false,12,0,13,0);

INSERT INTO BULB(ID,BULB_NAME,ROOM_ID,AUTO_MODE_ACTIVE,AUTO_TIME_OFFM,AUTO_TIME_OFFH,AUTO_TIME_ONH,AUTO_TIME_ONM,OFF_AT_DAY,ON_AT_NIGHT,ON_OFF,SILENT_INTENSITY,SILENT_MODE_ACTIVE,SILENT_TIME_OFFH,SILENT_TIME_OFFM,SILENT_TIME_ONH,SILENT_TIME_ONM) VALUES(5,'na środku',3,false,12,0,13,0,false,false,true,3,false,12,0,13,0);
INSERT INTO BULB(ID,BULB_NAME,ROOM_ID,AUTO_MODE_ACTIVE,AUTO_TIME_OFFM,AUTO_TIME_OFFH,AUTO_TIME_ONH,AUTO_TIME_ONM,OFF_AT_DAY,ON_AT_NIGHT,ON_OFF,SILENT_INTENSITY,SILENT_MODE_ACTIVE,SILENT_TIME_OFFH,SILENT_TIME_OFFM,SILENT_TIME_ONH,SILENT_TIME_ONM) VALUES(6,'po prawej',3,false,12,0,13,0,false,false,false,3,false,12,0,13,0);
INSERT INTO BULB(ID,BULB_NAME,ROOM_ID,AUTO_MODE_ACTIVE,AUTO_TIME_OFFM,AUTO_TIME_OFFH,AUTO_TIME_ONH,AUTO_TIME_ONM,OFF_AT_DAY,ON_AT_NIGHT,ON_OFF,SILENT_INTENSITY,SILENT_MODE_ACTIVE,SILENT_TIME_OFFH,SILENT_TIME_OFFM,SILENT_TIME_ONH,SILENT_TIME_ONM) VALUES(7,'po lewej',4,false,12,0,13,0,false,false,false,3,false,12,0,13,0);
INSERT INTO BULB(ID,BULB_NAME,ROOM_ID,AUTO_MODE_ACTIVE,AUTO_TIME_OFFM,AUTO_TIME_OFFH,AUTO_TIME_ONH,AUTO_TIME_ONM,OFF_AT_DAY,ON_AT_NIGHT,ON_OFF,SILENT_INTENSITY,SILENT_MODE_ACTIVE,SILENT_TIME_OFFH,SILENT_TIME_OFFM,SILENT_TIME_ONH,SILENT_TIME_ONM) VALUES(8,'przy oknie',4,false,12,0,13,0,false,false,false,3,false,12,0,13,0);
