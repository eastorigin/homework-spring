<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성하기</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<form method="post">
		<div class = "grid">
			<label for ="subject">제목</label>
			<input id = "subject" type ="text" name = "subject" />
			<br />
			
			<label for="email">이메일</label>
			<input id="email" type="email" name="email" />
			<br />
			
			<label for="content">내용</label>
			<textarea id="content" name="content"></textarea>
			<br />
			
			<div class="btn-group">
				<div class="right=align">
					<input type="submit" value="저장" />
				</div>
			</div>
		</div>
	</form>
</body>
</html>