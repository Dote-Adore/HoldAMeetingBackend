package top.cyc.dao.impl;

import top.cyc.dao.AttendeeDAO;
import top.cyc.dao.DAOUtlis;
import top.cyc.entity.Attendee;
import top.cyc.entity.AttendeeStatistics;

import java.sql.SQLException;
import java.util.List;

public class AttendeeDAOImpl extends DAOUtlis implements AttendeeDAO {
    @Override
    public void add(Attendee a) throws SQLException {
        sql = "insert into attendee() values(?,?,?,?,?,?,?,?,?,?,?)";
        DB.update(sql,a.getId(),a.getMeetingID(),a.getAttendeeOpenID(),a.getCreateTime(),a.getaName(),a.getaWorkUnit(),
        a.getaIDNum(),a.getaGender(),a.getaPhoneNum(),a.getaAttendTime(),a.getaArrangeRoom());
    }

    @Override
    public List<Attendee> getForList(String openid) throws SQLException {
        sql = "select * from attendee where  attendeeOpenID = ?";
        return DB.getForList(Attendee.class, sql, openid);
    }

    @Override
    public AttendeeStatistics getStatisticsByMeeting(String meetingId) throws SQLException {
       sql = "select count(*) AS allCount, count(case when aGender=1 then 1 end) AS male, count(case when aGender=0 then 1 end) AS female, " +
               "count(case when aArrangeRoom=1 then 1 end) AS arrangeRoom, count(case when aArrangeRoom=0 then 1 end) AS noArrangeRoom " +
               "FROM attendee where meetingID = ?";
       return DB.get(AttendeeStatistics.class,sql,meetingId);
    }
}
