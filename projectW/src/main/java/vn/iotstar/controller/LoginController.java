package vn.iotstar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.iotstar.DAO.UserDAO;
import vn.iotstar.model.User;

@WebServlet(urlPatterns  = "/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try 
		{
			String email = req.getParameter("email"); 
			String password = req.getParameter("password");
			UserDAO loginDAO =new UserDAO(); 
			User a = loginDAO.checkLogin(email, password);
			String alert = "";
			if(a == null) //Người dùng không tồn tại
			{
				alert="Email hoặc mật khẩu không chính xác!";
				req.setAttribute("message", alert);
				req.setAttribute("messageType", "danger");
				req.getRequestDispatcher("/views/shared/login.jsp").forward(req,resp);
			}
			else //Người dùng tồn tại
			{
				// cách gọi session ở servlet Controller khác: Ex: request.getSession().getAttribute("listaProdutos");
				HttpSession session = req.getSession(); //Tạo session
				session.setAttribute("uEmail", email); // Cách gọi session ở trang jsp: ${sessionScope.uPass}
				session.setAttribute("uId", a.get_id());
				session.setAttribute("uFirstname", a.getFirstname());
				session.setAttribute("uLastname", a.getLastname());
				if (a.get_role().equals("1")) // Nếu role là user thì chuyển hướng về trang khách hàng
				{
					resp.sendRedirect("welcome"); 
				}
				if (a.get_role().equals("0")) // Nếu role là admin thì chuyển hướng về trang admin
				{
					req.getRequestDispatcher("/views/admin/welcomeAdmin.jsp").forward(req,resp);
				}
				else // Nếu role là vendor thì chuyển hướng về trang vendor
					req.getRequestDispatcher("/views/admin/welcomeAdmin.jsp").forward(req,resp);//thay thành trang chủ của vendor
			}
		}
		catch (Exception e){
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
}