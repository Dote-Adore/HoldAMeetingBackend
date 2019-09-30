package top.cyc.servlet.department;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import top.cyc.dao.impl.DepartmentDAOImpl;
import top.cyc.entity.Department;
import top.cyc.utils.UtilJSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GetDepartmentList")
public class GetDepartmentList extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        DepartmentDAOImpl DDI = new DepartmentDAOImpl();
        JSONArray jsonArray = new JSONArray();
        JSONArray NameArr = new JSONArray();
        try {
            List<Department> departmentList =  DDI.GetList();
            for(Department i: departmentList){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id",i.getId());
                jsonObject.put("name",i.getName());
                jsonArray.add(jsonObject);
                NameArr.add(i.getName());
            }
            JSONObject res = new JSONObject();
            res.put("keyValueArr",jsonArray);
            res.put("nameArr",NameArr);
            out.print(new UtilJSON(res));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
