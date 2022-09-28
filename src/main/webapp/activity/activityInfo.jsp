<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액티비티 상세페이지</title>
</head>
<body>
	<h3>${vo.aName} 액티비티 정보</h3>
	
	<table>
		<tr>
			<td>액티비티명 : </td>
			<td>${vo.aName }</td>
		</tr>
		<tr>
			<td>액티비티 내용 : </td>
			<td>${vo.aContent }</td>
		</tr>
		<tr>
			<td>활동 시작 날짜 : </td>
			<td>${vo.aStartDay }</td>
		</tr>
		<tr>
			<td>활동 마감 날짜 : </td>
			<td>${vo.aEndDay }</td>
		</tr>
		<tr>
			<td>활동 지역 : </td>
			<td>${vo.location }</td>
		</tr>
		<tr>
			<td>모집 시작 날짜 : </td>
			<td>${vo.startDate }</td>
		</tr>
		<tr>
			<td>모집 마감 날짜 : </td>
			<td>${vo.endDate }</td>
		</tr>
		<tr>
			<td>모집 종료 여부 : </td>
			<c:if test="${today gt vo.endDate}">
				<td>모집 종료</td>
			</c:if>
			<c:if test="${today le vo.endDate}">
				<td>모집 중</td>
			</c:if>
		</tr>
		<tr>
			<td>최소 나이 : </td>
			<td>${vo.minAge }</td>
		</tr>
		<tr>
			<td>최대 나이 : </td>
			<td>${vo.maxAge }</td>
		</tr>
		<tr>
			<td>성별 : </td>
			<c:if test="${vo.sex eq 'M'}">
				<td>남자</td>
			</c:if>
			<c:if test="${vo.sex eq 'F'}">
				<td>여자</td>
			</c:if>
			<c:if test="${vo.sex eq 'X'}">
				<td>상관없음</td>
			</c:if>
		</tr>
		<tr>
			<td>최대 인원 수 : </td>
			<td>${vo.maxPerson }</td>
		</tr>
		
	</table>
</body>
</html>