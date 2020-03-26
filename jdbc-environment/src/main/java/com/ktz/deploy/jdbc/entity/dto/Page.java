package com.ktz.deploy.jdbc.entity.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> implements Serializable {

    private List<T> list;
    private long total;
    private int pageNum;
    private int pageSize;

}