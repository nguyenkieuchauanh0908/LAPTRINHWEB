package vn.iotstar.AdminController;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.DAO.ProductDAO;
import vn.iotstar.model.Category;
import vn.iotstar.model.Product;
@MultipartConfig
@WebServlet(urlPatterns = { "/productAdd"})
public class productAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public productAddController() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		CategoryDAO cateDAO = new CategoryDAO();
		List<Category> cateList = cateDAO.getAll();
		req.setAttribute("cateList", cateList);
		req.getRequestDispatcher("/views/admin/Product/productAdd.jsp").forward(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int check = 0;//Nếu thêm thành công thì check = 1
		String pname = req.getParameter("pname");
		int categoryId =  Integer.parseInt(req.getParameter("categoryId"));
		String description = req.getParameter("description");
		float price = Float.parseFloat(req.getParameter("price"));
		Product product = new Product();
		Part part = req.getPart("image");
		if (part.getSubmittedFileName().isEmpty() == false) //Kiểm tra nếu có file nộp về thì mới cập nhật ảnh
		{
			String realPath = req.getServletContext().getRealPath("/images/products/"); //lấy đường dẫn thực tế
			String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString(); //lấy tên filename
			//Path oldImagePath = Paths.get(req.getServletContext().getRealPath(product.getImage()));//lấy đường dẫn của ảnh cũ
			if (!Files.exists(Paths.get(realPath))) //Nếu đường dẫn thực tế chưa có thì tạo đường dẫn
			{
				Files.createDirectories(Paths.get(realPath));
			}
			part.write(realPath + "/" + filename); //Lưu ảnh vô vị trí
			String image = "images/products/" + filename;
			product.setImage(image);
		}
		product.setName(pname);
		product.setCategoryId(categoryId);
		product.setDescription(description);
		product.setPrice(price);
		HttpSession session = req.getSession();
		session.setAttribute("pname", description);
		ProductDAO productDAO = new ProductDAO();
		check = productDAO.insertProduct(product);
		if (check == 1) 
		{
			resp.sendRedirect("productList");  // Nếu thêm thành công thì về lại trang List, thay thành hiện thông báo																					
		} 
		else
			req.getRequestDispatcher("/views/shared/test.jsp").forward(req, resp); // Thêm thất bại thì chuyển sang test
	}
}
