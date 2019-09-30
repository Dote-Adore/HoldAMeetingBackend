package top.cyc.servlet.login;

import com.alibaba.fastjson.JSONObject;
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
        System.out.println(userName+"   "+password+"   "+code);
        ToWxApi wxapi = new ToWxApi();
        UserInfoDAOImpl UIDI = new UserInfoDAOImpl();
        StringBuilder reslut = wxapi.GetOpenId(code);
        JSONObject jsonObject = JSONObject.parseObject(reslut.toString());
        String openid = jsonObject.getString("openid");
        try {
            UserInfo userInfo = UIDI.Login(userName,password,openid);
            // 如果有结果
            if(userInfo!=null){
                JSONObject json = new JSONObject();
                json.put("id", userInfo.getId());
                json.put("username",userInfo.getUserName());
                json.put("permission", userInfo.getPermission());
                out.print(new UtilJSON(json));
            }
            // 如找不到结果
            else{
                out.print(new UtilJSON(false, "noAccount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(openid.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
