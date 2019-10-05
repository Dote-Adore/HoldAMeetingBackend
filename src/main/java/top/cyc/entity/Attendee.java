package top.cyc.entity;

import com.alibaba.fastjson.JSONObject;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

public class Attendee {
    private String id;
    private String meetingID;
    private String attendeeOpenID;
    private Timestamp createTime;
    private String aName;
    private String aWorkUnit;
    private String aIDNum;
    private Integer aGender;
    private String aPhoneNum;
    private Timestamp aAttendTime;
    private Integer aArrangeRoom;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeetingID() {
        return meetingID;
    }

    public void setMeetingID(String meetingID) {
        this.meetingID = meetingID;
    }

    public String getAttendeeOpenID() {
        return attendeeOpenID;
    }

    public void setAttendeeOpenID(String attendeeOpenID) {
        this.attendeeOpenID = attendeeOpenID;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        if(aName.equals("null")){
            this.aName =null;
        }
        else
        this.aName = aName;
    }

    public String getaWorkUnit() {
        return aWorkUnit;
    }

    public void setaWorkUnit(String aWorkUnit) {
        if(aWorkUnit.equals("null")){
            this.aWorkUnit =null;
        }
        else
            this.aWorkUnit = aWorkUnit;
    }

    public String getaIDNum() {
        return aIDNum;
    }

    public void setaIDNum(String aIDNum) {
        if(aIDNum.equals("null"))
            this.aIDNum = null;
        else
        this.aIDNum = aIDNum;
    }

    public Integer getaGender() {
        return aGender;
    }

    public void setaGender(Integer aGender) {
        this.aGender = aGender;
    }

    public String getaPhoneNum() {
        return aPhoneNum;
    }

    public void setaPhoneNum(String aPhoneNum) {
        if(aPhoneNum.equals("null"))
            this.aPhoneNum = null;
        else
        this.aPhoneNum = aPhoneNum;
    }

    public Timestamp getaAttendTime() {
        return aAttendTime;
    }

    public void setaAttendTime(Timestamp aAttendTime) {

            this.aAttendTime = aAttendTime;
    }

    public Integer getaArrangeRoom() {
        return aArrangeRoom;
    }

    public void setaArrangeRoom(Integer aArrangeRoom) {
        this.aArrangeRoom = aArrangeRoom;
    }

    //    private  Integer id;
//    private  String meetingID;
//    private  String attendeeOpenID;
//    private Timestamp createTime;
//    private  String aName;
//    private String aWorkUnit;
//    private String aIDNum;
//    private Boolean aGender;
//    private  String aPhoneNum;
//    private  Timestamp aAttendTime;
//    private Boolean aArrangeRoom;
    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("meetingID", meetingID);
        jsonObject.put("attendeeOpenID", attendeeOpenID);
        jsonObject.put("createTime", createTime);
        jsonObject.put("aName", aName);
        jsonObject.put("aWorkUnit", aWorkUnit);
        jsonObject.put("aIDNum", aIDNum);
        jsonObject.put("aGender", aGender);
        jsonObject.put("aPhoneNum", aPhoneNum);
        jsonObject.put("aAttendTime", aAttendTime);
        jsonObject.put("aArrangeRoom", aArrangeRoom);
        return jsonObject;
    }

    public void create(
            String meetingID,
            String attendeeOpenID,
            String aName,
            String aWorkUnit,
            String aIDNum,
            Integer aGender,
            String aPhoneNum,
            Timestamp aAttendTime,
            Integer aArrangeRoom) throws SQLException {
        setaArrangeRoom(aArrangeRoom);
        setaAttendTime(aAttendTime);
        setaGender(aGender);
        setaIDNum(aIDNum);
        setaName(aName);
        setaPhoneNum(aPhoneNum);
        setAttendeeOpenID(attendeeOpenID);
        setMeetingID(meetingID);
        setaWorkUnit(aWorkUnit);
        createTime = new Timestamp(System.currentTimeMillis());
        id = getRandomID();
    }

    private String getRandomID() throws SQLException {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        //0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        return machineId + String.format("%011d", hashCodeV);
    }
}
