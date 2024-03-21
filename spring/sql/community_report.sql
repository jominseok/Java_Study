CREATE DATABASE  IF NOT EXISTS `community` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `community`;

DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `re_num` int NOT NULL AUTO_INCREMENT,
  `re_rt_name` varchar(15) NOT NULL,
  `re_me_id` varchar(13) NOT NULL,
  `re_table` varchar(10) NOT NULL,
  `re_content` text NOT NULL,
  `re_state` varchar(5) NOT NULL DEFAULT '신고접수',
  `re_target` int NOT NULL,
  PRIMARY KEY (`re_num`),
  KEY `FK_report_type_TO_report_1` (`re_rt_name`),
  KEY `FK_member_TO_report_1` (`re_me_id`),
  CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (`re_me_id`) REFERENCES `member` (`me_id`),
  CONSTRAINT `FK_report_type_TO_report_1` FOREIGN KEY (`re_rt_name`) REFERENCES `report_type` (`rt_name`)
);

