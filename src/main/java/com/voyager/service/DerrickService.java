package com.voyager.service;

import com.voyager.domain.QueryDerrick;

import java.util.List;

public interface DerrickService {
    /**
     * 查询最近的记录
     * @return
     */
    public QueryDerrick findRecentData();

    /**
     * 拿到所有数据
     * @return
     */
    public List<QueryDerrick> findAllData();
}