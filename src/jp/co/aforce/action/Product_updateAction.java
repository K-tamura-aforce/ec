package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Product_info;
import jp.co.aforce.dao.Product_registDAO;
import jp.co.aforce.dao.Product_updateDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/Product_updateAction" })
public class Product_updateAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/product_update.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "/ShoppingSite/views/product_update.jsp";

		HttpSession session = request.getSession();

		Product_info product_info = new Product_info();
		product_info.setProduct_id(request.getParameter("product_id"));
		product_info.setProduct_genre(request.getParameter("product_genre"));
		product_info.setProduct_name(request.getParameter("product_name"));
		product_info.setProduct_price(Integer.parseInt(request.getParameter("product_price")));

		Product_registDAO product_registDao = new Product_registDAO();
		try {
			int count = product_registDao.product_select_count(product_info);

			if (count != 0) {
				session.setAttribute("product_info", product_info);
				session.setAttribute("message", Messages.E_WSK0001);
				response.sendRedirect(path);
			} else {
				Product_updateDAO product_updateDao = new Product_updateDAO();
				int line = product_updateDao.product_update(product_info);

				if (line > 0) {
					session.setAttribute("message", Messages.I_WSK0002);
					response.sendRedirect("/ShoppingSite/views/product_update_search.jsp");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("product_info", product_info);
			session.setAttribute("message", Messages.E_WKK0002);
			response.sendRedirect(path);
		}

	}

}
