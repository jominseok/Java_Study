//게시글 리스트를 관리할 배열
let list = [];

function btnClick(){
	//입력한 제목, 작성자, 내용 가져옴
	let title = $("#title").val();
	let writer = $("#writer").val();
	let content = $("#content").val();
	//가져온 제목, 내용, 작성자와 번호(계산), 조회수(0)를 이용해서 객체를 생성
	let num;
	if(!list.length){ //0이면
	   num = 1;
	}else{
	   num = parseInt(list[0]["num"]) + 1;
	}
	let view = 0;
	let obj = {
	   num,
	   title,// => title : title
	   writer,
	   view,
	   content
	}
	if(!checkBoard(obj)){
	   alert("모든 항목은 필수 항목입니다.");
	   return false;
	}
	//생성된 객체를 배열의 앞에 추가
	list.unshift(obj);
	console.log(list);
	//display 함수를 호출 : 테이블에 list를 출력하는 함수
	display(list);
	//입력값을 비워줌
	initForm();
	//return false를 통해 서버로 전송되는 것을 막아줌
	return false;
 }
 
 closeBtn.onclick = function(){
	modal.style.display = "none";
	display(list);
 }
 //x버튼 클릭 이벤트
 $(".btn-close").click(function(){
   $(".model-box").hide();
   display(list);
 })

 //리스트에서 num와 일치하는 게시글 번호를 가진 게시글을 반환하는 함수
 function getBoard(list, num){
	for(board of list){
	   if(board["num"] == num){
		  return board;
	   }
	}
	return null;
 }

 //제목을 클릭하면
 function linkClick(){
   $(".modal-box").show();
   let num = $(this).data("num");
   let board = getBoard(list, num);
	if(board){
	   //번호, 제목, 작성자, 조회수, 내용을 구성 후 모달창에 출력 : html 코드를 문자열로
	   ++board["view"];
	   let html = 
	   `
	   <h1>게시글 등록</h1>
	   <div class="input-box">
		  <label class="label">제목:</label>
		  <input type="text" name="title" class="input" readonly value="${board["title"]}">
	   </div>
	   <div class="input-box">
		  <label class="label">작성자:</label>
		  <input type="text" name="writer" class="input" readonly value="${board["writer"]}">
	   </div>
	   <div class="input-box">
		  <label class="label">조회수:</label>
		  <input type="text" name="view" class="input" readonly value="${board["view"]}">
	   </div>
	   <div class="input-box">
		  <label class="label">내용:</label>
		  <textarea name="content" rows="10" class="input text-area" readonly>${board["content"]}</textarea>
	   </div>
	   `;
	   $(".modal-box .content-box").html(html);
	}else{
	   //없는 게시글입니다를 구성해 모달창에 출력

	   let html = $(".modal-box .content-box").html(html);
	   modalIn.innerHTML = "<h1>없는 게시글입니다.</h1>"
	}
 }

 //display 함수
 function display(list){
	//list가 비어있으면
	if(!list.length){
	   //tr 태그 생성
	   let tr = 
	   `<tr>
		  <th colspan="4">등록된 게시글이 없습니다.</th>
	   </tr>`;
	   $("tbody").html(tr);
	   return;
	}
	$("tbody").empty();
	//list가 비어있지 않으면
	//반복문 : list 전체를
	for(let i = 0; i < list.length; i++){
	   let tr = `<tr>`;
	   //tr 태그 생성
	   //반복문 : list[i] 객체를 반복문으로 속성 값을 꺼냄, for in
	   for(let key in list[i]){
		  if(key == "content"){
			 continue;
		  }
		  let obj = list[i];
		  if(key != "title"){
			 tr += `<td class="${key}">${obj[key]}</td>`;
		  }else{
			 tr += `
				<td class="${key}">
				   <a href="#" class="link" data-num="${obj["num"]}">${obj[key]}</a>
				</td>
			 `;
		  }
	   }
	   tr += `</tr>`;
	   //tbody 태그에 tr 태그를 추가
	   $("tbody").append(tr);
	}
 }
 
 
 //게시글에 빈 항목이 있는지 없는지 알려주는 함수
 function checkBoard(board){
	if(!board){
	   return false;
	}
	if(typeof board != "object"){
	   return false;
	}
	//제목체크. trim : 앞 뒤 공백 지워줌
	if(!board["title"].trim().length){
	   return false;
	}
	//작성자 체크
	if(!board["writer"].trim().length){
	   return false;
	}
	//내용 체크
	if(!board["content"].trim().length){
	   return false;
	}
	return true;
 }

 //form 태그의 입력값들을 초기화하는 함수
 function initForm(){
	$(".input").val("");
 }