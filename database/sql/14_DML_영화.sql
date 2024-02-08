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

#지역을 추가하는 쿼리
#(서울, 경기, 인천, 강원, 대전/충청, 대구, 부산/울산, 경상, 광주/전라/제주)
insert into region values
("서울"),
("경기"),
("인천"),
("강원"),
("대전/충청"),
("대구"),
("부산/울산"),
("경상"),
("광주/전라/제주");
select * from region;

# 영화관을 추가하는 쿼리
# CGV강남, 서울특별시 강남구 역삼동, 좌석수 : 0, 상영관수 : 3, 서울
# CGV영등포, 서울특별시 영등포구 4가, 좌석수 : 0, 상영관수 : 4, 서울
insert into theater values(null,'CGV강남', '서울특별시 강남구 역삼동', 0, 3, '서울'),
(null,'CGV영등포', '서울특별시 영등포구 4가', 0, 4, '서울');
select * from theater;

# CGV강남에 상영관과 좌석 추가하는 쿼리
# 1관 : 10좌석, 2관 : 12좌석, 3관 :  6좌석
# 1관 : A1~A3, B1~B3, C1~C4
# 2관 : A1~A4, B1~B4, C1~C4
# 3관 : A1,A2, B1,B2, C1,C2
insert into screen values
(null, 1, 10, 1),
(null, 2, 12, 1),
(null, 3, 6, 1);
select * from screen;

insert into seat values
(null, 'A1', 1),(null, 'A2', 1),(null, 'A3', 1),
(null, 'B1', 1),(null, 'B2', 1),(null, 'B3', 1),
(null, 'C1', 1),(null, 'C2', 1),(null, 'C3', 1),(null, 'C4', 1);

insert into seat values
(null, 'A1', 2),(null, 'A2', 2),(null, 'A3', 2), (null, 'A4', 2),
(null, 'B1', 2),(null, 'B2', 2),(null, 'B3', 2),(null, 'B4', 2),
(null, 'C1', 2),(null, 'C2', 2),(null, 'C3', 2),(null, 'C4', 2);

insert into seat values
(null, 'A1', 3),(null, 'A2', 3),(null, 'C1', 3),
(null, 'B1', 3),(null, 'B2', 3),(null, 'C2', 3);
select * from seat;

UPDATE theater 
SET 
    th_scat = 30
WHERE
    th_name = 'CGV강남';
    
/*
서브 쿼리를 이용하여 극장 CGV강남에 등록된 좌석수를 계산해서 영화관 전체 좌석수에 업데이트 하는 쿼리
- 서브 쿼리로 A테이블을 업데이트 할 때, 서브 쿼리에 A테이블을 단순 이용하면 업데이트가 되지 않음
- 이럴 때, A테이블이 아닌 A테이블을 조회한 결과를 이용하면 가능
- 서브 쿼리가 select count(*) from A일 때, A대신
  select count(*) from (select * from A) as 임시 이름을 이용해야 한다.
*/
UPDATE theater 
SET 
    th_scat = (SELECT 
            COUNT(*)
        FROM
            seat
                JOIN
            screen ON se_sc_num = sc_num
                JOIN
            (SELECT 
                *
            FROM
                theater) AS th ON sc_th_num = th_num
        WHERE
            th_name = 'CGV강남')
WHERE
    th_name = 'CGV강남';
    
SELECT 
    *
FROM
    theater;
    
# CGV강남에 상영관과 좌석 추가하는 쿼리
# 1관 : 14좌석, 2관 : 16좌석, 3관 :  10좌석, 4관 : 25좌석
# 1관 : A1~A3, B1~B3, C1~C4, D1~D4
# 2관 : A1~A4, B1~B4, C1~C4, D1~D4
# 3관 : A1,A2, B1,B2, C1,C2, D1,D1, E1,E2
# 4관 : A1~A5, B1~B4, C1~C5

insert into screen values
(null, 1, 14, 2),
(null, 2, 16, 2),
(null, 3, 10, 2),
(null, 4, 15, 2);
select * from screen;
select * from seat;

