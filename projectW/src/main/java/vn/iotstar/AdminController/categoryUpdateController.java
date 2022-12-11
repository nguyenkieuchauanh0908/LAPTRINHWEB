package vn.iotstar.AdminController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.CategoryDAO;
import vn.iotstar.model.Category;

@WebServlet(urlPatterns  = "/categoryUpdate")
public class categoryUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public categoryUpdateController() {
        super();
    }
    Category cate = new Category();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String cid =  req.getParameter("cid");
		CategoryDAO categoryDAO = new CategoryDAO();
		cate = categoryDAO.getCateByIdC(cid);
		req.setAttribute("cate", cate);
		if (cate.equals(null)) {
			resp.sendRedirect("categoryList");  // Nếu không tìm thấy loại sản phẩm thì không chuyển trang																				
		} 
		else
			req.getRequestDispatcher("/views/admin/Category/categoryUpdate.jsp").forward(req, resp); //Nếu tìm thấy loại sản phẩm thì chuyển sang trang update loại sp	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int check = 0;
		String cname =  req.getParameter("cname");
		cate.set_name(cname);
		CategoryDAO categoryDAO = new CategoryDAO();
		check = categoryDAO.updateCategory(cate);
		if (check == 0) {
			resp.sendRedirect("categoryUpdate");  // Nếu update thất bại																			
		} 
		else
			
			resp.sendRedirect("categoryList"); //Nếu upate thành công
	}

}
