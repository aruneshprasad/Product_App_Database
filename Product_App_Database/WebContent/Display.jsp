<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Application</title>
</head>
<body>

<jsp:include page="/Index.jsp"/>

<div align="center">
<h2>${param.msg}</h2>
</div>

<c:if test="${requestScope.products ne null }">

<table rowspacing="5" cellspacing="5" align="center">


<tr>
	<th>Product Id</th>
	<th>Product Name</th>
	<th>Price</th>
	<th>Description</th>
	<th>Link-1</th>
	<th>Link-2</th>
	
</tr>

<c:forEach var="product" items="${products}">
	<tr>
	
		<td> ${product.id} </td>
		<td> ${product.name} </td>
		<td> ${product.price} </td>
		<td> ${product.description} </td>
		<td><a href="ProductController?menu=updateRequest&&id=${product.id}">Update</a>
		<td><a href="ProductController?menu=delete&&id=${product.id}">Delete</a>
	</tr>

</c:forEach>

</table>


</c:if>

</body>
</html>