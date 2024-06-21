package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.IOException;

import admin.dal.DAO_Nhan_Vien;
import admin.dal.LSX_Anh;
import admin.model.Nhan_Vien;

@WebServlet("/admin/thongtintk")
@MultipartConfig
public class Thong_Tin_TK extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("tai_khoan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id_nv = request.getParameter("id_nv");
		String ho_ten_nv = request.getParameter("ho_ten_nv");
		String chuc_vu = request.getParameter("chuc_vu");
		String dia_chi = request.getParameter("dia_chi");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		String tai_khoan = request.getParameter("tai_khoan");
		String mat_khau = request.getParameter("mat_khau");
		String anh = request.getParameter("anh");

		String image_new = null;
		Part part = request.getPart("file");
		String url = "H:\\Hoang\\QL_BH_Java_Web\\Lab_02\\QL_BH\\src\\main\\webapp\\admin\\image";

		int id_nv_int;
		HttpSession session = request.getSession();
		try {
			id_nv_int = Integer.parseInt(id_nv);
			DAO_Nhan_Vien nv_DAO = new DAO_Nhan_Vien();
			Nhan_Vien nv = nv_DAO.getNVByID(id_nv);

			if (!anh.equals(nv.getAnh())) {
				LSX_Anh image = new LSX_Anh();
				image.Xoa_Anh(url + "\\" + nv.getAnh());
				image_new = image.Ten_Anh(part, url);
				image.Luu_Anh(part, url);
			} else {
				image_new = anh;
			}
			Nhan_Vien nv1 = new Nhan_Vien(id_nv_int, ho_ten_nv, chuc_vu, dia_chi, sdt, image_new, email, tai_khoan,
					mat_khau);
			nv_DAO.sua_nv(nv1);
			session.setAttribute("account", nv1);
			request.getRequestDispatcher("trangchu").forward(request, response);

		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}

}
