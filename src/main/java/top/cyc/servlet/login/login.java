package top.cyc.servlet.login;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
import java.sql.SQLException;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        Boolean autoLogin = Boolean.parseBoolean(request.getParameter("autoLogin"));
        UserInfoDAOImpl UIDI = new UserInfoDAOImpl();
        String openid = ToWxApi.GetOpenId(code);
        try {
            UserInfo userInfo = UIDI.Login(userName,password,openid,autoLogin);
            // 如果有结果
            if(userInfo!=null){
                out.print(new UtilJSON(userInfo.toJSON()));
                System.out.println(userName+"   "+password+"   "+userInfo.getName());
            }
            // 如找不到结果
            else{
                out.print(new UtilJSON(false, "noAccount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
