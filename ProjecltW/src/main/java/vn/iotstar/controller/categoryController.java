package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.categoryDAO;
import vn.iotstar.DAO.productDAO;
import vn.iotstar.model.category;
import vn.iotstar.model.product;

@WebServlet(urlPatterns = "/category")
public class categoryController extends HttpServlet {

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
		//lay tham so tu JSP
		String cid = req.getParameter("cid"); 
		// B1:khỏi tạo DAO
		productDAO productDao = new productDAO();
		categoryDAO categoryDao = new categoryDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		List<product> list = productDao.getAllProductByIdC(cid);
		List<category> listC = categoryDao.getAll();
		category cate = categoryDao.getCateByIdC(cid);
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
