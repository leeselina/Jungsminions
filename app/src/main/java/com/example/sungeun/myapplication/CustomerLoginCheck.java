package com.example.sungeun.myapplication;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Looper;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by sungeun on 2017-03-07.
 */
//로그인 성공시 다음창으로 넘어가기 위한 중복 체크하는 곳. 디비 id/pw와 연동하여 true면 새로운 activity창 부르기.
// false이면 alert창을 띄워 '아이디가 틀렸습니다' '비밀번호가 틀렸습니다' 알림띄우기

// 아이디가 null값일 경우에, 아이디를 입력해주세요. 비밀번호가 null값일 경우에, 비밀번호를 입력해주세요.
// 둘다 null값이면  --- switch문으로 해야 될듯 나중에 추가추가 할때(비밀번호 틀렸을 때/아이디 없을때..). 그게 편하니까

public class CustomerLoginCheck extends MainActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passlogin);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); //강제 네트워크 접속

        btn_login = (Button)findViewById(R.id.btn_login);/*
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = ProgressDialog.show(CustomerLoginCheck.this,"","사용자 검색중", true);
                //로그인 버튼 누르고 잠시 기다리는 동안 출력되는 다이얼 로그
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Looper.prepare();
                        login();
                        Looper.loop();
                    }
                }).start();
            }
        });*/
    }






}
