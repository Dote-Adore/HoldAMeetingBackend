package top.cyc.dao;

import top.cyc.utils.DButils;

public class DAOUtlis {
    protected DButils DB;
    protected String sql = null;
    public DAOUtlis(){
        DB = new DButils();
    }
}
