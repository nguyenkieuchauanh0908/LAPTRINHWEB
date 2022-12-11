package vn.iotstar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.UserDAO;

/**
 * Servlet implementation class registrationController
 */

@WebServlet(urlPatterns  = "/registration")
public class registrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html;charset=UTF-8");
		int check = -1;
		try 
		{
			String fname = req.getParameter("fname");
			String lname = req.getParameter("lname");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String password = req.getParameter("pass");
			String re_pass = req.getParameter("re_pass");
			if(email == null)
			{
				req.getRequestDispatcher("/views/shared/registration.jsp").forward(req,resp); 
			}
			else
			if (password.equals(re_pass) && fname != null && lname!= null && email != null && phone != null && address != null)
			{
				UserDAO signupDAO = new UserDAO();
				check = signupDAO.checkSignup(fname, lname, email, phone, address, password);
				if(check == 1) //nếu đăng ký thành công thì chuyển hướng sang trang đăng nhập
				{
					 req.getRequestDispatcher("/views/shared/login.jsp").forward(req,resp);
				}
				else //nếu thất bại
				{
						  req.getRequestDispatcher("/views/shared/registration.jsp").forward(req,resp); 
				}
				check = -1;
			}
			else 
				req.getRequestDispatcher("/views/shared/registration.jsp").forward(req,resp); 
		}
		catch (Exception e)
		{
			
		}
	}



}
