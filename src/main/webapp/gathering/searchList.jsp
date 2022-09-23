<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<form class="was-validated" action="g_searchListOK.do" method="get">
		<div class="container">
			<h2>공개 모임 검색</h2>
			<br>
			<h5>모임 검색 조건 선택</h5>
			<br>
			<label for="sex">성별 :</label><br> <input type="radio"
				name="sex" value="F">여성 <br> <input type="radio"
				name="sex" value="M">남성 <br> <input type="radio"
				name="sex" value="X" checked="checked">제한 없음 <br> <br>
			<label>연령대:</label><br> 
			<label>최소 나이:</label><br> <input
				type="number" class="form-control" id="minAge"
				placeholder="모임을 설명해주세요" name="minAge" value=1> <br>
				<label>최대 나이:</label><br> <input type="number" class="form-control" id="maxAge"
				placeholder="모임을 설명해주세요" name="maxAge" value=100>
			<br>
			<button type="submit" class="btn btn-primary">모임 검색</button>
		</div>
	</form>
</html>