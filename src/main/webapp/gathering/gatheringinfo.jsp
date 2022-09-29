<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h3 style="display:inline;">${param.gname}</h3><h3 style="display:inline;"> 모임에 오신걸 환영합니다</h3>
<p>게시판</p>
<div class="container">
<button onclick="location.href='createActivity.do?gNum=${param.gnum }'">액티비티 생성하기</button>

  <h2>모임</h2>${param.gnum}<h2>의 게시글 목록</h2>        
  <table class="table">
    <thead>
      <tr>
        <th>게시글 번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>작성일</th>
         <th>수정하기</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="vo" items="${vos}">
        <tr>
            <td>${vo.tmpBnum}</td>
            <td>${vo.bTitle }</td>
            <td>${vo.wName }</td>
            <td>${vo.wDate }</td>
            <td><a href="b_selectOne.do?bNum=${vo.bNum }&gNum=${param.gnum}&tmpBnum=${vo.tmpBnum}">수정하기</a></td>
        </tr>
        </c:forEach>
    </tbody>
  </table>
  <a href="b_insert.do?gNum=${param.gnum}">글쓰기</a>
</div>


<p>투표</p>
</body>
</html>