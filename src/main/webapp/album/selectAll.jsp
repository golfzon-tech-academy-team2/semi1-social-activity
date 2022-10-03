<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<div class="py-5">
		<div class="container">
			<div class="row hidden-md-up">
				<c:forEach var="vo" items="${vos}">
					<div class="col-md-3">
						<div class="card" style="width: 300px height:300px" onclick="location.href='ab_selectOne.do?aNum=${vo.aNum}&gNum=${vo.gNum}'">
							<c:if test="${vo.type eq 'video'}">
								<video src="gallery/${vo.fileName}" controls> 이 브라우저에서
									지원하지 않는 영상입니다.
								</video>
							</c:if>
							<c:if test="${vo.type eq 'image'}">
								<img class="card-img-top" src="gallery/${vo.fileName}"
									alt="Card image" style="width: 100">
							</c:if>
							<div class="card-body"></div>
						</div>
					</div>
				</c:forEach>
			</div>
			<button onclick="location.href='gatheringinfo.do?gnum=${param.gNum}'"
				class="btn btn-primary">모임으로 돌아가기</button>
		</div>

	</div>

</body>
</html>