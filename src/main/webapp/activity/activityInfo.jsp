<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액티비티 상세페이지</title>
<script>
	function createEvent() {
		var url = "createEvent.do?aNum=${vo.aNum}";
		var name = "createEvent";
		var option = "width = 500px, height = 400px location = no";
		
		window.open(url, name, option);
	}
	
	function deleteEvent() {
		if (!confirm("이벤트를 삭제하시겠습니까?")) {
		} else {
			var aNum = document.getElementById('aNum').value;
			var eNum = document.getElementById('eNum').value;
			location.href = "deleteEvent.do?aNum=" + aNum + "&eNum=" + eNum;
		}
	}
	
	function deleteActivity() {
		if (!confirm("액티비티를 삭제하시겠습니까?")) {
		} else {
			location.href = "deleteActivity.do?aNum=" + ${vo.aNum};
		}
	}
</script>
</head>
<body>
	<a href="index.do">홈</a>
	<hr>
	
	<input type="button" id="joinActivity" name="joinActivity" value="액티비티 가입하기" onclick="joinActivity()">
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
			<fmt:formatDate var="today" value="${today }" pattern="yyyy-MM-dd"/>
			<c:if test="${today gt vo.endDate}">
				<td>모집 종료</td>
			</c:if>
			<c:if test="${today le vo.endDate && today ge vo.startDate}">
				<td>모집 중</td>
			</c:if>
			<c:if test="${today lt vo.endDate}">
				<td>모집 전</td>
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
	
	<p><a href="javascript:createEvent()">이벤트 생성</a></p>
	
	<hr>
	
	<h4>액티비티 조편성</h4>
	
	<hr>
	
	<h4>액티비티 이벤트</h4>
	
	<div style="overflow:auto; width:1000px; height:150px;">
		<table border="1">
			<c:if test="${vos.size() ne 0}">
				<th>이벤트 제목</th>
				<th>이벤트 내용</th>
				<th>이벤트 상품</th>
			</c:if>
			<c:if test="${vos.size() eq 0}">
				<p>생성된 이벤트 없음</p>
			</c:if>
			<c:forEach var="vo2" items="${vos}">
		        <tr>
		            <td>${vo2.eTitle }</td>
		            <td>${vo2.eContent }</td>
		            <td>${vo2.gift }</td>
		            <td><input type="button" id="deleteEvent" name="deleteEvent" value="이벤트 삭제하기" onclick="deleteEvent()"></td>
		            
		        	<input type="hidden" id="aNum" name="aNum" value="${vo2.aNum }">
		        	<input type="hidden" id="eNum" name="eNum" value="${vo2.eNum }">
		        </tr>
	        </c:forEach>
		</table>
	</div>
	
	<hr>
	
	<input type="button" id="deleteActivity" name="deleteActivity" onclick="deleteActivity()" value="액티비티 삭제하기">
</body>
</html>