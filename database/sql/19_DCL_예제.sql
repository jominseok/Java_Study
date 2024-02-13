create user 'minseok'@'%' identified by 'abc123'; #사용자 추가

set password for 'minseok'@'%' = '123123';#사용자의 비밀번호를 수정

drop user 'minseok'@'%'; # 사용자 삭제

select user, host from mysql.user; # 사용자 탐색

# 권한 부여 : grant 권한종류 on db명.테이블 명 to '사용자명'@'호스트명';
grant all privileges on `shoppingmall`.product to 'minseok'@'%';  

# 권한 제거 : revoke 권한 종류 on db명.테이블명 from '사용자명'@'호스트명'
revoke all privileges on `shoppingmall`.product from 'minseok'@'%';

grant all privileges on `shoppingmall`.* to 'minseok'@'%';