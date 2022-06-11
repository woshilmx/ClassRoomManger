package com.lmx.Pojo;

public class Manger {
    private String id;
    private String username;
    private String mpassword;

    public Manger() {
    }

    public Manger(String id, String username, String mpassword) {
        this.id = id;
        this.username = username;
        this.mpassword = mpassword;
    }

    @Override
    public String toString() {
        return "Manger{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", mpassword='" + mpassword + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }
}
