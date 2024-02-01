/*
테이블명만 쓰는 것과 db명.테이블명을 쓰는 것의 차이는
- 테이블명만 쓰는 경우는 내가 작업하려는 db가 선택 됐을 때
- db명.테이블명은 현재 선택된 db와 상관없이 작업할 수 있다.
*/

# 테이블에 등록된 순서에 상관 없이 추가할 때 나열한 컬럼 순서대로 값들을 넣어주면 됨.
insert into member(id, pw, email, reg_date) values(
	"abc",
    "def",
    "abc@naver.com",
    now()
);
insert into member(pw, id, reg_date, email) values(
	"비번123",
    "ID1",
    now(),
    "abc@naver.com"
);

SELECT 
    *
FROM
    test.member;

#속성명을 생략한 대신, 테이블에 등록된 컬럼 순서대로 값들을 넣어주어야함
insert into member values(
	"ID1",
    "pass",
    "abc@naver.com",
     now()
);


# NOW()를 이용해서 날짜를 문자열에 저장하면 날짜가 문자열로 변환되서 문제가 없음
#날짜형태가 아닌 문자열을 DATETIME에 저장하려 하면 에러가 발생
#insert into ("ID3", "비번입니다.", NOW(), "ABCD@GMAIL.com");


# 날짜 형태인 문자열을 datetime에 저장하려 하면 변환이 가능하기 때문에 정상 동작
insert into member values("id3", "비번입니다.", NOW(), "2024-02-01 16:25:00");

# 아이디가 id3인 이메일을 ID3@naver.com으로 수정하는 쿼리

UPDATE member 
SET 
    email = 'rkrkr@naver.com'
WHERE
    id = 'abc';
    
# 아이디가 ID1인 회원의 비번을 IDABC로, 이메일을 IDABC@naver.com으로 수정하는 쿼리
UPDATE MEMBER 
SET 
    email = "IDABC@naver.com",
    pw = "IDABCDF"
WHERE
		id = "ID1";




#아이디가 ABC인 회원 정보를 삭제하는 쿼리

delete from member where id = "abc";


#member 테이블 조회

select ID, PW, Email, reg_date from member;
select * from member;

#ID가 ID1인 회원의 정보를 조회
select * from member where id = "id1";

















