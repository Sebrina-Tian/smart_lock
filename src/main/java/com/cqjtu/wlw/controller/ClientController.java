package com.cqjtu.wlw.controller;

import com.cqjtu.wlw.pojo.ClientInfo;
import com.cqjtu.wlw.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired//自动装配，将ClientService接口实现的类自动注入进来
    private ClientService clientService;

    /**
     * 处理用户注册的请求
     * @param clientInfo
     * @return
     */
    @RequestMapping("/register")//....client/register.d
    public String doReg(ClientInfo clientInfo){
        System.out.println("执行ClientInfoController.doReg...");
        //获取前端的输入
        clientService.regClientInfo(clientInfo);
        return "homepage";
    }
    /**
     * 处理用户注销的请求
     * @param clientInfo
     * @return
     */
    @RequestMapping("/dodelete")//.....client/dodelete.d?clientId=2
    public String doDelete(ClientInfo clientInfo){
        clientService.delClientInfo(clientInfo);
        return "client";
    }

    /**
     * 处理用户信息更新的请求
     * @param clientInfo
     * @return
     */
    @RequestMapping("/doupdate")
    public String doUpdate(ClientInfo clientInfo){
        clientService.updateClientInfo(clientInfo);
        return "client";
    }
    /**
     * 处理查询单个客户信息的请求
     * @param clientInfo
     * @param request
     * @return
     */
    @RequestMapping("/show")//...client/show?clientId=1
    public @ResponseBody ClientInfo show(ClientInfo clientInfo, HttpServletRequest request){
        clientInfo = clientService.getClientById(clientInfo);
        request.setAttribute("client", clientInfo);
        System.out.println(clientInfo);
        return clientInfo;
    }

    /**
     * 根据条件查询用户信息
     * @param clientInfo {clientName 可能为空，可能不为空 clientPhone可能为空，可能不为空}
     * @return
     */
    @RequestMapping("/list")//...client/list.d?clientId=1
    public String list(ClientInfo clientInfo, HttpSession session){
        List<ClientInfo> list = clientService.getClientInfos(clientInfo);
        session.setAttribute("clients", list);
        System.out.println(list);
        return "client";
    }
}
