<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div>
		<label>${vo.vList1} : ${vo.vCnt1}표</label> <progress value=${vo.vCnt1/(vo.vCnt1+vo.vCnt2+vo.vCnt3)*100} max="100"></progress>
	</div>
	<div>
		<label>${vo.vList2} : ${vo.vCnt2}표</label> <progress value=${vo.vCnt2/(vo.vCnt1+vo.vCnt2+vo.vCnt3)*100} max="100"></progress>
	</div>
	<div>
		<label>${vo.vList3} : ${vo.vCnt3}표</label> <progress value=${vo.vCnt3/(vo.vCnt1+vo.vCnt2+vo.vCnt3)*100} max="100"></progress>
	</div>
	<button onclick="location.href='gatheringinfo.do?gnum=${param.gNum}'">모임으로 돌아가기</button>
</body>
</html>