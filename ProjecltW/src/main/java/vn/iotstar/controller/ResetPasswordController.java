package vn.iotstar.controller;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.DAO.userInfoDAO;
import vn.iotstar.model.user;
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
        String subject = "Your Password has been reset";
        userInfoDAO user = new userInfoDAO();
        String newPassword = user.resetCustomerPassword(recipient);
        int u_id = user.findByEmail(recipient);
        user.update(newPassword,u_id);
        String content = "Hi, this is your new password: " + newPassword;
        content += "\nNote: for security reason, "
                + "you must change your password after logging in.";
        String message = "";
        try 
        {
            EmailUtility.sendEmail(host, port, email, name, pass,
                    recipient, subject, content);
            message = "Your password has been reset. Please check your e-mail.";
        } catch (Exception ex) 
        {
            ex.printStackTrace();
            message = "There were an error: " + ex.getMessage();
        } finally 
        {
            request.setAttribute("message", message);
            request.getRequestDispatcher("/views/shared/message.jsp").forward(request, response);
        }
    }
 
}