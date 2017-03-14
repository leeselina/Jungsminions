package com.example.sungeun.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import android.widget.TextView;
import android.app.DialogFragment;

/**
 * Created by sungeun on 2017-03-06.
 */

public class CustomerRegister extends AppCompatActivity {

    //private Button mDateDisplay;
    private int mYear;
    private int mMonth;
    private int mDay;
    static final int DATE_DIALOG_ID = 0;

    /* 변수 선언 */
    Button register_done; //등록 완료
    Button btn_idcheck; //아이디 중복체크
    EditText edittext; //아이디 입력 값


    private EditText editTextId, editTextPw, editTextName;
    Button btn_birth;
    EditText editTextphone;
    final TextView tv = (TextView)findViewById(R.id.textView1); //주소
    EditText editTextheight, editTextweight; //키, 몸무게

    /*라디오 그룹은 onCreate에서 생성과 동시에 선언*/
    RadioButton one, two, three, four;  /*판단기수*/
    RadioButton no, yes;                 /*재수술여부*/
    final TextView tv2 = (TextView)findViewById(R.id.textView2); //수술방법
    Button btn_operdate, btn_out; // 수술일, 퇴원일
    RadioButton ms, mrs;    /*결혼유무*/
    RadioButton ischild, nochild;    /*자식유무*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginregister);

        editTextId = (EditText) findViewById(R.id.id);
        editTextPw = (EditText) findViewById(R.id.pw);
        editTextName = (EditText) findViewById(R.id.name);
        btn_birth = (Button)findViewById(R.id.btn_birth);
        editTextphone = (EditText) findViewById(R.id.phonenumber); //전번
        Spinner s = (Spinner)findViewById(R.id.spinner1);//주소
        editTextheight = (EditText) findViewById(R.id.height); // 키
        editTextweight = (EditText) findViewById(R.id.weight); // 무게

        /*판단기수*/
        final RadioGroup judgementgroup = (RadioGroup) findViewById(R.id.judgement);
        one = (RadioButton) findViewById(R.id.one);
        two= (RadioButton) findViewById(R.id.two);
        three = (RadioButton) findViewById(R.id.three);
        four = (RadioButton) findViewById(R.id.four);

        /*재수술여부*/
        final RadioGroup numsurgerygroup = (RadioGroup) findViewById(R.id.NumSurgery);
        no = (RadioButton) findViewById(R.id.no);
        yes = (RadioButton) findViewById(R.id.yes);

        Spinner s2 = (Spinner)findViewById(R.id.spinner2);//수술방법
        btn_operdate = (Button)findViewById(R.id.btn_operdate); // 수술일
        btn_out = (Button)findViewById(R.id.btn_out); //퇴원일

        /*결혼 유무*/
        final RadioGroup maritalstatusgroup = (RadioGroup) findViewById(R.id.maritalstatus);
        ms = (RadioButton) findViewById(R.id.ms);
        mrs = (RadioButton) findViewById(R.id.mrs);

        /*자식 상태*/
        final RadioGroup childgroup = (RadioGroup) findViewById(R.id.child);
        ischild = (RadioButton) findViewById(R.id.ischild);
        nochild = (RadioButton) findViewById(R.id.nochild);


