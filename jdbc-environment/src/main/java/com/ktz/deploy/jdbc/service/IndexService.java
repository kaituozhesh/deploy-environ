package com.ktz.deploy.jdbc.service;

import com.ktz.deploy.jdbc.entity.dto.DepartDataDto;

import java.util.List;

public interface IndexService {

    List<DepartDataDto> collectData();

    List<DepartDataDto> tableList(String id);
}
