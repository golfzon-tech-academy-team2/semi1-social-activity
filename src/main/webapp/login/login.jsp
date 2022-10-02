<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>로그인</title>
<script>
	function enterPressed(e) {
		if (e.keyCode == 13) {
			login();
		}
	}

	function login() {
		var signinForm = document.signin;
		var id = signinForm.id.value;
		var pw = signinForm.pw.value;
		
		if (id.length == 0 || id == "") {
			alert("아이디를 입력하세요.");
		} else if (pw.length == 0 || pw == "") {
			alert("비밀번호를 입력하세요.");
		} else {
			$("#signin").attr("action", "loginOK.do");
			$("#signin").submit();
		}
	}
</script>
</head>

<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form id="signin" name="signin" method="post">
		<table>
			<tr>
				<td><label for="id">ID:</label></td>
				<td><input type="text" placeholder="ID" id="id" name="id"
					value=""></td>
			</tr>
			<tr>
				<td><label for="pw">PW:</label></td>
				<td><input type="password" placeholder="PW" id="pw" name="pw"
					value="" onkeypress="enterPressed(event)"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="로그인" onclick="login()"></td>
			</tr>
			
		</table>
	</form>
	
	<p>아직 회원이 아니신가요? <a href="signup.do">회원가입</a></p>
</body>
</html>