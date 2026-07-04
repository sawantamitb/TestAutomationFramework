package com.ui.pojo;

public class Environment {
    private String Url, Username, Password;
    private int MAX_ATTEMPTS;

    public void setUserName(String userName) {
        Username = userName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getMAX_ATTEMPTS() {
        return MAX_ATTEMPTS;
    }

    public void setMAX_ATTEMPTS(int mAX_ATTEMPTS) {
        MAX_ATTEMPTS = mAX_ATTEMPTS;
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
