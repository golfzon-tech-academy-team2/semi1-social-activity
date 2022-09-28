<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생성완료</title>
<script>
	function btnClose() {
		opener.parent.location.reload();
		window.close();
	}
</script>
</head>
<body>
	<p>이벤트 생성이 완료되었습니다</p>
	<input type="button" value="창 닫기" onclick="btnClose()">
</body>
</html>