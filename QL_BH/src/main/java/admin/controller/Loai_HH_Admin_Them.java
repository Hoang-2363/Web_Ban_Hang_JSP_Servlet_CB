package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import page.model.Loai_HH;

import java.io.IOException;

import admin.dal.DAO_Loai_HH;
import admin.dal.LSX_Anh;

@WebServlet("/admin/loaihhthem")
@MultipartConfig
public class Loai_HH_Admin_Them extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("loaihanghoathem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ten_loai_hang = request.getParameter("ten_loai_hang");
		// String anh = request.getParameter("anh");
		String ghi_chu = request.getParameter("ghi_chu");

		String image_new = null;
		Part part = request.getPart("file");
		String url = "H:\\Hoang\\QL_BH_Java_Web\\Lab_02\\QL_BH\\src\\main\\webapp\\page\\img\\loai_hh";

		DAO_Loai_HH lhh_DAO = new DAO_Loai_HH();
		try {
			Loai_HH lhh = lhh_DAO.getLHHByTenLHH(ten_loai_hang);
			if (lhh == null) {
				LSX_Anh image = new LSX_Anh();
				image_new = image.Ten_Anh(part, url);
				image.Luu_Anh(part, url);
				lhh_DAO.them_LHH(ten_loai_hang, image_new, ghi_chu);
				response.sendRedirect("loaihanghoa");
			} else {
				request.setAttribute("error", ten_loai_hang + " đã tồn tại!");
				request.getRequestDispatcher("loaihanghoathem.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}
}
