<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category</title>

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
					<li class="active"><a href="/admin/category">Category</a></li>
					<li><a href="/admin/author">Author</a></li>
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
				<form:form class="form-horizontal" action="/admin/category" method="POST" modelAttribute="categoryForm">
				<custom:hiddenInputs excludeParams="nameOfCategory"/>
				
					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
						<form:errors path="nameOfCategory"></form:errors>
						</label>
					</div>
					<div class="form-group">
    					<label for="nameOfCategory" class="col-sm-2 control-label">Name Of Category</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="nameOfCategory" id="nameOfCategory"/>
    					</div>
  					</div>
  							    				
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Save</button>
      						<a class="btn btn-primary" href="/admin/category/cancel<custom:allParams/>">Cancel</a>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-xs-4"><h3>Name of category</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Update</h3></div>
			<div class="col-md-4 col-xs-4"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${categories.content}" var="category">
				<div class="row">
					<div class="col-md-4 col-xs-4">${category.nameOfCategory}</div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-warning" href="/admin/category/update/${category.id}<custom:allParams/>">update</a></div>
					<div class="col-md-4 col-xs-4"><a class="btn btn-danger" href="/admin/category/delete/${category.id}<custom:allParams/>">delete</a></div>
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
						<custom:sort innerHtml="Name asc" paramValue="nameOfCategory"/>
						<custom:sort innerHtml="Name desc" paramValue="nameOfCategory,desc"/>
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
		<custom:pageable page="${categories}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>
</body>
</html>