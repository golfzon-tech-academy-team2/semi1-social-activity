<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>전체 모임 리스트</title>
</head>
<body>
	<div class="py-5">
		<div class="container">
			<div class="row hidden-md-up">

				<c:forEach var="vo" items="${vos}">
				<div class="col-md-4">
					<div class="card" style="width: 300px">
						<img class="card-img-top" src="gEmblem/${vo.logo}" alt="Card image"
							style="width: 100">
						<div class="card-body">
							<h4 class="card-title">${vo.gName}</h4>
							<p class="card-text">${vo.gContent}</p>
							<a href="joinPubGathering.do" class="btn btn-primary">모임 가입하기</a>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>

		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"></script>
	<script
		src="https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.min.js"></script>
</body>
</html>