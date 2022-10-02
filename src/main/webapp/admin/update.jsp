<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>관리자 페이지</title>
</head>
<body>
	<jsp:include page="../top_menu.jsp"></jsp:include>
	<form class="was-validated" action="ad_updateOK.do?gNum=${param.gNum}" method="post"
		enctype="multipart/form-data">
		<div class="container">
			<h2>공개 모임 수정</h2>
			<div class="form-group">
				<label for="gName">모임명:</label> <input type="text"
					class="form-control" id="gName" placeholder="모임 이름을 입력하세요"
					name="gName" value=${vo.gName}>
			</div>

			<div class="form-group">
				<label for="gContent">모임 설명:</label> <input type="text"
					class="form-control" id="gContent" placeholder="모임을 설명해주세요"
					name="gContent" value=${vo.gContent}>
			</div>


			<div class="mb-3">
				<label for="logo">모임 앰블럼:</label><br> <input type="file" id="logo" name="logo"
					class="form-control" aria-label="file example" required>
				<div class="invalid-feedback">Example invalid form file
					feedback</div>
			</div>
			<c:if test="${vo.sex == 'F'}">
			<label for="sex">가입 성별 제한:</label><br> <input type="radio"
				name="sex" value="F" checked="checked">여성 <br> <input type="radio"
				name="sex" value="M" >남성 <br> <input type="radio"
				name="sex" value="X" >제한 없음 <br> <br>
			</c:if>
			<c:if test="${vo.sex == 'M'}">
			<label for="sex">가입 성별 제한:</label><br> <input type="radio"
				name="sex" value="F">여성 <br> <input type="radio"
				name="sex" value="M" checked="checked">남성 <br> <input type="radio"
				name="sex" value="X" >제한 없음 <br> <br>
			</c:if>	
			<c:if test="${vo.sex == 'X'}">
			<label for="sex">가입 성별 제한:</label><br> <input type="radio"
				name="sex" value="F">여성 <br> <input type="radio"
				name="sex" value="M" >남성 <br> <input type="radio"
				name="sex" value="X" checked="checked">제한 없음 <br> <br>
			</c:if>	
				
			<label>연령대:</label><br> <label>최소 나이:</label><br> <input
				type="number" class="form-control" id="minAge"
				placeholder="모임을 설명해주세요" name="minAge" value=${vo.minAge}> <label>최대
				나이:</label><br> <input type="number" class="form-control" id="maxAge"
				placeholder="모임을 설명해주세요" name="maxAge" value=${vo.maxAge}>

			<div class="form-group form-check">
				<c:if test="${vo.permission == 'on'}">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="permission" checked="checked">
					운영자 승낙 필요 여부
				</label>
				</c:if>
			</div>
			<button type="submit" class="btn btn-primary">모임 수정</button>
		</div>
	</form>
</body>
</html>