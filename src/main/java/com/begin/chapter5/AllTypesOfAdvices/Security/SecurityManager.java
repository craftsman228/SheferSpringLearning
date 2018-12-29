package com.begin.chapter5.AllTypesOfAdvices.Security;

public class SecurityManager {

    private ThreadLocal<UserInfo> userInfo = new ThreadLocal<>();

    public void login(String username, String password){
        userInfo.set(new UserInfo(username, password));
    }

    public void logout(){
        userInfo.set(null);
    }

    public UserInfo getLoggedUser(){
        return userInfo.get();
    }
}
