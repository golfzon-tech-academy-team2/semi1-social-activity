<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  	
<!doctype html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>액티비티 리스트 검색</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">




<!-- Custom styles for this template -->
<link href="css/a_searchList.css" rel="stylesheet">
<script>
	function searchList() {
		var searchForm = document.search;
		var sex = searchForm.sex.value;
		var location = searchForm.location.value;
		var age = searchForm.age.value;

		$("#search").attr("action", "a_searchListOK.do"); // attribute setting
		$("#search").submit();
	}
</script>
</head>



<body class="text-center">

	

	<main class="form-signin w-100 m-auto">
		<div id="searchCondition">
			<form method="post" id="search" name="search">

				<h1 class="h3 mb-3 fw-normal">액티비티 검색</h1>
				<div class="form-floating">
					
					<tr>
						<td>성별 :</td>
						<td><select id="sex" name="sex">
								<option value="X" selected>상관없음</option>
								<option value="M">남자</option>
								<option value="F">여자</option>
						</select></td>
					</tr>
					<hr>
						<td>지역 : </td>
						<td>
							<input type="text" id="location" name="location" placeholder="미입력 시 전체 지역 검색">
						</td>
						<hr>
						<td>나이 : </td>
						<td>
							<select id="age" name="age">
								<c:forEach var="cnt" begin="1" end="19">
									<option value="${cnt }">${cnt }</option>
								</c:forEach>
									<option value="20" selected>20</option>
								<c:forEach var="cnt" begin="21" end="99">
									<option value="${cnt }">${cnt }</option>
								</c:forEach>
							</select>
					
				</div>
				<br>

				<input type="button" id="search" name="search" value="검색하기" onclick="searchList()"
					class="w-100 btn btn-lg btn-primary">

			</form>
		</div>
	</main>	
</body>
</html>
