package com.example.sungeun.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by sungeun on 2017-03-07.
 */
//고객의 필수 정보 값 입력만 모두 완료되면 가입 버튼이 활성화 되도록 한다.
//가입버튼을 누르는 순간 php와 연동해놓은 mysql DB로 정보가 전송되도록 한다.
//mysql db로 질의어와 명령들이 제대로 완료하면 고객에게 alert창을 띄운다.

public class CustomerRegisterPass extends CustomerRegister {

    Button btn_register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginregister);

        btn_register = (Button) findViewById(R.id.register_done);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