insert into seat values
#CGV영등포 1관
(null, 'A1', 4),(null, 'A2', 4),(null, 'A3', 4),
(null, 'B1', 4),(null, 'B2', 4),(null, 'B3', 4),
(null, 'C1', 4),(null, 'C2', 4),(null, 'C3', 4),(null, 'C4', 4),
(null, 'D1', 4),(null, 'D2', 4),(null, 'D3', 4),(null, 'D4', 4),
#CGV영등포 2관
(null, 'A1', 5),(null, 'A2', 5),(null, 'A3', 5),(null, 'A4', 5),
(null, 'B1', 5),(null, 'B2', 5),(null, 'B3', 5),(null, 'B4', 5),
(null, 'C1', 5),(null, 'C2', 5),(null, 'C3', 5),(null, 'C4', 5),
(null, 'D1', 5),(null, 'D2', 5),(null, 'D3', 5),(null, 'D4', 5),
#CGV영등포 3관
(null, 'A1', 6),(null, 'A2', 6),
(null, 'B1', 6),(null, 'B2', 6),
(null, 'C1', 6),(null, 'C2', 6),
(null, 'D1', 6),(null, 'D2', 6),
(null, 'E1', 6),(null, 'E2', 6),
#CGV영등포 4관
(null, 'A1', 7),(null, 'A2', 7),(null, 'A3', 7),(null, 'A4', 7),(null, 'A5', 7),
(null, 'B1', 7),(null, 'B2', 7),(null, 'B3', 7),(null, 'B4', 7),(null, 'B5', 7),
(null, 'C1', 7),(null, 'C2', 7),(null, 'C3', 7),(null, 'C4', 7),(null, 'C5', 7),
(null, 'D1', 7),(null, 'D2', 7),(null, 'D3', 7),(null, 'D4', 7),(null, 'D5', 7),
(null, 'E1', 7),(null, 'E2', 7),(null, 'E3', 7),(null, 'E4', 7),(null, 'E5', 7);

UPDATE theater 
SET 
    th_scat = (SELECT 
            COUNT(*)
        FROM
            seat
                JOIN
            screen ON se_sc_num = sc_num
                JOIN
            (SELECT 
                *
            FROM
                theater) AS th ON sc_th_num = th_num
        WHERE
            th_name = 'CGV영등포')
WHERE
    th_name = 'CGV영등포';
    
select * from theater;

#상영시간을 추가
#CGV강남 1관 상영시간
#웡카 - 2월 9일 10:30, 13:00, 16:00, 18:10, 20:30
#CGV강남 2관 상영시간
#웡카 - 2월 9일 11:30, 14:00, 15:00, 19:10, 21:30
#CGV강남 3관 상영시간
#웡카 - 2월 9일 12:20, 14:30, 17:30, 19:50
insert into schedule values
#강남 1관 상영 시간 추가
(null, '2024-02-09', '10:30', 1, 1, 1),
(null, '2024-02-09', '13:00', 0, 1, 1),
(null, '2024-02-09', '16:00', 0, 1, 1),
(null, '2024-02-09', '18:10', 0, 1, 1),
(null, '2024-02-09', '20:30', 0, 1, 1),

#강남 2관 상영 시간 추가
(null, '2024-02-09', '11:30', 1, 2, 1),
(null, '2024-02-09', '14:00', 0, 2, 1),
(null, '2024-02-09', '15:00', 0, 2, 1),
(null, '2024-02-09', '19:10', 0, 2, 1),
(null, '2024-02-09', '21:30', 0, 2, 1),

#강남 3관 상영 시간 추가
(null, '2024-02-09', '12:20', 0, 3, 1),
(null, '2024-02-09', '14:30', 0, 3, 1),
(null, '2024-02-09', '17:30', 0, 3, 1),
(null, '2024-02-09', '19:50', 0, 3, 1);

select * from schedule;
#조조 할인 적용(12시 이전)
UPDATE schedule 
SET 
    sh_morning = 1
WHERE
    sh_time <= '12:00';

# 기본 요금 등록
# 성인 14,000 조조 11,000 청소년 11,200
insert into price values(null, '성인', 14000),(null, '청소년', 10000),(null, '성인조조', 14000),(null, '청소년조조', 8000);


# abc123회원이 웡카를 예매 했을때 쿼리
# CGV강남점 1상영관 10:30 영화를 성인 2명, A1, A2를 예매
insert into ticketing values(null, 2, 0, 11200*2, 1, "abc123");
select * from ticketing;
#ticketing_list 테이블에 추가
insert into ticketing_list(tl_ti_num, ti_se_num) values
(1, 1),
(1, 2);
select * from ticketing_list;