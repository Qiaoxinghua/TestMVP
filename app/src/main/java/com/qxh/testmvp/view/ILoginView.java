package com.qxh.testmvp.view;

/**
 * Created by 乔兴华 on 2016/10/8.
 */

public interface ILoginView {
    String getUserName();

    String getPassword();

    void resetMsg();

    void showLoginProgress();

    void hideLoginProgress();

    void toSucceedActivity();

    void showLoginFailedView();

}
