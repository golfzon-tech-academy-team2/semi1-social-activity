<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마이페이지-비밀번호확인</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
<link href="css/pw_check.css" rel="stylesheet">
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


<body class="text-center">
	<main class="form-signin w-100 m-auto">
		<form id="pwcheck" name="pwcheck" method="post">

			<h1 class="h3 mb-3 fw-normal">비밀번호 확인</h1>
			<div class="form-floating">
				<input type="password" id="pw" name="pw" value="" class="form-control" placeholder="Password" onkeypress="enterPressed(event)"> 
				<label for="floatingPassword">Password</label>
			</div>

			<button type="button" value="비밀번호 확인" onclick="pw_check()" class="w-100 btn btn-lg btn-primary" >확인</button>
			
		</form>
	</main>

</body>
</html>
