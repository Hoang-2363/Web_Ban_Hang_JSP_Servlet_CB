package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.Nha_CC;

import java.io.IOException;
import java.util.List;

import admin.dal.DAO_NCC;

@WebServlet("/admin/nhacungcap")
public class NCC_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO_NCC d = new DAO_NCC();
		List<Nha_CC> list = d.selec_Nha_CC();
		request.setAttribute("data", list);
		request.getRequestDispatcher("nhacungcap.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
