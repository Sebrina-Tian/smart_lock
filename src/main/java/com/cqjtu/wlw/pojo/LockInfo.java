package com.cqjtu.wlw.pojo;

public class LockInfo {
    private Integer lockId;
    private String lockType;

    public Integer getLockId(){
        return lockId;
    }
    public void setLockId(Integer lockId) {
        this.lockId = lockId;
    }
    public String getLockType(){
        return lockType;
    }
    public void setLockType(String lockType) {
        this.lockType = lockType;
    }
}
