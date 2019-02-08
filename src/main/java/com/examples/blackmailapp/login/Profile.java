package com.examples.blackmailapp.login;

public class Profile {
    private int caloric;
    private String userMail2;

    private String objectId;

    public Profile(){
        this.caloric = 0;
        this.userMail2 = null;
    }

    public void setCaloric(int calories){
        this.caloric = calories;
    }
    public int getCaloric(){
        return caloric;
    }
    public void setUserMail2(String userMail2){
        this.userMail2 = userMail2;
    }
    public String getUserMail2(){
        return userMail2;
    }
    public void setObjectId(String objectId){
        this.objectId = objectId;
    }
    public String getObjectId(){
        return objectId;
    }
}
