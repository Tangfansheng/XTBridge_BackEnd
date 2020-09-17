package com.voyager.dao;

import com.voyager.domain.QueryDate;
import com.voyager.domain.QueryDerrick;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface DerrickDao {
    @Select("select force1,force2,force3,force4,force5,datetime from derrick_force order by id desc LIMIT 1")
    public QueryDerrick findRecentData();

    @Select("select force1,force2,force3,force4,force5,datetime from derrick_force")
    public List<QueryDerrick> findAllData();

    @Select("select force1,force2,force3,force4,force5,datetime from derrick_force order by id desc Limit 10")
    public List<QueryDerrick> findRecent10Data();

    @Select("select datetime from derrick_force order by id desc LIMIT 10")
    public List<QueryDate> getRecent10date();



}
