package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Member_info;
import jp.co.aforce.dao.Member_infoDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/LoginAction" })
public class LoginAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/login.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();

		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");
		String path = "/ShoppingSite/views/login.jsp";

		Member_infoDAO dao = new Member_infoDAO();
		try {
			Member_info member_info = dao.search(member_id, password);

			if (member_info == null) {
				session.setAttribute("message", Messages.E_WKK0003);
				session.setAttribute("member_id", member_id);
				response.sendRedirect(path);
			} else {
				if (member_id.contains("A")) {
					session.setAttribute("member_info", member_info);
					response.sendRedirect("/ShoppingSite/jp.co.aforce.action/Product_listAction");
				} else {
					session.setAttribute("member_info", member_info);
					response.sendRedirect("/ShoppingSite/jp.co.aforce.action/Product_searchAction");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("message", Messages.E_WKK0002);
			session.setAttribute("member_id", member_id);
			response.sendRedirect(path);
		}

	}

}
