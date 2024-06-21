package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.Hang_Hoa;

import java.io.IOException;
import java.util.List;

import admin.dal.DAO_Hang_Hoa;

@WebServlet("/admin/hanghoa")
public class Hang_Hoa_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DAO_Hang_Hoa d = new DAO_Hang_Hoa();
		List<Hang_Hoa> list = d.select_Hang_Hoa();
		request.setAttribute("data", list);
		request.getRequestDispatcher("hanghoa.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
