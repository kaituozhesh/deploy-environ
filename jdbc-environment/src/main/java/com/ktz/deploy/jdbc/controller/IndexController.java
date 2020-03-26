package com.ktz.deploy.jdbc.controller;

import com.ktz.deploy.jdbc.entity.dto.DepartDataDto;
import com.ktz.deploy.jdbc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName IndexController
 * @Description 部门数据 首页表格块统计信息
 * @Author kaituozhesh
 * @Date 2020/3/26 9:47
 * @Version V1.0
 **/
@RestController
@RequestMapping("/department_data")
public class IndexController {

    @Autowired
    private IndexService indexService;

    /**
     * 部门数据表格块统计数据
     *
     * @return
     */
    @PostMapping("/index_block_list")
    public List<DepartDataDto> blockList() {
        return indexService.collectData();
    }

    /**
     * 查询市场监管局下的菜单列表
     *
     * @return
     */
    @PostMapping("/menu_list/{id}")
    public List<?> menuList(@PathVariable("id") String id) {
        return indexService.tableList(id);
    }
}
