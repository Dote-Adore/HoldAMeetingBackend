package top.cyc.dao.impl;

import top.cyc.dao.DAOUtlis;
import top.cyc.dao.MeetingDAO;
import top.cyc.entity.Meeting;

import java.sql.Timestamp;
import java.util.UUID;
import java.sql.SQLException;
import java.util.List;

public class MeetingDAOImpl extends DAOUtlis implements MeetingDAO {
    @Override
    public void insert(Meeting m) throws SQLException {
        String ID = getRandomID();
        m.setId(ID);

        sql = "insert into meeting values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        DB.update(sql, m.getId(),m.getName(),m.getAddress(),m.getMeetingTime(),m.getOrganizerID(),m.getOrganizerName(),
                m.getCreateTime(),m.getIntroduction(),m.getaName(),m.getaWorkUnit(),m.getaIDNum(),m.getaGender(),
                m.getaPhoneNum(),m.getaAttendTime(),m.getaArrangeRoom());
    }

    @Override
    public void update(Meeting meeting) throws SQLException {

    }

    @Override
    public List<Meeting> getAllByOrganizer(int organizerID, int page) throws SQLException {

        sql = "select * from meeting where organizerID = ? and meetingTime > ?  order by meetingTime";

        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        return DB.getForList(Meeting.class, sql, organizerID,currentTime);
    }

    @Override
    public List<Meeting> getAll(int page) throws SQLException {
        return null;
    }

    @Override
    public void DeleteById(String id) throws SQLException {

    }

    @Override
    public Meeting GetById(String id) throws SQLException {
        sql= "select * from meeting where id = ?";
        return DB.get(Meeting.class,sql,id);
    }

    private String getRandomID()throws  SQLException{
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        //0 代表前面补充0     
        // 4 代表长度为4     
        // d 代表参数为正数型
        return  machineId+ String.format("%011d", hashCodeV);
    }
}
