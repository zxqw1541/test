<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>쪽지-새글</title>
</head>
<body>
  <h1>새 쪽지</h1>
  <form action='add.do' method='post' enctype="multipart/form-data">
    <table border='1'>
      <tr>
        <th>제목</th>
        <td><input type='text' name='title' placeholder="제목을 넣으세요."></td>
      </tr>
      <tr>
        <th>내용</th>
        <td><textarea name='content' rows='10' cols='60' placeholder="내용을 입력하세요."></textarea></td>
      </tr>
    </table>
    <p>
      <button type='submit'>등록</button>
    </p>
    
</body>
</html>





