package com.example.indiv_bav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button set_about_btn, set_bookItem1, set_bookItem2, set_bookItem3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set_about_btn = findViewById(R.id.main_intro_button);
        set_about_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_about = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(get_about);
            }
        });

        set_bookItem1 = findViewById(R.id.bookItem1_button);
        set_bookItem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_bookItem1 = new Intent(MainActivity.this, BookItem1Activity.class);
                startActivity(get_bookItem1);
            }
        });

        set_bookItem2 = findViewById(R.id.bookItem2_button);
        set_bookItem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_bookItem2 = new Intent(MainActivity.this, BookItem2Activity.class);
                startActivity(get_bookItem2);
            }
        });

        set_bookItem3 = findViewById(R.id.bookItem3_button);
        set_bookItem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_bookItem3 = new Intent(MainActivity.this, BookItem3Activity.class);
                startActivity(get_bookItem3);
            }
        });
    }
}

