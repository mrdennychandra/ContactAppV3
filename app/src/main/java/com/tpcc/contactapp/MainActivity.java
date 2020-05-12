package com.tpcc.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    //deklarasi variabel
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //memanggil layout
        setContentView(R.layout.activity_main);
        //inisialisasi/dapatkan id nya
        fab = findViewById(R.id.fab);
        //event onclick
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                        FormActivity.class);
                startActivity(intent);
            }
        });
    }
}
