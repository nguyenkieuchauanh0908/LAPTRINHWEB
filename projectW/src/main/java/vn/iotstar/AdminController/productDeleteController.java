package vn.iotstar.AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.ProductDAO;

/**
 * Servlet implementation class productDeleteController
 */
@WebServlet("/productDelete")
public class productDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public productDeleteController() {
        super();

    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int check = 0;//Nếu thêm thành công thì check = 1
		int pid = Integer.parseInt(req.getParameter("pid"));
		HttpSession session = req.getSession();
		session.setAttribute("pname", pid);
		ProductDAO productDAO = new ProductDAO();
		check = productDAO.deleteProduct(pid);
		if (check == 1) {
			resp.sendRedirect("productList");  // Nếu xóa thành công thì về lại trang List, thay thành hiện thông báo	
			//req.getRequestDispatcher("/views/shared/test.jsp").forward(req, resp);
		} 
		else
			if(check == 0)
			req.getRequestDispatcher("/views/shared/test.jsp").forward(req, resp); // Thêm thất bại thì chuyển sang test
	}

}
