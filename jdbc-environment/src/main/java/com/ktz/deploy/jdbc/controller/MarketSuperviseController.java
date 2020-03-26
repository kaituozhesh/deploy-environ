package com.ktz.deploy.jdbc.controller;

import com.ktz.deploy.jdbc.entity.dto.MarketSuperviseParam;
import com.ktz.deploy.jdbc.entity.dto.ProvTable;
import com.ktz.deploy.jdbc.service.DepartmentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MarketSuperviseController
 * @Description 市市场监管局
 * @Author kaituozhesh
 * @Date 2020/3/26 8:51
 * @Version V1.0
 **/
@RestController
@RequestMapping("/market_supervise")
public class MarketSuperviseController {

    @Autowired
    private DepartmentDataService departmentDataService;

    /**
     * 查询列表信息  統一接口
     * 根据table 列 ID来决定查询的表
     *
     * @param marketSuperviseParam
     * @return
     */
    @PostMapping("/find_market_list")
    public ProvTable findMarketSuperviseList(@RequestBody MarketSuperviseParam marketSuperviseParam) {
        return departmentDataService.getList(marketSuperviseParam);
    }

}
