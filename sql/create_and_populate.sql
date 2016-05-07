CREATE TABLE `USER` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `BIRTHDAY` datetime NOT NULL,
  `FIRSTNAME` varchar(45) NOT NULL,
  `LASTNAME` varchar(45) NOT NULL,
  `ZIP` int(11) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `STREET` varchar(45) DEFAULT NULL,
  `STREET_NR` int(11) DEFAULT NULL,
  `ROLE` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

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
 1999-01-01, 'max', 'mustermann', 99999, 
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
 1999-01-01, 'max', 'mustermann', 99999, 
 'Musterstadt', 'Musterstrasse', 8, 0);

commit;