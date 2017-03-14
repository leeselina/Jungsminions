package com.example.sungeun.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Html;

public class MainActivity extends Activity {

    Button btn_register, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*로그인 정보 입력*/
        EditText edit_id = (EditText) findViewById(R.id.id);
        EditText edit_pw = (EditText) findViewById(R.id.pw);
















        btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomerRegister.class);
                startActivity(intent);
                finish();
            }
        });

        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomerLoginCheck.class);
                startActivity(intent);
                finish();
            }
        });

        TextView find_idpw = (TextView) findViewById(R.id.find_idpw);
        find_idpw.setText(Html.fromHtml("<a href=\"http://www.naver.com\">아이디/비밀번호 찾기</a>"));
        find_idpw.setMovementMethod(LinkMovementMethod.getInstance());

        TextView facebook = (TextView) findViewById(R.id.login_facebook);
        facebook.setText(Html.fromHtml("<a href=\"http://www.facebook.com\">페이스북 로그인</a>"));
        facebook.setMovementMethod(LinkMovementMethod.getInstance());

    }
}