package top.cyc.dao.impl;

import top.cyc.dao.DAOUtlis;
import top.cyc.dao.UserInfoDAO;
import top.cyc.entity.UserInfo;

import java.sql.SQLException;

public class UserInfoDAOImpl extends DAOUtlis implements UserInfoDAO {
    @Override
    public void Register(UserInfo userInfo) throws SQLException {
        sql = "insert into userInfo(userName, password, name) values(?,?,?)";
        DB.update(sql,userInfo.getUserName(),userInfo.getPassword(), userInfo.getName());
    }

    @Override
    public UserInfo Login(String userName, String password, String openId, Boolean autoLogin) throws SQLException {
        cleanOpenId(openId);
        sql = "select * from userInfo where userName=? and `password`=?";
        UserInfo userInfo = DB.get(UserInfo.class,sql,userName,password);
        // 如果userinfo不为空，则登陆,openid 更新
        if(userInfo!=null) {
            String sql2 = "update userInfo set openID = ?, autoLogin = ? where id = ?";
            DB.update(sql2, openId, autoLogin,userInfo.getId());
        }
        return userInfo;
    }

    @Override
    public boolean hasUserName(String username) throws SQLException {
        sql = "select count(*) from userInfo where userName = ?";
        int count = DB.getCount(sql,username);
        if(count == 0)
            return false;
        else
            return true;

    }

    @Override
    public UserInfo autoLogin(String openID) throws SQLException {
        System.out.println("autoLogin  openID:"+openID);
        sql = "select * from userInfo where openID = ? and autoLogin = ?";
        return DB.get(UserInfo.class,sql,openID,true);
    }

    private void cleanOpenId(String openid)throws  SQLException{
        sql = "update userInfo set openID= ?  where openID = ?";
        DB.update(sql,"",openid);
    }

}
