package com.demo.qrcode.simple.project.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class AdminLogoutController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		
		if (session.getAttribute("adminEmail")!=null) {
			session.invalidate();
			RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
			dispatcher.include(req, resp);
		}
		
	}

}
