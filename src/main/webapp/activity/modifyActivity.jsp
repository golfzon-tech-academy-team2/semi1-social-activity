<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>액티비티 정보 수정</title>
</head>
<script>
	function aNameRes() {
		var modActForm = document.modAct;
		var aName = modActForm.aName.value;
		if (aName.length <= 1) {
			alert("액티비티명은 최소 두 자리 이상이어야합니다");
		}
	}

	function aContentRes() {
		var modActForm = document.modAct;
		var aContent = modActForm.aContent.value;
		if (aContent.length <= 5) {
			alert("액티비티 내용은 최소 다섯 글자 이상이어야합니다");
		}
	}

	function startDateRes() {
		var modActForm = document.modAct;
		var startDate = modActForm.startDate.value;
		var endDate = modActForm.endDate.value;
		if (startDate > endDate) {
			alert("모집 시작 날짜는 모집 마감 날짜보다 뒤에 있어야합니다");
		}
	}

	function endDateRes() {
		var modActForm = document.modAct;
		var startDate = modActForm.startDate.value;
		var endDate = modActForm.endDate.value;
		if (startDate > endDate) {
			alert("모집 마감 날짜는 모집 시작 날짜보다 뒤에 있어야합니다");
		}
	}

	function aStartDayRes() {
		var modActForm = document.modAct;
		var aStartDay = modActForm.aStartDay.value;
		var endDate = modActForm.endDate.value;
		if (aStartDay <= endDate) {
			alert("활동 시작 날짜는 모집 마감 날짜보다 뒤에 있어야합니다");
		}
	}

	function aEndDayRes() {
		var modActForm = document.modAct;
		var aEndDay = modActForm.aEndDay.value;
		var aStartDay = modActForm.aStartDay.value;
		if (aStartDay > aEndDay) {
			alert("활동 마감 날짜는 활동 시작 날짜보다 뒤에 있어야합니다");
		}
	}

	function minAgeRes() {
		var modActForm = document.modAct;
		var minAge = modActForm.minAge.value;
		var maxAge = modActForm.maxAge.value;
		if (minAge > maxAge) {
			alert("최소 나이는 최대 나이보다 작아야합니다")
		}
	}

	function maxAgeRes() {
		var modActForm = document.modAct;
		var minAge = modActForm.minAge.value;
		var maxAge = modActForm.maxAge.value;
		if (minAge > maxAge) {
			alert("최대 나이는 최소 나이보다 커야합니다")
		}
	}

	function modifyActivity() {
		var modActForm = document.modAct;
		var aName = modActForm.aName.value;
		var aContent = modActForm.aContent.value;
		var startDate = modActForm.startDate.value;
		var endDate = modActForm.endDate.value;
		var location = modActForm.location.value;
		var aStartDay = modActForm.aStartDay.value;
		var aEndDay = modActForm.aEndDay.value;
		var minAge = modActForm.minAge.value;
		var maxAge = modActForm.maxAge.value;
		var sex = modActForm.sex.value;
		var maxPerson = modActForm.maxPerson.value;

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
			$("#modAct").attr("action", "modActOK.do"); // attribute setting
			$("#modAct").submit();
		}
	}
</script>
<body>
	<a href="index.do">홈</a>
	<hr>
	<h3>액티비티 정보 수정</h3>

	<form id="modAct" name="modAct" method="post">
		<input type="hidden" id="aNum" name="aNum" value="${vo.aNum }">
		<table>
			<tr>
				<td>액티비티명 :</td>
				<td><input type="text" id="aName" name="aName"
					value="${vo.aName }" onblur="aNameRes()">
			</tr>
			<tr>
				<td>액티비티 내용 :</td>
				<td><input type="text" id="aContent" name="aContent"
					value="${vo.aContent }" onblur="aContentRes()">
			</tr>
			<tr>
				<td>모집 시작 날짜 :</td>
				<td><input type="date" id="startDate" name="startDate"
					value="${vo.startDate }" min="${today }" onblur="startDateRes()">
			</tr>
			<tr>
				<td>모집 마감 날짜 :</td>
				<td><input type="date" id="endDate" name="endDate"
					value="${vo.endDate }" min="${today }" onblur="endDateRes()">
				</td>
			</tr>
			<tr>
				<td>활동 지역 :</td>
				<td><input type="text" id="location" name="location"
					value="${vo.location }"></td>
			</tr>
			<tr>
				<td>활동 시작 날짜 :</td>
				<td><input type="date" id="aStartDay" name="aStartDay"
					value="${vo.aStartDay }" onblur="aStartDayRes()"></td>
			</tr>
			<tr>
				<td>활동 마감 날짜 :</td>
				<td><input type="date" id="aEndDay" name="aEndDay"
					value="${vo.aEndDay }" onblur="aEndDayRes()"></td>
			</tr>
			<tr>
				<td>최소 나이 :</td>
				<td><select id="minAge" name="minAge" onblur="minAgeRes()">
						<c:forEach var="cnt" begin="1" end="${vo.minAge - 1}">
							<option value="${cnt }">${cnt }</option>
						</c:forEach>
						<option value="${vo.minAge }" selected>${vo.minAge }</option>
						<c:forEach var="cnt" begin="${vo.minAge + 1}" end="99">
							<option value="${cnt }">${cnt }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>최대 나이 :</td>
				<td><select id="maxAge" name="maxAge" onblur="maxAgeRes()">
						<c:forEach var="cnt" begin="1" end="${vo.maxAge - 1}">
							<option value="${cnt }">${cnt }</option>
						</c:forEach>
						<option value="${vo.maxAge }" selected>${vo.maxAge }</option>
						<c:forEach var="cnt" begin="${vo.maxAge + 1}" end="99">
							<option value="${cnt }">${cnt }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>성별 :</td>
				<td><c:if test="${vo.sex eq 'M'}">
						<select id="sex" name="sex">
							<option value="${vo.sex }" selected>남자</option>
							<option value="F">여자</option>
							<option value="X">상관없음</option>
						</select>
					</c:if> <c:if test="${vo.sex eq 'F'}">
						<select id="sex" name="sex">
							<option value="M">남자</option>
							<option value="F" selected>여자</option>
							<option value="X">상관없음</option>
						</select>
					</c:if> <c:if test="${vo.sex eq 'X'}">
						<select id="sex" name="sex">
							<option value="M">남자</option>
							<option value="F">여자</option>
							<option value="X" selected>상관없음</option>
						</select>
					</c:if></td>
			</tr>
			<tr>
				<td>최대 인원 수 :</td>
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
				<td><input type="button" value="액티비티 수정하기" onclick="modifyActivity()"></td>
			</tr>
		</table>

	</form>

</body>
</html>