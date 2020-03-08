package com.ktz.deploy.elasticsearch.controller;

import lombok.extern.slf4j.Slf4j;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: GoodsInfoDocument
 * Description:
 * date: 2020/3/8 19:45
 *
 * @author kaituozhe_sh
 */
@RestController
@RequestMapping("/create")
@Slf4j
public class CreateIndexController {

    @Autowired
    private BBossESStarter bbossESStarter;

    /**
     * 创建商品索引
     *
     * @return
     */
    @GetMapping("/goods_info_index")
    public String createGoodsInfoIndex() {
        ClientInterface clientUtil = bbossESStarter.getConfigRestClient("esmapper/GoodsInfo.xml");
        boolean exist = clientUtil.existIndice("goods_info");
        if (exist) {
            clientUtil.dropIndice("goods_info");
        }
        String indiceMapping = clientUtil.createIndiceMapping("goods_info", "createGoodsInfoIndex");
        log.info("创建商品索引 message：" + indiceMapping);
        return "success";
    }

}
