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
	<table>
	<tr>
	<th>작성자</th>
	<td>${vo.wName}</td>
	<th>작성일</th>
	<td>${vo.wDate}</td>
	</tr>
	<tr>
	<th>제목</th>
	<td  colspan="3" >${vo.bTitle}</td>
	</tr>
	<tr>
	<th>내용</th>
	<td  colspan="3" rowspan="3">${vo.bContent}</td>
	</tr>
	</table>
	<button onclick="location.href='gatheringinfo.do?gnum=${param.gNum}'">목록</button>
	
	<button>수정</button>
	<button>삭제</button>
</body>
</html>