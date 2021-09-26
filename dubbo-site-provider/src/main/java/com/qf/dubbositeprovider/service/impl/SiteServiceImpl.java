package com.qf.dubbositeprovider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.api.SiteService;
import com.qf.entity.Site;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Cjl
 * @date 2021/8/12 20:02
 */
@Service(version = "1.0")
public class SiteServiceImpl implements SiteService {
    @Value("${dubbo.protocol.port}")
    private String port;

    @Override
    public Site getSiteById(Long id) {
        System.out.println("调用1.0服务");
        Site site = new Site();
        site.setId(id);
        site.setName("北京"+port);
        return site;
    }
}
