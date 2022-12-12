package vn.iotstar.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.DAO.UserDAO;
import vn.iotstar.model.Category;
import vn.iotstar.model.User;

@WebServlet(urlPatterns = "/edituserinfo")
public class EditUserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lay tham so tu Session
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("uId");
		String uid = String.valueOf(obj);
		// B1:khỏi tạo DAO
		UserDAO userInfoDao = new UserDAO();
		CategoryDAO categoryDao = new CategoryDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ profileUSerDAO
		User list1 = userInfoDao.getUser(uid);
		List<Category> listC = categoryDao.getAll();
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("getUserEdit", list1);
		req.setAttribute("listcate", listC);
		RequestDispatcher rq = req.getRequestDispatcher("views/user/editUserInfo.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try {
			String uid = req.getParameter("id");
			String fname = req.getParameter("firstname");
			String lname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String addresses = req.getParameter("addresses");
			String alert="";
			UserDAO UserInfoDAO = new UserDAO();
			int check = -1;
			check = UserInfoDAO.checkUpdateInfo(uid, fname, lname, email, phone, addresses);
			if (check == 1) // nếu edit thành công thì chuyển hướng sang trang info
			{
				resp.sendRedirect("user");
			} else// nếu thất bại
			{
				alert = "Cập nhật thất bại";
				req.setAttribute("alert", alert);
				resp.sendRedirect("edituserinfo");
			}
		} catch (Exception e) {

		}
	}

}
