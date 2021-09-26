package com.qf.dubbositeconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.api.SiteService;
import com.qf.entity.Site;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/site")
public class SiteController {
    /**
     * version:
     * 多版本
     * 当一个接口实现，出现不兼容升级时，可以用版本号过渡，版本号不同的服务相互间不引用。
     *
     * 可以按照以下的步骤进行版本迁移：
     *
     * 在低压力时间段，先升级一半提供者为新版本
     * 再将所有消费者升级为新版本
     * 然后将剩下的一半提供者升级为新版本
     */
    @Reference(version = "2.0")
    private SiteService service;

    @GetMapping("/get/{id}")
    public Site getSiteById(@PathVariable Long id){

        return service.getSiteById(id);


    }



}
