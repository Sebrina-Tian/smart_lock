package com.cqjtu.wlw.service;

import com.cqjtu.wlw.pojo.ClientInfo;
import com.cqjtu.wlw.pojo.RepairInfo;

import java.util.List;

public interface ClientService {
    /**
     * client注册、添加
     * @param clientInfo
     */
    void regClientInfo(ClientInfo clientInfo);

    /**
     * 学生注销
     * @param clientInfo
     */
    void delClientInfo(ClientInfo clientInfo);

    /**
     * 学生信息更新
     * @param clientInfo
     */
    void updateClientInfo(ClientInfo clientInfo);

    /**
     * 根据条件查询多条用户信息
     * @param clientInfo
     * @return
     */
    List<ClientInfo> getClientInfos(ClientInfo clientInfo);
    /**
     * 根据条件查询多条用户信息
     * @param clientInfo
     * @return
     */
    List<ClientInfo> getRepairClientInfos(ClientInfo clientInfo);
    /**
     * 根据id查询学生记录
     * @param clientInfo
     * @return
     */
    ClientInfo getClientById(ClientInfo clientInfo);
    /**
     * 根据条件查询多条维修记录信息
     * @param clientInfo
     * @return
     */
    List<RepairInfo> getRepairInfosbyAddr(ClientInfo clientInfo);
}
