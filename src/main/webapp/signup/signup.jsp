<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>회원가입</title>
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
			window.open("${contextPath}/social-activity/idCheck.do?user_id=" + id, "", "width = 500, height = 300");
		}
	}
</script>
</head>
<body>
	<form id="signup" name="signup" method="post">
		<table>
			<tr>
				<td><label for="uname">이름 :</label></td>
				<td><input type="text" id="uname" name="uname"
					value=""></td>
			</tr>
			<tr>
				<td><label for="id">아이디 :</label></td>
				<td><input type="text" id="id" name="id"
					value=""></td>
				<td>
					<button type="button" onclick="fn_dbCheckId()" name="dbCheckId" class="checkId">
						중복체크
					</button>
				</td>
				<input type="hidden" id="isDuplication" name="isDuplication" value="idUncheck"/>
			</tr>
			<tr>
				<td><label for="pw">비밀번호 :</label></td>
				<td><input type="password" id="pw" name="pw"
					value=""></td>
			</tr>
			<tr>
				<td><label for="pw_check">비밀번호 재확인 :</label></td>
				<td><input type="password" id="pw_check" name="pw_check"
					value=""></td>
			</tr>
			<tr>
				<td><label for="sex">성 :</label></td>
				<td>
					<select id="sex" name="sex">
						<option>남자</option>
						<option>여자</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="addr">주소 :</label></td>
				<td><input type="text" id="addr" name="addr"
					value=""></td>
			</tr>
			<tr>
				<td><label for="tel">전화번호 :</label></td>
				<td><input type="text" id="tel" name="tel"
					value=""></td>
			</tr>
			<tr>
				<td><label for="bday">생년월일 :</label></td>
				<td>
					<input type="date" id="bday" name="bday">
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="회원가입" onclick="fn_signup()"></td>
			</tr>
		</table>
	</form>
</body>
</html>