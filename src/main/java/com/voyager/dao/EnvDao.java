package com.voyager.dao;

import com.voyager.domain.QueryEnv;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvDao {
    @Select("select * from env where id = 1")
    public QueryEnv getEnv();
}
