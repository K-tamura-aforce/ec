package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Product_info;
import jp.co.aforce.dao.Product_deleteDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/Product_deleteAction" })
public class Product_deleteAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/product_confirm_delete.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "/ShoppingSite/views/product_confirm_delete.jsp";

		HttpSession session = request.getSession();

		Product_info product_info = new Product_info();
		product_info.setProduct_id(request.getParameter("product_id"));

		Product_deleteDAO product_deleteDAO = new Product_deleteDAO();

		try {
			int line = product_deleteDAO.product_delete(product_info);

			if (line > 0) {
				session.setAttribute("message", Messages.I_WSK0003);
				response.sendRedirect("/ShoppingSite/views/product_delete_search.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("E_WKK0002", Messages.E_WKK0002);
			response.sendRedirect(path);
		}

	}

}
