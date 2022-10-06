<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="utf-8">
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<link rel="canonical"
	href="https://getbootstrap.com/docs/5.2/examples/checkout/">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css">
<title>액티비티생성</title>
<!-- <link href="css/signup.css" rel="stylesheet"> -->

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>


<script>
	function aNameRes() {
		var creActForm = document.creAct;
		var aName = creActForm.aName.value;
		if (aName.length <= 1) {
			alert("액티비티명은 최소 두 자리 이상이어야합니다");
		}
	}

	function aContentRes() {
		var creActForm = document.creAct;
		var aContent = creActForm.aContent.value;
		if (aContent.length <= 5) {
			alert("액티비티 내용은 최소 다섯 글자 이상이어야합니다");
		}
	}

	function endDateRes() {
		var creActForm = document.creAct;
		var startDate = creActForm.startDate.value;
		var endDate = creActForm.endDate.value;
		if (startDate > endDate) {
			alert("모집 마감 날짜는 모집 시작 날짜보다 뒤에 있어야합니다");
		}
	}

	function aStartDayRes() {
		var creActForm = document.creAct;
		var aStartDay = creActForm.aStartDay.value;
		var endDate = creActForm.endDate.value;
		if (aStartDay <= endDate) {
			alert("활동 시작 날짜는 모집 마감 날짜보다 뒤에 있어야합니다");
		}
	}

	function aEndDayRes() {
		var creActForm = document.creAct;
		var aEndDay = creActForm.aEndDay.value;
		var aStartDay = creActForm.aStartDay.value;
		if (aStartDay > aEndDay) {
			alert("활동 마감 날짜는 활동 시작 날짜보다 뒤에 있어야합니다");
		}
	}

	function minAgeRes() {
		var creActForm = document.creAct;
		var minAge = creActForm.minAge.value;
		var maxAge = creActForm.maxAge.value;
		if (minAge > maxAge) {
			alert("최소 나이는 최대 나이보다 작아야합니다")
		}
	}

	function maxAgeRes() {
		var creActForm = document.creAct;
		var minAge = creActForm.minAge.value;
		var maxAge = creActForm.maxAge.value;
		if (minAge > maxAge) {
			alert("최대 나이는 최소 나이보다 커야합니다")
		}
	}

	function createActivity() {
		var creActForm = document.creAct;
		var aName = creActForm.aName.value;
		var aContent = creActForm.aContent.value;
		var startDate = creActForm.startDate.value;
		var endDate = creActForm.endDate.value;
		var location = creActForm.location.value;
		var aStartDay = creActForm.aStartDay.value;
		var aEndDay = creActForm.aEndDay.value;
		var minAge = creActForm.minAge.value;
		var maxAge = creActForm.maxAge.value;
		var sex = creActForm.sex.value;
		var maxPerson = creActForm.maxPerson.value;

		if (aName == "" || aName.length == 0) {
			alert("액티비티명을 입력하세요");
		} else if (aContent == "" || aContent.length == 0) {
			alert("액티비티 내용을 입력하세요");
		} else if (startDate == "" || startDate.length == 0) {
			alert("모집 시작 날짜를 입력하세요");
		} else if (endDate == "" || endDate.length == 0) {
			alert("모집 마감 날짜를 입력하세요");
		} else if (location == "" || location.length == 0) {
			alert("활동 지역을 입력하세요");
		} else if (aStartDay == "" || aStartDay.length == 0) {
			alert("활동 시작 날짜를 입력하세요");
		} else if (aEndDay == "" || aEndDay.length == 0) {
			alert("활동 마감 날짜를 입력하세요");
		} else if (startDate > endDate) {
			alert("모집 마감 날짜는 모집 시작 날짜보다 뒤에 있어야합니다");
		} else if (aStartDay <= endDate) {
			alert("활동 시작 날짜는 모집 마감 날짜보다 뒤에 있어야합니다");
		} else if (aStartDay > aEndDay) {
			alert("활동 마감 날짜는 활동 시작 날짜보다 뒤에 있어야합니다");
		} else if (minAge > maxAge) {
			alert("최소 나이는 최대 나이보다 작아야합니다");
		} else {
			$("#creAct").attr("action", "creActOK.do"); // attribute setting
			$("#creAct").submit();
		}
	}
