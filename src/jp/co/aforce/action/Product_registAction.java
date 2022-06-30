package jp.co.aforce.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Product_info;
import jp.co.aforce.dao.Product_registDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/Product_registAction" })
public class Product_registAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/product_regist.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "/ShoppingSite/views/product_regist.jsp";

		HttpSession session = request.getSession();

		Product_info product_info = new Product_info();
		product_info.setProduct_genre(request.getParameter("product_genre"));
		product_info.setProduct_name(request.getParameter("product_name"));
		product_info.setProduct_price(Integer.parseInt(request.getParameter("product_price")));

		Product_registDAO dao = new Product_registDAO();
		try {
			int count = dao. product_select_count(product_info);

			if (count != 0) {
				session.setAttribute("message", Messages.E_WSK0001);
				session.setAttribute("product_info", product_info);
				response.sendRedirect(path);
			} else {

				Calendar calendar = Calendar.getInstance();

				SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");

				String formattedDate = format.format(calendar.getTime());

				String product_id = "P" + formattedDate;

				product_info.setProduct_id(product_id);

				int line = dao.product_regist(product_info);

				if (line > 0) {
					session.setAttribute("message", Messages.I_WSK0001);
					response.sendRedirect(path);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", Messages.E_WKK0002);
			session.setAttribute("product_info", product_info);
			response.sendRedirect(path);
		}

	}

}
