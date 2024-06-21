package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.Loai_HH;

import java.io.IOException;
import java.util.List;

import admin.dal.DAO_Loai_HH;

@WebServlet("/admin/loaihanghoa")
public class Loai_HH_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO_Loai_HH d = new DAO_Loai_HH();
		List<Loai_HH> list = d.selec_Loai_HH();
		request.setAttribute("data", list);
		request.getRequestDispatcher("loaihanghoa.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
