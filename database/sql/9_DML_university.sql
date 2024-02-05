# 컴퓨터 공학 고길동 학생이 수강신청한 강의 개수를 조회하는 쿼리


select st_name as "이름", st_major as "전공", count(*) "수강신청개수" from course join student on co_st_num = st_num where st_major = "컴퓨터공학" and st_name = "고길동"; 

# 컴퓨터 공학 고길동 학생이 수강신청한 학점을 조회하는 쿼리
select 
	st_name as "이름", st_major as "전공",
    sum(LE_POINT)  AS "수강신청 학점"
from 
	course 
join 
	student on co_st_num = st_num 
JOIN
	LECTURE ON CO_LE_NUM = LE_NUM
where 
	st_major = "컴퓨터공학" and st_name = "고길동"; 

select * from lecture;
select * from course;

select * from student;

#24학년 신입생을 조회하는 쿼리
select * from student where st_num like "2024%" and st_grade = 1;

# 각 전공별 학생 수를 조회하는 쿼리

select distinct st_major as 학과, count(st_major) as 학생수 from student group by st_major;

#강의별 수강신청한 학생 수를 조회하는 쿼리 : 강의명, 학생 수 순으로 조회
select le_title 강의명, count(co_st_num) 학생수 from course join lecture on co_le_num = le_num group by le_num;