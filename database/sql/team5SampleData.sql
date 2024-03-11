use team5;

SELECT * FROM team5.`member`;
insert into `member` values
("admin", "admin", "admin", "admin@naver.com", "010-1234-1234", "관리자"),	# 관리자
("asd123", "asd123", "asd123", "asd123@naver.com", "010-9208-2023", "조민석"),
("user", "user", "user", "user@naver.com", "010-7890-7890", "고길동")
;

SELECT * FROM team5.category;
insert into `category` (c_name) values("축구"), ("화장품"), ("강아지")	#축구, 화장품, 강아지 카테고리 추가
;

SELECT * FROM team5.board;
insert into `board` (b_name, b_c_num) values
("공지", 1),("리버풀",1),	# 축구 카테고리
("공지", 2),("가성비",2),	# 화장품 카테고리
("공지", 3),("사진",3)		# 강아지 카테고리
;

SELECT * FROM team5.post;
insert into `post` (p_title, p_content, p_date, p_mb_id, p_b_num) values
# 축구 카테고리 - 공지
("축구공지1", "축구공지1", NOW(), "admin", 1),
("축구공지2", "축구공지2", NOW(), "admin", 1),
# 축구 카테고리 - 리버풀
("살라", "엄청 잘함", NOW(), "asd123", 2),
("24시즌", "5위", NOW(), "user", 2),
# 화장품 카테고리 - 공지
("공지1", "공지1", NOW(), "admin", 3),
("공지2", "공지2", NOW(), "admin", 3),
# 화장품 카테고리 - 가성비
("몰라", "죄송합니다.", NOW(), "user", 4),
("올리브영", "사기먹은거 같음", NOW(), "user", 4),
# 강아지 카테고리 - 공지
("공지1", "공지1", NOW(), "admin", 5),
("공지2", "공지2", NOW(), "admin", 5),
# 강아지 카테고리 - 사진
("리트리버", "너무큼", NOW(), "user", 6),
("푸들", "너무 작음", NOW(), "user", 6)
;

SELECT * FROM team5.reply;
insert into `reply` (r_content, r_date, r_mb_id, r_p_num) values
("댓글1", NOW(), "admin", 1),
("댓글2", NOW(), "admin", 2),
("댓글3", NOW(), "user", 3),
("댓글4", NOW(), "user", 4),
("댓글5", NOW(), "admin", 5),
("댓글6", NOW(), "admin", 6),
("댓글7", NOW(), "user", 7),
("댓글8", NOW(), "user", 8),
("댓글9", NOW(), "admin", 9),
("댓글10", NOW(), "admin", 10),
("댓글11", NOW(), "user", 11),
("댓글12", NOW(), "user", 12)
;

