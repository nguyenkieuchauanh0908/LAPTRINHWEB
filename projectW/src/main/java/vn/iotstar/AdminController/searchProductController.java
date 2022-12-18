package vn.iotstar.AdminController;

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

@WebServlet(urlPatterns = "/searchProductAdmin")
public class searchProductController extends HttpServlet {
	int n = 5;
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lay tham so tu jsp
		String keyword = req.getParameter("keyword");
		String index = req.getParameter("index");
		if (index == null) {
			index = "1";
		}
		int indexpage = Integer.parseInt(index);
		// B1:khỏi tạo DAO
		ProductDAO productDao = new ProductDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		int countPro = productDao.countAllProbyKeyWord(keyword);
		int countPage = countPro / n;
		if (countPro % n != 0) {
			countPage++;
		}
		List<Product> list = productDao.getAllProbyPagebyKeyWord(indexpage,keyword,n);//Lấy list tất cả sản phẩm theo keywword truyền vào
		List<Category> listC = categoryDao.getAll();
		req.setAttribute("listpro", list);
		req.setAttribute("listcate", listC);
		req.setAttribute("CountPa", countPage);
		req.setAttribute("tag", indexpage);
		req.setAttribute("key", keyword);
		RequestDispatcher rq = req.getRequestDispatcher("views/admin/Product/productSearch.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
