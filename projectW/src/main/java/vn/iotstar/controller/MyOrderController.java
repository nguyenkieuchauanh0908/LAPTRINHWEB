package vn.iotstar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.DAO.OrderDAO;
import vn.iotstar.DAO.OrderItemDAO;
import vn.iotstar.model.Category;
import vn.iotstar.model.Order;
import vn.iotstar.model.OrderItem;

@WebServlet(urlPatterns = {"/myorder"})
public class MyOrderController extends HttpServlet {

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
		// B1:khỏi tạo DAO
		CategoryDAO categoryDao = new CategoryDAO();
		OrderDAO orderDao=new OrderDAO();
		OrderItemDAO orderItemDao = new OrderItemDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		List<Category> listC = categoryDao.getAll();
		List<Order> orders = orderDao.getAllOrderbyUserId(uid);
		List<List<OrderItem>> listorderItems = new ArrayList<>();
		for(Order o: orders) {
			List<OrderItem> orderItems = orderItemDao.getAllOrderItembyUserId(o.get_id());
			listorderItems.add(orderItems);
		}
		req.setAttribute("orderList", orders);
		req.setAttribute("orderItemList", listorderItems);
		req.setAttribute("listcate", listC);
		RequestDispatcher rq = req.getRequestDispatcher("/views/user/myOrder.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
