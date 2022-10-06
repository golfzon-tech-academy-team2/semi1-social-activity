<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>액티비티 검색 결과</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">
	<jsp:include page="../top_menu.jsp"></jsp:include>

	<main class="container">

	
		<div class="my-3 p-3 bg-body rounded shadow-sm">
			<h4 class="border-bottom pb-2 mb-0">액티비티 검색 결과</h4>

			<div class="d-flex text-muted pt-3 text-center">


				<table class="table table-striped text-center">
					<thead>

						<tr>

							<th scope="col">액티비티 명</th>
							<th scope="col">액티비티 내용</th>
							<th scope="col">활동 시작 날짜</th>
							<th scope="col">활동 마지막 날짜</th>
							<th scope="col">활동 지역</th>
							<th scope="col">모집 시작 날짜</th>
							<th scope="col">모집 마감 날짜</th>
							<th scope="col">현재 인원</th>
							<th scope="col">최대 인원</th>
							<th scope="col">최소나이</th>
							<th scope="col">최대나이</th>
							<th scope="col">성별</th>
							<th scope="col">활동 상태</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
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
								<td>${vo.maxPerson }</td>
								<td>${vo.minAge }</td>
								<td>${vo.maxAge }</td>
								<c:choose>
									<c:when test="${vo.sex == 'X'}">
										<td>상관없음</td>
									</c:when>
									<c:when test="${vo.sex == 'M'}">
										<td>남자</td>
									</c:when>
									<c:otherwise>
										<td>여자</td>
									</c:otherwise>
								</c:choose>
								<fmt:formatDate var="today2" value="${today}"
									pattern="yyyy-MM-dd" />
								<c:if test="${today2 lt vo.aStartDay }">
									<td>활동 전</td>
								</c:if>
								<c:if test="${today2 ge vo.aStartDay && today2 le vo.aEndDay }">
									<td>활동 중</td>
								</c:if>
								<c:if test="${today2 gt vo.aEndDay }">
									<td>활동 후</td>
								</c:if>
								<c:choose>
									<c:when test="${signedid eq null}">
										<td><a href="login.do">상세 보기</a></td>
									</c:when>
									<c:otherwise>
										<td><a href="activityInfo.do?aNum=${vo.aNum }" class="btn btn-primary">상세 보기</a></td>
									</c:otherwise>
								</c:choose>
							</tr>
						</c:forEach>	

					</tbody>
				</table>
			</div>
		</div>

		<hr>


	</main>
</body>
</html>