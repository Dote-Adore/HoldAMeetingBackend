package top.cyc.dao.impl;

import top.cyc.dao.DAOUtlis;
import top.cyc.dao.DepartmentDAO;
import top.cyc.entity.Department;

import java.sql.SQLException;
import java.util.List;

public class DepartmentDAOImpl extends DAOUtlis implements DepartmentDAO {
    @Override
    public List<Department> GetList() throws SQLException {
        sql = "select * from department";
        return DB.getForList(Department.class,sql);
    }
}
