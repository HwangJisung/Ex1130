package com.hjs.ex_1129;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    TextView name, age, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);


        // 메인 액티비티에서 잔달받은 Intent를 받는다
        Intent intent = getIntent(); // Main에서 전달된 Intent(i)


        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        pwd = findViewById(R.id.pwd);

        //메인에서 보내준 값을 추출
        String m_name = intent.getStringExtra("my_name");
        String m_age = intent.getStringExtra("my_age");
        String m_pwd = intent.getStringExtra("my_pwd");

        name.setText("이름 : "+m_name);
        age.setText("나이 : "+m_age);
        pwd.setText("비번 : "+m_pwd);

    }
}
