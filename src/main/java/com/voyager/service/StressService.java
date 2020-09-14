package com.voyager.service;
import com.voyager.domain.QueryStress;
import java.util.List;

public interface StressService {
    /**
     * 查询最近的记录
     * @return
     */
    public QueryStress findRecentData();

    /**
     * 拿到所有数据
     * @return
     */
    public List<QueryStress> findAllData();


    public List<QueryStress> findRecent10Data();
}
