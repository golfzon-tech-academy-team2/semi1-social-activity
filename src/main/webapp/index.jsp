<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Social Activity</title>
</head>
<body>
<h3>소셜 액티비티 (임시)</h3>
<jsp:include page="top_menu.jsp"></jsp:include>

<c:choose>
		<c:when test="${signedid == null}">
			<a href="login.do">로그인</a>
			<a href="signup.do">회원가입</a>
		</c:when>
		<c:otherwise>
			${signedid}
			<a href="pw_check.do">마이페이지</a>
			<a href="logout.do">로그아웃</a>
		</c:otherwise>
</c:choose>

</body>
</html>