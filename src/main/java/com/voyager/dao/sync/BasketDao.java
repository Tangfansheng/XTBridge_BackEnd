package com.voyager.dao.sync;

import com.voyager.domain.QueryDate;
import com.voyager.domain.sync.QueryBasket;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketDao {
    @Select("select force1,force2,force3,force4, datetime from sync_basket order by id desc LIMIT 1" )
    public QueryBasket findRecentData();

    @Select("select force1,force2,force3,force4, datetime from sync_basket" )
    public List<QueryBasket> findAllData();

    @Select("select force1,force2,force3,force4, datetime from sync_basket order by id desc LIMIT 10" )
    public List<QueryBasket> findRecent10Data();

    @Select("select datetime from sync_basket order by id desc LIMIT 10")
    public List<QueryDate> getRecent10date();
}
