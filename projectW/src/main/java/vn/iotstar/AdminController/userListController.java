package vn.iotstar.AdminController;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.ProductDAO;
import vn.iotstar.DAO.UserDAO;
import vn.iotstar.model.Product;
import vn.iotstar.model.User;
@WebServlet(urlPatterns  = "/userList")
public class userListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int role = 1;//người dùng
	public int n;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		n = 5;
		// thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lay tham so tu jsp
		String index = req.getParameter("index");
		if (index == null) {// mặc định index = 1 (trang thứ nhất) nếu user chưa chọn trang nào
			index = "1";
		}
		int indexpage = Integer.parseInt(index); // trang thứ index
		// B1:khỏi tạo DAO
		UserDAO userDAO = new UserDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		int countCate = userDAO.countAllUser(role); // số dòng
		int countPage = countCate / n; // Số lượng trang (mỗi trang 8 sản phẩm)
		if (countCate % n != 0) {// nếu chia ra bị lẻ thì ta cộng thêm một trang
			countPage++;
		}
		List<User> userList = userDAO.getAllUserByPage(indexpage,n,role); // lấy các user/nhân viên thuộc trang thứ indexPage
																			// cần hiển thị
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("userList", userList);
		req.setAttribute("CountPa", countPage);
		req.setAttribute("tag", indexpage);
		RequestDispatcher rq = req.getRequestDispatcher("views/admin/User/userList.jsp");
		rq.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
