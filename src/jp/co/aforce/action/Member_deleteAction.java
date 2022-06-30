package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Member_info;
import jp.co.aforce.dao.Member_deleteDAO;
import jp.co.aforce.dao.Member_infoDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/Member_deleteAction" })
public class Member_deleteAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/member_confirm_delete.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();

		String member_id = request.getParameter("member_id");
		String password = request.getParameter("password");
		String path = "/ShoppingSite/views/member_confirm_delete.jsp";

		Member_infoDAO dao = new Member_infoDAO();
		try {
			Member_info member_info = dao.search(member_id, password);

			if (member_info == null) {
				session.setAttribute("message", Messages.E_WKK0006);
				response.sendRedirect(path);
			} else {

				Member_deleteDAO member_deleteDAO = new Member_deleteDAO();

				int line = member_deleteDAO.member_delete(member_info);

				if (line > 0) {
					response.sendRedirect("/ShoppingSite/views/member_delete_success.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("E_WKK0002", Messages.E_WKK0002);
			response.sendRedirect(path);
		}

	}

}
