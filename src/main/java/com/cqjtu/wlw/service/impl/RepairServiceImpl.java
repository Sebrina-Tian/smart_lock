package com.cqjtu.wlw.service.impl;

import com.cqjtu.wlw.dao.RepairDao;
import com.cqjtu.wlw.pojo.RepairInfo;
import com.cqjtu.wlw.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RepairServiceImpl implements RepairService {
    
    @Autowired
    private RepairDao repairDao;
    
    //添加
    @Override
    public void regRepairInfo(RepairInfo repairInfo) {
        //id自增
        repairInfo.setRequestTime("null");
        repairInfo.setReDetail("null");
        repairInfo.setRepairGrade((float) 5);//默认
   

        repairDao.addRepairInfo(repairInfo);
        System.out.println("添加成功");

    }

    @Override
    public void delRepairInfo(RepairInfo repairInfo) {
        repairDao.deleteRepairInfo(repairInfo);
    }

    @Override
    public void updateRepairInfo(RepairInfo repairInfo) {
        repairDao.updateRepairInfo(repairInfo);
    }
    /**
     * 张	--》   %张%
     * 10	--》   %10%
     * @return
     */
    @Override
    public List<RepairInfo> getRepairInfos(RepairInfo repairInfo) {
        //维修id、报修时间查询
        if(repairInfo.getRepairId() != null &&!repairInfo.getRepairId().equals(0)){
            repairInfo.setRepairId(repairInfo.getRepairId());
        }
        if(repairInfo.getRequestTime() != null &&!repairInfo.getRequestTime().equals("")){
            repairInfo.setRequestTime("%" + repairInfo.getRequestTime() + "%");
        }
        return repairDao.getRepairInfos(repairInfo);
    }

    @Override
    public RepairInfo getRepairById(RepairInfo repairInfo) {
        List<RepairInfo> Repairs = repairDao.getRepairInfos(repairInfo);
        if(Repairs != null && Repairs.size() == 1){
            return Repairs.get(0);
        }
        return null;
    }

    @Override
    public Long getRepairCount(RepairInfo repairInfo) {
        //维修id、客户id、报修时间查询
        if(repairInfo.getRepairId() != null &&!repairInfo.getRepairId().equals("")){
            repairInfo.setRepairId(repairInfo.getRepairId());
        }
        if(repairInfo.getClientInfo().getClientId() != null &&!repairInfo.getClientInfo().getClientId().equals("")){
            repairInfo.getClientInfo().setClientId("%" + repairInfo.getClientInfo().getClientId() + "%");
        }
        if(repairInfo.getRequestTime() != null &&!repairInfo.getRequestTime().equals("")){
            repairInfo.setRequestTime("%" + repairInfo.getRequestTime() + "%");
        }
        return repairDao.getRepairCount(repairInfo);
    }

}
