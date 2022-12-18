package vn.iotstar.AdminController;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.UserDAO;
import vn.iotstar.model.User;

@WebServlet("/searchUserAdmin")
public class searchUserAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int role = 1; //role ngươi dùng
	public int n = 5;
    public searchUserAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }
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
		UserDAO uDao = new UserDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		int countPro = uDao.countAllUserByKeyWord(keyword,2);
		int countPage = countPro / n;
		if (countPro % n != 0) {
			countPage++;
		}
		List<User> uList = uDao.getAllUserbyPagebyKeyWord(indexpage, keyword, n,role);// Lấy list tất cả user theo role																									
		// keywword truyền vào
		req.setAttribute("uList", uList);
		req.setAttribute("CountPa", countPage);
		req.setAttribute("tag", indexpage);
		req.setAttribute("key", keyword);
		RequestDispatcher rq = req.getRequestDispatcher("views/admin/User/userSearch.jsp");
		rq.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
