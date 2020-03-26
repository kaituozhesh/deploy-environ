package com.ktz.deploy.jdbc.entity.dto;

import java.io.Serializable;

/**
 * @ClassName MarketSuperviseParam
 * @Description
 * @Author kaituozhesh
 * @Date 2020/3/26 14:46
 * @Version V1.0
 **/
public class MarketSuperviseParam extends AbsDepartmetData implements Serializable {
    /**
     * 机构名称
     */
    private String company_name;

    /**
     * 统一信用编码
     */
    private String credit_code;
}
