<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색 결과</title>
</head>
<body>
	<a href="index.do">홈</a>
	
	<hr>
	
	<h3>검색 결과</h3>
	
	<table border="1">
		<tr>
			<th>액티비티 명</th>
			<th>액티비티 내용</th>
			<th>활동 시작 날짜</th>
			<th>활동 마지막 날짜</th>
			<th>활동 지역</th>
			<th>모집 시작 날짜</th>
			<th>모집 마감 날짜</th>
			<th>현재 모집 인원</th>
			<th>모집 최소 나이</th>
			<th>모집 최대 나이</th>
			<th>성별</th>
			<th>최대 인원</th>
			<th>활동 상태</th>
		</tr>
		<c:forEach var="vo" items="${vos}">
        <tr>
        	<td>${vo.aName }</td>
            <td>${vo.aContent }</td>
            <td>${vo.aStartDay }</td>
            <td>${vo.aEndDay }</td>
            <td>${vo.location }</td>
            <td>${vo.startDate }</td>
            <td>${vo.endDate }</td>
            <td>${vo.personCnt }</td>
            <td>${vo.minAge }</td>
            <td>${vo.maxAge }</td>
            <td>${vo.sex }</td>
            <td>${vo.maxPerson }</td>
            <fmt:formatDate var="today2" value="${today}" pattern="yyyy-MM-dd"/>
            <c:if test="${today lt vo.aStartDay }">
            	<td>활동 전</td>
            </c:if>
            <c:if test="${today ge vo.aStartDay && today le vo.aEndDay }">
            	<td>활동 중</td>
            </c:if>
            <c:if test="${today gt vo.aEndDay }">
            	<td>활동 후</td>
            </c:if>
            <td><a href="activityInfo.do?aNum=${vo.aNum }">상세 보기</a></td>
        </tr>
	</c:forEach>
	</table>
	
</body>
</html>