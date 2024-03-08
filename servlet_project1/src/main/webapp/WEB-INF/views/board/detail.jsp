<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.css"
	rel="stylesheet">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
	<div class="container">
		<c:choose>
			<c:when test="${board != null}">
				<h1>게시글 상세</h1>
				<form action="<c:url value="/board/insert"/>" method="post">
					<div>
						<div class="mb-3 mt-3">
							<label for="community" class="form-label">게시판:</label> <input
								type="text" class="form-control" id="community" name="community"
								readonly value="${board.community.co_name}">
						</div>
						<div class="mb-3 mt-3">
							<label for="title" class="form-label">제목 : </label> <input
								type="text" class="form-control" id="title" name="title"
								readonly value="${board.bo_title}">
						</div>
						<div class="mb-3 mt-3">
							<label for="writer" class="form-label">작성자 : </label> <input
								type="text" class="form-control" id="writer" name="writer"
								readonly value="${board.bo_me_id}">
						</div>
						<div class="mb-3 mt-3">
							<label for="view" class="form-label">조회수 : </label> <input
								type="text" class="form-control" id="view" name="view" readonly
								value="${board.bo_view}">
						</div>
						<div class="mb-3 mt-3 clearfix">
							<button type="button" id="btnUP" data-state="1"
								class="btn btn-outline-danger col-5 float-start">추천</button>
							<button type="button" id="btnDown" data-state="-1"
								class="btn btn-outline-danger col-5 float-end">비추천</button>
						</div>
						<div class="mb-3 mt-3">
							<label for="content" class="form-label">내용 : </label>
							<div class="form-control" style="min-height: 400px;">${board.bo_content }</div>
						</div>
						<c:if test="${fileList != null && fileList.size() != 0}">
							<div class="mb-3 mt-3">
								<label for="view" class="form-label">첨부파일 : </label>
								<c:forEach items="${fileList}" var="file">
									<a class="form-control"
										href="<c:url value="/download?filename=${file.fi_name}"/>"
										download="${file.fi_ori_name}">${file.fi_ori_name}</a>
								</c:forEach>
							</div>
						</c:if>
						<a href=<c:url value = "/board/list/"/>
							class="btn btn-outline-dark">목록으로</a>
						<c:if test="${board.bo_me_id == user.me_id}">
							<a href=<c:url value = "/board/delete?num=${board.bo_num}"/>
								class="btn btn-outline-danger">삭제</a>
							<a href=<c:url value = "/board/update?num=${board.bo_num}"/>
								class="btn btn-outline-danger">수정</a>
						</c:if>
						<hr>
						<div class="mt-3 comment-box">
						<h3>댓글</h3>
							<!-- 댓글 리스트를 보여주는 박스 -->
							<div class="comment-list"></div>
							<!-- 댓글 페이지네이션 박스 -->
							<div class="comment-pagination"></div>
							<!-- 댓글 입력 박스 -->
							<div class="comment-input-box">
								<div class="input-group">
									<textarea class="form-control comment-content"></textarea>
									<button type="button" class="btn btn-outline-success btn-comment-insert">등록</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</c:when>
			<c:otherwise>
				<h1>등록되지 않은 게시글 이거나 삭제된 게시글입니다.</h1>
			</c:otherwise>
		</c:choose>
	</div>
	<!-- 추천 기능 구현 -->
	<script type="text/javascript">
   let btnUp = document.getElementById("btnUP");
   let btnDown = document.getElementById("btnDown");
   
   btnUp.onclick = recommend;
   
   btnDown.onclick = recommend;
   
   function recommend() {
      //로그인 안 했으면
      if('${user.me_id}' == ''){
         if(confirm("로그인이 필요한 서비스입니다. 로그인 화면으로 이동하시겠습니까?")){
            location.href = "<c:url value='/login'/>";
         }
         //취소 누르면 현재 페이지에서 추천/비추천 동작을 안 함
         else{
            return;
         }
      }
      
      let boNum = '${board.bo_num}';
      
      //state가 1이면 추천, -1이면 비추천
      let state = this.getAttribute("data-state");

      //해당 url로 boNum과 state 값을 보냄.
      fetch(`<c:url value="/recommend"/>?boNum=\${boNum}&state=\${state}`)
         .then(response =>{
        	 console.log(response);
        	 return response.text() 
         })
         .then(data => {
        	 let str = state == 1 ? "추천" : "비추천";
        	 initRecommend(btnUp);
        	 initRecommend(btnDown);
        	 switch(data){
        	 	case "1":
        	 		alert('게시글을 추천했습니다.');
        	 		selectRecommendBtn(btnUp);
        	 		break;
        	 	case "-1":
        	 		alert('게시글을 비추천했습니다.');
	        	 	selectRecommendBtn(btnDown);
	        	 	break;
        	 	case "0":alert(`게시글을 \${str}을 취소했습니다.`);break;
        	 	default: alert(data);
        	 }
         })
         .catch(error => console.error(error));
   }
   //추천/비추천 버튼을 기본으로 돌리는 함수 btn-outline-danger
   function initRecommend(btn){
	 btn.classList.remove('btn-danger');
  	 btn.classList.add('btn-outline-danger');
   }
   
   //추천/비추천 버튼을 선택했을 때 색상을 지정하는 함수
   function selectRecommendBtn(btn){
	  btn.classList.remove('btn-outline-danger');
	  btn.classList.add('btn-danger');
   }
   <c:if test="${recommend != null}">
   		if(${recommend.re_state == 1}){
   			selectRecommendBtn(btnUp);
   		}else if(${recommend.re_state == -1}){
   			selectRecommendBtn(btnDown);
   		}
   </c:if>
</script>
<!-- 댓글 기능 구현 -->
<script type="text/javascript">
	//(댓글) 등록 버튼 클릭 이벤트를 등록
	if('${user.me_id})' == ''){
		if(confirm("로그인이 필요한 서비스입니다. 로그인 화면으로 이동하시겠습니까?")){
            location.href = "<c:url value='/login'/>";
         }
         //취소 누르면 현재 페이지에서 추천/비추천 동작을 안 함
         else{
            return;
         }
	}
	$(".btn-comment-insert").click(function(){
		//입력받은 댓글을 가져옴
		//입력 테그로 값을 받으면 .val()로 아니면 .text()로 받아옴
		let content = $(".comment-content").val();
		//게시글 번호를 가져옴
		let num = '${board.bo_num}';
		$.ajax({
			url:'<c:url value="/comment/insert"/>',
			method:"post",
			data : {
				"content" : content,//변수 이름과 속성 이름  같으면 content:content이런식으로 안써도 됨
				num
			},
			success : function(data){
				console.log(data);
			},
			error : function(a, b, c){
				
			}
		});
	});//click end
</script>
</body>
</html>