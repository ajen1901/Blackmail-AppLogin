package com.examples.blackmailapp.login;

public class Profile {
    private int calories;
    private String userMail;

    private String objectId;

    public Profile(){
        this.calories = 0;
        this.userMail = null;
    }

    public void setCalories(int calories){
        this.calories = calories;
    }
    public int getCalories(){
        return calories;
    }
    public void setUserMail(String userMail){
        this.userMail = userMail;
    }
    public String getUserMail(){
        return userMail;
    }
    public void setObjectId(String objectId){
        this.objectId = objectId;
    }
    public String getObjectId(){
        return objectId;
    }
}
