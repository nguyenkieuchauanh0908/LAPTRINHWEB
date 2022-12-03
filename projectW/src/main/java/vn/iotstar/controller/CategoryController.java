package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.DAO.ProductDAO;
import vn.iotstar.model.Category;
import vn.iotstar.model.Product;

@WebServlet(urlPatterns = "/category")
public class CategoryController extends HttpServlet {

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
		String cid = req.getParameter("cid");
		// B1:khỏi tạo DAO
		ProductDAO productDao = new ProductDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		List<Product> list = productDao.getAllProductByIdC(cid);
		List<Category> listC = categoryDao.getAll();
		Category cate = categoryDao.getCateByIdC(cid);
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("cate", cate);
		req.setAttribute("listprobycate", list);
		req.setAttribute("listcate", listC);
		RequestDispatcher rq = req.getRequestDispatcher("views/user/category.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
