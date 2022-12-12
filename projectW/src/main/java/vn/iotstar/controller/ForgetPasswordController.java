package vn.iotstar.controller;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.iotstar.DAO.UserDAO;
import vn.iotstar.util.EmailUtility;
@WebServlet("/forgetPassword")
public class ForgetPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        email = context.getInitParameter("email");
        name = context.getInitParameter("name");
        pass = context.getInitParameter("pass");
    }
    public ForgetPasswordController() 
    {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String page = "/views/shared/forgetPw.jsp";
        request.getRequestDispatcher(page).forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String recipient = request.getParameter("email");
        String subject = "Đặt lại mật khẩu";
        UserDAO user = new UserDAO();
        String code = user.resetCustomerPassword(recipient); //taọ pass ngẫu nhiên
        int u_id = user.findByEmail(recipient); // tìm id ứng với email nhập vào
        HttpSession session = request.getSession(); //Tạo session
		session.setAttribute("code", code);
		session.setAttribute("u_id", u_id);
        String content = "Đây là mã xác nhận để đổi mật khẩu: " + code;
        content += "\nLưu ý: Vì lý do bảo mật, "
                + "Vui lòng không chia sẻ mã nãy với bất kỳ ai!";
        String message;
        try 
        {
            EmailUtility.sendEmail(host, port, email, name, pass,
                    recipient, subject, content);
            message = "Vui lòng kiểm tra email của bạn.";
        } catch (Exception ex) 
        {
            ex.printStackTrace();
            message = "Có lỗi xảy ra: " + ex.getMessage();
        } finally 
        {
            //request.setAttribute("message", message);
            //request.getRequestDispatcher("/views/shared/message.jsp").forward(request, response);
            response.sendRedirect("ResetPassword");
        }
    }
 
}