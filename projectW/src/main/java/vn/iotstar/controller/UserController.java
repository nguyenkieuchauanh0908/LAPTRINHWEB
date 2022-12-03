package vn.iotstar.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.iotstar.DAO.userInfoDAO;
import vn.iotstar.model.User;

@WebServlet(urlPatterns = "/user")
public class UserController extends HttpServlet {

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
		// B1:khỏi tạo DAO
		userInfoDAO userInfoDao = new userInfoDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ profileUSerDAO
		User list1 = userInfoDao.getUser(1);
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("getUser", list1);
		RequestDispatcher rq = req.getRequestDispatcher("views/user/userInfo.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
