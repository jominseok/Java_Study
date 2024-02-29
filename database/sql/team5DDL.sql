drop database if exists team5;

create database if not exists team5;

use team5;

DROP TABLE IF EXISTS `Member`;

CREATE TABLE `Member` (
	`mb_id`	varchar(13) primary key,
	`mb_pw`	varchar(20) not	NULL,
	`mb_nickname`	varchar(13) unique	not NULL,
	`mb_mail`	varchar(50) unique	not NULL,
	`mb_phone`	varchar(13) unique	not NULL,
	`mb_name`	varchar(10) not	NULL
);

DROP TABLE IF EXISTS `Category`;

CREATE TABLE `Category` (
	`c_num`	int auto_increment primary key,
	`c_name` varchar(20) unique not	NULL
);

DROP TABLE IF EXISTS `Board`;

CREATE TABLE `Board` (
	`b_num`	int auto_increment primary key,
	`b_name`	varchar(20) not	NULL,
	`b_c_num`	int
);

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
	`p_num`	int auto_increment primary key,
	`p_title`	varchar(20) not	NULL,
	`p_content`	text not NULL,
	`p_date`	date not NULL,
	`p_view`	int default 0,
	`p_mb_id`	varchar(13)	NOT NULL,
	`p_b_num`	int
);

DROP TABLE IF EXISTS `reply`;

CREATE TABLE `reply` (
	`r_num`	int auto_increment primary key,
	`r_content`	text not NULL,
	`r_date`	date not NULL,
	`r_mb_id`	varchar(13),
	`r_p_num`	int
);

DROP TABLE IF EXISTS `authority`;

CREATE TABLE `authority` (
	`a_name`	varchar(20) primary key,
	`a_list`	int default 0
);

DROP TABLE IF EXISTS `Log`;

CREATE TABLE `Log` (
	`l_num`	int auto_increment primary key,
	`l_content`	varchar(20) not	NULL,
	`l_date`	date not NULL,
	`l_mb_id`	varchar(13)
);

DROP TABLE IF EXISTS `keyword`;

CREATE TABLE `keyword` (
	`k_num`	int auto_increment primary key,
	`k_content`	varchar(10) not	NULL,
	`k_mb_id`	varchar(13)
);

DROP TABLE IF EXISTS `MA`;

CREATE TABLE `MA` (
	`ma_mb_id`	varchar(13),
	`ma_a_name`	varchar(20)
);

ALTER TABLE `Board` ADD CONSTRAINT `FK_Category_TO_Board_1` FOREIGN KEY (
	`b_c_num`
)
REFERENCES `Category` (
	`c_num`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_Member_TO_post_1` FOREIGN KEY (
	`p_mb_id`
)
REFERENCES `Member` (
	`mb_id`
);

ALTER TABLE `post` ADD CONSTRAINT `FK_Board_TO_post_1` FOREIGN KEY (
	`p_b_num`
)
REFERENCES `Board` (
	`b_num`
);

ALTER TABLE `reply` ADD CONSTRAINT `FK_Member_TO_reply_1` FOREIGN KEY (
	`r_mb_id`
)
REFERENCES `Member` (
	`mb_id`
);

ALTER TABLE `reply` ADD CONSTRAINT `FK_post_TO_reply_1` FOREIGN KEY (
	`r_p_num`
)
REFERENCES `post` (
	`p_num`
);

ALTER TABLE `Log` ADD CONSTRAINT `FK_Member_TO_Log_1` FOREIGN KEY (
	`l_mb_id`
)
REFERENCES `Member` (
	`mb_id`
);

ALTER TABLE `keyword` ADD CONSTRAINT `FK_Member_TO_keyword_1` FOREIGN KEY (
	`k_mb_id`
)
REFERENCES `Member` (
	`mb_id`
);

ALTER TABLE `MA` ADD CONSTRAINT `FK_Member_TO_MA_1` FOREIGN KEY (
	`ma_mb_id`
)
REFERENCES `Member` (
	`mb_id`
);

ALTER TABLE `MA` ADD CONSTRAINT `FK_authority_TO_MA_1` FOREIGN KEY (
	`ma_a_name`
)
REFERENCES `authority` (
	`a_name`
);

