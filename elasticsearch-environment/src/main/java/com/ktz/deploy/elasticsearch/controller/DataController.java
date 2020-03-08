package com.ktz.deploy.elasticsearch.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ktz.deploy.elasticsearch.documents.GoodsInfoDocument;
import com.ktz.deploy.elasticsearch.entity.GoodsInfo;
import com.ktz.deploy.elasticsearch.mapper.GoodsInfoMapper;
import org.frameworkset.elasticsearch.ElasticSearchHelper;
import org.frameworkset.elasticsearch.boot.BBossESStarter;
import org.frameworkset.elasticsearch.client.ClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ClassName: DataController
 * Description:  数据导入
 * date: 2020/3/8 19:56
 *
 * @author kaituozhe_sh
 */
@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    @Autowired
    private BBossESStarter bBossESStarter;

    @GetMapping("/goods_info_import")
    public String importGoodsInfoData() {
        List<GoodsInfo> goodsInfos = goodsInfoMapper.selectList(Wrappers.lambdaQuery());
        List<GoodsInfoDocument> goodsInfoDocuments = JSON.parseArray(JSON.toJSONString(goodsInfos), GoodsInfoDocument.class);
        ClientInterface clientUtil = ElasticSearchHelper.getRestClientUtil();
        clearIndexSearchData("goods_info");
        clientUtil.addDocuments("goods_info", goodsInfoDocuments);
        return "success";
    }

    private boolean clearIndexSearchData(String indexName) {
        ClientInterface client = bBossESStarter.getConfigRestClient("esmapper/GoodsInfo.xml");
        String indexData = client.deleteByQuery(indexName + "/_delete_by_query", "deleteIndexData");
        System.out.println("清空" + indexName + "数据:" + indexData);
        return true;
    }


}
