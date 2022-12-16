package vn.iotstar.VendorController;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.OrderDAO;
import vn.iotstar.model.Order;


@WebServlet(urlPatterns = "/Vendor")
public class ShowOrderSelledController extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	
	OrderDAO orderDAO = new OrderDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String status = req.getParameter("status");
		String indexPage = req.getParameter("index");
		HttpSession session = req.getSession();
		if (indexPage == null) {
			indexPage = "1";
		}
		if (status == null) {
			status ="Đã bán";
		}
		int indexp = Integer.parseInt(indexPage);
		int countP;
		int endPage;
		String statusName="";
		List<Order> orderlist = orderDAO.findAllPageToStatus(status, indexp - 1);
		countP = orderDAO.countOrderToStatus(status);
		System.out.println(countP);
		endPage = countP/6;
		if (countP % 6 != 0) {
			endPage++;
		}
		for(Order order: orderlist)
		{
			LocalDate localDate = order.getUpdatedAt().toLocalDate();
			LocalDate newDate = LocalDate.of(localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()).plusDays(5);
			
			order.setDeliveryAt(Date.valueOf(newDate));
		}
		
		if(status.equals("Đã bán")) {
			statusName = "Đơn hàng đã bán";
		}
		else if (status.equals("Cần xử lý")) {
			statusName = "Đơn hàng cần xử lý";
		}
		else if (status.equals("Đang giao hàng")) {
			statusName = "Đơn hàng đang vận chuyển";
		}
		else if (status.equals("Đã hủy")) {
			statusName = "Đơn hàng đã hủy";
		}
		req.setAttribute("statusName", statusName);
		req.setAttribute("orderlist", orderlist);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", indexp);
		req.setAttribute("countordersAll", countP);
		session.setAttribute("statusOrder", status);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/vendor/welcomevendor.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
