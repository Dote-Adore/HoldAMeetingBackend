package top.cyc.servlet.attendee;

import top.cyc.dao.impl.AttendeeDAOImpl;
import top.cyc.entity.Attendee;
import top.cyc.utils.UtilJSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;

@WebServlet(name = "Attend")
public class Attend extends HttpServlet {
    private String meetingID = null;
    private String openID = null;
    private Integer aArrangeRoom = null;
    private Timestamp aAttendTime = null;
    private Integer aGender = null;
    private String aIDNum  = null;
    private String aName = null;
    private String aPhoneNum = null;
    private String aWorkUnit = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        meetingID = request.getParameter("meetingID");
             openID = request.getParameter("openID");
             try {
                 aArrangeRoom = Integer.parseInt(request.getParameter("aArrangeRoom"));
                 System.out.println("aArrangeRoom:"+ aArrangeRoom);

             }catch (Exception e){
                 System.out.println("no aArrangeRoom");
             }
             try {
                 aAttendTime = new Timestamp(Long.parseLong(request.getParameter("aAttendTime")));
                 System.out.println("aAttendTime:"+ aAttendTime);
             }catch (Exception e){
                 System.out.println("no aAttendTime");
             }
             try {
                 aGender = Integer.parseInt(request.getParameter("aGender"));
                 System.out.println("aGender:"+ aGender);
             }catch (Exception e){
                 System.out.println("no aGender");
             }
             try {
                 aIDNum = request.getParameter("aIDNum");
                 System.out.println("aIDNum:"+ aIDNum);
             }
             catch (Exception e){
                 System.out.println("no aIDNum");

             }
             try {
                 aName = request.getParameter("aName");
                 System.out.println("aName:"+ aName);

             }catch (Exception e){
                 System.out.println("no aName");

             }
             try {
                 aPhoneNum = request.getParameter("aPhoneNum");
                 System.out.println("aPhoneNum:"+ aPhoneNum);
             }catch (Exception e){
                 System.out.println("no aPhoneNum");

             }
             try {
                 aWorkUnit = request.getParameter("aWorkUnit");
                 System.out.println("aWorkUnit:"+ aWorkUnit);
             }catch (Exception e){
                 System.out.println("no aWorkUnit");

             }
        Attendee attendee = new Attendee();
        try {
            attendee.create(meetingID,openID,aName,aWorkUnit,aIDNum,aGender,aPhoneNum,aAttendTime,aArrangeRoom);
            AttendeeDAOImpl ADI = new AttendeeDAOImpl();
            ADI.add(attendee);
            out.print(new UtilJSON(true,"插入成功"));
        } catch (SQLException e) {
            e.printStackTrace();
            out.print(new UtilJSON(false,"提交失败"));
        }
    }
}
