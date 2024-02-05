show tables;

# member 테이블의 권하는 일반 회원은 : user, 관리자는 : admin
# 아이디가 admin이고, 비번이 admin, 이메일이 admin@gmail.com, 번호는 010-1234-5678인 관리자가 
# 회원가입을 했을때 필요한 쿼리

insert into member values(
	"admin",
    "admin",
    "admin@gmail.com",
    "010-1234-5678",
    "admin",
    0
);
select * from member;

alter table product change `productcode` `productcode` varchar(15) primary key;

select * from product;


#관리자가 다음 제품을 등록할 때 필요한 쿼리
#코드 : ABC001, 제품명 : 텀블러, 가격:2000, 내용 : 스타벅스 텀블러 입니다., 카테고리 : 기타
# 카테고리 등록 : 기타
INSERT INTO CATEGORY
VALUES(NULL, '기타');

select * from category;

insert into product values(
	"ABC001", "텀블러", "스타벅스 텀블러입니다.", 20000, 1
);

#카테고리 : 전자 제품, 의류, 식품, 자동차

insert into category(ca_name) values("전자제품"), ("의류"), ("식품"), ("자동차");

/*
코드 : ABC002, 제품명 : 볼펜,  내용 : 모나미 볼펜, 가격:1000, 카테고리 : 기타 1
코드 : ABC003, 제품명 : 지우개,  내용 : 잘지워지는 지우개, 가격:500, 카테고리 : 기타 1
코드 : ELC001, 제품명 : 마우스,  내용 : 무선 마우스, 가격:10000, 카테고리 : 전자제품 2
코드 : ELC002, 제품명 : 키보드,  내용 : 무선 키보드, 가격:10000, 카테고리 : 전자제품 2
코드 : CLO001, 제품명 : 모자,  내용 : 좋은 모자, 가격:10000, 카테고리 : 의류 3
코드 : CLO002, 제품명 : 셔츠,  내용 : 구기 없는 셔츠, 가격:50000, 카테고리 : 의류 3
코드 : FOO001, 제품명 : 만두,  내용 : 고기 만두, 가격:10000, 카테고리 : 식품 4
코드 : FOO002, 제품명 : 라면,  내용 : 맛있는 라면, 가격:3000, 카테고리 : 식품 4
코드 : CAR003, 제품명 : 방향제,  내용 : 향기 좋음, 가격:5000, 카테고리 : 방향제 5
*/
insert into product values 
("ABC003", "볼펜",  "모나미 볼펜", 1000, 1),
("ABC004", "지우개",  "잘지워지는 지우개", 500, 1),
("ELC001", "마우스", "무선 마우스", 10000, 2),
("ELC002", "키보드",  "무선 키보드", 10000, 2),
("CLO001", "모자", "좋은 모자", 10000, 3),
("CLO002", "셔츠", "구김 없는 셔츠", 50000, 3),
("FOO001", "만두",  "고기 만두", 10000, 4),
("FOO002", "라면",  "맛있는 라면", 3000, 4),
("CAR003", "방향제", "향기 좋음", 5000, 5);

 # 아이디 : abc123, 비번 : abc123, 이메일 : abc123@kh.com, 번호 : 010-1111-1111
 # 아이디 : qwe123, 비번 : qwe123, 이메일 : qwe123@kh.com, 번호 : 111-2222-2222
 
 insert into member(me_id, me_pw, me_email, me_phone) values
 ("abc123", "abc123", "abc123@kh.com", 010-0000-0000), 
 ("qwe123", "qwe123", "qwe123@kh.com", 010-1111-1111);
 
 # abc123회원이 마우스를 장바구니에 2개 담았을 때 실행되는 쿼리
 insert into BASKET(BA_AMOUNT, BA_ME_ID, BA_PR_CODE)
 values(2, "abc123", "ELC001");
 
 #abc123회원이 마우스를 장바구니에 개 담았을때 실행되는 쿼리
UPDATE basket 
SET 
    ba_amount = 3
WHERE
    ba_me_id = 'abc123'
    and ba_pr_code = 'elc001';
 
 select * from basket;
 
 #abc123회원이 키보드를 장바구니에 1개 담았을 때 실행 되는 쿼리
 insert into basket(ba_amount, ba_me_id, ba_pr_code) values(1, "abc123", "ECL002");
 
 select * from basket where ba_me_id = "abc123";
 select * from product where pr_code = "ELC001";
 #abc123회원이 장바구니에 모든 제품을 주문했을때 실행되는 쿼리
 insert into `order`(or_amount, or_total_price, or_me_id, or_pr_code) values(
	3,
    3*10000,
    "abc123",
    "ELC001"
 ),
 (
	1,
    1*50000,
    "abc123",
    "ELC002");
 select * from `order`;
 
 # 장바구니에 담긴 제품을 구매하면 장바구니에는 해당 제품을 제거
 delete from basket where ba_num = 1;
 delete from basket where ba_num = 2;
 