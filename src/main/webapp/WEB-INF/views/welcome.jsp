<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/WEB-INF/views/includes.jsp"%>
<!doctype html>
<html>
<head>
	<title>Welcome page</title>
	<link rel="stylesheet" href="resources/static/css/styles.css">
</head>
<body>
<fmt:setLocale value="${locale}" scope="page"/>	
<fmt:setBundle basename="messages.Info" scope="page"  />
<div id="main">
	<div class="title"><fmt:message key="caption"/></div>
	<table class="viewTable">
		<tr>
			<td><fmt:message key="login"/></td>
			<td>${account.login}</td>
		<tr>
		<tr>
			<td><fmt:message key="password"/></td>
			<td>${account.password}</td>
		<tr>
		<tr>
			<td><fmt:message key="language"/></td>
			<td><fmt:message key="language.${language}"/></td>
		<tr>
	</table>
</div>	
</body>
</html>