        /////////////////////////버튼 데이트 피커//////////////////////////
        btn_birth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DialogFragment dialogfragment = new DatePickerDialogBirth();
                dialogfragment.show(getFragmentManager(), "Theme 1");
            }
        });

        btn_operdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DialogFragment dialogfragment = new DatePickerDialogOper();
                dialogfragment.show(getFragmentManager(), "Theme 2");
            }
        });

        btn_out.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DialogFragment dialogfragment = new DatePickerDialogOut();
                dialogfragment.show(getFragmentManager(), "Theme 3");
            }

        });


        /////////////////////////스피너///////////////////////

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                tv.setText("선택 : " + position + parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                tv2.setText("선택 : " + position +
                        parent.getItemAtPosition(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });



        //등록완료버튼
        register_done = (Button) findViewById(R.id.register_done);
        register_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerRegister.this, MainActivity.class);
                startActivity(intent);

                String id = editTextId.getText().toString();
                String pw = editTextPw.getText().toString();
                String name = editTextName.getText().toString();
                String phone = editTextphone.getText().toString();
                String address = tv.getText().toString();
                String height = editTextheight.getText().toString();
                String weight = editTextweight.getText().toString();

                /*판정기수*/
                RadioButton selectedjudge = (RadioButton)findViewById(judgementgroup.getCheckedRadioButtonId());
                String selectedValuejudge = selectedjudge.getText().toString();

                /*재수술여부*/
                RadioButton selectednumsur = (RadioButton)findViewById(numsurgerygroup.getCheckedRadioButtonId());
                String selectedValuenumsur = selectednumsur.getText().toString();

                /*수술 방법*/
                String howtooper = tv2.getText().toString();

                //데이트피커
                String dateofbirth = btn_birth.getText().toString();
                String dateofoper = btn_operdate.getText().toString();
                String dateofout = btn_out.getText().toString();

                /*결혼 유무*/
                RadioButton selectedmarital = (RadioButton)findViewById(maritalstatusgroup.getCheckedRadioButtonId());
                String selectedValuemarital = selectedmarital.getText().toString();

                /*자식 유무*/
                RadioButton selectedchild = (RadioButton)findViewById(childgroup.getCheckedRadioButtonId());
                String selectedValuechild = selectedchild.getText().toString();

                //스피너
                insertToDatabase(id, pw, name, dateofbirth, phone, address, height, weight, selectedValuejudge, selectedValuenumsur, howtooper,dateofoper, dateofout, selectedValuemarital, selectedValuechild);
            }
        });


        /*db와 연결시켜 중복체크 확인해야하지만 우선 아이디 값을 받아와서 토스트메세지로 띄워본 것.*/
        edittext = (EditText) findViewById(R.id.id);
        btn_idcheck = (Button) findViewById(R.id.idcheck);

        btn_idcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idText = edittext.getText().toString();
                Toast.makeText(CustomerRegister.this, idText, Toast.LENGTH_SHORT).show();
            }
        });
    }



    /*●●●●●●●●●●●●●●●●●●●●●●●●●●●●●●I●N●S●E●R●T●T●O●D●A●T●A●B●A●S●E●●●●●●●●●●●●●●●●●●●●●●●●●●●●*/
    private void insertToDatabase(String id, String pw, String name, String dateofbirth, String phone, String address,
                                  String height, String weight, String selectedValuejudge, String selectedValuenumsur, String howtooper, String dateofoper,
                                  String dateofout, String selectedValuemarital, String selectedValuechild){

        class InsertData extends AsyncTask<String, Void, String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(CustomerRegister.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                try{
                    String id = (String)params[0];
                    String pw = (String)params[1];
                    String name = (String)params[2];

                    //데이트피커
                    String dateofbirth = (String)params[3];
                    String phone =(String)params[4];
                    String address = (String)params[5];
                    String height = (String)params[6];
                    String weight = (String)params[7];
                    String selectedValuejudge = (String)params[8];
                    String selectedValuenumsur = (String)params[9];
                    String howtooper = (String)params[10];
                    String dateofoper = (String)params[11];
                    String dateofout = (String)params[12];
                    String selectedValuemarital = (String)params[13];
                    String selectedValuechild = (String)params[14];




                    String link="http://192.168.99.75/registration.php";
                    String data  = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id, "UTF-8");
                    data += "&" + URLEncoder.encode("pw", "UTF-8") + "=" + URLEncoder.encode(pw, "UTF-8");
                    data += "&" + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
                    //데이트피커
                    data += "&" + URLEncoder.encode("dateofbirth", "UTF-8") + "=" + URLEncoder.encode(dateofbirth, "UTF-8");
                    data += "&" + URLEncoder.encode("phone", "UTF-8") + "=" + URLEncoder.encode(phone, "UTF-8");
                    data += "&" + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8");
                    data += "&" + URLEncoder.encode("height", "UTF-8") + "=" + URLEncoder.encode(height, "UTF-8");
                    data += "&" + URLEncoder.encode("weight", "UTF-8") + "=" + URLEncoder.encode(weight, "UTF-8");
                    /*판정 기수, 재수술*/
                    data += "&" + URLEncoder.encode("selectedValuejudge", "UTF-8") + "=" + URLEncoder.encode(weight, "UTF-8");
                    data += "&" + URLEncoder.encode("selectedValuenumsur", "UTF-8") + "=" + URLEncoder.encode(weight, "UTF-8");
                    data += "&" + URLEncoder.encode("howtooper", "UTF-8") + "=" + URLEncoder.encode(dateofout, "UTF-8");
                    data += "&" + URLEncoder.encode("dateofoper", "UTF-8") + "=" + URLEncoder.encode(dateofoper, "UTF-8");
                    data += "&" + URLEncoder.encode("dateofout", "UTF-8") + "=" + URLEncoder.encode(dateofout, "UTF-8");
                    data += "&" + URLEncoder.encode("selectedValuemarital", "UTF-8") + "=" + URLEncoder.encode(weight, "UTF-8");
                    data += "&" + URLEncoder.encode("selectedValuechild", "UTF-8") + "=" + URLEncoder.encode(weight, "UTF-8");



                    URL url = new URL(link);
                    URLConnection conn = url.openConnection();

                    conn.setDoOutput(true);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write( data );
                    wr.flush();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    StringBuilder sb = new StringBuilder();
                    String line = null;

                    // Read Server Response
                    while((line = reader.readLine()) != null)
                    {
                        sb.append(line);
                        break;
                    }
                    return sb.toString();
                }
                catch(Exception e){
                    return new String("Exception: " + e.getMessage());
                }

            }

        }

        InsertData task = new InsertData();
        task.execute(id,pw,name,dateofbirth,phone,address,height,weight,selectedValuejudge,selectedValuenumsur,howtooper,dateofoper,dateofout,selectedValuemarital,selectedValuechild);
    }
}
