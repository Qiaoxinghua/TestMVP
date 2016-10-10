package com.qxh.testmvp.model;

import android.os.SystemClock;

/**
 * Created by 乔兴华 on 2016/10/8.
 */

public class LoginBiz implements IUserLoginBiz {
    @Override
    public void login(final String name, final String pass, final OnLoginListener listener) {
        new Thread() {
            @Override
            public void run() {
                //模拟耗时操作....
                SystemClock.sleep(2000);
                if ("qwe".equals(name) && "123".equals(pass)) {
                    listener.loginSucceed();
                } else {
                    listener.loginFailed();
                }
            }
        }.start();
    }
}
