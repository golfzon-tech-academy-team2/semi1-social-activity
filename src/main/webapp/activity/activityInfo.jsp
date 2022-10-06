<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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

	function joinActivity() {
		if (!confirm("액티비티에 가입하시겠습니까? 확인 시 액티비티에 바로 가입 신청 됩니다")) {
		} else {
			location.href = "joinActivity.do?aNum=" + ${vo.aNum};
		}
	}

	function modifyActivity() {
		if (!confirm("액티비티를 수정하시겠습니까?")) {
		} else {
			location.href = "modifyActivity.do?aNum=" + ${vo.aNum};
		}
	}

	function signOutActivity() {
		if (!confirm("액티비티를 탈퇴하시겠습니까? 탈퇴 후 계정을 복구할 수 없습니다")) {
		} else {
			location.href = "signOutActivity.do?aNum=" + ${vo.aNum};
		}
	}
</script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
	<fmt:formatDate var="today" value="${today }" pattern="yyyy-MM-dd" />
	<jsp:include page="../top_menu.jsp"></jsp:include>


	<main class="container">


		<div class="my-3 p-3 bg-body rounded shadow-sm">
			<h4 class="border-bottom pb-2 mb-0">${vo.aName} 액티비티 정보</h4>

			<div class="d-flex  pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">액티비티명</strong>
					</div>
					<span class="d-block">${vo.aName }</span>
				</div>
			</div>


			<div class="d-flex  pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">액티비티 내용</strong>
					</div>
					<span class="d-block">${vo.aContent }</span>
				</div>
			</div>

			<div class="d-flex  pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">활동 시작 날짜</strong>
					</div>
					<span class="d-block">${vo.aStartDay }</span>
				</div>
			</div>

			<div class="d-flex  pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">활동 마감 날짜</strong>
					</div>
					<span class="d-block">${vo.aEndDay }</span>
				</div>
			</div>

			<div class="d-flex  pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">활동 지역</strong>
					</div>
					<span class="d-block">${vo.location }</span>
				</div>
			</div>

			<div class="d-flex  pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">모집 시작 날짜</strong>
					</div>
					<span class="d-block">${vo.startDate }</span>
				</div>
			</div>

			<div class="d-flex  pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">모집 마감 날짜</strong>
					</div>
					<span class="d-block">${vo.endDate }</span>
				</div>
			</div>

			<div class="d-flex pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">모집종료여부</strong>
					</div>
					<span class="d-block"> 
						<c:if test="${today gt vo.endDate}">
							<td>모집 종료</td>
						</c:if> <c:if test="${today le vo.endDate && today ge vo.startDate}">
							<td>모집 중</td>
						</c:if> <c:if test="${today lt vo.startDate}">
							<td>모집 전</td>
						</c:if>


					</span>
				</div>
			</div>


			<div class="d-flex pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">최소나이</strong>
					</div>
					<span class="d-block">${vo.minAge }</span>
				</div>
			</div>

			<div class="d-flex pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">최대나이</strong>
					</div>
					<span class="d-block">${vo.maxAge }</span>
				</div>
			</div>

			<div class="d-flex pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">모집 성별</strong>
					</div>
					<span class="d-block"> <c:if test="${vo.sex eq 'M'}">
							<td>남자</td>
						</c:if> <c:if test="${vo.sex eq 'F'}">
							<td>여자</td>
						</c:if> <c:if test="${vo.sex eq 'X'}">
							<td>상관없음</td>
						</c:if>
					</span>
				</div>
			</div>


			<div class="d-flex pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">최대 모집인원수</strong>
					</div>
					<span class="d-block">${vo.maxPerson }명</span>
				</div>
			</div>
		</div>
		<c:if test="${today <= vo.endDate && today >= vo.startDate}">
			<c:if test="${checkActivity == 0 }">
				<c:if test="${vo.personCnt != vo.maxPerson }">
					<input type="button" id="joinActivity" name="joinActivity"
						value="액티비티 가입하기" onclick="joinActivity()"
						class="w-100 mb-2 btn btn-lg rounded-3 btn-primary">

				</c:if>
			</c:if>
		</c:if>




		<hr>

		<h4>액티비티 조편성</h4>

		<hr>


		<div class="my-3 p-3 bg-body rounded shadow-sm">
			<h4 class="border-bottom pb-2 mb-0">
				액티비티이벤트 <a href="javascript:createEvent()" class="btn btn-primary">이벤트생성</a>
			</h4>

			<div class="d-flex text-muted pt-3 text-center">


				<table class="table table-striped text-center">
					<thead>
						<c:if test="${vos.size() ne 0}">
							<tr>

								<th scope="col">이벤트 제목</th>
								<th scope="col">이벤트 내용</th>
								<th scope="col">이벤트 상품</th>
								<th scope="col"></th>

							</tr>
						</c:if>
					</thead>
					<tbody>

						<c:if test="${vos.size() eq 0}">
							<p class="text-center">생성된 이벤트 없음</p>
						</c:if>
						<c:forEach var="vo2" items="${vos}">
							<tr>
								<td>${vo2.eTitle }</td>
								<td>${vo2.eContent }</td>
								<td>${vo2.gift }</td>
								<td><input type="button" id="deleteEvent"
									name="deleteEvent" value="이벤트 삭제하기" onclick="deleteEvent()"
									class="btn btn-primary"></td>

								<input type="hidden" id="aNum" name="aNum" value="${vo2.aNum }">
								<input type="hidden" id="eNum" name="eNum" value="${vo2.eNum }">
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<hr>

		<c:if test="${checkActivity == 1 }">
			<div class="my-3 p-3 bg-body rounded shadow-sm">

				<h4 class="border-bottom pb-2 mb-0">액티비티원</h4>

				<div class="d-flex text-muted pt-3 text-center">


					<table class="table table-striped text-center">
						<thead>
							<tr>

								<th scope="col">이름</th>
								<th scope="col">성별</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vo3" items="${activityMember }">
								<tr>
									<td>${vo3.uName }</td>
									<td>${vo3.sex }</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
					</hr>
				</div>
			</div>
		</c:if>
		
		</hr>


		<c:if test="${checkLeader == 1 }">
		<input type="button" id="deleteActivity" name="deleteActivity" onclick="deleteActivity()" value="액티비티 삭제하기" class="btn btn-primary">
		<input type="button" id="modifyActivity" name="modifyActivity" onclick="modifyActivity()" value="액티비티 수정하기" class="btn btn-primary">
	</c:if>
	
	<c:if test="${checkLeader == 0 && checkActivity == 1}">
		<input type="button" id="signOutActivity" name="signOutActivity" onclick="signOutActivity()" value="액티비티 탈퇴하기" class="btn btn-primary">
	</c:if>





		<hr>
	</main>
</body>
</html>