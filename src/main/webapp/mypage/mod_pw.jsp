<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>비밀번호 수정</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">


<link href="css/mod.css" rel="stylesheet">
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
<body class="text-center">
	<main class="form-signin w-100 m-auto">
		<form id="modpw" name="modpw" method="post">
			<h1 class="h3 mb-3 fw-normal">비밀번호수정</h1>
			<div class="form-floating">
				<input type="password" id="pw" name="pw" value=""
					class="form-control" placeholder="Password"> <label
					for="floatingPassword">비밀번호</label>
			</div>
			<div class="form-floating">
				<input type="password" id="pw_check" name="pw_check" value=""
					class="form-control" placeholder="Password"> <label
					for="floatingPassword">비밀번호확인</label>
			</div>
			<button type="button" value="수정하기" onclick="mod_pw()"
				class="w-100 btn btn-lg btn-primary">수정하기</button>

		</form>
		</main>>
</body>
</html>