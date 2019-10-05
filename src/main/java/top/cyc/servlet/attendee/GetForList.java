package top.cyc.servlet.attendee;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import top.cyc.dao.impl.AttendeeDAOImpl;
import top.cyc.dao.impl.MeetingDAOImpl;
import top.cyc.entity.Attendee;
import top.cyc.entity.Meeting;
import top.cyc.utils.UtilFunction;
import top.cyc.utils.UtilJSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "GetForList")
public class GetForList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String openID = request.getParameter("openID");
        AttendeeDAOImpl ADI = new AttendeeDAOImpl();
        MeetingDAOImpl MDI = new MeetingDAOImpl();
        Meeting meeting = null;
        JSONObject meetingJSON = null;
        JSONObject attendeeJSON = null;
        JSONObject res = null;
        try{
            String meetingID = null;
            List<Attendee> attendeeList = ADI.getForList(openID);
            JSONArray jsonArray = new JSONArray();
            for(int i = 0; i<attendeeList.size();i++){
                res = new JSONObject();
                // 查询当前的会议内容
                meetingID = attendeeList.get(i).getMeetingID();
                meeting = MDI.GetById(meetingID);
                // 如果会议为空
                if(meeting==null){
                    continue;
                }
                // 获取会议执行的时间
               Timestamp meetingTime = meeting.getMeetingTime();
               // 如果会议时间比当天时间要早,则不要这段会议
                if(meetingTime.before(UtilFunction.getCurrentZeroTime())){
                    continue;
                }
                attendeeJSON = attendeeList.get(i).toJSON();
                meetingJSON = meeting.toJSONForOrganinzer();
                res.put("meetingDetails",meetingJSON);
                res.put("attendeeInfo",attendeeJSON);
                jsonArray.add(res);
            }
            out.print(new UtilJSON(true,"",jsonArray));
        }catch (Exception e){
            e.printStackTrace();
            out.print(new UtilJSON(false,"服务器执行错误"));
        }
    }
}
