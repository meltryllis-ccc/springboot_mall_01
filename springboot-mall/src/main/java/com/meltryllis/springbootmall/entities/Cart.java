package com.meltryllis.springbootmall.entities;

/**
 * @author Ereshkigal
 * @date 2019/10/23 - 18:32
 */
public class Cart {
    Integer id;
    Integer userid;
    Integer pid;
    Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
