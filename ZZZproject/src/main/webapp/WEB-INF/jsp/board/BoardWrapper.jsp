<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/boardw.css" rel="stylesheet"  type="text/css" />
<title>Welcome</title>
</head>
<body>
  <div id='wrapper'>
    <jsp:include page="/Header.jsp"/>
    <div id='sidebar'>
    <ul>
      <li><form action="/zzz/board/list.do" method="get">
      <input type="hidden" name="action" value="boardlist">      
      <button>게시판</button></form></li>
      <li><form action="/zzz/mail/box.do" method="get">
      <input type="hidden" name="action" value="maillist">
      <button>이메일</button></form></li>
    </ul>
    </div>
    <div id='content'>
    <c:if test="${action =='boardlist'}">
    1<jsp:include page="./BoardList.jsp"/>
    </c:if>
    <c:if test="${action =='maillist'}">
    2<jsp:include page="../mail/MailList.jsp"/>
    </c:if>
    </div>
    
  </div>
  <div id='footer'>
  <jsp:include page="/Copyright.jsp"/>
  </div>

</body>
</html>