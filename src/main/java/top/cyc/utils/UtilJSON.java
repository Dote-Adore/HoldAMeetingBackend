package top.cyc.utils;


import com.alibaba.fastjson.JSONObject;

// 公共的json，所有的数据以这个形式定义
public class UtilJSON {
        // 是否成功
        private boolean success;
        // 信息
        private String message;
        private JSONObject res = new JSONObject();
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
            res.put("success",success);
            res.put("message",message);
            res.put("data", jsonObject);
        }
    @Override
    public String toString() {
       return res.toString();
    }
}
