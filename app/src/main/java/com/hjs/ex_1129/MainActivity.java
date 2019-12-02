package com.hjs.ex_1129;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText edit_name, edit_age, edit_pwd, edit_b_day;
    Button btn_send, btn_date;
    Dialog dialog; // 달력을 띄우기 위한 다이얼로그

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_b_day = findViewById(R.id.edit_b_day);
        btn_date = findViewById(R.id.btn_date);

        edit_name = findViewById(R.id.edit_name);
        edit_age = findViewById(R.id.edit_age);
        edit_pwd = findViewById(R.id.edit_pwd);

        btn_send = findViewById(R.id.btn_send);

        // 전송 버튼에 이벤트 감지자 추가
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SubActivity.class);

                // SubActivity로 전달하고자 하는 값들
                String name = edit_name.getText().toString();
                String age = edit_age.getText().toString();
                String pwd = edit_pwd.getText().toString();
                String birth = edit_b_day.getText().toString();

                // Intent에 값 저장하기
                i.putExtra("my_name" , name);
                i.putExtra("my_age" , age);
                i.putExtra("my_pwd" , pwd);
                i.putExtra("my_birth" , birth);

                startActivity(i);
            }
        });

        // 날짜 선택 버튼 클릭시
        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //휴대폰에 설정되어 있는 현재 날짜를 가져온다.
                Calendar now = Calendar.getInstance();
                int y = now.get(Calendar.YEAR); // 년
                int m = now.get(Calendar.MONTH); // 월
                int d = now.get(Calendar.DAY_OF_MONTH); // 일

                // 준비해둔 다이얼로그에 날짜선택을 감지하는 감지자 붙이기
                dialog = new DatePickerDialog(MainActivity.this, dateSetListener, y, m, d); // dateSetListener는 달력의 날짜 변경 감지자

                dialog.show();

            }
        });
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int y, int m, int d) {

            // 날짜중 월을 표시하는 m변수는
            // 1월 -> 0 , 2월 -> 1 ......
            String result = String.format("%d-%02d-%02d",y,m+1,d);
            edit_b_day.setText(result);
        }
    };
}
