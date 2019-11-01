package com.meltryllis.springbootmall.entities;

/**
 * @author Ereshkigal
 * @date 2019/10/22 - 17:01
 */
public class User {
    Integer id;
    String username;
    String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
