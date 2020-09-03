package com.voyager.service.impl;

import com.voyager.dao.sync.BasketDao;
import com.voyager.domain.sync.QueryBasket;
import com.voyager.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
