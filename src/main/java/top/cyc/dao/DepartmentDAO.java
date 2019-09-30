package top.cyc.dao;

import top.cyc.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
    public List<Department> GetList() throws SQLException;
}
