package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.Loai_HH;

import java.io.IOException;

import admin.dal.DAO_Loai_HH;
import admin.dal.LSX_Anh;

@WebServlet("/admin/xoaloaihh")
@MultipartConfig
public class Loai_HH_Admin_Xoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_lhh = request.getParameter("ma_lhh");
		int ma_lhhoa = Integer.parseInt(ma_lhh);
		DAO_Loai_HH lhh_DAO = new DAO_Loai_HH();
		Loai_HH loai_hh = lhh_DAO.getLHHByMaLHH(ma_lhhoa);
		String url = "H:\\Hoang\\QL_BH_Java_Web\\Lab_02\\QL_BH\\src\\main\\webapp\\page\\img\\loai_hh\\";

		LSX_Anh image = new LSX_Anh();
		image.Xoa_Anh(url + loai_hh.getAnh());
		lhh_DAO.xoa_LHH(ma_lhhoa);
		response.sendRedirect("loaihanghoa");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
