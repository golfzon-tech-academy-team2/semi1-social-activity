<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>마이페이지</title>
<script>
	
</script>
</head>
<body>
	<h3>마이페이지</h3>
	
	<table>
			<tr>
				<td><label for="uname">이름 :</label></td>
				<td>${vo.uname }</td>
				<td><a href="mod_name.do"><button id="modify_name" name="modify_name">실명 수정</button></a></td>
			</tr>
			<tr>
				<td><label for="pw">비밀번호 :</label></td>
				<td>**********</td>
				<td><a href="mod_pw.do"><button id="modify_pw" name="modify_pw">비밀번호 변경</button></a></td>
			</tr>
			<tr>
				<td><label for="addr">주소 :</label></td>
				<td>${vo.addr }</td>
				<td><a href="mod_addr.do"><button type="button" id="modify_addr" name="modify_addr">주소 수정</button></a></td>
			</tr>
			<tr>
				<td><label for="tel">전화번호 :</label></td>
				<td>${vo.tel }</td>
				<td><a href="mod_tel.do"><button type="button" id="modify_tel" name="modify_tel">전화번호 수정</button></a></td>
			</tr>
		</table>
	
	<br><br>
	
	<br><br>
	
	<br><br>
	
	<p><a href="signout.do">회원탈퇴</a></p>
	

</body>
</html>