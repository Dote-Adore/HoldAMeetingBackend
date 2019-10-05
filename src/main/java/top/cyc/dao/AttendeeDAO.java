package top.cyc.dao;

import top.cyc.entity.Attendee;
import top.cyc.entity.AttendeeStatistics;

import java.sql.SQLException;
import java.util.List;

public interface AttendeeDAO {
    public void add(Attendee attendee)throws SQLException;
    public List<Attendee> getForList(String openid)throws  SQLException;
    public AttendeeStatistics getStatisticsByMeeting(String meetingId)throws SQLException;
}
