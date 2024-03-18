drop database if exists `community`;

create database if not exists `community`;
use `community`;
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13)	primary key,
	`me_ms_state`	varchar(10)	NOT NULL,
	`me_pw`	varchar(15)	not NULL,
	`me_email`	varchar(30)	not NULL unique,
	`me_authority`	varchar(5)	not NULL default 'user',
	`me_state`	varchar(5)	NULL,
	`me_stop`	datetime NULL,
    `me_fail` int not null default 0
);

DROP TABLE IF EXISTS `member_state`;

CREATE TABLE `member_state` (
	`ms_state`	varchar(10) primary key
);

DROP TABLE IF EXISTS `community`;

CREATE TABLE `community` (
	`co_num`	int	primary key auto_increment,
	`co_name`	varchar(10)	not NULL
);

DROP TABLE IF EXISTS `board`;

CREATE TABLE `board` (
	`bo_num`	int	primary key auto_increment,
	`bo_co_num`	int	NOT NULL,
	`bo_me_id`	varchar(13)	NOT NULL,
	`bo_title`	varchar(50) not	NULL,
	`bo_content`	text not NULL,
	`bo_view`	int	not NULL default 0,
	`bo_report_count` int not NULL default 0
);

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
	`fi_num` int primary key auto_increment,
	`fi_bo_num`	int	NOT NULL,
	`fi_name`	varchar(150) not NULL,
	`fi_ori_name`	varchar(50) not NULL
);

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
	`cm_num`	int	primary key auto_increment,
	`cm_bo_num`	int	NOT NULL,
	`cm_me_id`	varchar(13)	NOT NULL,
	`cm_content` text not NULL
);

DROP TABLE IF EXISTS `recomment`;

CREATE TABLE `recommend` (
	`re_num`	int	primary key auto_increment,
	`re_me_id`	varchar(13)	NOT NULL,
	`re_bo_num`	int	NOT NULL,
    `re_state` int not null
);

DROP TABLE IF EXISTS `report`;

CREATE TABLE `report` (
	`re_num`	int	primary key auto_increment,
	`re_rt_name` varchar(15) NOT NULL,
	`re_me_id`	varchar(13)	NOT NULL,
	`re_table`	varchar(10) not	NULL,
	`re_content` text not NULL,
	`re_state`	varchar(5) not NULL default '신고접수',
	`re_target`	int	not NULL
);

DROP TABLE IF EXISTS `report_type`;

CREATE TABLE `report_type` (
	`rt_name`	varchar(15) primary key
);

ALTER TABLE `member` ADD CONSTRAINT `FK_member_state_TO_member_1` FOREIGN KEY (
	`me_ms_state`
)
REFERENCES `member_state` (
	`ms_state`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_community_TO_board_1` FOREIGN KEY (
	`bo_co_num`
)
REFERENCES `community` (
	`co_num`
);

ALTER TABLE `board` ADD CONSTRAINT `FK_member_TO_board_1` FOREIGN KEY (
	`bo_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `file` ADD CONSTRAINT `FK_board_TO_file_1` FOREIGN KEY (
	`fi_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_board_TO_comment_1` FOREIGN KEY (
	`cm_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `comment` ADD CONSTRAINT `FK_member_TO_comment_1` FOREIGN KEY (
	`cm_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `recomment` ADD CONSTRAINT `FK_member_TO_recomment_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `recomment` ADD CONSTRAINT `FK_board_TO_recomment_1` FOREIGN KEY (
	`re_bo_num`
)
REFERENCES `board` (
	`bo_num`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_report_type_TO_report_1` FOREIGN KEY (
	`re_rt_name`
)
REFERENCES `report_type` (
	`rt_name`
);

ALTER TABLE `report` ADD CONSTRAINT `FK_member_TO_report_1` FOREIGN KEY (
	`re_me_id`
)
REFERENCES `member` (
	`me_id`
);

