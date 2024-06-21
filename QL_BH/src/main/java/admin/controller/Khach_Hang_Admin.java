package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.Khach_Hang;

import java.io.IOException;
import java.util.List;

import admin.dal.DAO_Khach_Hang;

@WebServlet("/admin/khachhang")
public class Khach_Hang_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO_Khach_Hang d = new DAO_Khach_Hang();
		List<Khach_Hang> list = d.selec_KH();
		request.setAttribute("data", list);
		request.getRequestDispatcher("khachhang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
