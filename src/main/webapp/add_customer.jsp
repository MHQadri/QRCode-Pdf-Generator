<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<link rel="stylesheet" href="css/addcustomer.css">
</head>
<body>
	<div>
		<jsp:include page="navbar.jsp" />
	</div>

	<div class="formbold-main-wrapper">
		<!-- Author: FormBold Team -->
		<!-- Learn More: https://formbold.com -->
		<div class="formbold-form-wrapper">

			<form action="insertCustomer" method="post" enctype="multipart/form-data">
				<div class="formbold-form-title">
					<h2 class="">Add Customer Details</h2>

				</div>

				<div class="formbold-input-flex">
					<div>
						<label for="regnNumber" class="formbold-form-label"> Regn.
							Number: </label> <input type="text" id="regnNumber"
							class="formbold-form-input" name="regnNumber" />
					</div>
					<div>
						<label for="regdOwner" class="formbold-form-label"> Regd.
							Owner: </label> <input type="text" id="regdOwner"
							class="formbold-form-input" name="regdOwner" />
					</div>
					<div>
						<label for="sDWf" class="formbold-form-label"> S/D/W of: </label>
						<input type="text" id="sDWf" class="formbold-form-input"
							name="sDWf" />
					</div>
				</div>

				<div class="formbold-input-flex">
					<div>
						<label for="purpose" class="formbold-form-label"> Purpose:
						</label> <input type="text" id="purpose" class="formbold-form-input"
							name="purpose" />
					</div>
					<div>
						<label for="regnDate" class="formbold-form-label">
							Regn.Date: </label> <input type="text" id="regnDate"
							class="formbold-form-input" name="regnDate" />
					</div>
					<div>
						<label for="manufacturingDt" class="formbold-form-label">
							Manufacturing Dt. </label> <input type="text" id="manufacturingDt"
							class="formbold-form-input" name="manufacturingDt" />
					</div>
				</div>

				<div class="formbold-input-flex">
					<div>
						<label for="taxPAidUpTo" class="formbold-form-label"> Tax
							Paid Up To. </label> <input type="text" id="taxPAidUpTo"
							class="formbold-form-input" name="taxPAidUpTo" />
					</div>
					<div>
						<label for="regdValidity" class="formbold-form-label">
							Regd.Validity </label> <input type="text" name="regdValidity"
							id="regdValidity" class="formbold-form-input" />
					</div>
					<div>
						<label for="colour" class="formbold-form-label"> Colour: </label>
						<input type="text" name="colour" id="colour"
							class="formbold-form-input" />
					</div>
				</div>

				<div class="formbold-input-flex">
					<div>
						<label for="fuel" class="formbold-form-label"> Fuel: </label> <input
							type="text" name="fuel" id="fuel" class="formbold-form-input" />
					</div>
					<div>
						<label for="vehicleClass" class="formbold-form-label">
							Vehicle Class: </label> <input type="text" name="vehicleClass"
							id="vehicleClass" class="formbold-form-input" />
					</div>
					<div>
						<label for="bodyType" class="formbold-form-label"> Body
							Type: </label> <input type="text" name="bodyType" id="bodyType"
							class="formbold-form-input" />
					</div>
				</div>

				<div class="formbold-input-flex">
					<div>
						<label for="manufacturar" class="formbold-form-label">
							Manufacturar: </label> <input type="text" name="manufacturar"
							id="manufacturar" class="formbold-form-input" />
					</div>
					<div>
						<label for="chassisNo" class="formbold-form-label">
							Chassis No: </label> <input type="text" name="chassisNo" id="chassisNo"
							class="formbold-form-input" />
					</div>
					<div>
						<label for="engineNo" class="formbold-form-label"> Engine
							No: </label> <input type="text" name="engineNo" id="engineNo"
							class="formbold-form-input" />
					</div>
				</div>

				<div class="formbold-input-flex">
					<div>
						<label for="modelNo" class="formbold-form-label"> Model
							No: </label> <input type="text" name="modelNo" id="modelNo"
							class="formbold-form-input" />
					</div>
					<div>
						<label for="seatCapacity" class="formbold-form-label">
							Seat Capacity</label> <input type="text" name="seatCapacity"
							id="seatCapacity" class="formbold-form-input" />
					</div>
					<div>
						<label for="standCapacity" class="formbold-form-label">
							Stand Capacity </label> <input type="text" name="standCapacity"
							id="standCapacity" class="formbold-form-input" />
					</div>

				</div>

				<div class="formbold-input-flex">
					
					<div>
						<label for="hypothecatedTo" class="formbold-form-label">
							Hypothecated To </label> <input type="text" name="hypothecatedTo" id="hypothecatedTo"
							class="formbold-form-input" />
					</div>
					<div>
						<label for="unladenWt" class="formbold-form-label">
							Unladen Wt </label> <input type="text" name="unladenWt" id="unladenWt"
							class="formbold-form-input" />
					</div>
					<div>
						<label for="cubicCapacity" class="formbold-form-label">
							Cubic Capacity </label> <input type="text" name="cubicCapacity"
							id="cubicCapacity" class="formbold-form-input" />
					</div>

				</div>

				<div class="formbold-input-flex">
					<div>
						<label for="noofcyc" class="formbold-form-label"> No of
							Cyc. </label> <input type="text" name="noofcyc" id="noofcyc"
							class="formbold-form-input" />
					</div>
					<div>
						<label for="ownerserial" class="formbold-form-label">
							Owner Serial </label> <input type="text" name="ownerserial"
							id="ownerserial" class="formbold-form-input" />
					</div>
					<div>
						<label for="wheelBase" class="formbold-form-label"> Wheel
							Base. </label> <input type="text" name="wheelBase" id="wheelBase"
							class="formbold-form-input" />
					</div>
				</div>

				<div class="formbold-input-flex">
					<div>
						<label for="rLW" class="formbold-form-label"> R.L.W </label> <input
							type="text" name="rLW" id="rLW" class="formbold-form-input" />
					</div>
					<div>
						<label for="address" class="formbold-form-label"> Address
						</label> <input type="text" name="address" id="address"
							class="formbold-form-input" />
					</div>
					<div>
						<label for="issuing" class="formbold-form-label">Issuing
							Authority </label> <input type="text" name="issuing" id="issuing"
							class="formbold-form-input" />
					</div>
				</div>
				<div class="formbold-input-flex">
						<div>
						<label for="issuing" class="formbold-form-label">Signature
							 </label> <input type="file" name="signature" id="issuing"
							class="formbold-form-input" />
					</div>
				</div>
				<button class="formbold-btn">Add Customer</button>
				<button class="formbold-btn" type="reset">Reset</button>
			</form>
		</div>
	</div>

</body>
</html>