use community;

insert into member_state values("이용중"),("기간정지"), ("영구정지"), ("탈퇴");
select * from member_state;
# 아이디 : abc123, 비번 : abc123, 이메일 : abc123@kh.co.kr
insert into member(me_id, me_ms_state, me_pw, me_email)values("abc123","이용중","abc123","abc123@kh.co.kr");
# 아이디 : qwe123, 비번 : qwe123, 이메일 : qwe123@kh.co.kr
insert into member(me_id, me_ms_state, me_pw, me_email)values("qwe123","이용중","qwe123","qwe123@kh.co.kr");
# 아이디 : admin123, 비번 : admin123, 이메일 : admin123@kh.co.kr
insert into member(me_id, me_ms_state, me_pw, me_email, me_authority)values("admin123","이용중","admin123","admin123@kh.co.kr", "admin");
select * from member;

#관리자가 커뮤니티를 등록(공지, 자유, 토론, 공부)

# 커뮤니티 추가 위 처럼 ,를 이용하여 값을 넣지 않은 이유는 꼭 게시판이 저 4개만 있는게 아닐거기 때문! 
# 만약  자바에서 insert해주면 아래처럼 하나씩 넣어줘야함
insert into community(co_name) values("공지");
insert into community(co_name) values("자유");
insert into community(co_name) values("토론");
insert into community(co_name) values("공부");
select * from community;

# abc123회원이 자유 커뮤니티에 게시글을 등록 했을 때 실행되는 쿼리 
# 제목 : 테스트, 내용 : 테스트 입니다. 첨부파일 없음
insert into board(bo_co_num, bo_me_id, bo_title, bo_content) values(2, 'abc123', '테스트', '테스트 입니다.');
select * from board;

insert into board(bo_co_num, bo_me_id, bo_title, bo_content) values(2, 'abc123', '테스트', '테스트 입니다.');
select 2, 'abc123', '테스트', '테스트 입니다.' from community where co_name = '자유';

#admin 관리자가 공지 커뮤니티에 게시글을 등록했을때 실행되는 쿼리
# 제목 : 공지사항, 내용 : 공지사항입니다., 첨부파일 : 공지사항1.jpg
# 첨부파일은 서버업로드 되면 현재 날짜를 기준으로 폴더를 생성해서 업로드함
# 업로드된 첨부파일은 /2024/02/14/파일명로 저장
insert into board(bo_co_num, bo_me_id, bo_title, bo_content) select co_num, 'admin123', '공지사항', '공지사항입니다.' from community where co_name = '공지';
select * from community;
select * from board;

insert file(fi_bo_num, fi_name, fi_ori_name) values(1, '/2024/02/14/공지사항1.JPG', '공지사항1.jpg');
select * from file;

# 공지 커뮤니티에 등록된 모든 게시글을 조회하는 쿼리
select * from board join community on bo_co_num = co_num where co_name = '공지';

# 공지 커뮤니티에 등록된 게시글중 1페이지에 해당하는 게시글을 조회하는 쿼리
select * from board join community on bo_co_num = co_num where co_name = '공지' order by bo_co_num desc limit 0, 10;

# 1번 게시글을 상세 조회 했을 때 실행되는 쿼리
select * from board where bo_num = 1;

# 3번 게시글을 상세 조회 했을때 쿼리
# 1. 3번 게식르의 조회수를 증가하는 쿼리
update board set bo_view = bo_view+1 where bo_num = 3;
# 2. 3번 게시글 조회하는 쿼리
select * from board where bo_num = 3;

# 게시글 목록에서 abc123 아이디를 클릭 했을때 실행되는 쿼리
select * from board where bo_me_id = 'abc123' order by bo_num desc limit 0,10;

# qwe123회원이 1번 게시글을 추천 버튼을 클릭했을때 쿼리
# 1. qwe123회원이 1번 게시글에 추천한 기록을 조회
select * from recomment where re_me_id = 'abc123' and re_bo_num = 1;
# 2-1 추천한 기록이 없다면 추천을 추가
insert into recomment (re_me_id, re_bo_num, re_state) values('abc123', 1,1);
# 2-2 추천한 기록이 있다면 추천을 수정
# 2-2-1. 추천한 기록이 추천인 경우 => 추천을 취소
update recomment set re_state = 0 where re_bo_num = 1 and re_me_id = 'abc123';
#2-2-2. 추천한 기록이 추천이 아닌경우 = > 비추천이거나 추천/비추천을 취소한 경우에서 다ㅣ시 추천한 경우
update recomment set re_state = 1 where re_bo_num = 1 and re_me_id = 'abc123';

# 아이디와 게시글이 주어졌을때 추천을 추가하거나 수정하는 프로시저
drop procedure if exists board_recommend;

delimiter //
create procedure board_recommend(
	in _id varchar(13),
    in _bo_num int,
    in _state int # 1이면 추천, -1이면 비추천
)

begin
	declare _re_num int;
    declare _re_state int;
    declare _new_state int;
    # 1. 아이디, 게시글 번호를 이용하여 등록된 추천 번호를 조회해서 변수에 저장
    set _re_num = (select re_num from recomment where re_me_id = _id and re_bo_num = _bo_num);
    
    # 2-1. 추천 번호가 null이면 추천 테이블에 추가
    if _re_num is null then 
    insert into recomment (re_me_id, re_bo_num, re_state) values(_id, _bo_num, _state);
	
    # 2-2. 추천번호가 null이 아니면
	else
		# 2-2-0. 추천 번호에 맞는 추천 상태를 가져옴
        set _re_state = (select re_state from recomment where re_num = _re_num);
		# 2-2-1. 추천 상태가 state와 같으면 취소 => (0)으로수정
		/*
        if _re_state = _state then
			#update recomment set re_state = 0 where re_bo_num = _bo_num and re_me_id = _id;
            
        # 2-2-2. 추천 상태가 state와 다르면 _state로 수정
		else
			#update recomment set re_state = _state where re_bo_num = _bo_num and re_me_id = _id;
            */
            if _re_state = _state then
				set _new_state = 0;
			# 2-2-2post. 추천 상태가 state와 다르면 _state로 수정
			else
				set _new_state = _state;
		end if;
			update recomment set re_state = _new_state where re_bo_num = _bo_num and re_me_id = _id;
    end if;
   
end //
delimiter ;

call board_recommend('abc123', 1,1);

select * from board;
select * from recomment;








