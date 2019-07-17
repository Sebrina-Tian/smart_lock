package com.cqjtu.wlw.dao;

import com.cqjtu.wlw.pojo.WorkerInfo;

import java.util.List;

public interface WorkerDao {

    void addWorkerInfo(WorkerInfo workerInfo);

    void deleteWorkerInfo(WorkerInfo workerInfo);

    void updateWorkerInfo(WorkerInfo workerInfo);

    /**
     * 根据id查询用户信息
     */
    WorkerInfo getWorkerInfoById(WorkerInfo workerInfo);


    /**
     * 根据条件查询学生记录
     */
    List<WorkerInfo> getWorkerInfos(WorkerInfo workerInfo);

}
