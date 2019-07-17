package com.cqjtu.wlw.service.impl;

import com.cqjtu.wlw.dao.WorkerDao;
import com.cqjtu.wlw.pojo.WorkerInfo;
import com.cqjtu.wlw.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerDao workerDao;
    /**
     * 用户注册
     */
    @Override
    public void regWorkerInfo(WorkerInfo workerInfo) {
        System.out.println("注册...");
        workerDao.addWorkerInfo(workerInfo);
    }

    @Override
    public void delWorkerInfo(WorkerInfo WorkerInfo) {
        workerDao.deleteWorkerInfo(WorkerInfo);

    }

    @Override
    public void updateWorkerInfo(WorkerInfo WorkerInfo) {
        workerDao.updateWorkerInfo(WorkerInfo);
    }
    /**
     * 张	--》   %张%
     * 10	--》   %10%
     * @return
     */
    @Override
    public List<WorkerInfo> getWorkerInfos(WorkerInfo WorkerInfo) {
        if(WorkerInfo.getWorkerName()!= null &&!WorkerInfo.getWorkerName().equals("")){
            WorkerInfo.setWorkerName("%" + WorkerInfo.getWorkerName() + "%");
        }
        if(WorkerInfo.getWorkerAddr() != null &&!WorkerInfo.getWorkerAddr().equals("")){
            WorkerInfo.setWorkerAddr("%" + WorkerInfo.getWorkerAddr() + "%");
        }
        if(WorkerInfo.getWorkerPhone() != null &&
                !WorkerInfo.getWorkerPhone().equals("")){
            WorkerInfo.setWorkerPhone("%" + WorkerInfo.getWorkerPhone() + "%");
        }
        return workerDao.getWorkerInfos(WorkerInfo);
    }

    @Override
    public WorkerInfo getWorkerById(WorkerInfo WorkerInfo) {
        List<WorkerInfo> Workers = workerDao.getWorkerInfos(WorkerInfo);
        if(Workers != null && Workers.size() == 1){
            return Workers.get(0);
        }
        return null;
    }
}