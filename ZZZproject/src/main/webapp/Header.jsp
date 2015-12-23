<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="boarder: 1px solid gray; background-color: aqua;">
프로젝트 관리 시스템 -
  <c:if test="${not empty loginUser}">${loginUser.name}(${loginUser.email}) 
    <a href="${pageContext.request.contextPath}/auth/logout.do">로그아웃</a>
  </c:if>
  <c:if test="${empty loginUser}">
    <a href="${pageContext.request.contextPath}/auth/login.do">로그인</a>
  </c:if>
</div> 