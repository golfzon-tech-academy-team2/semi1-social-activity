<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<script>

	function enterPressed(e) {
		if (e.keyCode == 13) {
			pw_check();
		}
	}
	
	function pw_check() {
		var pwCheckForm = document.pwcheck;
		var pw = pwCheckForm.pw.value;

		if (pw.length == 0 || pw == "") {
			alert("비밀번호를 입력하세요.");
		} else {
			$("#pwcheck").attr("action", "mypage.do");
			$("#pwcheck").submit();
		}
	}
</script>

</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<h3>비밀번호 확인</h3>
	<form id="pwcheck" name="pwcheck" method="post">
		<input type="password" id="pw" name="pw" value="" onkeypress="enterPressed(event)">
		<input type="button" value="비밀번호 확인" onclick="pw_check()">
	</form>
</body>
</html>