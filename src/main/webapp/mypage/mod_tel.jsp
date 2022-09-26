<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>전화번호 수정</title>
<script>
	function mod_tel() {
		var modTelForm = document.modtel;
		var tel = modTelForm.tel.value;

		if (tel.length == 0 || tel == "") {
			alert("전화번호를 입력하세요.");
		} else {
			$("#modtel").attr("action", "mod_telOK.do");
			$("#modtel").submit();
		}
	}
</script>
</head>
<body>
	<h3>전화번호 수정</h3>
	
	<form id="modtel" name="modtel" method="post">
		<label for="tel">전화번호 :</label>
		<input type="text" id="tel" name="tel" value="">
		<input type="button" value="수정하기" onclick="mod_tel()">
	</form>
</body>
</html>