package com.cqjtu.wlw.service;

import com.cqjtu.wlw.pojo.RepairInfo;

import java.util.List;

public interface RepairService {
    /**
     * Repair注册
     * @param repairInfo
     */
    void regRepairInfo(RepairInfo repairInfo);

    /**
     * 维修记录注销
     * @param repairInfo
     */
    void delRepairInfo(RepairInfo repairInfo);

    /**
     * 维修记录信息更新
     * @param repairInfo
     */
    void updateRepairInfo(RepairInfo repairInfo);

    /**
     * 根据条件查询多条维修记录信息
     * @param repairInfo
     * @return
     */
    List<RepairInfo> getRepairInfos(RepairInfo repairInfo);
    /**
     * 根据id查询记录
     * @param repairInfo
     * @return
     */
    RepairInfo getRepairById(RepairInfo repairInfo);

    Long getRepairCount(RepairInfo repairInfo);

}
