package com.cqjtu.wlw.pojo;

import java.util.Set;

public class ClientInfo {
    private String clientId;
    private String clientName;
    private String clientPassword;
    private String clientSex;
    private String clientPhone;
    private String clientAddr;
    private String clientPhoto;
    private Integer lockId;

    private LockInfo lockInfo;

    /**
     * 一个户主可对应多个维修记录
     */
    private Set<RepairInfo> repairInfos;


    /**
     * 一个户主下有多个家庭成员
     */
    private Set<FamilyInfo> familyInfos;


    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSex() {
        return clientSex;
    }

    public void setClientSex(String clientSex) {
        this.clientSex = clientSex;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientAddr() {
        return clientAddr;
    }

    public void setClientAddr(String clientAddr) {
        this.clientAddr = clientAddr;
    }

    public String getClientPhoto() {
        return clientPhoto;
    }

    public void setClientPhoto(String clientPhoto) {
        this.clientPhoto = clientPhoto;
    }

    public Integer getLockId() {
        return lockId;
    }

    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }

    public LockInfo getLockInfo() {
        return lockInfo;
    }

    public void setLockInfo(LockInfo lockInfo) {
        this.lockInfo = lockInfo;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public Set<FamilyInfo> getFamilyInfos() {
        return familyInfos;
    }

    public void setFamilyInfos(Set<FamilyInfo> familyInfos) {
        this.familyInfos = familyInfos;
    }

    public Set<RepairInfo> getRepairInfos() {
        return repairInfos;
    }

    public void setRepairInfos(Set<RepairInfo> repairInfos) {
        this.repairInfos = repairInfos;
    }
}
