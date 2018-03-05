<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add or Update Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

		<div id="container">
		<h3>Delete Customer</h3>
		
		<form:form action="deleteCustomer" modelAttribute="customer" method="POST">
			
			<!-- Need to associate this form data to Customer with Id -->
			<form:hidden path="id" />
			<!-- This will act while loading as newCustomer.getId() and while submitting as newCustomer.setId() -->
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" disabled="true" /></td>
					</tr>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" disabled="true" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email" disabled="true" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Delete" onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false" class=save /></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a>
		</p>

	</div>

</body>
</html>