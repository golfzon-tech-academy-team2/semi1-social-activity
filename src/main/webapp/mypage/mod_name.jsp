<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>이름 수정</title>
<script>
	function mod_name() {
		var modNameForm = document.modname;
		var uname = modNameForm.uname.value;

		if (uname.length == 0 || uname == "") {
			alert("이름을 입력하세요.");
		} else {
			$("#modname").attr("action", "mod_nameOK.do");
			$("#modname").submit();
		}
	}
</script>

</head>
<body>
	<h3>이름 수정</h3>

	<form id="modname" name="modname" method="post">
		<label for="uname">이름 :</label>
		<input type="text" id="uname" name="uname" value="">
		<input type="button" value="수정하기" onclick="mod_name()">
	</form>
</body>
</html>