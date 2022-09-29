<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width: 100%;
	border: 1px solid #444444;
}

th, td {
	border: 1px solid #444444;
}
</style>
</head>
<body>
   <form action="b_updateOK.do?bNum=${param.bNum}&gNum=${param.gNum}" method="post">
	<table>
		<tr>
			<th>글 번호</th>
			<td>${param.tmpBnum}</td>
			<th>작성일</th>
			<td>${vo.wDate}</td>
			<th>작성일</th>
			<td>${vo.wDate}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="5"><input type="text" class="form-control" id="bTitle" placeholder="제목을 입력하세요" name="bTitle" value=${vo.bTitle}></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="5" rowspan="3"><textarea class="form-control" rows="5" id="bContent" name="bContent">${vo.bContent}</textarea></td>
		</tr>
	</table>
	<button onclick="location.href='gatheringinfo.do?gnum=${param.gNum}'">목록</button>

	<button  type="submit">수정</button>
	<button onclick="deleteConfirm()">삭제</button>
	</form>
</body>
</html>