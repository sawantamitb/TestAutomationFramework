package com.ui.pojo;

public class Environment {
    private String Url, Username, Password;

    public void setUserName(String userName) {
        Username = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getUrl() {
        return Url;
    }


}
