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

@WebServlet("/orderSuccessList")
public class orderSuccessListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public int n;
    public orderSuccessListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		n = 5;
		// thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lay tham so tu jsp
		String index = req.getParameter("index");
		if (index == null) {// mặc định index = 1 (trang thứ nhất) nếu user chưa chọn trang nào
			index = "1";
		}
		int indexpage = Integer.parseInt(index); // trang thứ index
		// B1:khỏi tạo DAO
		OrderDAO orderDAO = new OrderDAO();
		// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
		int countOrder = orderDAO.countAllOrder(); // số dòng
		int countPage = countOrder / n; // Số lượng trang (mỗi trang 8 sản phẩm)
		if (countOrder % n != 0) {// nếu chia ra bị lẻ thì ta cộng thêm một trang
			countPage++;
		}
		List<Order> orderList = orderDAO.getAllOrderbyPage(indexpage, n, "Đã bán");// lấy các user/nhân viên thuộc trang thứ indexPage
																			// cần hiển thị
		// B3:thiết lập dữ liệu trên jsp
		req.setAttribute("orderList", orderList);
		req.setAttribute("CountPa", countPage);
		req.setAttribute("tag", indexpage);
		RequestDispatcher rq = req.getRequestDispatcher("views/admin/Order/orderSuccessList.jsp");
		rq.forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
