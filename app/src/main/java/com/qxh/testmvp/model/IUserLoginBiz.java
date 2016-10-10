package com.qxh.testmvp.model;

/**
 * Created by 乔兴华 on 2016/10/8.
 */

public interface IUserLoginBiz {
    void login(String name,String pass,OnLoginListener listener);
}
