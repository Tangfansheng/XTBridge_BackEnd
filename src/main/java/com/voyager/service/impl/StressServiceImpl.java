package com.voyager.service.impl;

import com.voyager.dao.StressDao;
import com.voyager.domain.QueryStress;
import com.voyager.service.StressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StressServiceImpl")
public class StressServiceImpl implements StressService {
    @Autowired
    private StressDao stressDao;

    @Override
    public QueryStress findRecentData() {
        return stressDao.findRecentData();
    }

    @Override
    public List<QueryStress> findAllData() {
        return stressDao.findAllData();
    }
}
