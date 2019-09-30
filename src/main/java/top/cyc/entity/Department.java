package top.cyc.entity;

import com.alibaba.fastjson.JSONObject;

public class Department {
    private  Integer id;
    private String name;
    private Integer staffNum;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(Integer staffNum) {
        this.staffNum = staffNum;
    }

    public JSONObject ToJSON(){
        JSONObject json = new JSONObject();
        json.put("id",id);
        json.put("name",name);
        json.put("staffNum",staffNum);
        return  json;
    }
}
