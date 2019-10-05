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

// 测试

@WebServlet(name = "autoLogin")
public class autoLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String openId = ToWxApi.GetOpenId(code);
        UserInfoDAOImpl UIDI = new UserInfoDAOImpl();
        try {
            UserInfo userInfo = UIDI.autoLogin(openId);
            if(userInfo!=null){
                out.print(new UtilJSON(true,"autoLoginSuccess",userInfo.toJSON()));
            }
            else{
                out.print(new UtilJSON(false,""));
            }
        }catch (Exception e){
            e.printStackTrace();
            out.print(new UtilJSON(false,""));
        }
    }
}
