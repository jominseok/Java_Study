/*여러줄 주석*/
 
#데이터 베이스 추가(업으면)
-- create database if not exists TEST; -- 데이터 베이스 생성 if not eixsts는 써주는걸 추천한다 에러 표시를 해주기 때문
-- create schema if not exists `TEST`;

-- #데이터 베이스 삭제(있으면)
-- drop database if exists TEST; -- 데이터 베이스삭제 if exists는 해주는걸 추천
-- drop schema if exists `TEST`;

use TEST;

#테이블 삭제
drop TABLE IF EXISTS MEMBER;

# 테이블 생성하는 예제
CREATE TABLE IF NOT EXISTS MEMBER(
	ID VARCHAR(13) PRIMARY KEY,
    PW VARCHAR(15) NOT NULL,
    EMAIL VARCHAR(30) NOT NULL UNIQUE
);

DESC MEMBER;

DROP TABLE IF EXISTS BOARD;

CREATE TABLE IF NOT EXISTS BOARD(
	NUM INT AUTO_INCREMENT,
    TITLE VARCHAR(50) NOT NULL,
    CONTENT LONGTEXT NOT NULL,
    VIEW INT NOT NULL DEFAULT 0,
    ID VARCHAR(13) NOT NULL,
    PRIMARY KEY(NUM),
    FOREIGN KEY(ID) REFERENCES MEMBER(ID)
);

DESC BOARD;


-- ----------------------------------------

# member테이블에 가입일 컬럼을 추가

use test;

# member테이블에 가입일 컬럼을 추가
alter table member add date datetime not null;

#멤버 테이블에 가입일을 의미하는 date를 REG_DATE로 변경
alter table `member` change `date` `reg_date` datetime not null;

# member테이블에 불필요한 컬럼 count를 추가
alter table `member` add `count` int not null;

# member table에서 count 컬럼을 삭제alter
alter table `member` drop `count`;






















