package top.cyc.entity;

import com.alibaba.fastjson.JSONObject;
import top.cyc.utils.UtilFunction;

import java.sql.Timestamp;

public class Meeting {

    private String id;
    private String name;
    private String address;
    private Timestamp meetingTime;
    private Integer organizerID;
    private String organizerName;
    private Timestamp createTime;
    private String introduction;
    private Boolean aName;
    private Boolean aWorkUnit;
    private Boolean aIDNum;
    private Boolean aGender;
    private Boolean aPhoneNum;
    private Boolean aAttendTime;
    private Boolean aArrangeRoom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(Timestamp meetingTime) {
        this.meetingTime = meetingTime;
    }

    public Integer getOrganizerID() {
        return organizerID;
    }

    public void setOrganizerID(Integer organizerID) {
        this.organizerID = organizerID;
    }

    public String getOrganizerName() {
        return organizerName;
    }

    public void setOrganizerName(String organizerName) {
        this.organizerName = organizerName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Boolean getaName() {
        return aName;
    }

    public void setaName(Boolean aName) {
        this.aName = aName;
    }

    public Boolean getaWorkUnit() {
        return aWorkUnit;
    }

    public void setaWorkUnit(Boolean aWorkUnit) {
        this.aWorkUnit = aWorkUnit;
    }

    public Boolean getaIDNum() {
        return aIDNum;
    }

    public void setaIDNum(Boolean aIDNum) {
        this.aIDNum = aIDNum;
    }

    public Boolean getaGender() {
        return aGender;
    }

    public void setaGender(Boolean aGender) {
        this.aGender = aGender;
    }

    public Boolean getaPhoneNum() {
        return aPhoneNum;
    }

    public void setaPhoneNum(Boolean aPhoneNum) {
        this.aPhoneNum = aPhoneNum;
    }

    public Boolean getaAttendTime() {
        return aAttendTime;
    }

    public void setaAttendTime(Boolean aAttendTime) {
        this.aAttendTime = aAttendTime;
    }

    public Boolean getaArrangeRoom() {
        return aArrangeRoom;
    }

    public void setaArrangeRoom(Boolean aArrangeRoom) {
        this.aArrangeRoom = aArrangeRoom;
    }

    public JSONObject toJSONForOrganinzer(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id",id);
        jsonObject.put("name",name);
        jsonObject.put("address",address);
        jsonObject.put("meetTime",meetingTime);
        // 时间格式化
        jsonObject.put("meetTimeFormat", UtilFunction.TimeFormat(meetingTime));
        jsonObject.put("organizerName",organizerName);
        jsonObject.put("organizerID",organizerID);
        jsonObject.put("createTime",createTime);
        jsonObject.put("introduction",introduction);
        return jsonObject;
    }

    public JSONObject toJSONForAttendee(){
        JSONObject jsonObject = toJSONForOrganinzer();


        JSONObject optionsjson = new JSONObject();
        optionsjson.put("aName",aName);
        optionsjson.put("aIDNum",aIDNum);

        optionsjson.put("aGender",aGender);

        optionsjson.put("aPhoneNum",aPhoneNum);

        optionsjson.put("aAttendTime",aAttendTime);

        optionsjson.put("aArrangeRoom",aArrangeRoom);

        optionsjson.put("aWorkUnit",aWorkUnit);

        jsonObject.put("options",optionsjson);
        return  jsonObject;

    }
}
