<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Application</title>
</head>
<body>
<jsp:include page="/Index.jsp"/>
<form action="ProductController?menu=find" method="post">
	<table align="center" rowspacing="5" cellspacing="5">
		<tr>
			<th>Product Id:</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th colspan="2">
				${param.msg}
			</th>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="Find">
				<input type="reset" value="Clear All">
			</th>
		</tr>
		
	</table>
</form>

</body>
</html>