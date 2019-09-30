package top.cyc.servlet.login;

import top.cyc.dao.impl.UserInfoDAOImpl;
import top.cyc.entity.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        Integer departmentId = Integer.parseInt(request.getParameter("departmentID"));
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setDepartment(departmentId);
        userInfo.setName(name);
        UserInfoDAOImpl UIDI = new UserInfoDAOImpl();
        try {
            UIDI.Register(userInfo);
            out.print(true);
        }catch (Exception e)
        {
            e.printStackTrace();
            out.print(false);
        }
    }
}
