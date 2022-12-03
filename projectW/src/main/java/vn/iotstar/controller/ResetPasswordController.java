package vn.iotstar.controller;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.userInfoDAO;
import vn.iotstar.util.EmailUtility;
/**
 * A Java Servlet to handle requests to reset password for customer
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/reset_password")
public class ResetPasswordController extends HttpServlet {
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
 
    public ResetPasswordController() 
    {
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String page = "/views/shared/reset_password.jsp";
        request.getRequestDispatcher(page).forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String recipient = request.getParameter("email");
        String subject = "Mật khẩu của bạn đã được đặt lại";
        userInfoDAO user = new userInfoDAO();
        String newPassword = user.resetCustomerPassword(recipient); //taọ pass ngẫu nhiên
        int u_id = user.findByEmail(recipient); // tìm id ứng với email nhập vào
        user.update(newPassword,u_id);// cập nhật pass mới theo id
        String content = "Đây là mật khẩu mới của bạn: " + newPassword;
        content += "\nLưu ý: Vì lý do bảo mật, "
                + "Vui lòng đổi mật khẩu ngay sau khi đăng nhập";
        String message = "";
        try 
        {
            EmailUtility.sendEmail(host, port, email, name, pass,
                    recipient, subject, content);
            message = "Mật khẩu mới đã được gửi qua email. Vui lòng kiểm tra email của bạn.";
        } catch (Exception ex) 
        {
            ex.printStackTrace();
            message = "Có lỗi xảy ra: " + ex.getMessage();
        } finally 
        {
            request.setAttribute("message", message);
            request.getRequestDispatcher("/views/shared/message.jsp").forward(request, response);
        }
    }
 
}