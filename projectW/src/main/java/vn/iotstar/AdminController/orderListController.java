package vn.iotstar.AdminController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.iotstar.DAO.OrderDAO;
import vn.iotstar.model.Order;
@WebServlet(urlPatterns  = "/orderList")
public class orderListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public orderListController() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try 
		{
			OrderDAO order = new OrderDAO();
			List<Order> orderList = order.getAll();
			req.setAttribute("orderList", orderList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/Order/orderList.jsp");
			dispatcher.forward(req, resp);
		}
		catch (Exception e){
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
