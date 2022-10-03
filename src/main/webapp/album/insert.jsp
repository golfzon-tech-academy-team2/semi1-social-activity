<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>사진/동영상 업로드</title>
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
	<form class="was-validated" action="ab_insertOK.do?gNum=${param.gNum}" method="post"
		enctype="multipart/form-data">
		<div class="container">
			<h2>사진/동영상 업로드</h2>
			<div class="mb-3">
				<label for="fileName">사진 등록:</label><br> <input type="file" id="fileName" name="fileName"
					class="form-control" aria-label="file example" required>
				<div class="invalid-feedback">Example invalid form file
					feedback</div>
			</div>
			<button type="submit" class="btn btn-primary">업로드</button>
		</div>
	</form>
</body>
</html>
