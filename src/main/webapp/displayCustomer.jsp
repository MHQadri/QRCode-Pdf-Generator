
<%@page import="java.util.Base64"%>
<%@page import="com.demo.qrcode.simple.project.dto.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.demo.qrcode.simple.project.service.CustomerService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers Detail</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Quicksand:wght@500&family=Ysabeau+SC:wght@300&display=swap')
	;

* {
	margin: 0px;
	padding: 0px;
}

th {
	font-family: 'Quicksand', sans-serif;
	font-family: 'Ysabeau SC', sans-serif;
}

.csm-btn {
	height: 30px;
	padding-left: 10px;
	padding-right: 10px;
	background: #fb8633;
	border: none;
	cursor: pointer;
}
}
</style>
</head>
<body>

	<%
	CustomerService service = new CustomerService();
	List<Customer> customers = service.getAllCustomers();
	%>
	<div>
		<jsp:include page="navbar.jsp"></jsp:include>
	</div>
	<div style="text-align: center; margin: 10px; font-size: 30px;">

		Customers Details</div>
	<div style="overflow: scroll;">
		<table border="1px" style="width: auto; table-layout: fixed;">
			<tr style="background-color: #6a64f1; color: white;">
				<th>Regn. Number</th>
				<th>Regd. Owner</th>
				<th>S/D/W of</th>
				<th>Purpose</th>
				<th>Regn.Date</th>
				<th>Manufacturing Dt</th>
				<th>Tax Paid Up To</th>
				<th>Regd.Validity</th>
				<th>Colour</th>
				<th>Fuel</th>
				<th>Vehicle Class</th>
				<th>Body Type</th>
				<th>Manufacturar</th>
				<th>Chassis No</th>
				<th>Engine No</th>
				<th>Model No</th>
				<th>Hypothecated To</th>
				<th>Seat Capacity</th>
				<th>Owner Serial</th>
				<th>Wheel Base</th>
				<th>Address</th>
				<th>Signature</th>
				<th colspan="2">Action</th>
			</tr>
			<%
			for (Customer customer : customers) {
			%>

			<tr>
				<td><%=customer.getRegnNumber()%></td>
				<td><%=customer.getRegdOwner()%></td>
				<td><%=customer.getsDWf()%></td>
				<td><%=customer.getPurpose()%></td>
				<td><%=customer.getRegnDate()%></td>
				<td><%=customer.getManufacturingDt()%></td>
				<td><%=customer.getTaxPAidUpTo()%></td>
				<td><%=customer.getRegdValidity()%></td>
				<td><%=customer.getColour()%></td>
				<td><%=customer.getFuel()%></td>
				<td><%=customer.getVehicleClass()%></td>
				<td><%=customer.getBodyType()%></td>
				<td><%=customer.getManufacturar()%></td>
				<td><%=customer.getChassisNo()%></td>
				<td><%=customer.getEngineNo()%></td>
				<td><%=customer.getModelNo()%></td>
				<td><%=customer.getHypothecatedTo()%></td>
				<td><%=customer.getSeatCapacity()%></td>
				<td><%=customer.getNoofcyc()%></td>
				<td><%=customer.getWheelBase()%></td>
				<td><%=customer.getAddress()%></td>
				<td>
					<%
					if (customer.getSignature() != null) {
					%> <img	style="max-width: 150px; max-height: 80px;"
					src="data:image/jpeg;base64,<%=new String(java.util.Base64.getEncoder().encode(customer.getSignature())) %>"
					alt="Employee Image" /> <%
 				} else {%>

					<p>No Signature Available</p> <%} %>

				</td>

				<td><a href="delete?regnNumber=<%=customer.getRegnNumber()%>"><button
							class="csm-btn">Delete</button></a></td>
				<td><a href="print?regnNumber=<%=customer.getRegnNumber()%>"><button
							class="csm-btn">Print</button></a></td>
				<%
				}
				%>
			
		</table>
	</div>
</body>
</html>