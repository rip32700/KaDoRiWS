CREATE TABLE `USER` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL,
  `EMAIL` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `BIRTHDAY` date NOT NULL,
  `FIRSTNAME` varchar(45) NOT NULL,
  `LASTNAME` varchar(45) NOT NULL,
  `ZIP` int(11) DEFAULT NULL,
  `CITY` varchar(45) DEFAULT NULL,
  `STREET` varchar(45) DEFAULT NULL,
  `STREET_NR` int(11) DEFAULT NULL,
  `ROLE` int(11) NOT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE GROUPS (
  `GROUP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CREATIONDATE` datetime NOT NULL,
  `GROUPNAME` varchar(45) NOT NULL,
  `GROUPDESCRIPTION` varchar(200),
  PRIMARY KEY (`GROUP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `GROUPMEMBER` (
  `GROUPMEMBER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` int(11) NOT NULL,
  `USER_ID` int(11) NOT NULL,
  PRIMARY KEY (`GROUPMEMBER_ID`),
  FOREIGN KEY (GROUP_ID) REFERENCES GROUPS(GROUP_ID),
  FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `FRIENDSHIP` (
  `FRIENDSHIP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER1_ID` int(11) NOT NULL,
  `USER2_ID` int(11) NOT NULL,
  PRIMARY KEY (`FRIENDSHIP_ID`),
  FOREIGN KEY (USER1_ID) REFERENCES USER(USER_ID),
  FOREIGN KEY (USER2_ID) REFERENCES USER(USER_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `POST` (
  `POST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CONTENT` varchar(200) NOT NULL,
  `CREATIONTIME` datetime NOT NULL,
  `ISPUBLIC` bool NOT NULL,
  `USER_ID` int(11) NOT NULL,
  `GROUP_ID` int(11),
  PRIMARY KEY (`POST_ID`),
  FOREIGN KEY (GROUP_ID) REFERENCES GROUPS(GROUP_ID),
  FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

commit;