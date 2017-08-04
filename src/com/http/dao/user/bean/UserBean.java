package com.http.dao.user.bean;

/**
 * Created by smart on 2017/8/3.
 */
public class UserBean {
    private String name;
    private String password;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String pUser_account) {
        name = pUser_account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pUser_password) {
        password = pUser_password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int pUser_age) {
        age = pUser_age;
    }
}
