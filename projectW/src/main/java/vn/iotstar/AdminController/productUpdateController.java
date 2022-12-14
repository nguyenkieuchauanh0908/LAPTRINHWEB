package vn.iotstar.AdminController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
@WebServlet(urlPatterns = "/productUpdate")
public class productUpdateController extends HttpServlet {
	Path oldImagePath;
	private static final long serialVersionUID = 1L;
	Product product = new Product();

	public productUpdateController() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String pid = req.getParameter("pid");
		HttpSession session = req.getSession();
		session.setAttribute("pid", pid);
		ProductDAO productDAO = new ProductDAO();
		product = productDAO.getProByIdPro(pid);
		CategoryDAO cateDAO = new CategoryDAO();
		List<Category> cateList = cateDAO.getAll();
		req.setAttribute("cateList", cateList);
		req.setAttribute("product", product);
		if (product.equals(null)) {
			resp.sendRedirect("productList"); // Nếu không tìm thấy loại sản phẩm thì không chuyển trang
		} else
			req.getRequestDispatcher("/views/admin/Product/productUpdate.jsp").forward(req, resp); // Nếu tìm thấy loại
																									// sản phẩm thì
																									// chuyển sang trang
																									// update loại sp
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int check = 0;// Nếu thêm thành công thì check = 1
		String pname = req.getParameter("pname");
		int categoryId = Integer.parseInt(req.getParameter("categoryId"));
		boolean isDeleted = Boolean.parseBoolean(req.getParameter("isDeleted"));
		String description = req.getParameter("description");
		float price = Float.parseFloat(req.getParameter("price"));
		Part part = req.getPart("image");
		if (part.getSubmittedFileName().isEmpty() == false) //Kiểm tra nếu có file nộp về thì mới cập nhật ảnh
		{
			String realPath = req.getServletContext().getRealPath("/images/products/"); //lấy đường dẫn thực tế
			String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString(); //lấy tên filename
			Path oldImagePath = Paths.get(req.getServletContext().getRealPath(product.getImage()));//lấy đường dẫn của ảnh cũ
			if (!Files.exists(Paths.get(realPath))) //Nếu đường dẫn thực tế chưa có thì tạo đường dẫn
			{
				Files.createDirectories(Paths.get(realPath));
			}
			part.write(realPath + "/" + filename); //Lưu ảnh vô vị trí
			String image = "images/products/" + filename;
			Files.deleteIfExists(oldImagePath);
			product.setImage(image);
		}
		//Cập nhật các thuộc tính khác của product
		product.setName(pname);
		product.setCategoryId(categoryId);
		product.setDescription(description);
		product.setPrice(price);
		product.setIsDeleted(isDeleted);
		ProductDAO productDAO = new ProductDAO();
		check = productDAO.updateProduct(product);
		//req.setAttribute("pid", Session);
		if (check == 1) {
			resp.sendRedirect("productList"); // Nếu thêm thành công thì về lại trang List, thay thành hiện thông báo
		} else
			doGet(req,resp);
			//req.getRequestDispatcher("/views/shared/test.jsp").forward(req, resp); // Thêm thất bại thì chuyển sang test
	}

}
