<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>주소 수정</title>
<script>
	function mod_addr() {
		var modAddrForm = document.modaddr;
		var addr = modAddrForm.addr.value;

		if (addr.length == 0 || addr == "") {
			alert("주소를 입력하세요.");
		} else {
			$("#modaddr").attr("action", "mod_addrOK.do");
			$("#modaddr").submit();
		}
	}
</script>
</head>
<body>
	<a href="index.do">홈</a>
	<hr>
	<h3>주소 수정</h3>
	
	<form id="modaddr" name="modaddr" method="post">
		<label for="addr">주소 :</label>
		<input type="text" id="addr" name="addr" value="">
		<input type="button" value="수정하기" onclick="mod_addr()">
	</form>
</body>
</html>