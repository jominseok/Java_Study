CREATE DATABASE  IF NOT EXISTS `community`;
USE `community`;

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `me_id` varchar(13) NOT NULL,
  `me_ms_state` varchar(10) NOT NULL,
  `me_pw` varchar(255) NOT NULL,
  `me_email` varchar(30) NOT NULL,
  `me_authority` varchar(5) NOT NULL DEFAULT 'user',
  `me_state` varchar(5) DEFAULT NULL,
  `me_stop` datetime DEFAULT NULL,
  `me_fail` int NOT NULL DEFAULT '0',
  `me_cookie` varchar(255) DEFAULT 'null',
  `me_cookie_limit` date DEFAULT NULL,
  PRIMARY KEY (`me_id`),
  UNIQUE KEY `me_email` (`me_email`),
  KEY `FK_member_state_TO_member_1` (`me_ms_state`),
  CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (`me_ms_state`) REFERENCES `member_state` (`ms_state`)
);
