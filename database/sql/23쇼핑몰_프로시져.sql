
# 제품을 추가하는 프로시저
# 제품 코드는 영문3자리(주어짐), 숫자 3자리(같은 카테고리로 등록된 제품들 수를 이용)
# 주어지는 정보 : 제품코드영문3자리, 제품명, 내용, 가격, 카테고리명
# 프로시저 실행 결과 : 제품이 등록
use shoppingmall;
select * from product;
drop procedure if exists insert_product;

delimiter //
create procedure insert_product(
	in _code char(3),
    in _title varchar(50),
    in _content text,
    in _price int,
    in _category varchar(10)
)
begin
	declare _count int;
    declare _pr_code varchar(15);
    declare _ca_num int;
    # _category와 일치하는 등록된 제품 수를 찾아서 +1을 한 후 변수에 저장
    set _count = (  SELECT COUNT(*) + 1 FROM product
					JOIN category ON ca_num = pr_ca_num WHERE
					ca_name = _category);
	# _code와 _count를 이용하여 _pr_code를 생성
    # _count가 3자리가 아니면 앞에'0'을 붙여서 3자리로 만든 후 제품 코드를 생성
    set _pr_code = concat(_code, lpad(_count, 3, '0'));
    
    # _category를 이용하여 _ca_num를 찾음
    set _ca_num = (select ca_num from category where ca_name = _category);
    
    if _ca_num is not null then
		insert into product(pr_code, pr_title, pr_content, pr_price, pr_ca_num)
        values(_pr_code, _title, _content, _price, _ca_num);
    end if;
end//
delimiter ;

# 무슨 프로시저가 있는지 확인하기 위한 코드
#show create procedure insert_product;
#프로시저를 불러와서 실행하는 코드
#call insert_product("ABC", '수정펜', '수정팬입니다.', 3000, '기타'); 

#call insert_product("ABC", '수정펜', '수정팬입니다.', 3000, 'ABC'); 

/*
SELECT 
    COUNT(*) + 1
FROM
    product
        JOIN
    category ON ca_num = pr_ca_num
WHERE
    ca_name = '기타';
    
SELECT 
   *
FROM
    product
WHERE
    pr_ca_num = (SELECT 
            ca_num
        FROM
            category
        WHERE
            ca_name = '기타');
*/

# 제품을 주문하는 프로시져
drop procedure if exists insert_order;
delimiter //
create procedure insert_order(
	in _amount int,
    in _id varchar(13),
    in _pr_code varchar(15)
)
begin
	declare _price int; #제품 가격
    declare _total_price int; #제품 총 가격
    
    # 제품 가격을 가져옴 
    set _price = (select pr_price from product where pr_code = _pr_code);
    # 제품 총 가격 계산
    set _total_price = _price * _amount;
	# order 테이블에 데이터를 추가
	insert into `order`(or_amount, or_total_price ,or_me_id, or_pr_code) values(_amount, _total_price ,_id, _pr_code);
end //
delimiter ;
call insert_order(3,'qwe123','ABC004');
select * from `order`;
select * from product;
select * from member;