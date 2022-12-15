package vn.iotstar.AdminController;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vn.iotstar.DAO.ProductDAO;
import vn.iotstar.model.Product;
@WebServlet(urlPatterns  = "/productList")
public class productListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public productListController() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		try 
		{
			ProductDAO product = new ProductDAO();
			List<Product> producList = product.getAll();
			req.setAttribute("producList", producList);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/Product/productList.jsp");
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
