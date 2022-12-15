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
import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.model.CartItem;
import vn.iotstar.model.Category;

@WebServlet(urlPatterns = "/cart")
public class CartController extends HttpServlet {

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
//		//lay tham so từ jsp
//		String minusPro = req.getParameter("MinusPro");
//		String minusCart = req.getParameter("MinusCart");
//		String plusPro = req.getParameter("PlusPro");
//		String plusCart = req.getParameter("PlusCart");
		// B1:khỏi tạo DAO
		CartItemDAO cartItemDAO = new CartItemDAO();
		CategoryDAO categoryDao = new CategoryDAO();
//		//quantity
//		if(minusPro != null && minusCart != null) {
//			cartItemDAO.MinusQuantity(minusPro, minusCart);
//		}
//		if(plusPro != null && plusCart != null) {
//			cartItemDAO.PlusQuantity(plusPro, plusCart);
//		}
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		List<CartItem> list = cartItemDAO.getAllCartItemByUserId(uid);
		List<Category> listC = categoryDao.getAll();
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("getAllCartItem", list);
		req.setAttribute("listcate", listC);
		RequestDispatcher rq = req.getRequestDispatcher("/views/user/cart.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
