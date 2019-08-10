package com.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private Integer id;//id
    private String loginname;//登陆名
    private String password;//密码
    private String username;//用户名
    private String phone;//电话
    private String address;//地址

    public User() {
    }

    public User(String loginname, String password, String username, String phone, String address) {
        this.loginname = loginname;
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", loginname=" + loginname + ", password="
                + password + ", username=" + username + ", phone=" + phone
                + ", address=" + address + "]";
    }
}
