#abc123회원이 주문 내역을 확인하는 쿼리
select * from `order`;
select * from `order` where or_me_id = "abc123";

# 기타(1)에 포함된 모든 제품을 조회하는 쿼리
select * from product;
select * from product where pr_ca_num = 1;

#기타(1), 자동차(5), 의류(3)에 포함된 모든 제품을 조회하는 쿼리

select * from product where pr_ca_num in (1, 3, 5);
SELECT 
    *
FROM
    product
WHERE
    pr_ca_num = 1 OR pr_ca_num = 3
        OR pr_ca_num = 5;
        
# 등록된 제품들의 카테고리 번호를 조회하는 쿼리

select distinct pr_ca_num from product;

# 가격이 높은 순으로 제품을 정렬하는 쿼리
select * from product order by pr_price desc, pr_code;


# 제품 페이지에서 1페이지에 있는 제품을 조회하는 쿼리(한페이지에 제품은 2개 조회)
select * from product limit 0, 2;
# 2페이지에 있는 제품을 조회하는 쿼리(한 페이지에 2개 조회)
# 2번지 = 컨텐츠 개수 * (2페이지 -1)
select * from product limit 2, 2;

#10페이지에 있는 제품을 조회하는 쿼리
select * from product limit 18, 2;

# 카테고리 별 등록된 제품의 개수를 조회
select pr_ca_num "카테고리 번호", count(pr_ca_num) as "제품수" from product group by pr_ca_num;

#카테고리별 등록된 제품의 개수가 2개 이상인 카테고리를 조회
select pr_ca_num "카테고리 번호", count(pr_ca_num) as "제품수" from product group by pr_ca_num having count(pr_ca_num >= 2);

# abc123회원이 지금까지 주문한 총 금액을 조회하는 쿼리

select * from `order`;
select or_me_id as 아이디, sum(or_total_price) as "총 주문 금액" from `order` where or_me_id = "abc123" and or_state not in("반품", "환불") group by or_me_id;

# 제품별 판매된 개수를 조회하는 쿼리
select or_pr_code as 제품코드, sum(or_amount) as 주문개수 from `order` where or_state not in ("반품", "환불") group by or_pr_code;


# 제품별 카테고리명을 조회하기 위한 INNER JOIN 쿼리
SELECT 
    product.*, category.ca_name
FROM
    product
        JOIN
        #product의 외래키를 category의 기본키와 연결
        #속성명이 다르면 테이블명을 생략할 수 있다.
    category ON product.pr_ca_num = category.ca_num;

# 기타로 등록된 제품들을 조회하는 쿼리
SELECT 
    product.*, category.ca_name
FROM
    product
        JOIN
    category ON product.pr_ca_num = category.ca_num
WHERE
    category.ca_name = '기타';

# abc123회원이 주문한 제품 목록을 조회하는 쿼리

SELECT distinct
    product.pr_title as 제품명
FROM
    `order`
        JOIN
    product ON `order`.or_pr_code = product.pr_code
WHERE
    or_me_id = 'abc123' and or_state not in("환불", "반품");


# 각 제품별 판매된 개수(판매된 제품에 한해서)
select pr_title, sum(or_amount) as '판매수' from `order` join product on or_pr_code = pr_code where or_state not in ('반품', '환불') group by pr_code;


# 각 제품별 판매된 개수(모든 제품에 한해서)
SELECT 
	# ifnull(속성, 값) : 속성이 null인 경우 null 대신 값 A로 변경
    pr_title, ifnull (sum(or_amount), 0) as 판매수량
FROM
    product
        left JOIN
    `order` ON product.pr_code = `order`.or_pr_code
where
	or_state is null or or_state not in ("환불", "반품")
group by
 pr_code;
 
 select * from `order`;

SELECT 
	# ifnull(속성, 값) : 속성이 null인 경우 null 대신 값 A로 변경
    pr_title, ifnull (sum(or_amount), 0) as 판매수량
FROM
    `order`
        right JOIN
    product ON product.pr_code = `order`.or_pr_code
where
	or_state is null or or_state not in ("환불", "반품")
group by
 pr_code;














