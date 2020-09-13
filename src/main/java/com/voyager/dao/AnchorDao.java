package com.voyager.dao;

import com.voyager.domain.QueryAnchor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnchorDao {
    /**
     *  查询最近的数据
     */
    @Select("select force1,force2,force3,force4,force5,force6, datetime from anchor_force order by id desc LIMIT 1")
    public QueryAnchor findRecentData();

    @Select("select force1,force2,force3,force4,force5,force6, datetime from anchor_force")
    public List<QueryAnchor> findAllData();

    @Insert("insert into anchor_force(force1, force2, force3,force4,force5,force6, datetime) values (#{force1}, #{force2},#{force3},#{force4}, #{force5},#{force6}, #{date})")
    public void saveOneRecord(QueryAnchor data);

    @Select("select force1,force2,force3,force4,force5,force6, datetime from anchor_force order by id desc LIMIT 10")
    public List<QueryAnchor> findRecent10Data();

}
