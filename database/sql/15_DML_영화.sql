#사용자가 아이디가 abc123, 비번이 asd123으로 회원가입을 진행
insert into member values('abc123', 'asd123', 'USER');
#사용자가 아이디가 qwe123, 비번이 qweqwe으로 회원가입을 진행
insert into member(me_id, me_pw) value('qwe123', 'qweqwe');

#관리자가 아이디가 admin, 비번이 admin으로 회원가입을 진행
insert into member value('admin', 'admin', 'admin');
select * from member;

#CGV에서 영화 웡카를 관리자가 등록하려고 한다. 이때 해야하는 쿼리를 순서대로 작성
#영화정보(제목, 내용, 개봉일, 상영시간), 감독, 배우들, 장르, 연령, 제작 국가, 트레일러, 스틸컷

#0. 모든 국가를 nation테이블에 추가(한국, 미국, 영국, 일본, 중국)
insert into nation values
("한국"),
("미국"),
("영국"),
("중국"),
("일본");
select * from nation;

#1. 폴킹, 티모시샬라메, 칼라 레인, 올리비아 콜맨, 톰 데이비스, 휴 그랜트, 셀리 호킨 정보를 추가
# character 테이블에 추가
insert into `character`(CH_name, ch_birthday, ch_detail, ch_na_name) values
("폴킹", "780729", "영국의 영화 감독 , 각본가이다.", "영국"),
("티모시샬라메", "951227", "티모시 샬라메만으로도 이 영화를 볼 가치가 있다.","미국"),
("칼라 레인", "090420", "미국의 배우이다.","미국"),
("올리비아 콜맨", "740130", "영국의 배우이다.","영국"),
("톰 데이비스", "790427", "영국의 배우이고 키가 207cm이다.","영국"),
("휴 그랜트", "600909", "영국의 배우이다.","영국"),
("셀리 호킨", "760427", "영국의 배우이다.","영국");
select * from `character`;

#2. 폴킹, 티모시샬라메, 칼라 레인, 올리비아 콜맨, 톰 데이비스, 휴 그랜트, 셀리 호킨 정보를 추가
# movie_person 테이블에 추가(1에서 추가한 정보를 이용)
insert into movie_person(mp_role, mp_pic, mp_ch_num) values
("감독","file_path", 1),
("배우","file_path", 2),
("배우","file_path", 3),
("배우","file_path", 4),
("배우","file_path", 5),
("배우","file_path", 6),
("배우","file_path", 7);
select * from movie_person;

#3. 영화 정보를 이용하여 영화를 등록
insert into movie value(null, "웡카", "2024-01-31", "세상에서 가장 달콤한 여정", 116, "전체관람가");
select * from movie;

#4. 폴킹, 티모시샬라메, 칼라 레인, 올리비아 콜맨, 톰 데이비스, 휴 그랜트, 셀리 호킨 정보를 추가
# join테이블에 추가(2, 3에서 추가한 정보를 이용), 배역을 모르면 ""로
insert into `join` values
(null, "감독", 1, 1),
(null, "배우", 1, 2),
(null, "배우", 1, 3),
(null, "배우", 1, 4),
(null, "배우", 1, 5),
(null, "배우", 1, 6),
(null, "배우", 1, 7);
select * from `join`;

#5. 모든 장르를 genre 테이블에 추가(액션, 범죄, SF, 드라마, 환타지, 코미디, 로맨스, 스릴러, 공포, 멜로)
insert into genre values
("액션"),
("범죄"),
("SF"),
("드라마"),
("환타지"),
("코미디"),
("로맨스"),
("스릴러"),
("공포"),
("멜로");

#6. 모든 연령을  age테이블에 추가 (전체관람가, 12이상 관람가, 15세 이상 관람가, 청소년 관람 불가, 제한 관람가)
insert into age values
("전체관람가"),
("12세이상 관람가"),
("15세이상 관람가"),
("청소년 관람 불가"),
("제한관람가");

#8. 트레일러 정보를 추가. 파일명은 임의로 정해서 추가. 트레일러 3개, 스틸컷 4개 
insert into movie_file(mf_filename, mf_type, mf_mo_num) values
("file_path", "트레일러",1),
("file_path", "트레일러",1),
("file_path", "트레일러",1),
("file_path", "스틸컷",1),
("file_path", "스틸컷",1),
("file_path", "스틸컷",1),
("file_path", "스틸컷",1);
select * from movie_file;

#9. 영화 제작에 영화와 제작 국가 정보를 추가
insert into production_nation(pn_na_name, pn_mo_num) values("미국", 1),("영국", 1);
select * from production_nation;

#10. 장르 포함에 영화와 장르를 추가
insert into genre_include(gi_ge_name, gi_mo_num) values("환타지", 1),("드라마", 1);
select * from genre_include;
