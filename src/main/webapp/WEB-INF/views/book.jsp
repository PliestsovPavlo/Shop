<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book</title>

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
					<li><a href="/admin/author">Author</a></li>
					<li class="active"><a href="/admin/book">Book</a></li>
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
				<form:form class="form-horizontal" action="/admin/book" method="POST" modelAttribute="bookForm">
				<custom:hiddenInputs excludeParams="title, price, author, category"/>
				
					<div class="form-group">
						<div class="form-group">
						<label for="author" class="col-sm-10 col-sm-offset-2">
							<form:errors path="author"/>
						</label>
					</div>
					<div class="form-group">
    					<label for="author" class="col-sm-2 control-label">Author</label>
    					<div class="col-sm-10">
							<form:select path="author" id="authorId" items="${authors}" itemValue="id" itemLabel="lastName"></form:select>
    					</div>
  					</div>
  					</div>
  					
  					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="category"></form:errors>
						</label>
  					<div class="form-group">
    					<label for="category" class="col-sm-2 control-label">Category</label>
    					<div class="col-sm-10">
							<form:select path="category" id="categoryId" items="${categories}" itemValue="id" itemLabel="nameOfCategory"></form:select>
    					</div>
  					</div>
					</div>
  					
  					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="title"></form:errors>
						</label>
  					<div class="form-group">
    					<label for="title" class="col-sm-2 control-label">Title</label>
    					<div class="col-sm-10">
							<form:input class="form-control" path="title" id="title"/>   
 					</div>
 					</div>
 					</div>
  					<div class="form-group">
						<label class="col-sm-10 col-sm-offset-2">
							<form:errors path="price"></form:errors>
						</label>
  					<div class="form-group">
    					<label for="price" class="col-sm-2 control-label">Price</label>
    					<div class="col-sm-10">
							<form:input class="form-control" path="price" id="price"/>   
 					</div>
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
			<div class="col-md-2 col-xs-2"><h3>Title</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Author</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Category</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Price</h3></div>
			
		</div>
			<c:forEach items="${books.content}" var="book">
				<div class="row">
					<div class="col-md-2 col-xs-2">${book.title}</div>
					<div class="col-md-2 col-xs-2">${book.author.lastName}</div>
					<div class="col-md-2 col-xs-2">${book.category.nameOfCategory}</div>
					<div class="col-md-2 col-xs-2">${book.price}</div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/book/update/${book.id}<custom:allParams/>">update</a></div>
					<div class="col-md-2col-xs-2"><a class="btn btn-danger" href="/admin/book/delete/${book.id}<custom:allParams/>">delete</a></div>			
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
						<custom:sort innerHtml="Name asc" paramValue="title"/>
						<custom:sort innerHtml="Name desc" paramValue="title,desc"/>
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
		<custom:pageable page="${books}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>
</body>
</html>