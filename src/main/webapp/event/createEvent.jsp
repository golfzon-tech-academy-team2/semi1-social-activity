<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>이벤트 생성</title>
</head>
<script>
	function createE() {
		var creEvent = document.createEvent;
		var openSignupform = opener.document.signup;
		
		var eTitle = creEvent.eTitle.value;
		var eContent = creEvent.eContent.value;
		var gift = creEvent.gift.value;
		
		if(eTitle == "" || eTitle.length == 0) {
			alert("제목이 비었습니다");
		} else if (eContent == "" || eContent.length == 0) {
			alert("내용이 비었습니다");
		} else if (gift == "" || gift.length == 0) {
			alert("상품이 비었습니다");
		} else if (eTitle.length < 2) {
			alert("제목은 두 글자 이상이어야합니다");
		} else if (eContent.length < 2) {
			alert("내용은 두 글자 이상이어야합니다");
		} else if (gift.length < 2) {
			alert("상품은 두 글자 이상이어야합니다");
		} else {
			$("#createEvent").attr("action", "createEventOK.do"); // attribute setting
			$("#createEvent").submit();
		}
	}
</script>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form id="createEvent" name="createEvent" method="post">
		<table>
			<tr>
				<td>제목 : </td>
				<td><input type="text" id="eTitle" name="eTitle" value=""></td>
			</tr>
			<tr>
				<td>내용 : </td>
				<td><input type="text" id="eContent" name="eContent" value=""></td>
			</tr>
			<tr>
				<td>상품  : </td>
				<td><input type="text" id="gift" name="gift" value=""></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="이벤트 생성하기" onclick="createE()"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="aNum" id="aNum" value="${aNum }"></td>
			</tr>
		</table>
	</form>
</body>
</html>