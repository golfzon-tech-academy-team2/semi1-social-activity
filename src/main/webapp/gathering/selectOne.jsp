<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<table class="table">
		<tr>
			<th>모임 이름</th>
			<td>${vo.gName}</td>
		</tr>
		<tr>
			<th>모임 내용</th>
			<td>${vo.gContent}</td>
		</tr>
		<tr>
			<th>운영자</th>
			<td>${vo.uName}</td>
		</tr>
		<tr>
			<th>앰블럼</th>
			<td colspan="2"><img width="100" alt="imgName"
				src="gEmblem/${vo.logo}"></td>
		</tr>
		<tr>
			<th>가입 최소 나이</th>
			<td>${vo.minAge}</td>
		</tr>
		<tr>
			<th>가입 가능 최대나이</th>
			<td>${vo.maxAge}</td>
		</tr>
		<tr>
			<th>가입 가능 성별</th>
			<c:if test="${vo.sex eq 'X'}">
				<td>상관 없음</td>
			</c:if>
			<c:if test="${vo.sex eq 'F'}">
				<td>여성</td>
			</c:if>
			<c:if test="${vo.sex eq 'M'}">
				<td>남성</td>
			</c:if>
		</tr>
	</table>
	<button onclick="location.href='joinPubGathering.do?gNum=${param.gNum}'" class="btn btn-primary">가입하기</button>
</body>
</html>