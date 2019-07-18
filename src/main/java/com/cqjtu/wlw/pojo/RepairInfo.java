package com.cqjtu.wlw.pojo;

public class RepairInfo {
    private Integer repairId;
    private String requestTime;
    private String startTime;
    private String reDetail;
    private String reReview;
    private Float repairGrade;

    private ClientInfo clientInfo;
    private WorkerInfo workerInfo;

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getReDetail() {
        return reDetail;
    }

    public void setReDetail(String reDetail) {
        this.reDetail = reDetail;
    }

    public String getReReview() {
        return reReview;
    }

    public void setReReview(String reReview) {
        this.reReview = reReview;
    }

    public Float getRepairGrade() {
        return repairGrade;
    }

    public void setRepairGrade(Float repairGrade) {
        this.repairGrade = repairGrade;
    }


    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public WorkerInfo getWorkerInfo() {
        return workerInfo;
    }

    public void setWorkerInfo(WorkerInfo workerInfo) {
        this.workerInfo = workerInfo;
    }
}
