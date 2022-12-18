package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.CartItemDAO;
import vn.iotstar.DAO.OrderDAO;
import vn.iotstar.DAO.OrderItemDAO;
import vn.iotstar.model.CartItem;
import vn.iotstar.model.OrderItem;

@WebServlet(urlPatterns = "/order")
public class OrderController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lay tham so tu Session
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("uId");
		String uid = String.valueOf(obj);
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		// B1:khỏi tạo DAO
		OrderDAO orderDao=new OrderDAO();
		OrderItemDAO orderItemDao = new OrderItemDAO();
		CartItemDAO cartItemDao = new CartItemDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		orderDao.insert(uid, address, phone);
		int orderId = orderDao.getIDMaxbyUser(uid);
		List<CartItem> cartItem =  cartItemDao.getAllCartItemByUserId(uid);
		for(CartItem cI: cartItem) {
			OrderItem orderItem = new OrderItem();
			orderItem.set_id(orderId);
			orderItem.setProductId(cI.getProduct().get_id());
			orderItem.setCount_SP(cI.getCount_SP());
			orderItemDao.insert(orderItem);
			
		}
		cartItemDao.removeAllItemInCart(uid);
		resp.sendRedirect("ordersuccess");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
