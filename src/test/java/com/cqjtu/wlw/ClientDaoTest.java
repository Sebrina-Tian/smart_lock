package com.cqjtu.wlw;

import com.cqjtu.wlw.dao.ClientDao;
import com.cqjtu.wlw.pojo.ClientInfo;
import com.cqjtu.wlw.pojo.FamilyInfo;
import com.cqjtu.wlw.pojo.RepairInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/application-*.xml")

public class ClientDaoTest {
    @Autowired
    private ClientDao clientDao;

    @Test
    public void test1() {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientId("1");

        clientInfo = clientDao.getClientInfoById(clientInfo);
        System.out.println(clientInfo.getClientName());
        System.out.println(clientInfo.getClientPhone());
    }

    @Test
    public void test2() {
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientId("1111");
        clientInfo.setClientName("王五");
        clientInfo.setClientPassword("123456");
        clientInfo.setClientSex("1");
        clientInfo.setClientPhone("1852345678");
        clientInfo.setClientAddr("慧园711");
        clientInfo.setClientPhoto("重庆南岸区");
        clientInfo.setLockId(1001);//目前只有1001型号
        clientDao.addClientInfo(clientInfo);
    }
    @Test
    public void test3(){//注册
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientId("185244560");
        clientInfo.setClientPassword("1233422");
        clientInfo.setLockId(1001);

        clientInfo.setClientId(clientInfo.getClientId());
        clientInfo.setClientName("null");
        clientInfo.setClientPassword(clientInfo.getClientPassword());
        clientInfo.setClientSex("null");
        clientInfo.setClientPhone(clientInfo.getClientId());
        clientInfo.setClientAddr("null");
        clientInfo.setClientPhoto("null");
        clientInfo.setLockId(clientInfo.getLockId());//目前只有1001型号
        clientDao.addClientInfo(clientInfo);
    }

    @Test
    public void test4() {//模糊查询
        ClientInfo ClientInfo = new ClientInfo();
        ClientInfo.setClientName("%2%");
        ClientInfo.setClientPhone("2%");
        List<ClientInfo> list = clientDao.getClientInfos(ClientInfo);
        for (ClientInfo s : list) {
            System.out.println("client.name = " + s.getClientName());
            System.out.println("client.phone = " + s.getClientPhone());
        }
    }

    @Test
    public void test11(){
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientId("2");//按户主id查找全部family姓名（1对多）
        clientInfo = clientDao.getClientInfoById(clientInfo);
        System.out.println("clientInfo.name = " + clientInfo.getClientName()+"\n---------");

        Set<FamilyInfo> familyInfos = clientInfo.getFamilyInfos();
        for(FamilyInfo t : familyInfos){
            System.out.println("member_name = " + t.getMemberName());
        }
    }
    @Test
    public void test1s2(){
        List<ClientInfo> clients = clientDao.getClients();//按班级号依次查找
        for(ClientInfo client : clients){
            System.out.println("----------------");
            System.out.println("client.name = " + client.getClientName());

            Set<FamilyInfo> familyInfos = client.getFamilyInfos();
            for(FamilyInfo s : familyInfos){
                System.out.println("s.name = " + s.getMemberName());
            }
            System.out.println("----------------");
        }
    }
    @Test
    public void test21(){
        ClientInfo clientInfo = new ClientInfo();
        clientInfo.setClientId("1");//client_id="1"对应的全部repair记录（1对多）
        clientInfo = clientDao.getClientInfoById(clientInfo);
        System.out.println("clientInfo.name = " + clientInfo.getClientName()+"\n---------");

        Set<RepairInfo> repairInfos = clientInfo.getRepairInfos();
        for(RepairInfo r : repairInfos){
            System.out.println("repair_id = " + r.getRepairId());
        }
    }
    @Test
    public void test22(){
        List<ClientInfo> clients = clientDao.getClients();//按户主号依次查找(返回集合)
        for(ClientInfo client : clients){
            System.out.println("----------------");
            System.out.println("client.name = " + client.getClientName());

            Set<RepairInfo> repairInfos = client.getRepairInfos();
            for(RepairInfo s : repairInfos){
                System.out.println("repair.id = " + s.getRepairId());
            }
            System.out.println("----------------");
        }
    }
}