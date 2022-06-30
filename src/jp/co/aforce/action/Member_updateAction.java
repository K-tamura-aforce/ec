package jp.co.aforce.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Member_info;
import jp.co.aforce.dao.Member_registDAO;
import jp.co.aforce.dao.Member_updateDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/Member_updateAction" })
public class Member_updateAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/member_update.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "/ShoppingSite/views/member_update.jsp";

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

		Member_registDAO member_registDao = new Member_registDAO();
		try {
			int count = member_registDao.member_select_count(member_info);

			if (count != 0) {
				session.setAttribute("member_info", member_info);
				session.setAttribute("message", Messages.E_WKK0001);
				response.sendRedirect(path);
			} else {
				Member_updateDAO member_updateDao = new Member_updateDAO();
				int line = member_updateDao.member_update(member_info);

				if (line > 0) {
					session.setAttribute("member_info", member_info);
					session.setAttribute("message", Messages.I_WKK0003);
					response.sendRedirect(path);
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
