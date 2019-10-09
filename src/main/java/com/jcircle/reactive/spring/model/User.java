package com.jcircle.reactive.spring.model;

public class User {


    private String userName;
    private String userAddress;
    private String userId;
    private Boolean isPremiumUser;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getPremiumUser() {
        return isPremiumUser;
    }

    public void setPremiumUser(Boolean premiumUser) {
        isPremiumUser = premiumUser;
    }



}
