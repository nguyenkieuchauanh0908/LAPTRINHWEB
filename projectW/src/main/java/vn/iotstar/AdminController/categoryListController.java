package vn.iotstar.AdminController;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.model.Category;
@WebServlet(urlPatterns  = "/categoryList")
public class categoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public categoryListController() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try 
		{
			CategoryDAO category = new CategoryDAO();
			List<Category> categoryList = category.getAll();
			req.setAttribute("categoryList", categoryList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/Category/categoryList.jsp");
			dispatcher.forward(req, resp);
		}
		catch (Exception e){
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
