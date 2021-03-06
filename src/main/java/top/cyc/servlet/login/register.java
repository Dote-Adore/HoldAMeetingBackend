package top.cyc.servlet.login;

import top.cyc.dao.impl.UserInfoDAOImpl;
import top.cyc.entity.UserInfo;
import top.cyc.utils.UtilJSON;

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
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setPassword(password);
        userInfo.setName(name);
        UserInfoDAOImpl UIDI = new UserInfoDAOImpl();
        try {
            // 如果该用户没有被注册
            if(!UIDI.hasUserName(userName)) {
                UIDI.Register(userInfo);
                out.print(new UtilJSON(true,""));
            }
            else{
                out.print(new UtilJSON(false, "该用户名已被注册"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            out.print(new UtilJSON(false, "注册失败，请重试"));
        }
    }
}
