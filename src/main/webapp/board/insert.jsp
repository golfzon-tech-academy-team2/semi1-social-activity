<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<h3>게시글 입력하숑~</h3>
<div class="container">
  <h2>게시글 작성</h2>
  <form action="/b_insertOK.do">
    <div class="form-group">
      <label for="btitle">게시글 제목:</label>
      <input type="text" class="form-control" id="bTitle" placeholder="제목을 입력하세요" name="bTitle">
      <label for="comment">게시글 내용:</label>
      <textarea class="form-control" rows="5" id="bContent" name="bContent"></textarea>
    </div>
    <button type="submit" class="btn btn-primary">작성 완료</button>
  </form>
</div>
</body>
</html>