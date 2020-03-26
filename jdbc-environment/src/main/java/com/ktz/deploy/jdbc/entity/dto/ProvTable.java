package com.ktz.deploy.jdbc.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @ClassName ProvTable
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/26 14:21
 * @Version V1.0
 **/
@Data
public class ProvTable {
    private List<ProvBase> provBaseList;
    private Page page;

    public ProvTable(){

    }

    public ProvTable( List<ProvBase>  provBaseList, Page page){
        this.provBaseList = provBaseList;
        this.page = page;
    }
}