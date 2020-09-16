package com.voyager.service;

import com.voyager.domain.QueryEnv;
import org.springframework.stereotype.Service;

@Service
public interface EnvService {

    public QueryEnv getEnv();
}
