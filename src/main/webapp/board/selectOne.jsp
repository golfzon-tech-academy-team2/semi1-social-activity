<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.1.min.js" crossorigin="anonymous"></script>
<style>
table {
	width: 100%;
	border: 1px solid #444444;
}

th, td {
	border: 1px solid #444444;
}
</style>
<script type="text/javascript">
	function deleteConfirm() {

		if (confirm("삭제 하시겠습니까?")) {
			location = "b_deleteOK.do?bNum=${vo.bNum}&gNum=${param.gNum}";	
		}
	}
</script>
<script>
$(function() {
    console.log("ready....");

    $(".modify").on('click',function(){
       console.log("click....");
       $.ajax({
          url:"isSameWriter.do?id=${vo.id}",
          type:"get",
          dataType:"text",//xml,html,text
          success : function(responseTxt,status,obj){
              console.log(responseTxt);
              console.log(status);
              console.log(obj);
              if(responseTxt=="{t}"){
              	console.log("됨요");
              	location = "b_update.do?bNum=${param.bNum}&gNum=${param.gNum}";
              }else{
              	alert('다른 회원의 글은 수정이 불가능합니다.');
              	$("input:checkbox[id='isOL']").prop("checked",false);
              }
           },
           error:function(xhr,status,error){
              console.log("error:function....",status);
              
           }
       });
       
    });
 });
</script>
</head>
<body>
	<table>
		<tr>
			<th>글 번호</th>
			<td>${param.tmpBnum}</td>
			<th>작성일</th>
			<td>${vo.wDate}</td>
			<th>작성일</th>
			<td>${vo.wDate}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="5">${vo.bTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="5" rowspan="3">${vo.bContent}</td>
		</tr>
	</table>
	<button onclick="location.href='gatheringinfo.do?gnum=${param.gNum}'">목록</button>
	<button class="modify">수정</button>
	<button onclick="deleteConfirm()">삭제</button>
</body>
</html>