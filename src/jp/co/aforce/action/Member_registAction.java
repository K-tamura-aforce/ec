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

import jp.co.aforce.beans.Member_info;
import jp.co.aforce.dao.Member_registDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/Member_registAction" })
public class Member_registAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/member_regist.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "/ShoppingSite/views/member_regist.jsp";

		HttpSession session = request.getSession();

		Member_info member_info = new Member_info();
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
		member_info.setPassword(request.getParameter("password"));
		String confirm_password = request.getParameter("confirm_password");

		if (!member_info.getPassword().equals(confirm_password)) {
			session.setAttribute("message", Messages.E_WKK0005);
			session.setAttribute("member_info", member_info);
			response.sendRedirect(path);
		} else {

			Member_registDAO dao = new Member_registDAO();
			try {
				int count = dao.member_select_count(member_info);

				if (count != 0) {
					session.setAttribute("message", Messages.E_WKK0001);
					session.setAttribute("member_info", member_info);
					response.sendRedirect(path);
				} else {

					Calendar calendar = Calendar.getInstance();

					SimpleDateFormat format = new SimpleDateFormat("yyMMddHHmmss");

					String formattedDate = format.format(calendar.getTime());

					String member_id = "M" + formattedDate;

					member_info.setMember_id(member_id);
					int line = dao.member_regist(member_info);

					if (line > 0) {
						session.setAttribute("message", Messages.I_WKK0001);
						String message2 = "あなたのIDは"+ member_id + "です。";
						session.setAttribute("message2", message2);
						response.sendRedirect("/ShoppingSite/views/login.jsp");
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
				session.setAttribute("message", Messages.E_WKK0002);
				session.setAttribute("member_info", member_info);
				response.sendRedirect(path);
			}

		}

	}

}
