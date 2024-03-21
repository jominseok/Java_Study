CREATE DATABASE  IF NOT EXISTS `community` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `community`;

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
  `re_num` int NOT NULL AUTO_INCREMENT,
  `re_me_id` varchar(13) NOT NULL,
  `re_bo_num` int NOT NULL,
  `re_state` int NOT NULL,
  PRIMARY KEY (`re_num`)
);
