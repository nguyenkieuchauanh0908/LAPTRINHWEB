package vn.iotstar.VendorController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/Vendor/ShowVendorInfo")
public class ShowVendorInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Views/userinfo.jsp");
			dispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}	
}
