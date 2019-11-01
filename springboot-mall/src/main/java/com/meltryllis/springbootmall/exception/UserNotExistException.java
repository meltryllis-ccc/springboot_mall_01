package com.meltryllis.springbootmall.exception;

/**
 * @author Ereshkigal
 * @date 2019/9/29 - 15:39
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}
