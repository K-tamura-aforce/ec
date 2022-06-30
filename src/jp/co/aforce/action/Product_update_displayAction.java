package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Product_info;
import jp.co.aforce.dao.Product_infoDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/Product_update_displayAction" })
public class Product_update_displayAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/product_update_search.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "/ShoppingSite/views/product_update_search.jsp";

		HttpSession session = request.getSession();

		String product_id = request.getParameter("product_id");

		Product_infoDAO dao = new Product_infoDAO();
		try {
			Product_info product_info = dao.searchProduct(product_id);

			if (product_info == null) {
				session.setAttribute("product_id", product_id);
				session.setAttribute("message", Messages.E_WSK0002);
				response.sendRedirect(path);
			} else {
				session.setAttribute("product_info", product_info);
				response.sendRedirect("/ShoppingSite/views/product_update.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("product_id", product_id);
			session.setAttribute("message", Messages.E_WKK0002);
			response.sendRedirect(path);
		}

	}

}
