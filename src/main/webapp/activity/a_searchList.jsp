<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>액티비티 리스트 검색</title>
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
<body>
	<a href="index.do">홈</a>
	<hr>

	<h3>액티비티 검색</h3>
	
	<div id="searchCondition">
			<form method="post" id="search" name="search">
				<table>
					<tr>
						<td>성별 : </td>
						<td>
							<select id="sex" name="sex">
								<option value="X" selected>상관없음</option>
								<option value="M">남자</option>
								<option value="F">여자</option>
							</select>
						</td>
						<td>지역 : </td>
						<td>
							<input type="text" id="location" name="location" placeholder="미입력 시 전체 지역 검색">
						</td>
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
						</td>
						<td><input type="button" id="search" name="search" value="검색하기" onclick="searchList()"></td>
					</tr>

				</table>
			</form>
		</div>
	
</body>
</html>