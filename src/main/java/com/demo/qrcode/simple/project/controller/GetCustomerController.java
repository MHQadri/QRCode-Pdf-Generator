package com.demo.qrcode.simple.project.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit.CutAction;

import com.demo.qrcode.simple.project.dto.Customer;
import com.demo.qrcode.simple.project.service.CustomerService;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/print")
@MultipartConfig
public class GetCustomerController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	CustomerService service = new CustomerService();


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// Get user details from the form
			String regnNumber = request.getParameter("regnNumber");

			Customer customer = service.getCustomerByRegnNumber(regnNumber);
			System.out.println(customer);
			String value = String.valueOf(customer);

			// Generate QR code

			byte[] qrCodeImage = generateQRCode(value);

			// Generate PDF

			byte[] pdfBytes = generatePDF(customer, qrCodeImage);

			// Set response headers
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline; filename=user_details.pdf");

			// Write PDF to response output stream
			response.getOutputStream().write(pdfBytes);

		} catch (WriterException | DocumentException e) {
			e.printStackTrace(); // Handle the exception appropriately
		}
	}

	private byte[] generateQRCode(String qrCodeData) throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, 20, 20);

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);

		return byteArrayOutputStream.toByteArray();
	}

	private byte[] generatePDF(Customer customer, byte[] qrCodeImage)
			throws DocumentException, MalformedURLException, IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

		Document document = new Document (new Rectangle(3.39f * 72, 2.14f * 72));
		document.setMargins(3, 0, 5, 0);
		PdfWriter.getInstance(document, byteArrayOutputStream);
		
		document.open();
		
		PdfPTable table1 = new PdfPTable(1);
		table1.setWidthPercentage(100);
		createRowUp(table1, customer.getRegnNumber());
		createRowUp(table1, customer.getRegdOwner());
		createRowUp(table1, customer.getsDWf());
		document.add(table1);
		
		PdfPTable table2 = new PdfPTable(3);
		table2.setWidthPercentage(100);
		addThreeColumn(table2, customer.getPurpose(), null, customer.getTaxPAidUpTo());
		addThreeColumn(table2, customer.getRegnDate(), customer.getManufacturingDt(), customer.getRegdValidity());
		document.add(table2);
		
		 Font font = new Font(Font.FontFamily.HELVETICA, 4, Font.BOLD); 
		 Font font2 = new Font(Font.FontFamily.HELVETICA, 5, Font.BOLD);
		PdfPTable table3 = new PdfPTable(1);
		table3.setWidthPercentage(100);
		PdfPCell color= new PdfPCell(new Paragraph(customer.getColour(),font));
		color.setBorder(Rectangle.NO_BORDER);
		color.setPadding(0);
		color.setPaddingLeft(30);
		color.setPaddingTop(2);
		table3.addCell(color);
		createRowOne(table3, customer.getFuel());
		createRowOne(table3, customer.getVehicleClass());
		createRowOne(table3, customer.getBodyType());
		createRowOne(table3, customer.getManufacturar());
		document.add(table3);
		
		PdfPTable table4 = new PdfPTable(1);
		table4.setWidthPercentage(100);
		createRowBottom(table4, customer.getChassisNo());
		createRowBottom(table4, customer.getEngineNo());
		createRowBottom(table4, customer.getModelNo());
		document.add(table4);
		
        PdfPTable nestedTable = new PdfPTable(new float[]{35, 65});
        nestedTable.setWidthPercentage(100);
        nestedTable.getPaddingTop();
        Image qrCode = Image.getInstance(qrCodeImage);
        PdfPCell image= new PdfPCell(qrCode);
       image.setFixedHeight(79);  
       image.setBorder(Rectangle.NO_BORDER);
       nestedTable.addCell(image);
       
       PdfPCell ncell=new PdfPCell();
       ncell.setBorder(Rectangle.NO_BORDER);
       
       PdfPTable tble=new PdfPTable(3);
       tble.setWidthPercentage(95);
       PdfPCell row1col1=new PdfPCell(new Paragraph(customer.getHypothecatedTo(), font));
       row1col1.setFixedHeight(20);
       row1col1.setColspan(2);
       row1col1.setPaddingTop(6);
       row1col1.setBorder(Rectangle.NO_BORDER);
       row1col1.setPaddingRight(20);
       row1col1.setPaddingLeft(31);
       PdfPCell  row1col2=new PdfPCell(new Paragraph(""+customer.getUnladenWt(), font));
       row1col2.setBorder(Rectangle.NO_BORDER);
       row1col2.setPaddingLeft(23);
       row1col2.setPaddingTop(8);
       tble.addCell(row1col1);
       tble.addCell(row1col2);
       ncell.addElement(tble);
       
       PdfPTable sideTable=new PdfPTable(3);
       sideTable.setWidthPercentage(95);
       
       PdfPCell row2col1=new PdfPCell(new Paragraph());
       row2col1.setBorder(Rectangle.NO_BORDER);
       PdfPCell row2col2=new PdfPCell(new Paragraph());
       row2col2.setBorder(Rectangle.NO_BORDER);
       PdfPCell row2col3=new PdfPCell(new Paragraph(""+(float) customer.getCubicCapacity(), font));
       row2col3.setBorder(Rectangle.NO_BORDER);
       row2col3.setPaddingTop(-6);
       row2col3.setPaddingLeft(23);
       sideTable.addCell(row2col1);
       sideTable.addCell(row2col2);
       sideTable.addCell(row2col3);
       
       PdfPCell row3col1=new PdfPCell(new Paragraph(""+customer.getSeatCapacity(), font));
       row3col1.setBorder(Rectangle.NO_BORDER);
       row3col1.setPaddingLeft(30);
       row3col1.setPaddingTop(0);
       PdfPCell row3col2=new PdfPCell(new Paragraph(""+customer.getNoofcyc(), font));
       row3col2.setPaddingTop(0);
       row3col2.setBorder(Rectangle.NO_BORDER);
       row3col2.setPaddingLeft(25);
       PdfPCell row3col3=new PdfPCell(new Paragraph(""+customer.getWheelBase(), font));
       row3col3.setBorder(Rectangle.NO_BORDER);
       row3col3.setPaddingTop(-1);
       row3col3.setPaddingLeft(23);
       sideTable.addCell(row3col1);
       sideTable.addCell(row3col2);
       sideTable.addCell(row3col3);
       
       PdfPCell row4col1=new PdfPCell(new Paragraph(""+customer.getStandCapacity() , font));
       row4col1.setPaddingTop(0);
       row4col1.setBorder(Rectangle.NO_BORDER);
       row4col1.setPaddingLeft(30);
       PdfPCell row4col2=new PdfPCell(new Paragraph(""+customer.getOwnerserial(), font));
       row4col2.setPaddingTop(0);
       row4col2.setBorder(Rectangle.NO_BORDER);
       row4col2.setPaddingLeft(25);
       PdfPCell row4col3=new PdfPCell(new Paragraph(""+customer.getrLW(), font));
       row4col3.setBorder(Rectangle.NO_BORDER);
       row4col3.setPaddingTop(0);
       row4col3.setPaddingLeft(23);
       sideTable.addCell(row4col1);
       sideTable.addCell(row4col2);
       sideTable.addCell(row4col3);
       ncell.addElement(sideTable);
       
       
       
       PdfPTable add=new PdfPTable(1);
       add.setWidthPercentage(100);
       PdfPCell celladd=new PdfPCell(new Paragraph(customer.getAddress(), font2));
       celladd.setPaddingTop(-1);
       celladd.setBorder(Rectangle.NO_BORDER);
       celladd.setFixedHeight(23);
       celladd.setPaddingTop(6);
       celladd.setPaddingLeft(16);
       add.addCell(celladd);
       ncell.addElement(add);

       
       Font font3 = new Font(Font.FontFamily.HELVETICA, 6, Font.NORMAL);
       PdfPTable is=new PdfPTable(3);
       is.setWidthPercentage(100);
       PdfPCell cellis=new PdfPCell(new Paragraph(customer.getIssuing(), font3));
