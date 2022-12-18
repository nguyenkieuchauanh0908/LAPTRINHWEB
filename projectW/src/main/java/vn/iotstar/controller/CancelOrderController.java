package vn.iotstar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.OrderDAO;
@WebServlet(urlPatterns = "/cancelorder")
public class CancelOrderController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lay tham so tu jsp
		String oid = req.getParameter("orderId");
		// B1:khỏi tạo DAO
		OrderDAO orderDao = new OrderDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		orderDao.cancelOrder(oid);
		resp.sendRedirect("myorder");

	}

}
