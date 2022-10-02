<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../top_menu.jsp"></jsp:include>
	<h2>${vo.vTitle}</h2>
	<form class="was-validated" action="v_updateOK.do?vNum=${vo.vNum}&gNum=${param.gNum}" method="post">
		<div class="container">
			<br> <input type="radio" name="vList" value="vCnt1">${vo.vList1}<br>
			<br> <input type="radio" name="vList" value="vCnt2">${vo.vList2}<br>
			<br> <input type="radio" name="vList" value="vCnt3">${vo.vList3}<br>
		</div>
	<button type="submit">투표</button>
	</form>
	
	<button onclick="location.href='v_result.do?vNum=${vo.vNum}&gNum=${param.gNum}'">결과</button>
</body>
</html>