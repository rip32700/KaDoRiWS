INSERT INTO `KaDoRi`.`USER`
(`USER_ID`,
`USERNAME`,
`EMAIL`,
`PASSWORD`,
`BIRTHDAY`,
`FIRSTNAME`,
`LASTNAME`,
`ZIP`,
`CITY`,
`STREET`,
`STREET_NR`,
`ROLE`)
VALUES
(1, 'rip32700', 'rip@test.de', 'test123', 
 '1999-01-01', 'max', 'mustermann', 99999, 
 'Musterstadt', 'Musterstrasse', 8, 1);
 
 INSERT INTO `KaDoRi`.`USER`
(`USER_ID`,
`USERNAME`,
`EMAIL`,
`PASSWORD`,
`BIRTHDAY`,
`FIRSTNAME`,
`LASTNAME`,
`ZIP`,
`CITY`,
`STREET`,
`STREET_NR`,
`ROLE`)
VALUES
(2, 'kaa3333', 'kaaa@test.de', '123test', 
 '1999-01-01', 'max', 'mustermann', 99999, 
 'Musterstadt', 'Musterstrasse', 8, 0);
 
  INSERT INTO `KaDoRi`.`USER`
(`USER_ID`,
`USERNAME`,
`EMAIL`,
`PASSWORD`,
`BIRTHDAY`,
`FIRSTNAME`,
`LASTNAME`,
`ZIP`,
`CITY`,
`STREET`,
`STREET_NR`,
`ROLE`)
VALUES
(3, 'ADMIN', 'ADMIN@ADMIN.DE', 'admin', 
 '1999-01-01', 'admin', 'admin', 99999, 
 'ADMIN', 'ADMIN', 8, 0);
 
INSERT INTO `KaDoRi`.`USER`
(`USER_ID`,
`USERNAME`,
`EMAIL`,
`PASSWORD`,
`BIRTHDAY`,
`FIRSTNAME`,
`LASTNAME`,
`ZIP`,
`CITY`,
`STREET`,
`STREET_NR`,
`ROLE`)
VALUES
(0, 'anonymousUser', 'anonymousUser@ADManonymousUser.de', '98212345671aQeryAsd', 
 '1999-01-01', 'anonymous', 'anonymous', 99999, 
 'anonymous', 'anonymous', 8, 1);
 
 
 -- Neue Daten für Freunde + Gruppen:
 
 INSERT INTO `friendship`
 (`FRIENDSHIP_ID`,
 `USER1_ID`,
 `USER2_ID`)
 VALUES
 (1, 1, 2);
 
  INSERT INTO `friendship`
 (`FRIENDSHIP_ID`,
 `USER1_ID`,
 `USER2_ID`)
 VALUES
 (2, 3, 2);
 
 Insert into `groups`
 (`GROUP_ID`,
 `CREATIONDATE`,
 `GROUPNAME`,
 `GROUPDESCRIPTION`
 )
 values
 (1, '1990-09-09 00:00:01.000000',  'Test-Group', 'This group is just for testing');
 
  Insert into `groups`
 (`GROUP_ID`,
 `CREATIONDATE`,
 `GROUPNAME`,
 `GROUPDESCRIPTION`
 )
 values
 (2, '1990-09-09 00:00:01.000000',  'Another-Test-Group', 'This group also is just for testing');
 
 insert into `groupmember`
 (`GROUPMEMBER_ID`,
 `GROUP_ID`,
 `USER_ID`
 )
 values
 (1, 1, 1);
 
  insert into `groupmember`
 (`GROUPMEMBER_ID`,
 `GROUP_ID`,
 `USER_ID`
 )
 values
 (3, 2, 2);

insert into `groupmember`
 (`GROUPMEMBER_ID`,
 `GROUP_ID`,
 `USER_ID`
 )
 values
 (2, 1, 2);
 

commit;