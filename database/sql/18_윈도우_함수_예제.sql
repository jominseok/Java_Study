# 쇼핑몰을 이용한 윈도우 함수 예제

use shoppingmall;

# 제품을 가격순으로 정렬 row_number
select row_number() over(order by pr_price desc) as 순서, product.* from product;

#제품을 각격순으로 정렬 rank
select rank() over(order by pr_price desc) as 순서, product.* from product;

#제품을 각격순으로 정렬 dense_rank
select dense_rank() over(order by pr_price desc) as 순서, product.* from product;

# 제품을 비싼제품, 싼 제품으로 정렬 ntile
select ntile(2) over(order by pr_price desc) as '그룹', product.* from product;

#가장 비싼 제품들을 조회하는 쿼리 dense_rank
select * from (
	select dense_rank() over(order by pr_price desc) as pr_rank, product.* from product
) as ranked_product where pr_rank = 1;