<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Select those products which you want to buy </h2>

<form:form commandName="products" method="POST" action="finalcart">

<c:forEach var="i" items = "${list1}">
    	
    	  	<td>
    	  		<input type="checkbox" name="PID" value="${i.PID}">
			<tr>
    		<td>${i.prodName}</td>
    		</tr>
			
    		<tr>
    		<td>${i.prodPrice}</td>
    		</tr>
    		
    		<tr>
    		<td>${i.stock}</td><br>
    		</tr>
    		
    		
    		</td>
    		
</c:forEach>
<table>
	<tr>
		<td>
			<INPUT id="submit" name="submit" type="submit" value="Final Items"/>
		</td>
	</tr>
</table>
</form:form>

</body>
</html>