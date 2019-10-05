package top.cyc.servlet.login;
import com.alibaba.fastjson.JSONObject;
import top.cyc.utils.WX_API;

public class ToWxApi {


    public static String GetOpenId(String code) {
        try {
            String api = WX_API.GetOpenIDUrl+"?appid="+WX_API.APPID+"&secret="+WX_API.AppSecretID+"&js_code="+code+"&&grant_type=authorization_code";
            StringBuilder res =  WX_API.getResult(api, "GET");
            JSONObject jsonObject = JSONObject.parseObject(res.toString());
            return jsonObject.getString("openid");

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
