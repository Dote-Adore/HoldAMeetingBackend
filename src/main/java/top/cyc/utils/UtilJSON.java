package top.cyc.utils;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.xdevapi.SqlResult;

// 公共的json，所有的数据以这个形式定义
public class UtilJSON {
        // 是否成功
        private boolean success;
        // 信息
        private String message;
        private JSONObject res = null;
        public UtilJSON(){
            success = true;
            message = "";
            toJson(true,"",new JSONObject());
        }
        public UtilJSON(JSONObject jsonObject){
            toJson(true,"",jsonObject);
        }
        public UtilJSON(boolean success, String message){
        toJson(success,message,new JSONObject());
        }
        public UtilJSON(boolean success, String message, JSONObject jsonObject){
            toJson(success,message,jsonObject);
        }
        private void toJson(boolean success, String message, JSONObject jsonObject){
            res = new JSONObject();
        res.put("success",success);
        res.put("message",message);
        res.put("data", jsonObject);
        }


        public UtilJSON(JSONArray jsonArray){
            toJSONArray(true, "", jsonArray);
        }
        public UtilJSON(boolean success, String message, JSONArray jsonArray){
            toJSONArray(success, message, jsonArray);
        }

        private  void toJSONArray(boolean success, String message, JSONArray jsonArray){
            res = new JSONObject();
            res.put("success",success);
            res.put("message",message);
            res.put("data", jsonArray);
        }
    @Override
    public String toString() {
       return res.toString();
    }
}
