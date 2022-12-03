package vn.iotstar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;

import vn.iotstar.DAO.userInfoDAO;
import vn.iotstar.model.user;

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
			String contact = req.getParameter("contact");
			String address = req.getParameter("address");
			String username = req.getParameter("userName");
			String password = req.getParameter("pass");
			String re_pass = req.getParameter("re_pass");
			if(username == null)
			{
				req.getRequestDispatcher("/views/shared/registration.jsp").forward(req,resp); 
			}
			else
			if (password.equals(re_pass) && fname != null && lname!= null && email != null && contact != null && address != null)
			{
				userInfoDAO signupDAO = new userInfoDAO();
				check = signupDAO.checkSignup(fname, lname, email, contact, address, username,
						  password);
				if(check == 1)
				{
					 req.getRequestDispatcher("/views/shared/login.jsp").forward(req,resp);
				}
				else 
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
