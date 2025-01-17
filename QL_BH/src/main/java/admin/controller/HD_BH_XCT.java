package admin.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import page.model.CT_HD_BH;
import page.model.Hoa_Don_BH;

import java.io.IOException;
import java.util.List;

import admin.dal.DAO_Hoa_Don_BH;

@WebServlet("/admin/xcthoadonbh")
public class HD_BH_XCT extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ma_hd_bh = request.getParameter("ma_hd_bh");
		DAO_Hoa_Don_BH d = new DAO_Hoa_Don_BH();
		Hoa_Don_BH list1 = d.selec_HD_BH_By_ID(ma_hd_bh);
		List<CT_HD_BH> list2 = d.select_CT_HD_BH_By_ID(ma_hd_bh);
		request.setAttribute("data1", list1);
		request.setAttribute("data2", list2);
		request.getRequestDispatcher("hd_bh_ct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
