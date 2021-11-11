package com.misiontic.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText nombre,desc;
    Button add_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_TODO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        this.nombre = findViewById(R.id.input_nombre);
        this.desc = findViewById(R.id.input_description);
        this.add_product = findViewById(R.id.add_product);
        this.add_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase myDB = new DataBase(AddActivity.this);

                myDB.addTodos(desc.getText().toString(),nombre.getText().toString());

                Intent starIntent = getIntent();
                Intent intent = new Intent(AddActivity.this,MainActivity.class);

                finish();

                startActivity(intent);
            }
        });
    }
}