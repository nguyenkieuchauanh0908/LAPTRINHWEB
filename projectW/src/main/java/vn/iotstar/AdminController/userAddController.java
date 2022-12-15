package vn.iotstar.AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.UserDAO;
import vn.iotstar.model.User;

/**
 * Servlet implementation class userAddController
 */
@WebServlet(urlPatterns = { "/userAdd"})
public class userAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public userAddController() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/views/admin/Employee/employeeAdd.jsp").forward(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int check = 0;//Nếu thêm thành công thì check = 1
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone_number");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		String password = req.getParameter("password");
		if(role.equals("Quản trị viên"))
			role="0";
		if (role.equals("Khách hàng"))
			role="1";
		else
			role="2";
		User user = new User();
		user.setFirstname(fname);
		user.setLastname(lname);
		user.setEmail(email);
		user.setPhone(phone);
		user.setAddresses(address);
		user.set_role(role);
		user.setHashed_password(password);
		HttpSession session = req.getSession();
		session.setAttribute("phone", phone);
		UserDAO userInsert = new UserDAO();
		check = userInsert.insertUser(user);
		if (check == 1) {
			resp.sendRedirect("employeeList");  // Nếu thêm thành công thì về lại trang List, thay thành hiện thông báo
																				
		} else
			req.getRequestDispatcher("/views/shared/test.jsp").forward(req, resp); // Thêm thất bại thì chuyển sang test

	}
}
