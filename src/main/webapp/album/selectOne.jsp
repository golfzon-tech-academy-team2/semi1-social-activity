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
	<div class="container">
	<table>
		<tr>
			<th>게시자</th>
			<td colspan="5">${vo.uName}</td>
		</tr>
		<tr>
			<c:if test="${vo.type eq 'video'}">
				<video src="gallery/${vo.fileName}" controls> 이 브라우저에서 지원하지
					않는 영상입니다.
				</video>
			</c:if>
			<c:if test="${vo.type eq 'image'}">
				<img class="card-img-top" src="gallery/${vo.fileName}"
					alt="Card image" style="width: 300px">
			</c:if>
		</tr>
	</table>
	<button class="btn btn-primary" onclick="location.href='ab_selectAll.do?gNum=${param.gNum}'">목록으로 돌아가기</button>
	<button class="btn btn-primary" onclick="location.href='ab_delete.do?aNum=${vo.aNum}&gNum=${param.gNum}'">삭제하기</button>
	</div>
</body>
</html>