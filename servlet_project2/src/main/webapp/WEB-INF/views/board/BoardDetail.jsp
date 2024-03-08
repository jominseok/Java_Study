<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>
<div class="container">
   <c:choose>
      <c:when test="${board != null}">
         <h1>게시글 상세</h1>
         <div class="mb-3 mt-3">
             <label for="community" class="form-label">게시판:</label>
             <input type="text" class="form-control"readonly value="${board.community.co_name}">
          </div>
         <div class="mb-3 mt-3">
             <label for="title" class="form-label">제목:</label>
             <input type="text" class="form-control" readonly value="${board.bo_title}">
          </div>
          <div class="mb-3 mt-3">
             <label for="writer" class="form-label">작성자:</label>
             <input type="text" class="form-control" readonly value="${board.bo_me_id}">
          </div>
           <div class="mb-3 mt-3">
            <label for="view" class="form-label">조회수:</label>
            <input type="text" class="form-control" readonly value="${board.bo_view}">
           </div>
           <div class="mb-3 mt-3">
            <label for="content" class="form-label">내용:</label>
            <div class="form-control" style="min-height: 400px">${board.bo_content}</div>
           </div>
           <c:if test="${fileList != null && fileList.size() != 0}">
              <div class="mb-3 mt-3">
                <label for="file" class="form-label">첨부파일:</label>
                <c:forEach items="${fileList}" var="file">
                   <a href='<c:url value="/download?filename=${file.fi_name}"/>' class="form-control" download="${file.fi_ori_name}">${file.fi_ori_name}</a>
                </c:forEach>
              </div>
           </c:if>
           <div class="mb-3 mt-3 clearfix">
              <button type="button" data-state="1" class="btn btn-outline-success btn-up float-start col-5">추천</button>
              <button type="button" data-state="-1" class="btn btn-outline-success btn-down float-end col-5">비추천</button>
         </div>
        </c:when>
        <c:otherwise>
           <h1>없는 게시글이거나 삭제된 게시글입니다.</h1>
        </c:otherwise>
   </c:choose>
   <a href="<c:url value='/board/list'/>" class="btn btn-outline-dark">목록으로</a>
     <c:if test="${board.bo_me_id.equals(user.me_id)}">
        <a href="<c:url value="/board/delete?num=${board.bo_num}"/>" class="btn btn-outline-danger">삭제</a>
        <a href="<c:url value="/board/update?num=${board.bo_num}"/>" class="btn btn-outline-success">수정</a>
     </c:if>
</div>
<script src="//code.jquery.com/jquery-3.4.1.js"></script>
<script type="text/javascript">
   $(".btn-up, .btn-down").click(function(){
      
      if('${user.me_id}' == ''){
         if(confirm("로그인이 필요한 서비스입니다. 로그인 페이지로 이동하시겠습니까?")){
            location.href = '<c:url value="/login"/>'
         }else{
            return;
         }
      }
      
      let state = $(this).data('state');
      let boNum = '${board.bo_num}'; //게시글이 없는 경우 스크립트 오류가 생기지 않기 위해 '' 붙임
      $.ajax({
         url : '<c:url value="/recommend"/>',
         method : 'get',
         async : true, //동기/비동기 선택, true : 비동기, false : 동기 /// 비동기 : 앞의 작업이 끝나지 않아도 진행됨.
         data : {
            "state" : state,
            "boNum" : boNum  // "" 생략 가능
         },
         success : function(data){
            initBtn(".btn-up","btn-outline-success","btn-success");
            initBtn(".btn-down","btn-outline-success","btn-success");
            switch(data){
            case "1":
               alert("추천 되었습니다.");
               initBtn(".btn-up","btn-success","btn-outline-success");
               break;
            case "0":
               alert(`\${state == 1 ? '' : '비'}추천이 취소되었습니다.`);
               break;
            case "-1":
               alert("비추천 되었습니다.");
               initBtn(".btn-down","btn-success","btn-outline-success");
               break;
            }
         },
         error : function(a, b, c){
            console.error("예외 발생");
         }
      }); //ajax end
   }); //click end
   
   function initBtn(selector, addClassName, removeClassName){
      $(selector).addClass(addClassName);
      $(selector).removeClass(removeClassName);
   }
   
   <c:if test="${recommend != null}">
      <c:if test="${recommend.re_state == 1}">
         initBtn(".btn-up","btn-success","btn-outline-success");
      </c:if>
      <c:if test="${recommend.re_state == -1}">
         initBtn(".btn-down","btn-success","btn-outline-success");
      </c:if>
   </c:if>
</script>
</body>
</html>