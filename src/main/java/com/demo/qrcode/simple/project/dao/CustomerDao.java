package com.demo.qrcode.simple.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.qrcode.simple.project.connection.AdminConnection;
import com.demo.qrcode.simple.project.dto.Customer;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class CustomerDao {

	Connection connection = AdminConnection.getConnection();

	/*
	 * insert the method....
	 */

	public Customer insertCustomer(Customer customer) {
		String insert = "insert into customer values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insert);
			preparedStatement.setString(1, customer.getRegnNumber());
			preparedStatement.setString(2, customer.getRegdOwner());
			preparedStatement.setString(3, customer.getsDWf());
			preparedStatement.setString(4, customer.getPurpose());

			preparedStatement.setString(5, customer.getRegnDate());
			preparedStatement.setString(6, customer.getManufacturingDt());
			preparedStatement.setString(7, customer.getTaxPAidUpTo());
			preparedStatement.setString(8, customer.getRegdValidity());

			preparedStatement.setString(9, customer.getColour());
			preparedStatement.setString(10, customer.getFuel());
			preparedStatement.setString(11, customer.getVehicleClass());
			preparedStatement.setString(12, customer.getBodyType());

			preparedStatement.setString(13, customer.getManufacturar());
			preparedStatement.setString(14, customer.getChassisNo());
			preparedStatement.setString(15, customer.getEngineNo());
			preparedStatement.setString(16, customer.getModelNo());

			preparedStatement.setString(17, customer.getHypothecatedTo());
			preparedStatement.setInt(18, customer.getUnladenWt());
			preparedStatement.setDouble(19, customer.getCubicCapacity());
			preparedStatement.setInt(20, customer.getSeatCapacity());
			preparedStatement.setInt(21, customer.getStandCapacity());

			preparedStatement.setInt(22, customer.getNoofcyc());
			preparedStatement.setInt(23, customer.getOwnerserial());
			preparedStatement.setInt(24, customer.getWheelBase());
			preparedStatement.setInt(25, customer.getrLW());

			preparedStatement.setString(26, customer.getAddress());
			preparedStatement.setString(27, customer.getIssuing());
			preparedStatement.setBytes(28, customer.getSignature());
			preparedStatement.execute();

			return customer;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// get all customers method
	public List<Customer> getAllCustomers() {

		String displayQuery = "select * from customer";

		List<Customer> customers = new ArrayList<Customer>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayQuery);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setRegnNumber(resultSet.getString("regnNumber"));
				customer.setRegdOwner(resultSet.getString("regdOwner"));
				customer.setsDWf(resultSet.getString("sdwf"));
				customer.setPurpose(resultSet.getString("purpose"));

				customer.setRegnDate(resultSet.getString("regnDate"));
				customer.setManufacturingDt(resultSet.getString("manufacturingDt"));
				customer.setTaxPAidUpTo(resultSet.getString("taxPAidUpTo"));
				customer.setRegdValidity(resultSet.getString("regdValidity"));

				customer.setColour(resultSet.getString("colour"));
				customer.setFuel(resultSet.getString("fuel"));
				customer.setVehicleClass(resultSet.getString("vehicleClass"));
				customer.setBodyType(resultSet.getString("bodyType"));

				customer.setManufacturar(resultSet.getString("manufacturar"));
				customer.setChassisNo(resultSet.getString("chassisNo"));
				customer.setEngineNo(resultSet.getString("engineNo"));
				customer.setModelNo(resultSet.getString("modelNo"));

				customer.setHypothecatedTo(resultSet.getString("hypothecatedTo"));
				customer.setUnladenWt(resultSet.getInt("unladenWt"));
				customer.setCubicCapacity(resultSet.getInt("cubicCapacity"));
				customer.setSeatCapacity(resultSet.getInt("seatCapacity"));
				customer.setStandCapacity(resultSet.getInt("standCapacity"));

				customer.setNoofcyc(resultSet.getInt("noofcyc"));
				customer.setOwnerserial(resultSet.getInt("ownerserial"));
				customer.setWheelBase(resultSet.getInt("wheelBase"));
				customer.setrLW(resultSet.getInt("rLW"));

				customer.setAddress(resultSet.getString("Aaddress"));
				customer.setIssuing(resultSet.getString("issuing"));
				customer.setSignature(resultSet.getBytes("signature"));

				customers.add(customer);
			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// get customer by regnNumber method
	public Customer getCustomerByRegnNumber(String regnNumber) {

		String query = "select * from customer where regnNumber=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, regnNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setRegnNumber(resultSet.getString("regnNumber"));
				customer.setRegdOwner(resultSet.getString("regdOwner"));
				customer.setsDWf(resultSet.getString("sdwf"));
				customer.setPurpose(resultSet.getString("purpose"));

				customer.setRegnDate(resultSet.getString("regnDate"));
				customer.setManufacturingDt(resultSet.getString("manufacturingDt"));
				customer.setTaxPAidUpTo(resultSet.getString("taxPAidUpTo"));
				customer.setRegdValidity(resultSet.getString("regdValidity"));

				customer.setColour(resultSet.getString("colour"));
				customer.setFuel(resultSet.getString("fuel"));
				customer.setVehicleClass(resultSet.getString("vehicleClass"));
				customer.setBodyType(resultSet.getString("bodyType"));

				customer.setManufacturar(resultSet.getString("manufacturar"));
				customer.setChassisNo(resultSet.getString("chassisNo"));
				customer.setEngineNo(resultSet.getString("engineNo"));
				customer.setModelNo(resultSet.getString("modelNo"));

				customer.setHypothecatedTo(resultSet.getString("hypothecatedTo"));
				customer.setUnladenWt(resultSet.getInt("unladenWt"));
				customer.setCubicCapacity(resultSet.getInt("cubicCapacity"));
				customer.setSeatCapacity(resultSet.getInt("seatCapacity"));
				customer.setStandCapacity(resultSet.getInt("standCapacity"));

				customer.setNoofcyc(resultSet.getInt("noofcyc"));
				customer.setOwnerserial(resultSet.getInt("ownerserial"));
				customer.setWheelBase(resultSet.getInt("wheelBase"));
				customer.setrLW(resultSet.getInt("rLW"));

				customer.setAddress(resultSet.getString("Aaddress"));
				customer.setIssuing(resultSet.getString("issuing"));
				customer.setSignature(resultSet.getBytes("signature"));
				
				return customer;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// delete customer method
	public int deleteCustomer(String regnNumber) {

		String deleteQuery = "delete from customer where regnNumber=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setString(1, regnNumber);
			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
}
