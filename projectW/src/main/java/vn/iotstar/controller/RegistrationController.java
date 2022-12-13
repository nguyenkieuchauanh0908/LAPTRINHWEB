package vn.iotstar.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.CartDAO;
import vn.iotstar.DAO.UserDAO;
import vn.iotstar.model.User;
@WebServlet(urlPatterns  = "/registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.getRequestDispatcher("/views/shared/registration.jsp").forward(req,resp); 
		//doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int check = -1; //nếu đăng ký thành công thì check = 1
		try 
		{
			String email = req.getParameter("email");
			String password = req.getParameter("pass");
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String phone = req.getParameter("phone");
			String re_pass = req.getParameter("re_pass");
			String address = req.getParameter("address");
			User user = new User();
			user.setFirstname(fname);
			user.setLastname(lname);
			user.setPhone(phone);
			user.setEmail(email);
			user.setHashed_password(password);
			user.setAddresses(address);
			user.set_role("1");
			if (password.equals(re_pass))
			{
				UserDAO userDAO = new UserDAO();
				check = userDAO.insertUser(user);
				if(check == 1) //đăng ký thành công
				{
					String uId = Integer.toString(userDAO.findByEmail(email));
					CartDAO cartDAO = new CartDAO();
					cartDAO.Insert((String)(uId));
					req.getRequestDispatcher("/views/shared/login.jsp").forward(req,resp);
				}
				else //nếu thất bại
				{
						  req.getRequestDispatcher("/views/shared/registration.jsp").forward(req,resp); 
				}
				check = -1;
			}
			
			 
		}
		catch (Exception e)
		{
			
		}
	}
}
