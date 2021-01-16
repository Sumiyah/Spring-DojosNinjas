<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dojos - Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container text-center">
    <h1>New Ninja</h1>
    <h3><a href="/dojos">Dojos</a></h3>
		<a href="/ninjas/new">Add Ninja</a>
		<hr />
		<h2>All Ninjas</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Dojo</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ ninjas }" var="ninja">
				<tr>
					<td>${ ninja.firstName } ${ ninja.lastName }</td>
					<td>${ ninja.age }</td>
					<td>${ ninja.dojo.name }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
  </div>
</body>
</html>