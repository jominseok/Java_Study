create database if not exists university;

use university;
drop table if exists student; -- 강사님이랑 할 때 잘못된거 있으면 빠르게 수정하기 위한 삭제 쿼리
create table if not Exists student( -- 학생 테이블 
	st_num CHAR(10) primary key,
    st_name varchar(10) not null,
    st_major varchar(15) not null,
    st_grade int(11) not null default 1
);


drop table if exists professor; -- 강사님이랑 할 때 잘못된거 있으면 빠르게 수정하기 위한 삭제 쿼리
create table if not Exists professor( -- 교수 테이블 
	pr_num char(10) not null primary key,
    pr_name varchar(30) not null,
    pr_room  varchar(100),
    pr_major  varchar(15) not null
);

drop table if exists lecture; -- 강사님이랑 할 때 잘못된거 있으면 빠르게 수정하기 위한 삭제 쿼리
create table if not Exists lecture( -- 강의 테이블 
	le_num int primary key,
    le_title varchar(30) not null,
    le_room varchar(20),
    le_schedule varchar(50) not null,
    le_point int not null default 0,
    le_time int not null default 0,
    le_pr_num CHAR(10),
    foreign key(le_pr_num) REFERENCES professor(pr_num)
);



drop table if exists course; -- 강사님이랑 할 때 잘못된거 있으면 빠르게 수정하기 위한 삭제 쿼리
create table if not Exists course( -- 수강 테이블 
	co_num int primary key auto_increment,
    co_st_num char(10) not null,
    co_le_num int not null,
    foreign key(co_st_num) REFERENCES student(st_num),
    foreign key(co_le_num) REFERENCES lecture(le_num)
);



drop table if exists contect; -- 강사님이랑 할 때 잘못된거 있으면 빠르게 수정하기 위한 삭제 쿼리
create table if not Exists contect( -- 연락 테이블 
	ct_st_num char(10) primary key,
    ct_phone varchar(13) not null,
    ct_addr varchar(30) not null,
    ct_detil varchar(30) not null default "",
    foreign key(ct_st_num) references student(st_num)
);