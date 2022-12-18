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
import vn.iotstar.model.Category;
@WebServlet("/searchCategoryAdmin")
public class searchCategoryAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int n = 5;
	public searchCategoryAdminController() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
		//ProductDAO productDao = new ProductDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		int countPro = categoryDao.countAllCatebyKeyWord(keyword);
		int countPage = countPro / n;
		if (countPro % n != 0) {
			countPage++;
		}
		List<Category> categoryList = categoryDao.getAllCatebyPagebyKeyWord(indexpage, keyword, n);// Lấy list tất cả sản phẩm theo
																						// keywword truyền vào
		req.setAttribute("categoryList", categoryList);
		req.setAttribute("CountPa", countPage);
		req.setAttribute("tag", indexpage);
		req.setAttribute("key", keyword);
		RequestDispatcher rq = req.getRequestDispatcher("views/admin/Category/categorySearch.jsp");
		rq.forward(req, resp);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
