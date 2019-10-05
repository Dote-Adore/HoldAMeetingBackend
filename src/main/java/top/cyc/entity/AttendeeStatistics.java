package top.cyc.entity;

import com.alibaba.fastjson.JSONObject;

public class AttendeeStatistics {
    private  Long allCount;
    private Long male;
    private  Long female;
    private Long arrangeRoom;
    private  Long noArrangeRoom;

    public Long getAllCount() {
        return allCount;
    }

    public void setAllCount(Long allCount) {
        this.allCount = allCount;
    }

    public Long getMale() {
        return male;
    }

    public void setMale(Long male) {
        this.male = male;
    }

    public Long getFemale() {
        return female;
    }

    public void setFemale(Long female) {
        this.female = female;
    }

    public Long getArrangeRoom() {
        return arrangeRoom;
    }

    public void setArrangeRoom(Long arrangeRoom) {
        this.arrangeRoom = arrangeRoom;
    }

    public Long getNoArrangeRoom() {
        return noArrangeRoom;
    }

    public void setNoArrangeRoom(Long noArrangeRoom) {
        this.noArrangeRoom = noArrangeRoom;
    }
    public JSONObject toJSON(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("allCount",allCount);
        jsonObject.put("male",male);
        jsonObject.put("female",female);
        jsonObject.put("arrangeRoom",arrangeRoom);
        jsonObject.put("noArrangeRoom",noArrangeRoom);
        return jsonObject;
    }
}
