package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import page.model.Hang_Hoa;

import java.io.IOException;
import java.util.List;

import admin.dal.DAO_Hang_Hoa;
import admin.dal.DAO_Loai_HH;
import admin.dal.DAO_NCC;
import admin.dal.LSX_Anh;

@WebServlet("/admin/themhanghoa")
@MultipartConfig
public class Hang_Hoa_Admin_Them extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO_Hang_Hoa hh_DAO = new DAO_Hang_Hoa();
		DAO_NCC ncc_DAO = new DAO_NCC();
		DAO_Loai_HH lhh_DAO = new DAO_Loai_HH();

		List<String> list = hh_DAO.select_DVT();
		List<String> ncc = ncc_DAO.select_NCC();
		List<String> lhh = lhh_DAO.select_LHH();

		request.setAttribute("dvt", list);
		request.setAttribute("ncc", ncc);
		request.setAttribute("lhh", lhh);
		request.getRequestDispatcher("hanghoathem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ten_hang = request.getParameter("ten_hang");
		String gia_nhap = request.getParameter("gia_nhap");
		String gia_ban = request.getParameter("gia_ban");
		String don_vi_tinh = request.getParameter("don_vi_tinh");
		String so_luong = request.getParameter("so_luong");
		String ghi_chu = request.getParameter("ghi_chu");
		String ma_nha_cung_cap = request.getParameter("ma_nha_cung_cap");
		String ma_loai_hang = request.getParameter("ma_loai_hang");
		String anh = request.getParameter("anh");
		String image_new = null;
		Part part = request.getPart("file");
		String url = "H:\\Hoang\\QL_BH_Java_Web\\Lab_02\\QL_BH\\src\\main\\webapp\\page\\img\\hanghoa";

		int gia_nhap_int, gia_ban_int, so_luong_int;
		int ma_loai_hang_int;
		DAO_Hang_Hoa hh_DAO = new DAO_Hang_Hoa();
		DAO_NCC ncc_DAO = new DAO_NCC();
		DAO_Loai_HH lhh_DAO = new DAO_Loai_HH();
		try {
			gia_nhap_int = Integer.parseInt(gia_nhap);
			gia_ban_int = Integer.parseInt(gia_ban);
			so_luong_int = Integer.parseInt(so_luong);
			ma_loai_hang_int = Integer.parseInt(lhh_DAO.select_ma_lhh(ma_loai_hang));
			ma_nha_cung_cap = ncc_DAO.select_ma_ncc(ma_nha_cung_cap);
			Hang_Hoa hh1 = hh_DAO.getLHHByTenHH(ten_hang, anh);

			if (hh1 == null) {
				LSX_Anh image = new LSX_Anh();
				image_new = image.Ten_Anh(part, url);
				image.Luu_Anh(part, url);
				hh_DAO.them_HH(ten_hang, gia_nhap_int, gia_ban_int, don_vi_tinh, so_luong_int, ghi_chu, ma_nha_cung_cap,
						ma_loai_hang_int, image_new);
				response.sendRedirect("hanghoa");
			} else {
				request.setAttribute("error", ten_hang + " hoặc " + anh + " đã tồn tại!");
				request.getRequestDispatcher("hanghoathem.jsp").forward(request, response);
			}
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
	}

}