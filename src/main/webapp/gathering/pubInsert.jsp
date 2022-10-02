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
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form class="was-validated" action="insert_pubGOK.do" method="post"
		enctype="multipart/form-data">
		<div class="container">
			<h2>공개 모임 커뮤니티 생성</h2>
			<div class="btn-group btn-group">
				<button type="button" class="btn btn-primary"
					onclick="location.href='insert_pubGathering.do'">공개형</button>
				<button type="button" class="btn btn-primary"
					onclick="location.href='insert_priGathering.do'">비공개형</button>
			</div>
			<div class="form-group">
				<label for="gName">모임명:</label> <input type="text"
					class="form-control" id="gName" placeholder="모임 이름을 입력하세요"
					name="gName">
			</div>

			<div class="form-group">
				<label for="gContent">모임 설명:</label> <input type="text"
					class="form-control" id="gContent" placeholder="모임을 설명해주세요"
					name="gContent">
			</div>


			<div class="mb-3">
				<label for="logo">모임 앰블럼:</label><br> <input type="file" id="logo" name="logo"
					class="form-control" aria-label="file example" required>
				<div class="invalid-feedback">Example invalid form file
					feedback</div>
			</div>

			<label for="sex">가입 성별 제한:</label><br> <input type="radio"
				name="sex" value="F">여성 <br> <input type="radio"
				name="sex" value="M">남성 <br> <input type="radio"
				name="sex" value="X" checked="checked">제한 없음 <br> <br>
			<label>연령대:</label><br> <label>최소 나이:</label><br> <input
				type="number" class="form-control" id="minAge"
				placeholder="모임을 설명해주세요" name="minAge" value=1> <label>최대
				나이:</label><br> <input type="number" class="form-control" id="maxAge"
				placeholder="모임을 설명해주세요" name="maxAge" value=100>

			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="permission">
					운영자 승낙 필요 여부
				</label>
			</div>
			<button type="submit" class="btn btn-primary">모임 생성</button>
		</div>
	</form>
</body>
</html>
