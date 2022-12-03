package vn.iotstar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.iotstar.DAO.userInfoDAO;
import vn.iotstar.model.user;

@WebServlet(urlPatterns  = "/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try 
		{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			HttpSession session = req.getSession(); //Tạo session
			session.setAttribute("uName", username); //gán các giá trị vào session
			session.setAttribute("uPass", password); // cách gọi session ở servlet Controller khác: Ex: listaProds =(ArrayList<Produto>) request.getSession().getAttribute("listaProdutos");
			userInfoDAO loginDAO =new userInfoDAO(); // Cách gọi session ở trang jsp: ${sessionScope.uPass}
			user a = loginDAO.checkLogin(username, password);
			if(a == null) //Người dùng không tồn tại
			{
				req.getRequestDispatcher("/views/shared/login.jsp").forward(req,resp);
			}
			else
			{
				session.setAttribute("uId", a.getUserid());
				req.getRequestDispatcher("/views/shared/registration.jsp").forward(req,resp); // thay lại là trang home của admin
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