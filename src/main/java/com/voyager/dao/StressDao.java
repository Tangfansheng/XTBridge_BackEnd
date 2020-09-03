package com.voyager.dao;

import com.voyager.domain.QueryStress;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StressDao {
    @Select("select upper,front,mid,rear, bottom, datetime from stress order by id desc LIMIT 1" )
    public QueryStress findRecentData();

    @Select("select upper,front,mid,rear, bottom, datetime from stress" )
    public List<QueryStress> findAllData();
}