package jp.co.aforce.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Item;
import jp.co.aforce.beans.Member_info;
import jp.co.aforce.beans.Purchase_info;
import jp.co.aforce.dao.Purchase_infoDAO;
import jp.co.aforce.values.Messages;

@WebServlet(urlPatterns = { "/PurchaseAction" })
public class PurchaseAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ShoppingSite/views/purchase_confirm.jsp");

	}
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "views/purchase_confirm.jsp";

		HttpSession session = request.getSession();

		Purchase_info purchase_info=(Purchase_info)session.getAttribute("purchase_info");
		Member_info member_info=(Member_info)session.getAttribute("member_info");


		Calendar calendar = Calendar.getInstance();

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

		String formattedDate = format.format(calendar.getTime());

		String purchase_id = "MP" + formattedDate;

		purchase_info.setPurchase_id(purchase_id);


		SimpleDateFormat formatYear = new SimpleDateFormat("yyyy");

		String formattedYear = formatYear.format(calendar.getTime());

		String purchase_year = formattedYear;

		purchase_info.setPurchase_year(purchase_year);

		SimpleDateFormat formatMonth = new SimpleDateFormat("MM");

		String formattedMonth = formatMonth.format(calendar.getTime());

		String purchase_month = formattedMonth;

		purchase_info.setPurchase_month(purchase_month);

		SimpleDateFormat formatDay = new SimpleDateFormat("dd");

		String formattedDay = formatDay.format(calendar.getTime());

		String purchase_day = formattedDay;

		purchase_info.setPurchase_day(purchase_day);


		Purchase_infoDAO dao=new Purchase_infoDAO();
		List<Item> cart=(List<Item>)session.getAttribute("cart");
		try {
			if(cart==null || !dao.insert(member_info, purchase_info, cart)) {
				session.setAttribute("E_WKK0002", Messages.E_WKK0002);
				response.sendRedirect(path);
			} else {
				session.removeAttribute("cart");
				session.removeAttribute("purchase_info");
				response.sendRedirect("views/purchase_success.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("E_WKK0002", Messages.E_WKK0002);
			response.sendRedirect(path);
		}



	}
}
