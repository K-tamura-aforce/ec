package jp.co.aforce.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.beans.Item;

@WebServlet(urlPatterns = { "/jp.co.aforce.action/Cart_minusAction" })
public class Cart_minusAction extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = "../views/member_cart.jsp";

		HttpSession session = request.getSession();

		String product_id = request.getParameter("product_id");

		List<Item> cart = (List<Item>) session.getAttribute("cart");

		//		if(cart==null) {
		//			cart=new ArrayList<Item>();
		//			session.setAttribute("cart", cart);
		//		}

		for (Item i : cart) {
			if (i.getProduct_info().getProduct_id().equals(product_id)){
				//					java.lang.System.err.println("cart_product_id="+cart_product_id);
				i.setProduct_count(i.getProduct_count() - 1);
				//				int cart_product_count=i.getProduct_count()+product_count;
				//				java.lang.System.err.println("cart_product_count="+cart_product_count);
				if(i.getProduct_count()==0) {
					cart.remove(i);
					break;

				}else {
				i.setProduct_subtotal(i.getProduct_subtotal() - i.getProduct_info().getProduct_price());
				//				int cart_product_subtotal=i.getProduct_subtotal()+(i.getProduct_info().getProduct_price()*i.getProduct_count());
				//				java.lang.System.err.println("cart_product_subtotal="+cart_product_subtotal);
				request.getRequestDispatcher(path).forward(request, response);
				//					java.lang.System.err.println("cart item="+i);
									return;
				}
			}
		}

		//		List<Product_info> list=(List<Product_info>)session.getAttribute("list");
		//		java.lang.System.err.println("item="+list.toString());
		//		java.lang.System.err.println("product_id="+product_id);
		//		for(Product_info p: list) {
		//			java.lang.System.err.println("product="+p.getProduct_id());
		//			if(p.getProduct_id().equals(product_id)) {
		//				Item i=new Item();
		//				i.setProduct_info(p);
		//				i.setProduct_count(1);
		//				cart.add(i);
		//				java.lang.System.err.println("item="+i);

		request.getRequestDispatcher(path).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
}
