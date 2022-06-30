package jp.co.aforce.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Product_info;
import jp.co.aforce.dao.Product_infoDAO;
import jp.co.aforce.values.Messages;

@WebServlet("/jp.co.aforce.action/Product_searchAction")
public class Product_searchAction extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "../views/product_search.jsp";

		HttpSession session = request.getSession();

		try {
			Product_infoDAO dao = new Product_infoDAO();
			List<Product_info> list = dao.search("");
			session.setAttribute("list", list);
			response.sendRedirect(path);
//			request.setAttribute("list", list);
//			request.getRequestDispatcher(path).forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "../views/product_search.jsp";

		HttpSession session = request.getSession();

		String keyword = request.getParameter("keyword");
		if (keyword == null)
			keyword = "";

		try {
			Product_infoDAO dao = new Product_infoDAO();
			List<Product_info> list = dao.search(keyword);
				session.setAttribute("list", list);
				response.sendRedirect(path);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("keyword", keyword);
			session.setAttribute("message", Messages.E_WKK0002);
			response.sendRedirect(path);
		}

	}

}
