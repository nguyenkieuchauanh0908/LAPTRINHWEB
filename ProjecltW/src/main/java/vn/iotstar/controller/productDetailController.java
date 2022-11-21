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
import vn.iotstar.DAO.inventoryDAO;
import vn.iotstar.DAO.productDAO;
import vn.iotstar.model.category;
import vn.iotstar.model.inventory;
import vn.iotstar.model.product;

@WebServlet(urlPatterns = "/productDetail")
public class productDetailController extends HttpServlet {

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
		productDAO productDao = new productDAO();
		categoryDAO categoryDao = new categoryDAO();
		inventoryDAO inventoryDao = new inventoryDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		product Product = productDao.getProByIdPro(pid);
		List<category> listC = categoryDao.getAll();
		inventory inven =inventoryDao.getInvenByIdPro(pid);
		String status ;
		if(inven.getQuantity()>0) {
			status="Còn hàng";
		}
		else {
			status="hết hàng";
		}
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("getPro", Product);
		req.setAttribute("listcate", listC);
		req.setAttribute("Status", status);
		req.setAttribute("inven", inven);
		RequestDispatcher rq = req.getRequestDispatcher("views/user/productDetail.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
