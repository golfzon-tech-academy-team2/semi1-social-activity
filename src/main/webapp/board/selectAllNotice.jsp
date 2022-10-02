<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
			<jsp:include page="../top_menu.jsp"></jsp:include>
			<table class="table">
			<thead>
				<tr>
					<th>게시글 번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos}">
					<tr class="data"
						onclick="location.href='b_selectOneNotice.do?bNum=${vo.bNum }&gNum=${param.gNum}&tmpBnum=${vo.tmpBnum}'">
						<td>${vo.tmpBnum}</td>
						<td>${vo.bTitle }</td>
						<td>${vo.wName }</td>
						<td>${vo.wDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button onclick="location.href='gatheringinfo.do?gnum=${param.gNum}'">모임으로 돌아가기</button>
</body>
</html>