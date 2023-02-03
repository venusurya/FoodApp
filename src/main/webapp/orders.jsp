<%@page import="com.ty.jsp_application_eb8_prc.dto.Items"%>
<%@page import="java.util.List"%>
<%@page import="com.ty.jsp_application_eb8_prc.dto.FoodOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


   
    
    
    
    
    
    
    	<%
	List<Items> menus = (List) request.getAttribute("menus");
    	if(menus!=null){
	%>
	<table border="2px solid">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Offer</th>
			<th>Quantity</th>
		</tr>
		<%
		for (Items menu : menus) {
		%>
		<tr>
			<td><%=menu.getId()%></td>
			<td><%=menu.getName()%></td>
			<td><%=menu.getDescription()%></td>
			<td><%=menu.getPrice()%></td>
			<td><%=menu.getOffer()%></td>
			<td><%=menu.getQuantity()%></td>
		</tr>
		<%
		}
		%>
	</table>
<%} %>


    <a href="customer.jsp"><input type="submit" value="Exit"></a>
</body>
</html>