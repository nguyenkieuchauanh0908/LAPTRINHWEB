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

@WebServlet(urlPatterns  = "/employeeList")
public class employeeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public employeeListController() {
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
			List<User> employeeList = user.getEmployee();
			req.setAttribute("employeeList", employeeList);
			if(employeeList.equals(null))
					req.getRequestDispatcher("/views/shared/test.jsp").forward(req, resp);
			else
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/Employee/employeeList.jsp");
				dispatcher.forward(req, resp);
			}
		}
		catch (Exception e){	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
