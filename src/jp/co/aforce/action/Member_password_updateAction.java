package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Member_info;
import jp.co.aforce.dao.Member_password_updateDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/Member_password_updateAction" })
public class Member_password_updateAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/member_password_update.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "/ShoppingSite/views/member_password_update.jsp";

		HttpSession session = request.getSession();

		Member_info member_info = new Member_info();
		member_info.setMember_id(request.getParameter("member_id"));
		member_info.setLast_name(request.getParameter("last_name"));
		member_info.setFirst_name(request.getParameter("first_name"));
		member_info.setSex(request.getParameter("sex"));
		member_info.setBirth_year(Integer.parseInt(request.getParameter("birth_year")));
		member_info.setBirth_month(Integer.parseInt(request.getParameter("birth_month")));
		member_info.setBirth_day(Integer.parseInt(request.getParameter("birth_day")));
		member_info.setPhone_number(request.getParameter("phone_number"));
		member_info.setMail_address(request.getParameter("mail_address"));
		member_info.setPost_code(request.getParameter("post_code"));
		member_info.setAddress(request.getParameter("address"));
		member_info.setPassword(request.getParameter("new_password"));
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");

		try {

			if (!member_info.getPassword().equals(confirm_password)) {
				session.setAttribute("message", Messages.E_WKK0005);
				session.setAttribute("member_info", member_info);
				response.sendRedirect(path);
			} else {

				Member_password_updateDAO dao = new Member_password_updateDAO();
				int count = dao.member_password_select_count(password);

				if (count == 0) {
					session.setAttribute("member_info", member_info);
					session.setAttribute("message", Messages.E_WKK0006);
					response.sendRedirect(path);
				} else {

					if (member_info.getPassword().equals(password)) {
						session.setAttribute("message", Messages.E_WKK0007);
						session.setAttribute("member_info", member_info);
						response.sendRedirect(path);
					} else {
						Member_password_updateDAO member_password_updateDao = new Member_password_updateDAO();
						int line = member_password_updateDao.member_password_update(member_info);

						if (line > 0) {
							session.setAttribute("member_info", member_info);
							session.setAttribute("message", Messages.I_WKK0005);
							response.sendRedirect(path);
						}

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("member_info", member_info);
			session.setAttribute("message", Messages.E_WKK0002);
			response.sendRedirect(path);
		}

	}

}
