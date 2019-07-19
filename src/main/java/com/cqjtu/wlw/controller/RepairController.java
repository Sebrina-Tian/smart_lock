package com.cqjtu.wlw.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cqjtu.wlw.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqjtu.wlw.pojo.RepairInfo;
import com.cqjtu.wlw.service.RepairService;

/**
 * 处理维修功能模块请求的控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/repair")
public class RepairController extends BaseController{
    @Autowired
    private RepairService repairService;
    /**
     * 处理访问维修模块主页的条件+分页查询的请求
     * @return
     */
    @RequestMapping("/index")//要判断是谁请求，因为跳转不确定
    public String index(RepairInfo repairInfo,HttpServletRequest request){

        //处理请求中的pager.offset
        handleOffset(request);
        repairInfo.setStart(this.getStart());
        request.setAttribute("repairnamecondition", repairInfo.getStartTime());
        request.setAttribute("Repairnumbercondition", repairInfo.getRequestTime());
        request.setAttribute("Clientidcondition", repairInfo.getClientId());

        //按条件/分页查询出所有记录
        List<RepairInfo> Repairs = repairService.getRepairInfos(repairInfo);
        //按条件查询出所有的记录数
        Long count = repairService.getRepairCount(repairInfo);

        request.setAttribute("Repairs", Repairs);
        request.setAttribute("count", count);
        return "repair";
    }

    /**
     * 处理查询单个维修信息的请求
     * @param repairInfo
     * @param request
     * @return
     */
    //前端：client,worker,manager都会调用repair/show.d
    //返回json字符串，格式是repairInfo
    @RequestMapping("/show")//...repair/show.d?repairId=1
    public @ResponseBody RepairInfo show(RepairInfo repairInfo,HttpServletRequest request){
        repairInfo = repairService.getRepairById(repairInfo);
        request.setAttribute("repairInfo", repairInfo);
        return repairInfo;
    }
    /**
     * 处理添加维修信息的请求
     * @param repairInfo
     * @return
     */
    //前端client会调用
    @RequestMapping("/add")//...repair/show.d?repairId=1
    public String add(RepairInfo repairInfo,HttpServletRequest request){
        repairService.regRepairInfo(repairInfo);
        return "client";

    }
    /**
     * 处理修改前准备显示维护信息的请求
     * @param repairInfo
     * @return
     */
    //前端：client,worker,manager都会调用repair/update.d
    @RequestMapping("/update")
    public String update(RepairInfo repairInfo, HttpServletRequest request, UserInfo a, HttpSession session){
        repairInfo = repairService.getRepairById(repairInfo);
        request.setAttribute("repairInfo", repairInfo);
        session.setAttribute("user", a);
        String user_page = a.getUserIdentity();//client、manager、worker
        return user_page;
    }

    /**
     * 处理更新维修信息的请求
     * @param repairInfo
     * @param request
     * @return
     */
    @RequestMapping("/doupdate")
    public String doUpdate(RepairInfo repairInfo,HttpServletRequest request, UserInfo a, HttpSession session){
        repairService.updateRepairInfo(repairInfo);
        session.setAttribute("user", a);
        String user_page = a.getUserIdentity();//client、manager、worker
        return user_page;
    }

    /**
     * 处理删除维修信息的请求
     * @param repairInfo
     * @param request
     * @return
     */
    //client、manager调用
    @RequestMapping("/delete")
    public String delete(RepairInfo repairInfo,HttpServletRequest request, UserInfo a, HttpSession session){
        repairService.delRepairInfo(repairInfo);
        session.setAttribute("user", a);
        String user_page = a.getUserIdentity();//client、manager、worker
        return user_page;
    }

}
