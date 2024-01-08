package com.demo.qrcode.simple.project.service;

import java.util.List;

import com.demo.qrcode.simple.project.dao.CustomerDao;
import com.demo.qrcode.simple.project.dto.Customer;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class CustomerService {

	CustomerDao customerDao = new CustomerDao();

	/*
	 * insert the method....
	 */

	public Customer insertCustomer(Customer customer) {

		return customerDao.insertCustomer(customer);

	}

	// get all customers method
	public List<Customer> getAllCustomers() {

		return customerDao.getAllCustomers();

	}

	// delete customer method
	public int deleteCustomer(String regnNumber) {

		return customerDao.deleteCustomer(regnNumber);

	}

	// get customer by regnNumber method
	public Customer getCustomerByRegnNumber(String regnNumber) {

		return customerDao.getCustomerByRegnNumber(regnNumber);
	}

}
