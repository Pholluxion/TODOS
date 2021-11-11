package com.misiontic.todo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;

    DataBase myDB;
    ArrayList<String> id,des, nombre;

    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.Theme_TODO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.recyclerView);
        this.add_button = findViewById(R.id.add_button);
        this.add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);

            }
        });

        myDB = new DataBase(MainActivity.this);
        id = new ArrayList<>();
        des = new ArrayList<>();
        nombre = new ArrayList<>();

        displayProducts();

        customAdapter = new CustomAdapter(MainActivity.this,id,des, nombre);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }

    void  displayProducts(){

        Cursor cursor = myDB.readTodos();

        if (cursor.getCount()==0){
            Toast.makeText(this, "No hay produtos agregados", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                id.add(cursor.getString(0));
                des.add(cursor.getString(1));
                nombre.add(cursor.getString(2));

            }
        }


    }
}