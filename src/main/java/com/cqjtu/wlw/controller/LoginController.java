package com.cqjtu.wlw.controller;

import com.cqjtu.wlw.dao.ClientDao;
import com.cqjtu.wlw.pojo.ClientInfo;
import com.cqjtu.wlw.pojo.ManagerInfo;
import com.cqjtu.wlw.pojo.UserInfo;
import com.cqjtu.wlw.pojo.WorkerInfo;
import com.cqjtu.wlw.service.ClientService;
import com.cqjtu.wlw.service.ManagerService;
import com.cqjtu.wlw.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private WorkerService workerService;
    @Autowired
    private ManagerService managerService;

    @RequestMapping(value = "/login")
    public String login(UserInfo a, HttpSession session) {
        System.out.println("用户:" + a.getUserId() +"\t密码：" + a.getUserPassword()+"\t身份："+ a.getUserIdentity());
        session.setAttribute("user", a);
        String user_id=a.getUserId();
        String user_password= a.getUserPassword();
        String user_page = a.getUserIdentity();//client、manager、worker

        //当用户身份为client时，下同
        if(user_page.equals("client")){
            ClientInfo clientInfo=new ClientInfo();   //新建一个ClientInfo类
            clientInfo.setClientId(user_id);
            ClientInfo client = clientService.getClientById(clientInfo);   //调用ClientService方法，查询id等于user_id的用户信息，并返回ClientInfo类对象：client
            if(client != null && client.getClientPassword().equals(user_password)){    //判断client_password是否与user_password相等，若相等则跳转至用户页面
                    return user_page;
            }
        }

        if(user_page.equals("worker")){
            WorkerInfo workerInfo=new WorkerInfo();
            workerInfo.setWorkerId(user_id);
            WorkerInfo worker=workerService.getWorkerByWorkerId(workerInfo);
            if(worker !=null && worker.getWorkerPassword().equals(user_password)){
                return user_page;
            }
        }
        if(user_page.equals("manager")){
            int userid=Integer.parseInt(user_id);  //获取到前端输入的user_id为String类型，但MAanager_id是设置为int类型的，此处需转换
            ManagerInfo managerInfo=new ManagerInfo();
            managerInfo.setManagerId(userid);
            ManagerInfo manager=managerService.getManagerById(managerInfo);
            if(manager!=null && manager.getManagerPassword().equals(user_password)){
                return user_page;
            }
        }
            return "homepage";
    }
    @RequestMapping(value = "/check")
    public String login_check(UserInfo a, HttpServletRequest request, HttpSession session) {

        System.out.println("用户:" + a.getUserId() +"\t密码：" + a.getUserPassword()+"\t身份："+ a.getUserIdentity());
        session.setAttribute("user", a);

        String user_page = a.getUserIdentity();//client、manager、worker
        return user_page;
    }

}
