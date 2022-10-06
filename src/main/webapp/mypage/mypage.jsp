<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="utf-8">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>마이페이지</title>
<script>
	function signout() {
		if (!confirm("회원을 탈퇴하시겠습니까?")) {
		} else {
			location.href = "signout.do";
		}
	}
</script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">


<!-- <link href="resource/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<link href="css/mypage.css" rel="stylesheet">
</head>
	<jsp:include page="../top_menu.jsp"></jsp:include>
<body class="bg-light" style="padding-top:0px">

	<main class="container">
		<div class="my-3 p-3 bg-body rounded shadow-sm">
			<h6 class="border-bottom pb-2 mb-0">마이페이지</h6>

			<div class="d-flex text-muted pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">이름</strong> <a href="mod_name.do" class="btn btn-sm btn-outline-secondary">실명수정</a>
					</div>
					<span class="d-block">${vo.uname }</span>
				</div>
			</div>

			<div class="d-flex text-muted pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">비밀번호</strong> <a href="mod_pw.do" class="btn btn-sm btn-outline-secondary">비밀번호수정</a>
					</div>
					<span class="d-block">**********</span>
				</div>
			</div>


			<div class="d-flex text-muted pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">성별</strong>

					</div>
					<span class="d-block"><c:if test="${vo.sex eq 'F' }">
							<td>여자</td>
						</c:if> <c:if test="${vo.sex eq 'M' }">
							<td>남자</td>
						</c:if></span>
				</div>
			</div>


			<div class="d-flex text-muted pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">주소</strong> <a href="mod_addr.do" class="btn btn-sm btn-outline-secondary">주소수정</a>
					</div>
					<span class="d-block">${vo.addr }</span>
				</div>
			</div>

			<div class="d-flex text-muted pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">전화번호</strong> <a href="mod_tel.do" class="btn btn-sm btn-outline-secondary">전화번호수정</a>
					</div>
					<span class="d-block">${vo.tel }</span>
				</div>
			</div>

			<div class="d-flex text-muted pt-3">
				<div class="pb-3 mb-0 small lh-sm border-bottom w-100">
					<div class="d-flex justify-content-between">
						<strong class="text-gray-dark">생년월일</strong>
					</div>
					<span class="d-block">${vo.bday }</span>
				</div>
			</div>

			<small class="d-block text-end mt-3"> <a href="signout.do" class="btn btn-primary" onclick="signout()">회원탈퇴</a></small>

		</div>

		<!-- 		======모임리스트 구현======= -->
		<div class="my-3 p-3 bg-body rounded shadow-sm">
			<h6 class="border-bottom pb-2 mb-0">내 모임 리스트</h6>
			<div class="d-flex text-muted pt-3">

				<div class="album py-5 bg-light">
					<div class="container">


						<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
							<c:forEach var="vo2" items="${mygathering}">
								<div class="col">
									<div class="card shadow-sm" style="width: 100%; height: 100%;">
										<img class="bd-placeholder-img card-img-top" width="100%"
											height="250px" src="gEmblem/${vo2.logo }">

										<rect width="100%" height="100%" fill="#55595c"></rect>
										<text x="50%" y="50%" fill="#eceeef" dy=".3em">${vo2.roll }</text>


										<div class="card-body">
											<p class="card-text text-center">${vo2.gname }</p>
											<div
												class="d-flex justify-content-between align-items-center">
												<div class="btn-group">
													<a href="gatheringinfo.do?gnum=${vo2.gnum }"
														class="btn btn-sm btn-outline-secondary">모임 상세보기</a>

												</div>

											</div>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
			</div>
		</div>



		<div class="my-3 p-3 bg-body rounded shadow-sm">
			<h6 class="border-bottom pb-2 mb-0">내 액티비티 리스트</h6>
			<div class="d-flex text-muted pt-3">


				<table class="table table-striped text-center">
					<thead>
						<tr>
							
							<th scope="col">모임명</th>
							<th scope="col">엑티비티명</th>
							<th scope="col">활동 지역</th>
							<th scope="col">활동 시작 날짜</th>
							<th scope="col">활동 종료 날짜</th>
							<th scope="col">활동상태</th>
							<th scope="col">상세 페이지</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vo3" items="${myactivity}">
							<tr>
								<td>${vo3.gName }</td>
								<th scope="row">${vo3.aName }</td>
								<td>${vo3.location }</td>
								<td>${vo3.aStartDay }</td>
								<td>${vo3.aEndDay }</td>
								<fmt:formatDate var="today3" value="${today }"
									pattern="yyyy-MM-dd" />
								<c:if test="${today3 lt vo3.aStartDay }">
									<td>활동 전</td>
								</c:if>
								<c:if test="${today3 le vo3.aEndDay && today ge vo3.aStartDay }">
										<td>활동 중</td>
								</c:if>
								<c:if test="${today3 gt vo3.aEndDay }">
									<td>활동 후</td>
								</c:if>
								<td><a href="activityInfo.do?aNum=${vo3.aNum }" class="btn btn-primary">상세 보기</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
		<button onclick="location.href='admin.do'" class="btn btn-primary">모임 관리 페이지</button>
	</main>
</body>
</html>
