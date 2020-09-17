package com.voyager.service.impl;

import com.voyager.dao.sync.BasketDao;
import com.voyager.domain.QueryDate;
import com.voyager.domain.sync.QueryBasket;
import com.voyager.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service("BasketServiceImpl")
public class BasketServiceImpl implements BasketService {
    @Autowired
    BasketDao basketDao;

    @Override
    public QueryBasket findRecentData() {
        return basketDao.findRecentData();
    }

    @Override
    public List<QueryBasket> findAllData() {
        return basketDao.findAllData();
    }

    @Override
    public List<QueryBasket> findRecent10Data() {
        List<QueryBasket> data = basketDao.findRecent10Data();
        Collections.reverse(data);
        return data;
    }

    @Override
    public List<QueryDate> getRecent10date() {
        List<QueryDate> dates = basketDao.getRecent10date();
        Collections.reverse(dates);
        return dates;
    }


}
