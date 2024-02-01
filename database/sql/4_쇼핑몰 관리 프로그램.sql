drop database if exists shoppingmall;
create database if not exists shoppingmall;

use shoppingmall;

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(13)	primary key,
	`me_password`	varchar(20) not	NULL,
	`me_email`	varchar(30) not	NULL,
	`me_phone`	varchar(13) not	NULL,
	`me_authority`	varchar(10) not NULL default "USER",
	`me_try_count`	int not null default 0
);

DROP TABLE IF EXISTS `Certification`;

CREATE TABLE `Certification` (
	`ce_num`	int primary key,
	`ce_code`	char(6) not	NULL,
	`ce_limit`	datetime not NULL,
	`ce__me_id`	varchar(30)	NOT NULL
);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
	`productcode`	varchar(30)	primary key,
	`content`	text not NULL,
	`cf_num`	int	NOT NULL,
	`price`	int not NULL default 0,
	`bag_num`	int	NOT NULL,
	`productname`	varchar(50) not	NULL
);

DROP TABLE IF EXISTS `classification`;

CREATE TABLE `classification` (
	`cf_num`	int primary key auto_increment,
	`cf_name`	varchar(10) not	NULL
);

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
	`od_num`	int	primary key auto_increment,
	`od_date`	datetime not NULL  default current_timestamp,
	`od_situation`	varchar(10) not NULl default "결제완료",
	`od_quantity`	int not NULL default 0,
	`buy_price`	int not	NULL,
	`id`	varchar(30)	NOT NULL,
	`productcode`	varchar(30)	NOT NULL
);

DROP TABLE IF EXISTS `bag`;

CREATE TABLE `bag` (
	`bag_num`	int	primary key auto_increment,
	`bn_quantity`	int not NULL default 0,
	`id`	varchar(30)	NOT NULL
);

DROP TABLE IF EXISTS `thumbnail`;

CREATE TABLE `thumbnail` (
	`tn_num`	int	primary key Auto_increment,
	`file_name`	varchar(50) not	NULL,
	`productcode`	varchar(15)	NOT NULL
);


ALTER TABLE `Certification` ADD CONSTRAINT `FK_member_TO_Certification_1` FOREIGN KEY (
	`ce__me_id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_classification_TO_product_1` FOREIGN KEY (
	`cf_num`
)
REFERENCES `classification` (
	`cf_num`
);

ALTER TABLE `product` ADD CONSTRAINT `FK_bag_TO_product_1` FOREIGN KEY (
	`bag_num`
)
REFERENCES `bag` (
	`bag_num`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_member_TO_order_1` FOREIGN KEY (
	`id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `order` ADD CONSTRAINT `FK_product_TO_order_1` FOREIGN KEY (
	`productcode`
)
REFERENCES `product` (
	`productcode`
);

ALTER TABLE `bag` ADD CONSTRAINT `FK_member_TO_bag_1` FOREIGN KEY (
	`id`
)
REFERENCES `member` (
	`me_id`
);

ALTER TABLE `thumbnail` ADD CONSTRAINT `FK_product_TO_thumbnail_1` FOREIGN KEY (
	`productcode`
)
REFERENCES `product` (
	`productcode`
);

