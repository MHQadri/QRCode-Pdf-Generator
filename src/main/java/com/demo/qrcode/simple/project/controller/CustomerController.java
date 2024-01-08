package com.demo.qrcode.simple.project.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.demo.qrcode.simple.project.dto.Customer;
import com.demo.qrcode.simple.project.service.CustomerService;

@WebServlet("/insertCustomer")
@MultipartConfig
public class CustomerController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CustomerService customerService = new CustomerService();
		HttpSession httpSession = req.getSession();

		String a1 = req.getParameter("regnNumber");
		String a2 = req.getParameter("regdOwner");
		String a3 = req.getParameter("sDWf");
		String a4 = req.getParameter("purpose");

		String b = req.getParameter("regnDate");
		String b1 = req.getParameter("manufacturingDt");
		String b2 = req.getParameter("taxPAidUpTo");
		String b3 = req.getParameter("regdValidity");

		String c = req.getParameter("colour");
		String c1 = req.getParameter("fuel");
		String c2 = req.getParameter("vehicleClass");
		String c3 = req.getParameter("bodyType");

		String d = req.getParameter("manufacturar");
		String d1 = req.getParameter("chassisNo");
		String d2 = req.getParameter("engineNo");
		String d3 = req.getParameter("modelNo");

		String e4 = req.getParameter("hypothecatedTo");
		int e = Integer.parseInt(req.getParameter("unladenWt"));
		double e1 = Double.parseDouble(req.getParameter("cubicCapacity"));
		int e2 = Integer.parseInt(req.getParameter("seatCapacity"));
		int e3 = Integer.parseInt(req.getParameter("standCapacity"));

		int f = Integer.parseInt(req.getParameter("noofcyc"));
		int f1 = Integer.parseInt(req.getParameter("ownerserial"));
		int f2 = Integer.parseInt(req.getParameter("wheelBase"));
		int f3 = Integer.parseInt(req.getParameter("rLW"));

		String g = req.getParameter("address");
		String g1 = req.getParameter("issuing");

		Part part = req.getPart("signature");
		
		 byte[] imageData = IOUtils.toByteArray(part.getInputStream());
		

		Customer customer = new Customer();

		customer.setRegnNumber(a1);
		customer.setRegdOwner(a2);
		customer.setsDWf(a3);
		customer.setPurpose(a4);

		customer.setRegnDate(b);
		customer.setManufacturingDt(b1);
		customer.setTaxPAidUpTo(b2);
		customer.setRegdValidity(b3);

		customer.setColour(c);
		customer.setFuel(c1);
		customer.setVehicleClass(c2);
		customer.setBodyType(c3);

		customer.setManufacturar(d);
		customer.setChassisNo(d1);
		customer.setEngineNo(d2);
		customer.setModelNo(d3);

		customer.setHypothecatedTo(e4);
		customer.setUnladenWt(e);
		customer.setCubicCapacity(e1);
		customer.setSeatCapacity(e2);
		customer.setStandCapacity(e3);

		customer.setNoofcyc(f);
		customer.setOwnerserial(f1);
		customer.setWheelBase(f2);
		customer.setrLW(f3);

		customer.setAddress(g);
		customer.setIssuing(g1);

		customer.setSignature(imageData);

		customerService.insertCustomer(customer);

		RequestDispatcher reqdd = req.getRequestDispatcher("displayCustomer.jsp");
		reqdd.forward(req, resp);
	}

}
