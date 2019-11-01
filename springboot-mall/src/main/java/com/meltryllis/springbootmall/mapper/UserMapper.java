package com.meltryllis.springbootmall.mapper;

import com.meltryllis.springbootmall.entities.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author Ereshkigal
 * @date 2019/10/22 - 16:56
 */
public interface UserMapper {

    @Select("select * from user where username=#{userName} and password=#{password}")
    public User login(String userName, String password);
}
