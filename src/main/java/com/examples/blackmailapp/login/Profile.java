package com.examples.blackmailapp.login;

public class Profile {
    private int caloric;
    private String userMail3;

    private String objectId;

    public Profile(){
        this.caloric = 0;
        this.userMail3 = null;
    }

    public void setCaloric(int calories){
        this.caloric = calories;
    }
    public int getCaloric(){
        return caloric;
    }
    public void setUserMail3(String userMail3){
        this.userMail3 = userMail3;
    }
    public String getUserMail3(){
        return userMail3;
    }
    public void setObjectId(String objectId){
        this.objectId = objectId;
    }
    public String getObjectId(){
        return objectId;
    }
}
