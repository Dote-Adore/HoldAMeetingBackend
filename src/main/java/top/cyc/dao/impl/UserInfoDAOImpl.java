package top.cyc.dao.impl;

import top.cyc.dao.DAOUtlis;
import top.cyc.dao.UserInfoDAO;
import top.cyc.entity.UserInfo;

import java.sql.SQLException;

public class UserInfoDAOImpl extends DAOUtlis implements UserInfoDAO {
    @Override
    public void Register(UserInfo userInfo) throws SQLException {
    }

    @Override
    public UserInfo Login(String userName, String password, String openId) throws SQLException {
        String sql = "select * from userInfo where userName=? and `password`=?";
        UserInfo userInfo = DB.get(UserInfo.class,sql,userName,password);
        // 如果userinfo不为空，则登陆,openid 更新
        if(userInfo!=null) {
            String sql2 = "update userInfo set openID = ? where id = ?";
            DB.update(sql2, openId, userInfo.getId());
        }
        return userInfo;
    }
}
