package vn.iotstar.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.ReviewDAO;

@WebServlet(urlPatterns = "/review")
public class ReviewController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Create a random string to use as the CSRF token.
		String csrfToken = UUID.randomUUID().toString();
		// Store the CSRF token in the session.
		HttpSession session = req.getSession();
		session.setAttribute("csrfToken", csrfToken);
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// thiết lập tiếng việt
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		// lay tham so tu Session
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("uId");
		String uid = String.valueOf(obj);
		String comment = req.getParameter("comment");
		String rating = req.getParameter("rating");
		String pid = req.getParameter("pid");
		// Get the CSRF token from the request.
		String csrfTokenFromRequest = req.getParameter("csrfToken");
		// Get the CSRF token from the session.
		String csrfTokenFromSession = (String) session.getAttribute("csrfToken");
		// Validate the CSRF token.
		if (csrfTokenFromRequest == null || !csrfTokenFromRequest.equals(csrfTokenFromSession)) {
		  // The CSRF token is invalid.
		  throw new ServletException("CSRF token is invalid.");
		}
		else
		{
			// B1:khỏi tạo DAO
			ReviewDAO reviewDao = new ReviewDAO();
			// B2:sử dụng đối tượng list để chứa danh sách từ ProductDAO
			reviewDao.insert(uid, pid, comment, rating);
			req.setAttribute("pid", pid);
			RequestDispatcher rq = req.getRequestDispatcher("/views/user/productDetail.jsp");
			rq.forward(req, resp);
		}
		

	}

}
