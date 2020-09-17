package com.voyager.service;
import com.voyager.domain.QueryAnchor;
import com.voyager.domain.QueryDate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("anchorService")
public interface AnchorService {
    /**
     *  查询最近的数据
     */

    public QueryAnchor findRecentData();

    /**
     * 查询近所有数据
     * @return
     */
    public List<QueryAnchor> findAllData();

    /**
     * 插入一条记录
     */
    public void saveOneRecord(QueryAnchor data);

    /**
     * 最近的10条数据
     * @return
     */
    public List<QueryAnchor> findRecent10Data();

    /**
     * 最近的10个时间
     * @return
     */
    public List<QueryDate> getRecent10date();


}
