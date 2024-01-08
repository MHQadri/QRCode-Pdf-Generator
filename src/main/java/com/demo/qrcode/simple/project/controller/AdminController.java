package com.demo.qrcode.simple.project.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.qrcode.simple.project.dto.Admin;
import com.demo.qrcode.simple.project.service.AdminService;

@WebServlet("/adminLogin")
public class AdminController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		AdminService adminService = new AdminService();

		Admin admin = adminService.getAdminByEmail(email);

		if (admin != null) {
			if (admin.getAdminPassword().equals(password)) {
				session.setAttribute("adminEmail", admin.getAdminEmail());

				RequestDispatcher dispatcher = req.getRequestDispatcher("admin_home.jsp");
				dispatcher.forward(req, resp);
			} else {
				req.setAttribute("invalidPassword", "Invalid Password");
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.forward(req, resp);
			}
		} else {
			req.setAttribute("invalidEmail", "Invalid Email");
			RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