//       cellis.setHorizontalAlignment(Element.ALIGN_CENTER);
       cellis.setPaddingTop(5);
       cellis.setFixedHeight(16);
       cellis.setColspan(2);
       cellis.setBorder(Rectangle.NO_BORDER);
       cellis.setPaddingLeft(14);
       is.addCell(cellis);
       Image img=Image.getInstance(customer.getSignature());
       PdfPCell cellsig=new PdfPCell();
//       img.scaleToFit(cellsig.getWidth(), cellsig.getHeight());
       cellsig.addElement(img);
       cellsig.setFixedHeight(16);
       
       cellsig.setBorder(Rectangle.NO_BORDER);
       is.addCell(cellsig);
       ncell.addElement(is);
       
       
       nestedTable.addCell(ncell);
		document.add(nestedTable);
		
		
		
		document.close();

		return byteArrayOutputStream.toByteArray();
	}
	

	private static void createRowUp(PdfPTable table, String col1) {
		Font font = new Font(Font.FontFamily.HELVETICA, 5, Font.BOLD); 
		PdfPCell cell=new PdfPCell(new Paragraph(col1, font));	
		cell.setPadding(0.3f);
		cell.setPaddingLeft(39);		
		cell.setBorder(Rectangle.NO_BORDER);
		
		table.addCell(cell);
		table.setSpacingAfter(0);
		table.setSpacingBefore(0);
	}
	private static void addThreeColumn(PdfPTable table, String col1, String col2, String col3) {
		 Font font = new Font(Font.FontFamily.HELVETICA, 5, Font.BOLD); 
		 PdfPCell cell1=new PdfPCell(new Paragraph(col1, font));
		 cell1.setPadding(0.3f);
		 cell1.setPaddingLeft(39);
		 cell1.setBorder(Rectangle.NO_BORDER);
		 PdfPCell cell2=new PdfPCell(new Paragraph(col2, font));
		 cell2.setPadding(0.3f);
		 cell2.setPaddingLeft(52);
		 cell2.setBorder(Rectangle.NO_BORDER);
		 PdfPCell cell3=new PdfPCell(new Paragraph(col3, font));
		 cell3.setPadding(0.3f);
		 cell3.setPaddingLeft(50);
		 cell3.setBorder(Rectangle.NO_BORDER);

		 table.addCell(cell1);
		 table.addCell(cell2);
		 table.addCell(cell3);
		 table.setSpacingAfter(0);
		 table.setSpacingBefore(0);

		
	}
	private static void createRowOne(PdfPTable table, String col) {
		 Font font = new Font(Font.FontFamily.HELVETICA, 4, Font.BOLD); 
		PdfPCell cell=new PdfPCell(new Paragraph(col, font));
		cell.setPadding(0.3f);
		cell.setPaddingLeft(30);
		cell.setBorder(Rectangle.NO_BORDER);
		table.addCell(cell);
//		table.setSpacingAfter(0);
//		table.setSpacingBefore(0);
	}
	private static void createRowBottom(PdfPTable table, String col1) {
		Font font = new Font(Font.FontFamily.HELVETICA, 5, Font.BOLD); 
		PdfPCell cell=new PdfPCell(new Paragraph(col1, font));	
		cell.setPadding(0.3f);
		cell.setPaddingLeft(39);		
		cell.setBorder(Rectangle.NO_BORDER);
		
		table.addCell(cell);
//		table.setSpacingAfter(0);
//		table.setSpacingBefore(0);

	}
}
