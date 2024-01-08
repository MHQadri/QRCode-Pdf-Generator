package com.demo.qrcode.simple.project.service;

import java.util.List;

import com.demo.qrcode.simple.project.dao.AdminDao;
import com.demo.qrcode.simple.project.dto.Admin;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public class AdminService {

	AdminDao adminDao = new AdminDao();

	// saveAdmin method ...
	public Admin saveAdmin(Admin admin) {

		return adminDao.saveAdmin(admin);
	}

	// get admins details
	public List<Admin> getAllAdmin() {

		return adminDao.getAllAdmin();
	}
	
	/*
	 * getAllDataByEmail
	 */
	public Admin getAdminByEmail(String adminEmail) {
		
		return adminDao.getAdminByEmail(adminEmail);
	}
}
