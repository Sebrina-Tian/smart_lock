package com.cqjtu.wlw.controller;

import com.cqjtu.wlw.pojo.WorkerInfo;
import com.cqjtu.wlw.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController extends BaseController{

    @Autowired//自动装配，将WorkerInfoService接口实现的类自动注入进来
    private WorkerService workerInfoService;
    /**
     * 处理访问老师模块主页的条件+分页查询的请求
     * @return
     */
    @RequestMapping("/index")
    public String index(WorkerInfo workerInfo,HttpServletRequest request){

        //处理请求中的pager.offset
        handleOffset(request);
        workerInfo.setStart(this.getStart());
        request.setAttribute("workernamecondition", workerInfo.getWorkerName());
        request.setAttribute("workephonecondition", workerInfo.getWorkerPhone());
        //按条件/分页查询出所有记录
        List<WorkerInfo> wokers = workerInfoService.getWorkerInfos(workerInfo);
        request.setAttribute("workers", wokers);
        return "worker";
    }
    /**
     * 处理查询单个职员信息的请求
     * @param workerInfo
     * @param request
     * @return
     */
    @RequestMapping("/show")//...worker/show.d?workerId=1
    public @ResponseBody
    WorkerInfo show(WorkerInfo workerInfo, HttpServletRequest request){
        workerInfo = workerInfoService.getWorkerById(workerInfo);
        request.setAttribute("worker", workerInfo);
        System.out.println(workerInfo);
        return workerInfo;
    }

    /**
     * 根据条件查询职员信息
     * @param workerInfo {WorkerName 可能为空，可能不为空 WorkerPhone可能为空，可能不为空}
     * @return
     */
    @RequestMapping("/list")//...Worker/list.d?WorkerId=1
    public String list(WorkerInfo workerInfo, HttpSession session){
        List<WorkerInfo> list = workerInfoService.getWorkerInfos(workerInfo);
        session.setAttribute("workers", list);
        System.out.println(list);
        return "worker";
    }

    /**
     * 处理维修人员注册的请求
     * @param workerInfo
     * @return
     */
    @RequestMapping("/doreg")//....Worker/doreg.d
    public String doReg(WorkerInfo workerInfo){
        System.out.println("执行WorkerInfoController.doReg...");
        //获取前端的输入
        workerInfoService.regWorkerInfo(workerInfo);
        return "worker";
    }
    /**
     * 处理维修人员注销的请求
     * @param workerInfo
     * @return
     */
    @RequestMapping("/dodelete")//.....Worker/dodelete.d?WorkerId=2
    public String doDelete(WorkerInfo workerInfo){
        workerInfoService.delWorkerInfo(workerInfo);
        return "worker";
    }

    /**
     * 处理维修人员信息更新的请求
     * @param workerInfo
     * @return
     */
    @RequestMapping("/doupdate")
    public String doUpdate(WorkerInfo workerInfo){
        workerInfoService.updateWorkerInfo(workerInfo);
        return "worker";
    }

}
