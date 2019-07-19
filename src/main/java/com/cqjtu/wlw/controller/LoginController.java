package com.cqjtu.wlw.controller;

import com.cqjtu.wlw.pojo.ClientInfo;
import com.cqjtu.wlw.pojo.UserInfo;
import com.cqjtu.wlw.pojo.WorkerInfo;
import com.cqjtu.wlw.service.ClientService;
import com.cqjtu.wlw.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {
    @Autowired//自动装配，将ClientService接口实现的类自动注入进来
    private ClientService clientService;
    @Autowired
    private WorkerService workerService;
    //@Autowired
    //private ManagerService managerService;

    @RequestMapping(value = "/login")
    public String login(UserInfo a, HttpSession session) {
        System.out.println("用户:" + a.getUserId() +"\t密码：" + a.getUserPassword()+"\t身份："+ a.getUserIdentity());
        session.setAttribute("user", a);

        String user_page = a.getUserIdentity();//client、manager、worker

        return user_page;
    }
    @RequestMapping("/check")
    public String doPost(UserInfo userInfo, HttpServletResponse resp, HttpServletRequest request) {

            String user_id = userInfo.getUserId();
            String user_password = userInfo.getUserPassword();
            System.out.println("客户登录：" + user_id + "\t密码：" + user_password + "\t身份：" + userInfo.getUserIdentity());
            String identity = userInfo.getUserIdentity();
            if (identity == "client") {
                ClientInfo clientInfo = new ClientInfo();
                clientInfo.setClientId(user_id);
                String password = clientService.getClientById(clientInfo).getClientPassword();
                System.out.println(password);
                if (user_password == password) {
                    try {
                        System.out.println("客户登录成功");
                        return "client";
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("客户登录失败");
                    }
                    return "homepage";
                }
            } else if (identity == "worker") {
                WorkerInfo workerInfo = new WorkerInfo();
                workerInfo.setWorkerId(user_id);
                String password = workerService.getWorkerById(workerInfo).getWorkerPassword();
                System.out.println(password);
                if (user_password == password) {
                    try {
                        System.out.println("维修人员登录成功");
                        return "worker";
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("维修工失败");
                    }
                    return "homepage";
                }
            }else if (identity == "manager") {
                return "manager";
//                ManagerInfo managerInfo = new ManagerInfo();
//                managerInfo.setManagerId(user_id);
//                String password="1";
//                //String password = managerService.getWorkerById(workerInfo).getWorkerPassword();
//                System.out.println(password);
//                if (user_password == password) {
//                    try {
//                        return "manager";
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                        System.out.println("管理员登录失败");
//                    }
//                    return "homepage";
//                }
            }
            return "homepage";
    }

}
