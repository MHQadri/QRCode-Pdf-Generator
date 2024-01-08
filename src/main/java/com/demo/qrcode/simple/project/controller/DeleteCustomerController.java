package com.demo.qrcode.simple.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.qrcode.simple.project.service.CustomerService;

@WebServlet("/delete")
public class DeleteCustomerController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String regnNumber = req.getParameter("regnNumber");

		CustomerService service = new CustomerService();
		int regnNumber1 = service.deleteCustomer(regnNumber);
		if (regnNumber1 != 0) {
			req.getRequestDispatcher("displayCustomer.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("displayCustomer.jsp").forward(req, resp);
		}
	}

}
