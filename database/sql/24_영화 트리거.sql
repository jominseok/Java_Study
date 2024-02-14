
use movie;

#상영관에 좌석이 추가되면 상영관 전체 좌석수와 영화관 전체 좌석수를 업데이트 하는 트리거
# seat테이블에 좌석이 추가되면, screen테이블과 theater 테이블의 좌석수를 수정하는 트리거
drop trigger if exists insert_seat;

delimiter //
create trigger insert_seat after insert on seat
for each row
begin
	declare _sc_num int;
    declare _sc_seat int;
    declare _th_num int;
    declare _th_seat int;
    
    # 상영관 번호
    set _sc_num = new.se_sc_num;
    # 상영관에 있는 전체 좌석수 계산
    set _sc_seat = (select count(*) from seat where se_sc_num = _sc_num);
    # 상영관에 있는 전체 좌석수를 업데이트
    update screen set sc_seat = _se_seat where sc_num = _sc_num;
    
    #영화관 번호
    set _th_num = (select sc_th_num from screen where sc_num = _sc_num);
    set _th_seat = (select count(*) from seat where se_sc_num in (select sc_num from screen where sc_th_num = 1));
    #영화관에 있는 전체 좌석수를 업데이트
    update theater set th_scat = _th_seat where th_num = _th_num;
end //
delimiter ;

select * from screen;

# 상영관이 추가 되면 영화관의 전체 상영관 수를 업데이트 하는 트리거
drop trigger if exists insert_screen;

delimiter //
create trigger insert_screen after insert on screen
for each row
begin
/*
	# 상영관의 최고 숫자를 가져올 변수를 선언
	declare _sc_name_max int;
    # 상영관의 최고 숫자를 변수에 저장
    set _sc_name_max = (select max(sc_name) from screen where sc_th_num = 1);
    # 영화관 테이블에 업데이트 해줌
    update theater set th_screen = _sc_name_max;
    # 또 뭐가 필요한가...?*/
    declare _th_num int;
    declare _th_screen int;
    #영화관 번호
    set _th_num = new.sc_th_num;
    #영화관 상영관 수
    set _th_screen = (select count(*) from screen where sc_th_num = _th_num);
    #영화관에 있는 전체 좌석수를 업데이트
    update theater set th_screen = _th_screen where th_num = _th_num;
end //
delimiter ;

select max(sc_name) from screen where sc_th_num = 1;
select * from theater;
select * from screen;
insert into screen(sc_name, sc_scat, sc_th_num) values(4, 0, 1);
