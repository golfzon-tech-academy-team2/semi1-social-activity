<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>주소 수정</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">


<link href="css/mod.css" rel="stylesheet">
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
<body class="text-center" >
	<main class="form-signin w-100 m-auto">
			<form id="modtel" name="modtel" method="post">

			<h1 class="h3 mb-3 fw-normal">전화번호수정</h1>
			<div class="form-floating">
				<input type="text" id="tel" name="tel" value=""
					class="form-control" placeholder="Tel"> <label
					for="floatingPassword">전화번호</label>
			</div>

			<button type="button" value="수정하기" onclick="mod_tel()" class="w-100 btn btn-lg btn-primary">수정하기</button>

		</form>
	</main>
</body>
</html>