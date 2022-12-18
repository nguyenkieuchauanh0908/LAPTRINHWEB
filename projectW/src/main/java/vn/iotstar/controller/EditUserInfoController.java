package vn.iotstar.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.DAO.UserDAO;
import vn.iotstar.model.Category;
import vn.iotstar.model.User;
@MultipartConfig
@WebServlet(urlPatterns = "/edituserinfo")
public class EditUserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public User list1;
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
		list1 = userInfoDao.getUser(uid);
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
		HttpSession session = req.getSession(); //Tạo session
		try {
			int uid = Integer.parseInt(req.getParameter("id"));
			String fname = req.getParameter("firstname");
			String lname = req.getParameter("lastname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String addresses = req.getParameter("addresses");
			Part part = req.getPart("avatar");
			if (part.getSubmittedFileName().isEmpty() == false) //Kiểm tra nếu có file nộp về thì mới cập nhật ảnh
			{
				String realPath = req.getServletContext().getRealPath("/images/avatar/"); //lấy đường dẫn thực tế
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString(); //lấy tên filename
				if(!list1.getAvatar().equals(null))
				{
					Path oldImagePath = Paths.get(req.getServletContext().getRealPath(list1.getAvatar()));//lấy đường dẫn của ảnh cũ
					Files.deleteIfExists(oldImagePath);
				}
				if (!Files.exists(Paths.get(realPath))) //Nếu đường dẫn thực tế chưa có thì tạo đường dẫn
				{
					Files.createDirectories(Paths.get(realPath));
				}
				part.write(realPath + "/" + filename); //Lưu ảnh vô vị trí
				String image = "images/avatar/" + filename;
				list1.setAvatar(image);
				session.setAttribute("avatar", image);
				
			}
			list1.set_id(uid);
			list1.setFirstname(fname);
			list1.setLastname(lname);
			list1.setEmail(email);
			list1.setPhone(phone);
			list1.setAddresses(addresses);
			session.setAttribute("uFirstname", fname);
			session.setAttribute("uLastname", lname);
			String alert="";
			UserDAO UserInfoDAO = new UserDAO();
			int check = -1;
			check = UserInfoDAO.checkUpdateInfo(list1);
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
