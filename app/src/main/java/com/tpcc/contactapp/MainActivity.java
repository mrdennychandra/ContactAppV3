package com.tpcc.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tpcc.contactapp.adapter.ContactAdapter;
import com.tpcc.contactapp.db.AppDatabase;
import com.tpcc.contactapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    RecyclerView list;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.fab);
        list = findViewById(R.id.list);
        list.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        //dummy data
/*
        List<Contact> contacts = new ArrayList<>();
        Contact contact = new Contact();
        contact.email = "test@email.com";
        contact.id = 1L;
        contact.jeniskelamin = "L";
        contact.nama = "Denny Chandra";
        contact.pekerjaan = "swasta";
        contact.telpon = "12345";
        contact.tgllahir = "21-11-1990";
        contacts.add(contact);

        //adapter
        // Array lapor mapping ke row_layout
        adapter = new ContactAdapter(this,contacts);
        list.setAdapter(adapter);
 */
        List<Contact> contacts = AppDatabase.getInstance(this).contactDao().getAll();
        adapter = new ContactAdapter(this,contacts);
        list.setAdapter(adapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FormActivity.class);
                startActivity(intent);
            }
        });
    }
}
