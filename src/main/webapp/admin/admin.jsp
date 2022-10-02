<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모임 운영자용 관리페이지</title>
</head>
<body>
<table class="table">
			<thead>
				<tr>
					<th>모임 번호</th>
					<th>모임 이름</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos}">
					<tr class="data" onclick="location.href='ad_selectOne.do?gNum=${vo.gNum }'">
						<td>${vo.gNum}</td>
						<td>${vo.gName }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>