use test;
# 가입된 회원 전체를 조회
SELECT 
    *
FROM
    member;
    
# 아이디가 ID1인 회원의 정보를 조회

update member set id = "ID1" where email = "whalstjr1313@naver.com";

#모든 회원의 아이디와 이메일을 조회

select id, email from member;

#2024년에 가입한 회원을 조회
select * from member where reg_date like "2024-%";

update member set email = "IDABC@naver.com" where id = "id3" ;
update member set email = "whalstjr1313@naver.com" where id = "id3" ;

#이메일이 네이버인회원을 조회
select * from member where email like "%_@naver.com";