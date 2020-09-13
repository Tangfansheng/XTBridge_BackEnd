package com.voyager.service.impl;

import com.voyager.dao.AnchorDao;
import com.voyager.domain.QueryAnchor;
import com.voyager.service.AnchorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Level.INFO;

@Service("anchorServiceImpl")
public class AnchorServiceImpl implements AnchorService {
    @Autowired
    private AnchorDao anchorDao;

    @Override
    public QueryAnchor findRecentData() {
        Logger logger = Logger.getLogger("AnchorServiceImpl--findRecentData");
        logger.log(INFO, "执行查询");
        return anchorDao.findRecentData();
    }

    @Override
    public List<QueryAnchor> findAllData() {
        return anchorDao.findAllData();
    }

    @Override
    public void saveOneRecord(QueryAnchor data) {
        anchorDao.saveOneRecord(data);
    }

    @Override
    public List<QueryAnchor> findRecent10Data() {
        return anchorDao.findRecent10Data();
    }


}
