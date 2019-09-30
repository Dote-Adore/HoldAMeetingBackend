package top.cyc.dao;
import top.cyc.entity.UserInfo;

import java.sql.SQLException;

public interface UserInfoDAO {
    public void Register(UserInfo userInfo) throws SQLException;
    public UserInfo Login(String userName, String password,String openId) throws  SQLException;
}
