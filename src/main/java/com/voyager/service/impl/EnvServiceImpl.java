package com.voyager.service.impl;

import com.voyager.dao.EnvDao;
import com.voyager.domain.QueryEnv;
import com.voyager.service.EnvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("EnvServiceImpl")
public class EnvServiceImpl implements EnvService {
    @Autowired
    private EnvDao envDao;

    /**
     * 拿到最新的环境情况
     * @return
     */
    @Override
    public QueryEnv getEnv() {
        return envDao.getEnv();
    }
}
