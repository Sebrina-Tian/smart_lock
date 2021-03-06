package com.cqjtu.wlw.service.impl;

import com.cqjtu.wlw.dao.ClientDao;
import com.cqjtu.wlw.pojo.ClientInfo;
import com.cqjtu.wlw.pojo.RepairInfo;
import com.cqjtu.wlw.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    /**
     * 用户注册
     * 手机号为id：client_id==client_phone
     * 密码：client_password
     * 门锁：lock_id
     */
    @Override
    public void regClientInfo(ClientInfo clientInfo) {
        clientInfo.setClientId(clientInfo.getClientId());
        clientInfo.setClientName("null");
        clientInfo.setClientPassword(clientInfo.getClientPassword());
        clientInfo.setClientSex("null");
        clientInfo.setClientPhone(clientInfo.getClientId());
        clientInfo.setClientAddr("null");
        clientInfo.setClientPhoto("null");
        clientInfo.setLockId(clientInfo.getLockId());//目前只有1001型号
        clientDao.addClientInfo(clientInfo);
        System.out.println("注册成功");
    }

    @Override
    public void delClientInfo(ClientInfo clientInfo) {
        clientDao.deleteClientInfo(clientInfo);
    }

    @Override
    public void updateClientInfo(ClientInfo clientInfo) {
        clientDao.updateClientInfo(clientInfo);
    }
    /**
     * 张	--》   %张%
     * 10	--》   %10%
     * @return
     */
    @Override
    public List<ClientInfo> getClientInfos(ClientInfo clientInfo) {//姓名、地址、手机号
        if(clientInfo.getClientName()!= null &&!clientInfo.getClientName().equals("")){
            clientInfo.setClientName("%" + clientInfo.getClientName() + "%");
        }
        if(clientInfo.getClientAddr() != null &&!clientInfo.getClientAddr().equals("")){
            clientInfo.setClientAddr("%" + clientInfo.getClientAddr() + "%");
        }
        if(clientInfo.getClientPhone() != null &&!clientInfo.getClientPhone().equals("")){
            clientInfo.setClientPhone("%" + clientInfo.getClientPhone() + "%");
        }
        return clientDao.getClientInfos(clientInfo);
    }
    /**
     * 张	--》   %张%
     * 10	--》   %10%
     * @return
     */
    @Override
    public List<ClientInfo> getRepairClientInfos(ClientInfo clientInfo){
        if(clientInfo.getClientAddr() != null &&!clientInfo.getClientAddr().equals(""))
        {
            clientInfo.setClientAddr("%" + clientInfo.getClientAddr() + "%");
        }
        return clientDao.getRepairInfos(clientInfo);
    }
    /**
     * 用于用户登陆时，查询用户是否存在及其password
     * @return
     */
    @Override
    public ClientInfo getClientById(ClientInfo clientInfo) {
      return clientDao.getClientByClientId(clientInfo);
    }

    /**
     * 张	--》   %张%
     * 10	--》   %10%
     * @return
     */
    @Override
    public List<RepairInfo> getRepairInfosbyAddr(ClientInfo clientInfo) {
        return  clientDao.getRepairInfoByAddr(clientInfo);
    }
}
