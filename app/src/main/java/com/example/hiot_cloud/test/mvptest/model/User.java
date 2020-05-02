package com.example.hiot_cloud.test.mvptest.model;

import java.io.Serializable;

public class User implements Serializable {
    private String Name;
    private String Password;

    public String getUserName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public String getPassword(){
        return Password;
    }
    public void setPassword(String Password){
        this.Password = Password;
    }
}
