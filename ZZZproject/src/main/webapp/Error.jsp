<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <meta charset='UTF-8'>
 <title>시스템 오류</title>
</head>
<body>
<h1>시스템 오류</h1>
<pre>
<%
Exception e = (Exception) request.getAttribute("error");
e.printStackTrace(new PrintWriter(out));
%>
</pre>


<jsp:include page="/Copyright.jsp"/>
</body>
</html>
