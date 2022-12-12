package vn.iotstar.AdminController;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.iotstar.DAO.UserDAO;
import vn.iotstar.model.User;

/**
 * Servlet implementation class userListController
 */
@WebServlet(urlPatterns  = "/userList")
public class userListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public userListController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try 
		{
			UserDAO user =new UserDAO(); 
			List<User> userList = user.getCustomer();
			req.setAttribute("userList", userList);
			if(userList.equals(null))
					req.getRequestDispatcher("/views/shared/test.jsp").forward(req, resp);
			else
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/User/userList.jsp");
				dispatcher.forward(req, resp);
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/User/userList.jsp");
			dispatcher.forward(req, resp);
		}
		catch (Exception e){	
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
