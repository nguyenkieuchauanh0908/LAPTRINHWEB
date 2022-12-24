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

@WebServlet("/ProByCate")
public class proByCateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int n = 5;
    public proByCateController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String index = req.getParameter("index");
		String categoryId =  req.getParameter("categoryId");
		if(index == null) {//mặc định index = 1 (trang thứ nhất) nếu user chưa chọn trang nào
			index ="1";
		}
		int indexpage = Integer.parseInt(index); //trang thứ index
		// B1:khỏi tạo DAO
		ProductDAO productDao = new ProductDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		int countPro = productDao.countAllProbyCateId(categoryId); //số dòng
		int countPage= countPro/n; //Số lượng trang (mỗi trang n sản phẩm)
		if(countPro % n !=0) {//nếu chia ra bị lẻ thì ta cộng thêm một trang
			countPage++;
		}
		List<Product> list = productDao.getAllProbyPagebyCate(indexpage, categoryId, n); //lấy các sản phẩm thuộc trang thứ indexPage cần hiển thị
		List<Category> listC = categoryDao.getAll(); //Lấy hết tất cả sản phẩm
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("listpro", list);
		req.setAttribute("listcate", listC);
		req.setAttribute("CountPa", countPage);
		req.setAttribute("tag", indexpage);
		RequestDispatcher rq = req.getRequestDispatcher("views/admin/Product/productByCate.jsp");
		rq.forward(req, resp);
	}

}
