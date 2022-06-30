package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Purchase_info;

@WebServlet(urlPatterns = { "/Purchase_confirmAction" })
public class Purchase_confirmAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "/ShoppingSite/views/purchase_confirm.jsp";

		HttpSession session = request.getSession();

		Purchase_info purchase_info = new Purchase_info();
		purchase_info.setPurchase_name(request.getParameter("purchase_name"));
		purchase_info.setPurchase_post_code(request.getParameter("purchase_post_code"));
		purchase_info.setPurchase_address(request.getParameter("purchase_address"));
		purchase_info.setPayment_method(request.getParameter("payment_method"));

		session.setAttribute("purchase_info", purchase_info);
		response.sendRedirect(path);


	}
}
