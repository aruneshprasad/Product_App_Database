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

<jsp:include page="Index.jsp"/>

<form action="ProductController?menu=delete" method="post">
	<table align="center">
		<tr>
			<th>Product Id</th>
			<td>
				<select name="id">
					<c:forEach var="product" items="${products}">
						<option>${product.id}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		
		<tr>
			<th colspan = "2">${param.msg}</th>
		</tr>
		
		<tr>
			<th colspan="2">
				<input type="submit" value="Delete"/>
			</th>
		</tr>
	</table>
</form>

</body>
</html>