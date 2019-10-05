package top.cyc.servlet.attendee;

import top.cyc.dao.impl.AttendeeDAOImpl;
import top.cyc.entity.Attendee;
import top.cyc.entity.AttendeeStatistics;
import top.cyc.utils.UtilJSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Statistics")
public class Statistics extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String meetingID = request.getParameter("meetingID");
        AttendeeDAOImpl ADI = new AttendeeDAOImpl();
        try{
            AttendeeStatistics aS = ADI.getStatisticsByMeeting(meetingID);
          if(aS!=null){
              System.out.println("count:"+ aS.getAllCount()+";male:"+aS.getMale()
              +";ArrangeRoom:"+aS.getArrangeRoom());
              out.print(new UtilJSON(true,"",aS.toJSON()));
          }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
