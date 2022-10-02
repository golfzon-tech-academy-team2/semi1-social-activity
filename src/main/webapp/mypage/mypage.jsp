<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
<title>마이페이지</title>
<script>

	function signout() {
		if (!confirm("회원을 탈퇴하시겠습니까?")) {
		} else {
			location.href = "signout.do";
		}
	}
</script>

<style>
	td img {
		max-height:200px;
	}
</style>
</head>
<body>
	<a href="index.do">홈</a>
	
	<hr>
	<h3>마이페이지</h3>
	
	<table>
			<tr>
				<td><label for="uname">이름 :</label></td>
				<td>${vo.uname }</td>
				<td><a href="mod_name.do"><button id="modify_name" name="modify_name">실명 수정</button></a></td>
			</tr>
			<tr>
				<td><label for="pw">비밀번호 :</label></td>
				<td>**********</td>
				<td><a href="mod_pw.do"><button id="modify_pw" name="modify_pw">비밀번호 변경</button></a></td>
			</tr>
			<tr>
				<td><label for="sex">성별 :</label></td>
				<c:if test="${vo.sex eq 'F' }">
					<td>여자</td>
				</c:if>
				<c:if test="${vo.sex eq 'M' }">
					<td>남자</td>
				</c:if>
			</tr>
			<tr>
				<td><label for="addr">주소 :</label></td>
				<td>${vo.addr }</td>
				<td><a href="mod_addr.do"><button type="button" id="modify_addr" name="modify_addr">주소 수정</button></a></td>
			</tr>
			<tr>
				<td><label for="tel">전화번호 :</label></td>
				<td>${vo.tel }</td>
				<td><a href="mod_tel.do"><button type="button" id="modify_tel" name="modify_tel">전화번호 수정</button></a></td>
			</tr>
			<tr>
				<td><label for="bday">생년월일 :</label></td>
				<td>${vo.bday }</td>
			</tr>
		</table>
	
	<input type="button" id="signout" name="signout" onclick="signout()" value="회원탈퇴">
	
	<p>내 모임 리스트</p>
	
	<table id="mygathering" border="1">
		<tr>
			<td>역할</td>
			<td>모임 앰블럼</td>
			<td>모임명</td>
			<td>상세페이지</td>
		</tr>
		<c:forEach var="vo2" items="${mygathering}">
        <tr>
            <td>${vo2.roll }</td>
            <td><img src="gEmblem/${vo2.logo }"></td>
            <td>${vo2.gname }</td>
            <td><a href="gatheringinfo.do?gnum=${vo2.gnum }">모임 상세 보기</a>
        </tr>
        </c:forEach>
	</table>
	
	<p>내 액티비티 리스트</p>

	<table id="myactivity" border="1">
		<tr>
			<td>모임명</td>
			<td>엑티비티명</td>
			<td>활동 지역</td>
			<td>활동 시작 날짜</td>
			<td>활동 마감 날짜</td>
			<td>활동 상태</td>
			<td>상세 페이지</td>
		</tr>
		<c:forEach var="vo3" items="${myactivity}">
        <tr>
        	<td>${vo3.gName }</td>
            <td>${vo3.aName }</td>
            <td>${vo3.location }</td>
            <td>${vo3.aStartDay }</td>
            <td>${vo3.aEndDay }</td>
            <fmt:formatDate var="today3" value="${today }" pattern="yyyy-MM-dd"/>
            <c:if test="${today3 lt vo3.aStartDay }">
            	<td>활동 전</td>
            </c:if>
            <c:if test="${today3 le vo3.aEndDay && today ge vo3.aStartDay }">
            	<td>활동 중</td>
            </c:if>
            <c:if test="${today3 gt vo3.aEndDay }">
            	<td>활동 후</td>
            </c:if>
            <td><a href="activityInfo.do?aNum=${vo3.aNum }">상세 보기</a></td>
        </tr>
        </c:forEach>
	</table>
	<button onclick="location.href='admin.do'" class="btn btn-primary">모임 관리 페이지</button>
</body>
</html>