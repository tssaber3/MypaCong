package servlet;

import dao.userDao;
import entity.User;
import util.JDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet(name = "pictureServlet")
public class pictureServlet extends HttpServlet {
    private String action = "";//要执行的操作
    private userDao Dao = new userDao();
    String path = "";
    boolean bok = false;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        path = request.getContextPath();
        User user = new User();
        if(request.getParameter("action")!=null)
        {
            this.action = request.getParameter("action");
            if(action.equals("login"))
            {
                user.setUsername(username);
                user.setPassword(password);
                try {
                    bok = Dao.loginUser(user);
                    if(bok)
                    {
                        response.sendRedirect(path + "/welcome.jsp");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            if(action.equals("register"))
            {
                response.sendRedirect(path + "/register.jsp");
            }
            if(action.equals("registerUser"))
            {
                user.setUsername(username);
                user.setPassword(password);
                try {
                    Dao.addUser(user);
                    response.sendRedirect(path + "/login.jsp");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
