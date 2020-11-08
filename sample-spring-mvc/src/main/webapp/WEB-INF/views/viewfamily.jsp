<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>


<h1>Welcome to My Family</h1>

<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Profession</th>
		<th>Weight</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="f_member" items="${familyMembers}">
		<tr>
			<td>${f_member.f_id}</td>
			<td>${f_member.f_name}</td>
			<td>${f_member.f_profession}</td>
			<td>${f_member.f_weight}</td>
			<td><a href="editfamily/${f_member.f_id}">Edit</a></td>  
   			<td><a href="deletefamily/${f_member.f_id}">Delete</a></td>  
		</tr>
	</c:forEach>
</table>
<a href="familyform">Add New Member</a>  

</html>