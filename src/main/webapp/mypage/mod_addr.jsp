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
<body class="text-center" >
	<main class="form-signin w-100 m-auto">
			<form id="modaddr" name="modaddr" method="post">

			<h1 class="h3 mb-3 fw-normal">주소수정</h1>
			<div class="form-floating">
				<input type="text" id="addr" name="addr" value=""
					class="form-control" placeholder="Address"> <label
					for="floatingPassword">주소</label>
			</div>

			<button type="button" value="수정하기" onclick="mod_addr()" class="w-100 btn btn-lg btn-primary">수정하기</button>

		</form>
	</main>
</body>
</html>