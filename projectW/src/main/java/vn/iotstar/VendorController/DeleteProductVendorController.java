package vn.iotstar.VendorController;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.ProductDAO;
import vn.iotstar.model.Product;
import vn.iotstar.util.Constant;

@WebServlet(urlPatterns = { "/vendor/product/delete" })
public class DeleteProductVendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO proService = new ProductDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oid = req.getParameter("pid");
		Product product = proService.findOne(Integer.parseInt(oid));

		String fileName = product.getImage();
		final String dir = Constant.DIRPRO;
		File file = new File(dir + "/" + fileName);
		if (file.exists()) {
			file.delete();
		}
		proService.delete(Integer.parseInt(oid));
		resp.sendRedirect(req.getContextPath() + "/vendor/product");
	}
	
}
