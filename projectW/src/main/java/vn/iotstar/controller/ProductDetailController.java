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

import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.DAO.ProductDAO;
import vn.iotstar.DAO.ReviewDAO;
import vn.iotstar.model.Category;
import vn.iotstar.model.Product;
import vn.iotstar.model.Review;

@WebServlet(urlPatterns = "/productDetail")
public class ProductDetailController extends HttpServlet {

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
		// lay tham so tu JSP
		String pid = req.getParameter("pid");
		// B1:khỏi tạo DAO
		ProductDAO productDao = new ProductDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		ReviewDAO reviewDao = new ReviewDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		Product Product = productDao.getProByIdPro(pid);
		List<Category> listC = categoryDao.getAll();
		List<Review> listReview = reviewDao.getAllReviewbyPro(pid);
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("listReview", listReview);
		req.setAttribute("getPro", Product);
		req.setAttribute("listcate", listC);
		RequestDispatcher rq = req.getRequestDispatcher("views/user/productDetail.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lay tham so tu Session
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("uId");
		String uid = String.valueOf(obj);
		String comment = req.getParameter("comment");
		String rating = req.getParameter("rating");
		String pid = req.getParameter("pid");
		// B1:khỏi tạo DAO
		ReviewDAO reviewDao = new ReviewDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		reviewDao.insert(uid, pid, comment, rating);
		req.setAttribute("pid", pid);
		doGet(req, resp);
	}

}
