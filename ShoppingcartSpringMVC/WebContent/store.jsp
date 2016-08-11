<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="ex" uri="mytags"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products stored in shop</title>
<h1>Welcome To SmallBasket </h1>
</head>
<body>

<form:form commandName="products" method="POST" action="addtocart">
<c:forEach var="item" items="${ormap}">
    	
    	  	<td>
    	  		<input type="checkbox" name="PID" value="${item.PID}">

    		<tr>
    		<td>${item.prodName}</td>
    		</tr>
    		
    		<tr>
    		<td>${i.stock}</td><br>
    		</tr>
    		
</c:forEach>
<table>
	<tr>
		<td>
			<INPUT id="submit" name="submit" type="submit" value="Submit Items"/>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>