package top.cyc.dao;

import top.cyc.entity.Meeting;

import java.sql.SQLException;
import java.util.List;

public interface MeetingDAO {

    public void insert(Meeting meeting)throws SQLException;
    public void update(Meeting meeting)throws SQLException;
    public List<Meeting> getAllByOrganizer(int organizerID, int page)throws  SQLException;
    public List<Meeting> getAll(int page)throws  SQLException;
    public void DeleteById(String id)throws SQLException;
    public Meeting GetById(String id)throws SQLException;
}
