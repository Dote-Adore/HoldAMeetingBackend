package top.cyc.servlet.meeting;

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

@WebServlet(name = "GetById")
public class GetById extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        MeetingDAOImpl MDI = new MeetingDAOImpl();
        try{
            Meeting meeting = MDI.GetById(id);
            if(meeting!=null){
                out.print(new UtilJSON(true,"",meeting.toJSONForAttendee()));
            }
            else{
                out.print(new UtilJSON(false,"找不到该会议内容，或许被删除了..."));
            }
        }catch (Exception e){
            e.printStackTrace();
            out.print(new UtilJSON(false,"服务器运行错误"));
        }
    }
}
