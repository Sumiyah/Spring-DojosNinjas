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
    <h1>New Dojo</h1>
    <div class="row">
			<form:form action="/dojos" method="post"
				modelAttribute="dojo">
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<form:errors path="name" />
					<form:input path="name" />
				</div>
				<input type="submit" value="Create" />
			</form:form>
		</div>
  </div>
</body>
</html>