<%-- EL을 이용하여 게시물 데이터 출력하기 --%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<body>
<h1>게시판</h1>

<a href='add.do'>새 메일</a><br>
<table border='1'>
   <tr>
     <th>제목</th>
     <th>받는사람</th>
     <th>보낸사람</th>
     <th>보낸날짜</th>
   </tr>
<c:forEach var="mail" items="${mails}">
   <tr>
     <td><a href='detail.do?no=${mail.no}'>${mail.title}</a></td>
     <td>${mail.receiver}</td>
     <td>${mail.sender}</td>
     <td>${mail.sendDate}</td>
   </tr>
</c:forEach>
</table>
