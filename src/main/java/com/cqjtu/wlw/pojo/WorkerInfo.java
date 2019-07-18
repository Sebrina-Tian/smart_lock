package com.cqjtu.wlw.pojo;

import java.util.Set;

public class WorkerInfo extends BaseBean{
    private String workerId;
    private String workerName;
    private String workerPassword;
    private String workerSex;
    private String workerPhone;
    private String workerAddr;
    private String workerArea;
    private Float workerGrade;

    /**
     * 一个工人可对应多个维修记录
     */
    private Set<RepairInfo> repairInfos;

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName == null ? null : workerName.trim();
    }

    public String getWorkerSex() {
        return workerSex;
    }

    public void setWorkerSex(String workerSex) {
        this.workerSex = workerSex;
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone;
    }

    public String getWorkerAddr() {
        return workerAddr;
    }

    public void setWorkerAddr(String workerAddr) {
        this.workerAddr = workerAddr;
    }

    public String getWorkerArea() {
        return workerArea;
    }

    public void setWorkerArea(String workerArea) {
        this.workerArea = workerArea;
    }

    public String getWorkerPassword() {
        return workerPassword;
    }

    public void setWorkerPassword(String workerPassword) {
        this.workerPassword = workerPassword;
    }

    public Float getWorkerGrade() {
        return workerGrade;
    }

    public void setWorkerGrade(Float workerGrade) {
        this.workerGrade = workerGrade;
    }

    public Set<RepairInfo> getRepairInfos() {
        return repairInfos;
    }

    public void setRepairInfos(Set<RepairInfo> repairInfos) {
        this.repairInfos = repairInfos;
    }
}
