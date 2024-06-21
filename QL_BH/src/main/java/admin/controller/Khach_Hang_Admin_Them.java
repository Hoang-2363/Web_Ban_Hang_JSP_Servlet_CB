package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import page.model.Khach_Hang;

import java.io.IOException;

import admin.dal.DAO_Khach_Hang;
import admin.dal.LSX_Anh;

@WebServlet("/admin/themkhachhang")
@MultipartConfig
public class Khach_Hang_Admin_Them extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("khachhangthem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ten_kh = request.getParameter("ten_kh");
		// String anh = request.getParameter("anh");
		String sdt = request.getParameter("sdt");
		String dia_chi = request.getParameter("dia_chi");

		String image_new = null;
		Part part = request.getPart("file");
		String url = "H:\\Hoang\\QL_BH_Java_Web\\Lab_02\\QL_BH\\src\\main\\webapp\\page\\img\\khachhang";

		DAO_Khach_Hang kh_DAO = new DAO_Khach_Hang();
		try {
			Khach_Hang kh1 = kh_DAO.getkhByTenkh(ten_kh, sdt);
			if (kh1 == null) {
				LSX_Anh image = new LSX_Anh();
				image_new = image.Ten_Anh(part, url);
				image.Luu_Anh(part, url);
				kh_DAO.them_kh(ten_kh, image_new, sdt, dia_chi);
				response.sendRedirect("khachhang");
			} else {
				request.setAttribute("error", ten_kh + " hoặc " + sdt + " đã tồn tại!");
				request.getRequestDispatcher("khachhangthem.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}
