package com.example.lq.light_life.ui.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lq.light_life.R;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private String username,userpwd;
    public boolean checkresult;
    private Button button_login;
    private EditText account;
    private EditText password;
    private TextView textView_forgetpassword;
    private TextView textView_register;

    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){//隐藏系统标题栏
            actionBar.hide();
        }

        initView();//初始化所有的View并获取相应的实例

////        button_login.setOnClickListener(new View.OnClickListener(){
////            @Override
////            public void onClick(View v) {
////
////            }
////            @Override
////            public void onClick(View v) {
//                username = account.getText().toString();
//                userpwd = password.getText().toString();
//                if(TextUtils.isEmpty(account.getText())  ){
//                    account.setHint("请输入账号！");
//                    account.setText("");
//                }
//                if(TextUtils.isEmpty(password.getText())  ){
//                    password.setHint("请输入密码！");
//                    password.setText("");
//                }
//                sendCheckAcount();
//                if(true/*username.equals("LQ" ) && userpwd.equals("admin")*/) {
//                    Intent intent = new Intent(LoginActivity.this,MainHomeActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else{
//                    Toast.makeText(LoginActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
////                    Intent intent = new Intent(LoginActivity.this,LoginActivity.class);
////                    startActivity(intent);
//                    password.setText("");
//                }
////            }
////        });
    }

    private void initView(){
        textView_forgetpassword = (TextView)findViewById(R.id.link_forgetpwd);
        textView_register = (TextView)findViewById(R.id.link_register);
        account = (EditText) findViewById(R.id.input_account);
        password = (EditText) findViewById(R.id.input_password);
        button_login = (Button) findViewById(R.id.btn_login);

        textView_register.setOnClickListener(this);
        textView_forgetpassword.setOnClickListener(this);
        button_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                username = account.getText().toString();
                userpwd = password.getText().toString();
                if(TextUtils.isEmpty(account.getText())  ){
                    account.setHint("请输入账号！");
                    account.setText("");
                }
                if(TextUtils.isEmpty(password.getText())  ){
                    password.setHint("请输入密码！");
                    password.setText("");
                }
                sendCheckAcount();
                if(true/*username.equals("LQ" ) && userpwd.equals("admin")*/) {
                    Intent intent = new Intent(LoginActivity.this,MainHomeActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT).show();
                    password.setText("");
                }
                break;
            case R.id.link_register:
                    Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                    startActivity(intent);
                break;
            case R.id.link_forgetpwd:

                break;
            default:

                break;

        }
    }



    private void sendCheckAcount(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient.Builder().authenticator(new Authenticator() {
                        @Override
                        public Request authenticate(Route route, Response response) throws IOException {
                            String credential = okhttp3.Credentials.basic(username,userpwd);
                            return response.request().newBuilder()
                                    .header("Authorization", credential)
                                    .build();
                        }
                        Request request = new Request.Builder()
                                .url("http://192.168.23.1:5000/api/users")
                                .build();
                    }).build();
                    checkresult = true;
                }catch(Exception e){
                    e.printStackTrace();
                    checkresult = false;
                }
            }
        }).start();
    }


}
