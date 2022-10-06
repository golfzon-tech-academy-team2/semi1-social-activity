<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>회원가입</title>
<!-- <link href="css/signup.css" rel="stylesheet"> -->



<script>
	function fn_signup() {
		
		var signupForm = document.signup;
		var name = signupForm.uname.value;
		var id = signupForm.id.value;
		var pw = signupForm.pw.value;
		var pw_check = signupForm.pw_check.value;
		var sex = signupForm.sex.value;
		var addr = signupForm.addr.value;
		var tel = signupForm.tel.value;
		var bday = signupForm.bday.value;

		if (name.length == 0 || name == "") {
			alert("이름을 입력하세요.");
		} else if (id.length == 0 || id == "") {
			alert("아이디를 입력하세요.");
		} else if (signupForm.isDuplication.value != "idCheck") {
			alert("아이디 중복체크를 해주세요.");
		} else if (pw.length == 0 || pw == "") {
			alert("비밀번호를 입력하세요.");
		} else if (pw_check.length == 0 || pw_check == "") {
			alert("비밀번호를 다시 입력하세요.");
		} else if (addr.length == 0 || addr == "") {
			alert("주소를 입력하세요.");
		} else if (tel.length == 0 || tel == "") {
			alert("전화번호를 입력하세요.");
		} else if (bday.length == 0 || bday == "") {
			alert("생년월일을 입력하세요.");
		} else if (pw != pw_check) {
			alert("비밀번호가 일치하지 않습니다.");
		} else {
			$("#signup").attr("action", "signupOK.do"); // attribute setting
			$("#signup").submit();
		}

	}

	function fn_dbCheckId() {
		var form = document.signup;
		var id = form.id.value;
		if (id.length == 0 || id == "") {
			alert("아이디를 입력해주세요.");
			form.id.focus();
		} else {
			window.open("${contextPath}/social-activity/idCheck.do?user_id="
					+ id, "", "width = 500, height = 300");
		}
	}
</script>

</head>
<body class="bg-light">
	<jsp:include page="../top_menu.jsp"></jsp:include>

	<div class="container">
		<main>
			<div class="py-5 text-center">

				<h2>회원가입</h2>
			</div>

			<div class="row g-5"
				style="display: block; width: 70%; margin: auto;">

				<div class="col-md-7 col-lg-8 test" style="width: 100%">
					<!--             <div class="col-md-7 col-lg-8 test" > -->



					<form id="signup" name="signup" method="post"
						class="needs-validation" novalidate>
						<div class="row g-3">

							<div class="col-12">
								<label for="uname" class="form-label">이름 <span
									class="text-muted"></span></label> <input type="text" id="uname"
									name="uname" value="" class="form-control" placeholder="홍길동">

							</div>

							<div class="col-12">
								<label for="id" class="form-label">아이디 <span
									class="text-muted"></span></label> <input type="text" id="id" name="id"
									value="" class="form-control" style="width: 80%">
								<button type="button" onclick="fn_dbCheckId()" name="dbCheckId"
									class="checkId btn btn-primary btn-lg">중복체크</button>
								<input type="hidden" id="isDuplication" name="isDuplication"
									value="idUncheck">

							</div>


							<div class="col-12">
								<label for="pw" class="form-label">비밀번호 <span
									class="text-muted"></span></label> <input type="password" id="pw"
									name="pw" value="" class="form-control"
									placeholder="비밀번호 입력하세요">

							</div>

							<div class="col-12">
								<label for="pw_check" class="form-label">비밀번호재확인</label> <input
									type="password" id="pw_check" name="pw_check" value=""
									class="form-control" placeholder="비밀번호 입력하세요">

							</div>

							<div class="my-3">
								<label for="div_check" class="form-label">성별체크</label>
								<div id="div_check" class="form-check">
									<input id="man" name="sex" type="radio" value="남자"
										class="form-check-input" checked required> <label
										class="form-check-label" for="man">남자</label>
								</div>
								<div class="form-check">
									<input id="women" name="sex" type="radio" value="여자"
										class="form-check-input" required> <label
										class="form-check-label" for="women">여자 </label>
								</div>
							</div>

							<div class="col-12">
								<label for="addr" class="form-label">주소</label> <input
									type="text" id="addr" name="addr" value="" class="form-control"
									placeholder="주소를 입력하세요">

							</div>


							<div class="col-12">
								<label for="tel" class="form-label">전화번호</label> <input
									type="text" id="tel" name="tel" value="" class="form-control"
									placeholder="전화번호를 입력하세요">

							</div>


							<div class="col-12">
								<label for="addr" class="form-label">생년월일</label> <input
									type="date" id="bday" name="bday" class="form-control"
									placeholder="생년월일을 입력하세요">

							</div>



							<input class="w-100 btn btn-primary btn-lg" type="button"
								value="회원가입" onclick="fn_signup()" style="margin-top: 50px">
						</div>
					</form>
				</div>
			</div>
		</main>

	</div>


	<script src="resource/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>