package vn.iotstar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.iotstar.DAO.userInfoDAO;
import vn.iotstar.model.User;

@WebServlet(urlPatterns  = "/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		try 
		{
			String email = req.getParameter("email"); 
			String password = req.getParameter("password");
			HttpSession session = req.getSession(); //Tạo session
			userInfoDAO loginDAO =new userInfoDAO(); // Cách gọi session ở trang jsp: ${sessionScope.uPass}
			User a = loginDAO.checkLogin(email, password);
			if(a == null) //Người dùng không tồn tại
			{
				req.getRequestDispatcher("/views/shared/login.jsp").forward(req,resp);
			}
			else
			{
				//gán các giá trị vào session 
				// cách gọi session ở servlet Controller khác: Ex: listaProds =(ArrayList<Produto>) request.getSession().getAttribute("listaProdutos");
				session.setAttribute("uEmail", email); 
				session.setAttribute("uId", a.get_id());
				session.setAttribute("uFirstname", a.getFirstname());
				session.setAttribute("uLastname", a.getLastname());
				resp.sendRedirect("welcome"); // thay lại là trang home của admin
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