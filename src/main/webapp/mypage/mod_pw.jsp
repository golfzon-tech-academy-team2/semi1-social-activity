<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>비밀번호 수정</title>
<script>
	function mod_pw() {
		var modPwForm = document.modpw;
		var pw = modPwForm.pw.value;
		var pw_check = modPwForm.pw_check.value;

		if (pw.length == 0 || pw == "") {
			alert("비밀번호를 입력하세요");
		} else if (pw_check.length == 0 || pw_check == "") {
			alert("비밀번호 확인을 입력하세요")
		} else {
			if (pw != pw_check) {
				alert("비밀번호가 틀립니다")
			} else {
				$("#modpw").attr("action", "mod_pwOK.do");
				$("#modpw").submit();
			}
		}
	}
</script>
</head>
<body>
	<h3>비밀번호 수정</h3>
	
	<form id="modpw" name="modpw" method="post">
		<table>
			<tr>
				<td><label for="pw">비밀번호 :</label></td>
				<td><input type="password" id="pw" name="pw" value=""></td>
			</tr>
			<tr>
				<td><label for="pw_check">비밀번호 확인 :</label></td>
				<td><input type="password" id="pw_check" name="pw_check" value=""></td>
				<td><input type="button" value="수정하기" onclick="mod_pw()"></td>
			</tr>
		</table>
	</form>
</body>
</html>