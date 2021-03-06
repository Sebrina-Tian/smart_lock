package com.cqjtu.wlw.controller;

import com.cqjtu.wlw.pojo.ClientInfo;
import com.cqjtu.wlw.pojo.UserInfo;
import com.cqjtu.wlw.service.ClientService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {

    @Autowired//自动装配，将ClientService接口实现的类自动注入进来
    private ClientService clientService;
    @RequestMapping("/check")
    public String doPost(UserInfo userInfo,ClientInfo clientInfo, HttpServletResponse resp, HttpServletRequest request) {
        try {
            String user_id=userInfo.getUserId();
            String user_password = userInfo.getUserPassword();
            System.out.println("客户登录："+userInfo.getUserId()+"\t"+user_password);

            clientInfo.setClientId(userInfo.getUserId().toString());
            clientInfo = clientService.getClientById(clientInfo);

            System.out.println(clientInfo.getClientPassword());

            if(user_password==clientInfo.getClientPassword()){
                JSONArray data = JSONArray.fromObject(clientInfo);
                resp.setCharacterEncoding("utf-8");
                PrintWriter respWritter = resp.getWriter();
                respWritter.append(data.toString());
                System.out.println("成功");
                return "client";
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("失败");
        }return "homepage";
    }
    /**
     * 处理用户注册的请求
     * @param clientInfo
     * @return
     */
    @RequestMapping("/register")//....client/register.d
    public String doReg(ClientInfo clientInfo,HttpServletRequest request){
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
     * client_id,lock_id不可更改获取之前的值
     * 更新client_name,client_password,client_sex,client_phone,client_addr,client_photo
     * @param clientInfo
     * @return
     */
    @RequestMapping("/doupdate")//.....client/doupdate.d?clientId=2
    public String doUpdate(ClientInfo clientInfo,HttpServletRequest request){
        clientService.updateClientInfo(clientInfo);
        return "client";
    }
    /**
     * 处理查询单个客户信息,及关联的信息
     * 根据client_id查询（client_info表、lock_info表、family_info表）
     * @param clientInfo
     * @param request
     * @return
     * 前端交互：
     * 返回client单个信息
     * clientId,clientName,clientPassword,...
     * client.lockId,client.lockType
     * client.memberId,client.memberName,...
     */
    @RequestMapping("/show")//...client/show?clientId=1
    public @ResponseBody ClientInfo show(ClientInfo clientInfo, HttpServletRequest request){
        clientInfo = clientService.getClientById(clientInfo);
        request.setAttribute("client", clientInfo);
        System.out.println(clientInfo);
        return clientInfo;//@ResponseBody ClientInfo只返回ClientInfo实体类，不跳转
    }

    /**
     * 根据条件模糊查询用户信息
     * @param clientInfo {clientName 可能为空，可能不为空 clientPhone可能为空，可能不为空}
     * @return
     * 前端交互：
     * 返回clients列表,<c>标签循环打印
     * client/list.d?clientId=185 就是id（电话）为185开头的都能查询出来，循环打印到表格中
     */
    @RequestMapping("/list")//...client/list.d?clientId=185
    public String list(ClientInfo clientInfo, HttpSession session){
        List<ClientInfo> list = clientService.getClientInfos(clientInfo);
        session.setAttribute("clients", list);
        System.out.println(list);
        return "client";//跳转到client.html
    }
    @RequestMapping("/family_list")
    public void doPost2(ClientInfo clientInfo, HttpServletResponse resp, HttpServletRequest request) {
        try {
            List<ClientInfo> list = clientService.getClientInfos(clientInfo);//姓名、地址、手机号
            JSONArray data = JSONArray.fromObject(list);
            resp.setCharacterEncoding("utf-8");
            PrintWriter respWritter = resp.getWriter();
            respWritter.append(data.toString());
            System.out.println(list.get(1).getClientId());
            System.out.println("成功");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("失败");
        }
    }
}
