<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>액티비티 생성</title>
</head>
<script>
	function aNameRes() {
		var creActForm = document.creAct;
		var aName = creActForm.aName.value;
		if (aName.length <= 1) {
			alert("액티비티명은 최소 두 자리 이상이어야합니다");
		} 
	}
	
	function aContentRes() {
		var creActForm = document.creAct;
		var aContent = creActForm.aContent.value;
		if (aContent.length <= 5) {
			alert("액티비티 내용은 최소 다섯 글자 이상이어야합니다");
		} 
	}
	
	function endDateRes() {
		var creActForm = document.creAct;
		var startDate = creActForm.startDate.value;
		var endDate = creActForm.endDate.value;
		if (startDate > endDate) {
			alert("모집 마감 날짜는 모집 시작 날짜보다 뒤에 있어야합니다");
		} 
	}
	
	function aStartDayRes() {
		var creActForm = document.creAct;
		var aStartDay = creActForm.aStartDay.value;
		var endDate = creActForm.endDate.value;
		if (aStartDay <= endDate) {
			alert("활동 시작 날짜는 모집 마감 날짜보다 뒤에 있어야합니다");
		} 
	}
	
	function aEndDayRes() {
		var creActForm = document.creAct;
		var aEndDay = creActForm.aEndDay.value;
		var aStartDay = creActForm.aStartDay.value;
		if (aStartDay > aEndDay) {
			alert("활동 마감 날짜는 활동 시작 날짜보다 뒤에 있어야합니다");
		} 
	}
	
	function minAgeRes() {
		var creActForm = document.creAct;
		var minAge = creActForm.minAge.value;
		var maxAge = creActForm.maxAge.value;
		if (minAge > maxAge) {
			alert("최소 나이는 최대 나이보다 작아야합니다")
		}
	}
	
	function maxAgeRes() {
		var creActForm = document.creAct;
		var minAge = creActForm.minAge.value;
		var maxAge = creActForm.maxAge.value;
		if (minAge > maxAge) {
			alert("최대 나이는 최소 나이보다 커야합니다")
		}
	}

	function createActivity() {
		var creActForm = document.creAct;
		var aName = creActForm.aName.value;
		var aContent = creActForm.aContent.value;
		var startDate = creActForm.startDate.value;
		var endDate = creActForm.endDate.value;
		var location = creActForm.location.value;
		var aStartDay = creActForm.aStartDay.value;
		var aEndDay = creActForm.aEndDay.value;
		var minAge = creActForm.minAge.value;
		var maxAge = creActForm.maxAge.value;
		var sex = creActForm.sex.value;
		var maxPerson = creActForm.maxPerson.value;
		
		if (aName == "" || aName.length == 0) {
			alert("액티비티명을 입력하세요");
		} else if (aContent == "" || aContent.length == 0) {
			alert("액티비티 내용을 입력하세요");
		} else if (startDate == "" || startDate.length == 0) {
			alert("모집 시작 날짜를 입력하세요");
		} else if (endDate == "" || endDate.length == 0) {
			alert("모집 마감 날짜를 입력하세요");
		} else if (location == "" || location.length == 0) {
			alert("활동 지역을 입력하세요");
		} else if (aStartDay == "" || aStartDay.length == 0) {
			alert("활동 시작 날짜를 입력하세요");
		} else if (aEndDay == "" || aEndDay.length == 0) {
			alert("활동 마감 날짜를 입력하세요");
		} else if (startDate > endDate) {
			alert("모집 마감 날짜는 모집 시작 날짜보다 뒤에 있어야합니다");
		} else if (aStartDay <= endDate) {
			alert("활동 시작 날짜는 모집 마감 날짜보다 뒤에 있어야합니다");
		} else if (aStartDay > aEndDay) {
			alert("활동 마감 날짜는 활동 시작 날짜보다 뒤에 있어야합니다");
		} else if (minAge > maxAge) {
			alert("최소 나이는 최대 나이보다 작아야합니다");
		} else {
			$("#creAct").attr("action", "creActOK.do"); // attribute setting
			$("#creAct").submit();
		}
	}
</script>
<body>
	<a href="index.do">홈</a>
	<hr>
	<h1>${vo.gName }</h1>
	<h3> 모임의 액티비티 생성</h3>
	
	<form id="creAct" name="creAct" method="post">
		<input type="hidden" id="gNum" name="gNum" value="${vo.gNum }">
		<table>
			<tr>
				<td><label for="aName">액티비티 명 :</label></td>
				<td><input type="text" id="aName" name="aName" value="" onblur="aNameRes()"></td>
			</tr>
			<tr>
				<td><label for="aContent">액티비티 내용 :</label></td>
				<td><input type="text" id="aContent" name="aContent" value="" onblur="aContentRes()"></td>
			</tr>
			<tr>
				<td><label for="startDate">모집 시작 날짜 :</label></td>
				<td><input type="date" id="startDate" name="startDate" value="${today }"
					min="${today }"></td>
			</tr>
			<tr>
				<td><label for="endDate">모집 마감 날짜 :</label></td>
				<td><input type="date" id="endDate" name="endDate" value=""
					min="${today }"  onblur="endDateRes()"></td>
			</tr>
			<tr>
				<td><label for="location">활동 지역 :</label></td>
				<td><input type="text" id="location" name="location"
					value=""></td>
			</tr>
			<tr>
				<td><label for="aStartDay">활동 시작 날짜 :</label></td>
				<td><input type="date" id="aStartDay" name="aStartDay" value=""
					min="${today }" onblur="aStartDayRes()"></td>
			</tr>
			<tr>
				<td><label for="aEndDay">활동 마감 날짜 :</label></td>
				<td><input type="date" id="aEndDay" name="aEndDay" value=""
					min="${today }" onblur="aEndDayRes()"></td>
			</tr>
			<tr>
				<td><label for="minAge">최소 나이 :</label></td>
				<td>
					<select id="minAge" name="minAge" onblur="minAgeRes()">
						<option value="1" selected>1</option>
						<c:forEach var="cnt" begin="2" end="98">
							<option value="${cnt }">${cnt }</option>
						</c:forEach>
						<option value="99">99</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="maxAge">최대 나이 :</label></td>
				<td>
					<select id="maxAge" name="maxAge" onblur="maxAgeRes()">
						<option value="1">1</option>
						<c:forEach var="cnt" begin="2" end="98">
							<option value="${cnt }">${cnt }</option>
						</c:forEach>
						<option value="99" selected>99</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="sex">성별 :</label></td>
				<td>
					<select id="sex" name="sex">
						<option>남자</option>
						<option>여자</option>
						<option>상관없음</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><label for="maxPerson">최대 참가 가능 인원 :</label></td>
				<td>
				<select>
						<c:forEach var="cnt" begin="1" end="${gatheringUserNum }">
							<option value="${cnt }">${cnt }</option>
						</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="button" value="액티비티 생성하기" onclick="createActivity()">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>