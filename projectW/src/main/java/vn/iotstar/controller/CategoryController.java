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

	int n= 6;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lay tham so tu JSP
		String cid = req.getParameter("cid");
		// lay tham so tu jsp
		String index = req.getParameter("index");
		if (index == null) {
			index = "1";
		}
		int indexpage = Integer.parseInt(index);
		// B1:khỏi tạo DAO
		ProductDAO productDao = new ProductDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		int countPro = productDao.countAllProbyCateId(cid);
		int countPage= countPro/n;
		if(countPro % n !=0) {
			countPage++;
		}
		List<Product> list = productDao.getAllProbyPagebyCate(indexpage,cid,n);
		List<Category> listC = categoryDao.getAll();
		Category cate = categoryDao.getCateByIdC(cid);
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("cate", cate);
		req.setAttribute("listprobycate", list);
		req.setAttribute("listcate", listC);
		req.setAttribute("CountPa", countPage);
		req.setAttribute("tag", indexpage);
		req.setAttribute("cid", cid);
		RequestDispatcher rq = req.getRequestDispatcher("views/user/category.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
