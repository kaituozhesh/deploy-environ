package com.ktz.deploy.jdbc.service;

import com.ktz.deploy.jdbc.entity.dto.AbsDepartmetData;
import com.ktz.deploy.jdbc.entity.dto.ProvTable;


public interface DepartmentDataService {

    ProvTable getList(AbsDepartmetData t);

    long findCount(String talbeName);
}
