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

commit;