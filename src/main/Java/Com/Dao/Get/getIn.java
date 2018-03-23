package Com.Dao.Get;

import Com.Dao.Dao.Dao;
import Com.Dao.User.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getIn")
public class getIn extends HttpServlet {
    String name;
    String password;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        name = (String) request.getParameter("name");
        password = (String) request.getParameter("password");

        Dao compare = new Dao();
        User us = compare.getHehe(name,password);

        if (us!= null) {
            request.setAttribute("user", us);
//        转到hello.jsp页面
            request.getRequestDispatcher("hello.jsp").forward(request, response);
        } else {
//           转到登陆页面到登陆页面
            request.setAttribute("error", "用户名或密码错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
