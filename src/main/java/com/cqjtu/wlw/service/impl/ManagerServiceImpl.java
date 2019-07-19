package com.cqjtu.wlw.service.impl;

import com.cqjtu.wlw.dao.ManagerDao;
import com.cqjtu.wlw.pojo.ManagerInfo;
import com.cqjtu.wlw.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public ManagerInfo getManagerById(ManagerInfo managerInfo){
    return managerDao.getManagerInfoById(managerInfo);
    }
}
