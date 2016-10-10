package com.qxh.testmvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.qxh.testmvp.R;
import com.qxh.testmvp.presenter.LoginPresenter;

/**
 * 备注：仅做展示UI
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, ILoginView {

    private EditText etUserName;
    private EditText etPassword;
    private ProgressBar pbProgress;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPresenter = new LoginPresenter(this);
    }

    private void initView() {
        etUserName = (EditText) findViewById(R.id.et_username);
        etPassword = (EditText) findViewById(R.id.et_pass);
       findViewById(R.id.btn_login).setOnClickListener(this);
       findViewById(R.id.btn_reset).setOnClickListener(this);
        pbProgress = (ProgressBar) findViewById(R.id.pb_progress);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                mPresenter.login();
                break;
            case R.id.btn_reset:
                mPresenter.reset();
                break;
        }
    }

    @Override
    public String getUserName() {
        return etUserName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void resetMsg() {
        etPassword.setText("");
        etUserName.setText("");
    }

    @Override
    public void showLoginProgress() {
        pbProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginProgress() {
pbProgress.setVisibility(View.GONE);
    }

    @Override
    public void toSucceedActivity() {
        startActivity(new Intent(this,HomeActivity.class));
    }

    @Override
    public void showLoginFailedView() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
    }
}
