package com.cqjtu.wlw.pojo;

public class UserInfo {
    private Integer userId;
    private String userIdentity;
    private String userPassword;

    public UserInfo(){
        System.out.println("调用UserInfo类的无参构造方法");
    }

    public UserInfo(String userName,String userPassword){
        this.userIdentity = userName;
        this.userPassword = userPassword;
        System.out.println("调用UserInfo类的有参构造方法");
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public String show(String s1, String s2, Integer i3){
        return s1 + s2 + i3;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }
}
