<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Author</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/category">Category</a></li>
					<li class="active"><a href="/admin/author">Author</a></li>
					<li><a href="/admin/book">Book</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/author" method="POST" modelAttribute="authorForm">
					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="firstName"></form:errors>
						</label>
					</div>
					<div class="form-group">
    					<label for="firstName" class="col-sm-2 control-label">First Name</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="firstName" id="firstName"/>
    					</div>
  					</div>
  					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="lastName"></form:errors>
						</label>
					</div>
  					<div class="form-group">
    					<label for="lastName" class="col-sm-2 control-label">Last Name</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="lastName" id="lastName"/>
    					</div>
  					</div>
  					  					    				
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Save</button>
      						<a class="btn btn-primary" href="/admin/author/cancel<custom:allParams/>">Cancel</a>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-xs-3"><h3>Author first name</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Author last name</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Update</h3></div>
			<div class="col-md-3 col-xs-3"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${authors.content}" var="author">
				<div class="row">
					<div class="col-md-3 col-xs-3">${author.firstName}</div>
					<div class="col-md-3 col-xs-3">${author.lastName}</div>
					
					<div class="col-md-3 col-xs-3"><a class="btn btn-warning" href="/admin/author/update/${author.id}<custom:allParams/>">update</a></div>
					<div class="col-md-3 col-xs-3"><a class="btn btn-danger" href="/admin/author/delete/${author.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
	</div>
<div class="col-md-2 col-xs-12">
		<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="firstName"/>
						<custom:sort innerHtml="Name desc" paramValue="firstName,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${authors}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>


</body>
</html>