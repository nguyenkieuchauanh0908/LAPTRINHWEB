package vn.iotstar.AdminController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.model.Category;

@WebServlet(urlPatterns = { "/categoryAdd"})
public class categoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public categoryAddController() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.getRequestDispatcher("/views/admin/Category/categoryAdd.jsp").forward(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int check = 0;//Nếu thêm thành công thì check = 1
		String cname = req.getParameter("cname");
		Category cate = new Category();
		cate.set_name(cname);
		HttpSession session = req.getSession();
		session.setAttribute("pname", cname);
		CategoryDAO categoryInsert = new CategoryDAO();
		check = categoryInsert.insertCategory(cate);
		if (check == 1) {
			resp.sendRedirect("categoryList");  // Nếu thêm thành công thì về lại trang List, thay thành hiện thông báo																					
		} 
		else
			req.getRequestDispatcher("/views/shared/test.jsp").forward(req, resp); // Thêm thất bại thì chuyển sang test
	}

}
