package vn.iotstar.VendorController;

import vn.iotstar.DAO.OrderDAO;
import vn.iotstar.DAO.OrderItemDAO;
import vn.iotstar.DAO.ProductDAO;
import vn.iotstar.model.Order;
import vn.iotstar.model.OrderItem;
import vn.iotstar.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = { "/vendor/order/confirm"})
public class ConfirmOrderVendorController extends HttpServlet{
private static final long serialVersionUID = 1L;
	
OrderDAO ordersService = new OrderDAO();
	OrderItemDAO ordersItemService = new OrderItemDAO();
	ProductDAO productService = new ProductDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		String oid = req.getParameter("oid");
		Order order = ordersService.findtoOid(Integer.parseInt(oid));
		if (order.getStatus().equals("Đang giao hàng") ) {
			order.setStatus("Đã bán");
		}
		else if(order.getStatus().equals("Cần xử lý")) {
			List<OrderItem> ordersItem = ordersItemService.search(order.get_id());
			for(OrderItem item: ordersItem) {
				Product pro = productService.findById(item.getProductId());
				pro.setSold(pro.getSold() + item.getCount_SP());
				pro.setQuantity(pro.getQuantity() - item.getCount_SP());
			
				productService.update(pro);
			}
			order.setStatus("Đang giao hàng");
			java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
			order.setUpdatedAt(date);
		}
		
		ordersService.update(order);
		resp.sendRedirect(req.getContextPath() + "/Vendor");
	}	
}
