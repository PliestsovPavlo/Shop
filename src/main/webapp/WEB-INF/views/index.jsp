<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

		<a href="/registration">registration</a>
		<a href="/login">login</a>
		<a href="/admin">admin</a>
		<a href="/">Home</a>
		<a href="<c:url value="/logout" />">Logout</a>		
<form:form>
${user}
<c:forEach items="${books.content}" var="book">
				<div class="row">
					<div class="col-md-2 col-xs-2">${book.title}</div>
					<div class="col-md-2 col-xs-2">${book.author.lastName}</div>
					<div class="col-md-2 col-xs-2">${book.category.nameOfCategory}</div>
					<div class="col-md-2 col-xs-2">${book.price}</div><br><br>
<!--					<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/book/update/${book.id}<custom:allParams/>">update</a></div>
					<div class="col-md-2col-xs-2"><a class="btn btn-danger" href="/admin/book/delete/${book.id}<custom:allParams/>">delete</a></div>
-->
<security:authorize access="isAuthenticated()">

					<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/user/buy/${book.id}<custom:allParams/>">buy</a></div>
</security:authorize>
				</div>
			</c:forEach>

</form:form>

</body>
</html>