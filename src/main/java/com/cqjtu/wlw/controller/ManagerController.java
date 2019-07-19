package com.cqjtu.wlw.controller;

import com.cqjtu.wlw.pojo.ClientInfo;
import com.cqjtu.wlw.pojo.RepairInfo;

import com.cqjtu.wlw.service.ClientService;
import com.cqjtu.wlw.service.RepairService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController extends BaseController {
    @Autowired
    private RepairService repairService;
    @Autowired
    private ClientService clientService;

    /**
     * 处理访问维修模块主页的条件+分页查询的请求
     * @return
     */

    @RequestMapping(value = "/index")
    public String login(RepairInfo repairInfo, HttpServletRequest request) {

        //处理请求中的pager.offset
        handleOffset(request);
        repairInfo.setStart(this.getStart());
        request.setAttribute("repairnamecondition", repairInfo.getStartTime());
        request.setAttribute("requesttimecondition", repairInfo.getRequestTime());
        request.setAttribute("clientidcondition", repairInfo.getClientId());

        //按条件/分页查询出所有记录
        List<RepairInfo> repairs = repairService.getRepairInfos(repairInfo);
        //按条件查询出所有的记录数
        Long count = repairService.getRepairCount(repairInfo);

        request.setAttribute("repairs", repairs);
        request.setAttribute("count", count);

        return "manager";
    }
    @RequestMapping("/repair_list")
    public void doPost(RepairInfo repairInfo, HttpServletResponse resp, HttpServletRequest request) {
        try {
            List<RepairInfo> list = repairService.getRepairInfos(repairInfo);
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
    @RequestMapping("/repair_list2")
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
