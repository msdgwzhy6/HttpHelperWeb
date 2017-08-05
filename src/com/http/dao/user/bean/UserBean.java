package com.http.dao.user.bean;

/**
 * Created by smart on 2017/8/3.
 */
public class UserBean {
    private String name;
    private String password;
    private int age;

    public UserBean(String name, String password, int age) {
        this.name = name;
        this.password = password;
        this.age = age;
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }


    public int getAge() {
        return age;
    }

}
