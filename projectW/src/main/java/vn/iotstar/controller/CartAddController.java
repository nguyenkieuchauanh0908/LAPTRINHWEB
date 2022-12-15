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
import vn.iotstar.model.CartItem;

@WebServlet(urlPatterns = { "/cartadd" })
public class CartAddController extends HttpServlet {

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
		// lay tham so từ jsp
		String pid = req.getParameter("pid");
		String minusPro = req.getParameter("MinusPro");
		String minusCart = req.getParameter("MinusCart");
		String plusPro = req.getParameter("PlusPro");
		String plusCart = req.getParameter("PlusCart");
		// B1:khỏi tạo DAO
		CartItemDAO cartItemDAO = new CartItemDAO();
		// quantity
		if (minusPro != null && minusCart != null) {
			cartItemDAO.MinusQuantity(minusPro, minusCart);
		}
		if (plusPro != null && plusCart != null) {
			cartItemDAO.PlusQuantity(plusPro, plusCart);
		}
		// B2:sử dụng đối tượng list để chứa danh sách từ CartItemDAO
		if(pid != null) {
		cartItemDAO.addItem(uid, pid);
		}
		resp.sendRedirect("cart");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("uId");
		String uid = String.valueOf(obj);
		if(obj != null) {
			// get cart by user id
			// Cart cart = ...
			// Get data from form 
			String productId = req.getParameter("productId");
			String quantity = req.getParameter("quantity");
			// B1:khỏi tạo DAO
			CartItemDAO cartItemDAO = new CartItemDAO();
			
			// B2:sử dụng đối tượng list để chứa danh sách từ CartItemDAO
			cartItemDAO.addItemWithQuan(uid, productId, quantity);
			// Get product by product id
			// Product product = ...
			
			// if (quantity > 0 && quantity <= product.getQuantity()) {
				// Create cart item
				// send re... ?message=...
			// }
			// else { send ? message loi }
			
			// Add cart item to cart
			
			// =>>>
			resp.sendRedirect("cart");
			
		} else {
			resp.sendRedirect("login");
		}
	}

}
