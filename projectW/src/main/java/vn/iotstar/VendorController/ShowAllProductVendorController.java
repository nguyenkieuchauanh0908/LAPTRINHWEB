package vn.iotstar.VendorController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.DAO.ProductDAO;
import vn.iotstar.model.Product;




@WebServlet(urlPatterns = {"/vendor/product"})
public class ShowAllProductVendorController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	ProductDAO proService = new ProductDAO();
	CategoryDAO categoryService = new CategoryDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String indexPage = req.getParameter("index");
		HttpSession session = req.getSession();
		
		if (indexPage == null) {
			indexPage = "1";
		}
		
		int indexp = Integer.parseInt(indexPage);
		int countP;
		int endPage;
		List<Product> productListNew = new ArrayList<>();
		
			countP =  proService.countAll();
			productListNew = proService.findAllPage(indexp - 1);

		endPage = countP / 8;
		if (countP % 8 != 0) {
			endPage++;
		}

		req.setAttribute("productListNew", productListNew);
		req.setAttribute("countproductAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);

		req.getRequestDispatcher("/Views/vendor/product_vendor.jsp").forward(req, resp);
	}
}
