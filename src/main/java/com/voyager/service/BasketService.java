package com.voyager.service;

import com.voyager.domain.sync.QueryBasket;

import java.util.List;

public interface BasketService {
    /**
     * 查询最近的记录
     * @return
     */
    public QueryBasket findRecentData();
    /**
     * 拿到所有数据
     * @return
     */
    public List<QueryBasket> findAllData();
}