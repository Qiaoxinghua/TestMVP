package com.qxh.testmvp.presenter;

import android.os.Handler;

import com.qxh.testmvp.model.LoginBiz;
import com.qxh.testmvp.model.OnLoginListener;
import com.qxh.testmvp.view.ILoginView;

/**
 * Created by 乔兴华 on 2016/10/8.
 */

public class LoginPresenter {
    private LoginBiz mLoginBiz;
    private ILoginView mView;

    private Handler mHandler = new Handler();

    public LoginPresenter(ILoginView view) {
        mLoginBiz = new LoginBiz();
        this.mView = view;
    }

    public void login() {
        mView.showLoginProgress();
        mLoginBiz.login(mView.getUserName(), mView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSucceed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //跳到登录成功的界面
                        mView.toSucceedActivity();
                        //隐藏登录进度条
                        mView.hideLoginProgress();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showLoginFailedView();
                        mView.hideLoginProgress();
                    }
                });
            }
        });
    }
    public void reset(){
        mView.resetMsg();
    }

}
