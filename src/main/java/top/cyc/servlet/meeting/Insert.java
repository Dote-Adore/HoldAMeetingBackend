package top.cyc.servlet.meeting;

import com.alibaba.fastjson.JSONObject;
import top.cyc.dao.DAOUtlis;
import top.cyc.dao.impl.MeetingDAOImpl;
import top.cyc.entity.Meeting;
import top.cyc.utils.UtilJSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;


@WebServlet(name = "Insert")
public class Insert extends HttpServlet {
    private String name;
    private String address;
    private Timestamp meetingTime;
    private Integer organizerID;
    private String organizerName;
    private String introduction;
    private Timestamp createTime;
    private JSONObject optionsJson;
    private Meeting meeting = new Meeting();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        name  = request.getParameter("name");
        address = request.getParameter("address");
        meetingTime = new Timestamp(Long.parseLong(request.getParameter("meetingTime")));
        organizerID = Integer.parseInt(request.getParameter("organizerID"));
        organizerName = request.getParameter("organizerName");
        introduction = request.getParameter("introduction");
        createTime = new Timestamp(Long.parseLong(request.getParameter("createTime")));
        optionsJson = JSONObject.parseObject(request.getParameter("options"));
        MeetingDAOImpl MDI = new MeetingDAOImpl();
        setMeetingEntity();
        try{
            MDI.insert(meeting);
            System.out.println("Success insert a Meeting!");
            out.print(new UtilJSON(true, ""));
        }catch (Exception e){
            e.printStackTrace();
            out.print(new UtilJSON(false,e.toString()));
        }
    }


    // 设置meeting类
    private void setMeetingEntity(){
        meeting.setName(name);
        meeting.setAddress(address);
        meeting.setMeetingTime(meetingTime);
        meeting.setOrganizerID(organizerID);
        meeting.setOrganizerName(organizerName);
        meeting.setIntroduction(introduction);
        meeting.setCreateTime(createTime);
        meeting.setaName(optionsJson.getBoolean("aName"));
        meeting.setaWorkUnit(optionsJson.getBoolean("aWorkUnit"));
        meeting.setaIDNum(optionsJson.getBoolean("aIDNum"));
        meeting.setaGender(optionsJson.getBoolean("aGender"));
        meeting.setaPhoneNum(optionsJson.getBoolean("aPhoneNum"));
        meeting.setaAttendTime(optionsJson.getBoolean("aAttendTime"));
        meeting.setaArrangeRoom(optionsJson.getBoolean("aArrangeRoom"));

    }
}
