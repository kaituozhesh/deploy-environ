package com.ktz.deploy.elasticsearch.controller;

import com.ktz.deploy.elasticsearch.documents.GoodsInfoDocument;
import com.ktz.deploy.elasticsearch.dto.SearchDto;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.frameworkset.elasticsearch.entity.ESDatas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: SearchController
 * Description: 搜索
 * date: 2020/3/8 19:57
 *
 * @author kaituozhe_sh
 */
@RestController
@RequestMapping("/query")
public class SearchController {

    @Autowired
    private BBossESStarter bBossESStarter;

    @GetMapping("/search_goods")
    public Object search(SearchDto search) {
        System.out.println(search);
        ClientInterface client = bBossESStarter.getConfigRestClient("esmapper/GoodsInfo.xml");
        ESDatas<GoodsInfoDocument> searchList = client.searchList("goods_info/_search", "GoodsSearch", search, GoodsInfoDocument.class);
        return searchList.getDatas();
    }



}
