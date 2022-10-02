<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>모임 생성</title>
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
<script>
	
</script>
</head>
<body>

	<form class="was-validated" action="insert_pubGOK.do" method="post"
		enctype="multipart/form-data">
		<div class="container">
			<h2>투표 생성</h2>
			<div class="form-group">
				<label for="vTitle">투표 주제:</label> <input type="text"
					class="form-control" id="vTitle" placeholder="투표 주제를 입력하세요"
					name="vTitle">
			</div>
			
			<div class="form-group">
				<label for="startDate">투표 시작 날짜:</label> <input type="date"
					class="form-control" id="startDate"
					name="startDate">
			</div>
			
			<div class="form-group">
				<label for="endDate">투표 종료 날짜:</label> <input type="date"
					class="form-control" id="endDate"
					name="endDate">
			</div>

			<div class="form-group">
				<label for="vList1">항목 1:</label> <input type="text"
					class="form-control" id="vList1" placeholder="첫번째 투표 항목을 입력하세요"
					name="vList1">
			</div>
			<div class="form-group">
				<label for="vList2">항목 2:</label> <input type="text"
					class="form-control" id="vList2" placeholder="두번째 투표 항목을 입력하세요"
					name="vList2">
			</div>
			<div class="form-group">
				<label for="vList2">항목 3:</label> <input type="text"
					class="form-control" id="vList3" placeholder="세번째 투표 항목을 입력하세요"
					name="vList3">
			</div>

			<button type="submit" class="btn btn-primary">모임 생성</button>
		</div>
	</form>
</body>
</html>
