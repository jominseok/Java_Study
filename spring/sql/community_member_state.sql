CREATE DATABASE  IF NOT EXISTS `community` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `community`;
DROP TABLE IF EXISTS `member_state`;
CREATE TABLE `member_state` (
  `ms_state` varchar(10) NOT NULL,
  PRIMARY KEY (`ms_state`)
);
