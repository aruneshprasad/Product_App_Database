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

<jsp:include page="/Banner.jsp"/>
<jsp:include page="/Menu.jsp"/>

<form action="ProductController?menu=add" method="post">
	<table rowspacing="5" cellspacing="5" align="center">
	
		<tr>
			<th>Product Id</th>
			<td><input type="text" name="id"> </td>
		</tr>
		
		<tr>
			<th>Product Name</th>
			<td><input type="text" name="name"> </td>
		</tr>
		
		<tr>
			<th>Price</th>
			<td><input type="text" name="price"> </td>
		</tr>
		
		<tr>
			<th>Description</th>
			<td><textarea name="description"></textarea> </td>
		</tr>
		
		<tr>
			<td colspan="2"><hr></td>
		</tr>
		
		<tr>
			<th colspan="2">
					${param.msg}
			</th>
		</tr>
		
		<tr>
			<th colspan="2">
				<input type="submit" value="Save">
				<input type="reset" value="Clear All">
			</th>
		
		</tr>
	
	</table>
</form>
</body>
</html>