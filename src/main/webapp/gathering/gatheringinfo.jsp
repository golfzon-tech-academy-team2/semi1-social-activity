<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<style type="text/css">
.data:hover {
	background-color: #aaaaaa;
}
</style>
</head>
<body>
	<fmt:formatDate var="today" value="${today }" pattern="yyyy-MM-dd" />
	<h3 style="display: inline;">${param.gname}</h3>
	<h3 style="display: inline;">모임에 오신걸 환영합니다</h3>
	<div class="container">
		<button class="btn btn-primary"
			onclick="location.href='createActivity.do?gNum=${param.gnum }'">액티비티
			생성하기</button>

		<h2>공지 사항</h2>
		<button class="btn btn-primary"
			onclick="location.href='b_selectAll.do?gNum=${param.gnum}'">전체
			공지 보기</button>
		<table class="table">
			<thead>
				<tr>
					<th>제목</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<tr class="data"
					onclick="location.href='b_selectOneNotice.do?bNum=${vos[0].bNum }&gNum=${param.gnum}&tmpBnum=${vos[0].tmpBnum}'">
					<td>${vos[0].bTitle}</td>
					<td>${vos[0].bContent}</td>
				</tr>
			</tbody>
		</table>

		<h2 style="display: inline;">모임</h2>
		<h2 style="display: inline;">${param.gnum}</h2>
		<h2 style="display: inline;">의 게시글 목록</h2>
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
				<c:forEach var="vo" items="${vos[1]}">
					<tr class="data"
						onclick="location.href='b_selectOne.do?bNum=${vo.bNum }&gNum=${param.gnum}&tmpBnum=${vo.tmpBnum}'">
						<td>${vo.tmpBnum}</td>
						<td>${vo.bTitle }</td>
						<td>${vo.wName }</td>
						<td>${vo.wDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button class="btn btn-primary"
			onclick="location.href='b_insert.do?gNum=${param.gnum}'">글쓰기</button>


		<h2>액티비티!</h2>
		<table class="table">
			<thead>
				<tr>
					<th>엑티비티 제목</th>
					<th>엑티비티 내용</th>
					<th>모집 여부</th>
					<th>진행 여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos[2]}">
					<tr class="data" onclick="">
						<td>${vo.aName}</td>
						<td>${vo.aContent }</td>
						
						<c:if test="${today < vo.startDate}">
							<td>모집 전</td>
						</c:if>
						<c:if test="${vo.startDate <= today && today <= vo.endDate}">
							<td>모집 중</td>
						</c:if>
						<c:if test="${vo.endDate < today}">
							<td>모집 종료</td>
						</c:if>
						<c:if test="${today < vo.aStartDay}">
							<td>진행 전</td>
						</c:if>
						<c:if test="${vo.aStartDay <= today && today <= vo.aEndDay}">
							<td>진행 중</td>
						</c:if>
						<c:if test="${vo.aEndDay < today}">
							<td>진행 종료</td>
						</c:if>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h2>멤버</h2>
		<table class="table">
			<thead>
				<tr>
					<th>회원 이름</th>
					<th>자격</th>
	
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${vos[3]}">
					<tr class="data"
						onclick="">
						<td>${vo.uName}</td>
						<c:if test="${vo.roll eq 'O'}">
							<td>운영자</td>
						</c:if>
						<c:if test="${vo.roll eq 'L'}">
							<td>리더</td>
						</c:if>
						<c:if test="${vo.roll eq 'M'}">
							<td>멤버</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<p>투표</p>
	<button onclick="location.href='v_insert.do?gNum=${param.gnum}'">투표 생성</button>
</body>
</html>