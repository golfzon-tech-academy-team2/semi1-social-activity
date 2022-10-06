<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.101.0">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
<title>로그인</title>


<!-- <link href="css/login2.css" rel="stylesheet"> -->

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
		<jsp:include page="../top_menu.jsp"></jsp:include>
<body>

	<main class="form-signin w-100 m-auto">
	<div  style="padding:50px">
		<form id="signin" name="signin" method="post" style="width:300px" class="m-auto">

			<h1 class="h3 mb-3 fw-normal text-center">로그인</h1>

			<div class="form-floating">
				<input type="text" placeholder="ID" id="id" name="id" value=""
					class="form-control"> <label for="id">ID</label>
			</div>
			<div class="form-floating">
				<input type="password" placeholder="PW" id="pw" name="pw" value=""
					class="form-control" placeholder="Password" onkeypress="enterPressed(event)"> <label
					for="pw">Password</label>
			</div>

			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<!-- <input type="button" value="로그인" onclick="login()"> -->
			<button type="button" value="로그인" onclick="login()"
				class="w-100 btn btn-lg btn-primary" onkeypress="enterPressed(event)">로그인</button>

			<p>
				아직 회원이 아니신가요? <a href="signup.do">회원가입</a>
			</p>
		</form>
	</div>
	
</main>

</body>
</html>
