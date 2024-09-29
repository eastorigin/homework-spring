<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h1>게시글 수: ${boardList.getBoardCnt()}</h1>
	<br />
	<h1>조회한 게시글의 수: ${boardList.boardList.size()}</h1>
	<br />
</body>
</html>