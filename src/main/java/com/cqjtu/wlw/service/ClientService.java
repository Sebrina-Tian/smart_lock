package com.cqjtu.wlw.service;

import com.cqjtu.wlw.pojo.ClientInfo;

import java.util.List;

public interface ClientService {
    /**
     * client注册
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
     * 根据条件查询多条学生信息
     * @param clientInfo
     * @return
     */
    List<ClientInfo> getClientInfos(ClientInfo clientInfo);
    /**
     * 根据id查询记录
     * @param clientInfo
     * @return
     */
    ClientInfo getClientById(ClientInfo clientInfo);
}
