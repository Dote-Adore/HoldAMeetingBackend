package top.cyc.servlet.meeting;

import com.alibaba.fastjson.JSONArray;
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
import java.util.List;

@WebServlet(name = "GetByOrganizer")
public class GetByOrganizer extends HttpServlet {
    private Integer OrganizerID;
    private  Integer page;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        OrganizerID = Integer.parseInt(request.getParameter("id"));
        page = Integer.parseInt(request.getParameter("page"));
        MeetingDAOImpl MDI = new MeetingDAOImpl();
        try {
            List<Meeting> meetingList =  MDI.getAllByOrganizer(OrganizerID,page);
            JSONArray jsonArray = new JSONArray();
            for(int i = 0; i<meetingList.size();i++){
                jsonArray.add(meetingList.get(i).toJSONForOrganinzer());
            }
            out.print(new UtilJSON(jsonArray));
        }catch (Exception e){
            e.printStackTrace();
            out.print(new UtilJSON(false, ""));
        }

    }
}
