<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Application</title>
</head>
<body>

<jsp:include page="/Banner.jsp"/>
<jsp:include page="/Menu.jsp"/>

<form action="ProductController?menu=update" method="post">
	<table rowspacing="5" cellspacing="5" align="center">
	
		<tr>
			<th>Product Id</th>
			<td><input type="text" name="id" value="${product.id}" readonly="readonly"> </td>
		</tr>
		
		<tr>
			<th>Product Name</th>
			<td><input type="text" name="name" value="${product.name}"> </td>
		</tr>
		
		<tr>
			<th>Price</th>
			<td><input type="text" name="price" value="${product.price}"> </td>
		</tr>
		
		<tr>
			<th>Description</th>
			<td><textarea name="description">${product.description}</textarea> </td>
		</tr>
		
		<tr>
			<th colspan="2">
					${param.msg}
			</th>
		</tr>
		
		<tr>
			<th colspan="2">
				<input type="submit" value="Save">
			</th>
		
		</tr>
	
	</table>
</form>
</body>
</html>