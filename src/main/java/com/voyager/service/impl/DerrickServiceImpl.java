package com.voyager.service.impl;

import com.voyager.dao.DerrickDao;
import com.voyager.domain.QueryDate;
import com.voyager.domain.QueryDerrick;
import com.voyager.service.DerrickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service("DerrickServiceImpl")
public class DerrickServiceImpl implements DerrickService {
    @Autowired
    private DerrickDao derrickDao;


    @Override
    public QueryDerrick findRecentData() {
        return derrickDao.findRecentData();
    }

    @Override
    public List<QueryDerrick> findAllData() {
        return derrickDao.findAllData();
    }

    @Override
    public List<QueryDerrick> findRecent10Data() {
        List<QueryDerrick> data = derrickDao.findRecent10Data();
        Collections.reverse(data);
        return data;
    }

    @Override
    public List<QueryDate> getRecent10date() {
        List<QueryDate> date = derrickDao.getRecent10date();
        Collections.reverse(date);
        return date;
    }
}
