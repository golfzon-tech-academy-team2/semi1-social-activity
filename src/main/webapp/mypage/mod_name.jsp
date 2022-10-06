<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>이름 수정</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">


<link href="css/mod.css" rel="stylesheet">
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
<body class="text-center" >
	<main class="form-signin w-100 m-auto">
		<form id="modname" name="modname" method="post">

			<h1 class="h3 mb-3 fw-normal">실명수정</h1>
			<div class="form-floating">
				<input type="text" id="uname" name="uname" value=""
					class="form-control" placeholder="Password"> <label
					for="floatingPassword">이름</label>
			</div>

			<button type="button" value="수정하기" onclick="mod_name()" class="w-100 btn btn-lg btn-primary">수정하기</button>

		</form>
	</main>

</body>
</html>