</script>

</head>
<body class="bg-light">

	<div class="container">
		<main>
			<div class="py-5 text-center">

				<h2>액티비티생성</h2>
			</div>

			<div class="row g-5"
				style="display: block; width: 70%; margin: auto;">

				<div class="col-md-7 col-lg-8 test" style="width: 100%">

					<form id="creAct" name="creAct" method="post"
						class="needs-validation" novalidate>
						<input type="hidden" id="gNum" name="gNum" value="${vo.gNum }">
						<div class="row g-3">

							<div class="col-12">
								<label for="uname" class="form-label">액티비티명 <span
									class="text-muted"></span></label> <input type="text" id="aName"
									name="aName" value="" onblur="aNameRes()" class="form-control"
									placeholder="액티비티명">

							</div>

							<div class="col-12">
								<label for="id" class="form-label">액티비티 내용 <span
									class="text-muted"></span></label> <input type="text" id="aContent"
									name="aContent" value="" onblur="aContentRes()"
									class="form-control" placeholder="액티비티 내용">


							</div>


							<div class="col-12">
								<label for="pw" class="form-label">모집 시작 날짜 <span
									class="text-muted"></span></label> <input type="date" id="startDate"
									name="startDate" value="${today }" min="${today }"
									class="form-control">

							</div>


							<div class="col-12">
								<label for="pw" class="form-label">모집 마감 날짜 <span
									class="text-muted"></span></label> <input type="date" id="endDate"
									name="endDate" value="" min="${today }" onblur="endDateRes()"
									class="form-control">

							</div>

							<div class="col-12">
								<label for="pw_check" class="form-label">활동 지역</label> <input
									input type="text" id="location" name="location" value=""
									class="form-control" placeholder="활동 지역을 시(군)단위로 입력하세요">

							</div>


							<div class="col-12">
								<label for="pw" class="form-label">활동 시작 날짜 <span
									class="text-muted"></span></label> <input type="date" id="aStartDay"
									name="aStartDay" value="" min="${today }"
									onblur="aStartDayRes()" class="form-control">

							</div>


							<div class="col-12">
								<label for="pw" class="form-label">활동 마감 날짜 <span
									class="text-muted"></span></label> <input type="date" id="aEndDay"
									name="aEndDay" value="" min="${today }" onblur="aEndDayRes()"
									class="form-control">

							</div>


							<div class="col-12">
								<label for="minAge" class="form-label">최소 나이</label> <br> <select
									id="minAge" name="minAge" onblur="minAgeRes()">
									<option value="1" selected>1</option>
									<c:forEach var="cnt" begin="2" end="98">
										<option value="${cnt }">${cnt }</option>
									</c:forEach>
									<option value="99">99</option>
								</select>

							</div>

							<div class="col-12">
								<label for="maxAge" class="form-label">최대 나이</label> <br> <select
									id="maxAge" name="maxAge" onblur="maxAgeRes()">
									<option value="1">1</option>
									<c:forEach var="cnt" begin="2" end="98">
										<option value="${cnt }">${cnt }</option>
									</c:forEach>
									<option value="99" selected>99</option>
								</select>

							</div>


							<div class="col-12">
								<label for="sex" class="form-label">성별</label> <br> <select
									id="sex" name="sex">
									<option>남자</option>
									<option>여자</option>
									<option>상관없음</option>
								</select>

							</div>

							<div class="col-12">
								<label for="maxPerson" class="form-label">최대 참가 가능 인원</label> <br>
								<select id="maxPerson" name="maxPerson">
									<c:forEach var="cnt" begin="1" end="100">
										<option value="${cnt }">${cnt }</option>
									</c:forEach>
							</select>

							</div>

							<input class="w-100 btn btn-primary btn-lg" type="button"
								value="액티비티 생성하기" onclick="createActivity()"
								style="margin-top: 50px">

						</div>
						
					</form>
				</div>
			</div>

		</main>

	</div>


	<script src="resource/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>