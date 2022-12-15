package vn.iotstar.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.UserDAO;

@WebServlet("/ResetPassword")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResetPasswordController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = "/views/shared/resetPw.jsp";
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int check = -1;
		String code = request.getParameter("code");
		String pass = request.getParameter("pass");
		String re_pass = request.getParameter("re_pass");
		if (code.equals(request.getSession().getAttribute("code")))
		{
			{
				if (pass.equals(re_pass)) {
					UserDAO uDAO = new UserDAO();
					int u_id = (Integer) request.getSession().getAttribute("u_id");
					check = uDAO.updatePass(pass, u_id);
					if (check == 1)// Nếu đổi mật khẩu thành công
					{
						HttpSession session = request.getSession();
						session.removeAttribute("code");
						response.sendRedirect("login");
						
					} else {
						if (check == 0)// Nếu đổi mật khẩu thất bại
						{
							HttpSession session = request.getSession();
							session.removeAttribute("code");
							String page = "/views/shared/forgetPw.jsp";
							request.getRequestDispatcher(page).forward(request, response);
						}
					}
				}
			}
		}
		else
		{
			HttpSession session = request.getSession(); //Tạo session
			session.setAttribute("pname", check);
			request.getRequestDispatcher("/views/shared/test.jsp").forward(request,response);
		}

	}
}
