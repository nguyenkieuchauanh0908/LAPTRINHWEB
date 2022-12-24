package vn.iotstar.VendorController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.OrderDAO;
import vn.iotstar.DAO.OrderItemDAO;
import vn.iotstar.model.Order;
import vn.iotstar.model.OrderItem;
import vn.iotstar.util.FormatCurrency;

@WebServlet("/Vendor/ShowOrderDetail")
public class ShowOrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderDAO orderService = new OrderDAO();
	OrderItemDAO ordersItemService = new OrderItemDAO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		FormatCurrency fm = new FormatCurrency();
		String oid = req.getParameter("exist");
		System.out.println(oid);
		String total;
		float sum = 0;

		Order order = orderService.findtoOid(Integer.parseInt(oid));
		System.out.println(order.get_id());
		List<OrderItem> ordersItem = ordersItemService.search(order.get_id());

		for (OrderItem orderItem : ordersItem) {
			System.out.println(orderItem.getProduct().getPrice());
			sum = sum + orderItem.getProduct().getPrice() * (float) orderItem.getCount_SP();// tổng giá tiền của hóa đơn
		}
		total = fm.formatCurrency(sum);
		PrintWriter out = resp.getWriter();
		out.println("<div class=\"modal showed\" id=\"js-modal \">\r\n"
				+ "                                <div class=\"modal-container js-modal-container\" style=\"width: 800px\">\r\n"
				+ "                                    <header class=\"modal-header\">\r\n"
				+ "                                        <i class=\"model-heading-icon ti-bag\"></i> Thông tin đơn hàng\r\n"
				+ "                                    </header>\r\n" + "\r\n"
				+ "                                    <div class=\"modal-body\" style=\"max-height: 80%\">\r\n"
				+ "                                        <div class=\"order_purchase\">\r\n"
				+ "                                            <div class=\"purchase_tabcontent\" id=\"purchase_tabcontent--my\">\r\n"
				+ "                                                <div class=\"purchase_item\" style=\"max-height: 65%; overflow-y: auto\">\r\n"
				+ "                                                    <div class=\"purchase_item--order\">\r\n"
				+ "                                                        <div>\r\n"
				+ "                                                            <div class=\"purchase_item--order--title\">\r\n"
				+ "                                                                <div class=\"purchase_item--order--id\">\r\n"
				+ "                                                                    Đơn hàng <strong>#</strong>\r\n"
				+ "                                                                    <strong>" + order.get_id()
				+ "</strong>\r\n" + "                                                                </div>\r\n"
				+ "                                                                <div class=\"purchase_item--order--date\">Ngày đặt:\r\n"
				+ "                                                                    " + order.getCreatedAt()
				+ "</div>\r\n"
				+ "                                                                <div class=\"purchase_item--order--address\">\r\n"
				+ "                                                                    Địa chỉ nhận hàng: "
				+ order.getAddress() + "\r\n"
				+ "                                                                </div>\r\n"
				+ "                                                            </div>\r\n" + "\r\n");
		for (OrderItem oitem : ordersItem) {
			out.println(
					"														<div class=\"purchase_item--order--product\">\r\n"
							+ "                                                                            <div class=\"purchase_item--product\">\r\n"
							+ "                                                                                <div class=\"purchase_item--image\">\r\n"
							+ "                                                                                    <img src=\"/ProjecltW/"
							+ oitem.getProduct().getImage() + "\">\r\n"
							+ "                                                                                </div>\r\n"
							+ "                                                                                <div class=\"purchase_item--caption\" style=\"font-size: 18px;\">\r\n"
							+ "                                                                                    <div class=\"purchase_item--name\" style=\"font-size: 18px;\">\r\n"
							+ "                                                                                        "
							+ oitem.getProduct().getName() + "\r\n"
							+ "                                                                                    </div>\r\n"
							+ "                                                                                    <div class=\"purchase_item--amount\" style=\"font-size: 16px;\">\r\n"
							+ "                                                                                        Số lượng:\r\n"
							+ "                                                                                        "
							+ oitem.getCount_SP() + "</div>\r\n"
							+ "                                                                                    <div class=\"purchase_item--price\"style=\"font-size: 16px;\">\r\n"
							+ "                                                                                        Giá tiền:\r\n"
							+ "                                                                                        <div\r\n"
							+ "                                                                                            class=\"purchase_item--price--new\" style=\"font-size: 16px;\">\r\n"
							+ "                                                                                            "
							+ (fm.formatCurrency(oitem.getProduct().getPrice() * (float) oitem.getCount_SP())) + "\r\n"
							+ "                                                                                        </div>\r\n"
							+ "                                                                                    </div>\r\n"
							+ "                                                                                </div>\r\n"
							+ "                                                                            </div>\r\n"
							+ "                                                                        </div>\r\n"
							+ "\r\n");
		}
		;
		out.println("														\r\n"
				+ "                                                            <div class=\"purchase_item--order--total\">\r\n"
				+ "                                                                <div class=\"purchase_item--sum\" style=\"font-size: 20px; margin-top: 10px;\">\r\n"
				+ "                                                                    <div class=\"purchase_item--label\" style=\"font-size: 20px;\">Tổng tiền:</div>\r\n"
				+ "                                                                    <span class=\"purchase_item--value\" style=\"font-size: 20px;\">\r\n"
				+ "                                                                        " + total
				+ "                                                                    </span>\r\n"
				+ "                                                                </div>\r\n"
				+ "                                                            </div>\r\n"
				+ "                                                        </div>\r\n"
				+ "                                                    </div>\r\n"
				+ "                                                </div>\r\n"
				+ "                                                \r\n"
				+ "										<div class=\"modal-footer\">\r\n");
		HttpSession session = req.getSession(false);
		Integer role = Integer.parseInt((String) session.getAttribute("role"));
		if (role == 2)
		{
			if (order.getStatus().equals("Cần xử lý")) {
				out.println(
						"<button class=\"btn btn-primary\" onclick=\"location.href='/ProjecltW/vendor/order/confirm?oid="
								+ order.get_id() + "'\">Xác nhận</button>\r\n");
				
			} else if (order.getStatus().equals("Đang giao hàng")) {
				out.println(
						"<button class=\"btn btn-primary\" onclick=\"location.href='/ProjecltW/vendor/order/confirm?oid="
								+ order.get_id() + "'\">Hoàn thành đơn hàng </button>\r\n");
			}
		}
		out.println(
				"											<a class=\"btn btn-danger closed-dongs\" data-dismiss=\"modal\"\r\n"
						+ "												aria-label=\"Close\">Đóng</a>\r\n"
						+ "                                                        </div>\r\n"
						+ "                                                    </div>\r\n"
						+ "                                                        </div>\r\n"
						+ "                                                    </div>\r\n"
						+ "                                                </div>\r\n");


	}

}
