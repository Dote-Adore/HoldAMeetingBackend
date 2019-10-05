package top.cyc.servlet.login;
import com.alibaba.fastjson.JSONObject;
import top.cyc.utils.UtilJSON;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetOpenId extends HttpServlet {
    /**
     *
     */

    private static final long serialVersionUID = 1L;

    private String code;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        try {
            String openId = ToWxApi.GetOpenId(code);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("openId",openId);
            out.print(new UtilJSON(true,"",jsonObject));
        }catch (Exception e) {
            e.printStackTrace();
            out.print(new UtilJSON(false,""));

        }
    }
}
