package com.misiontic.todo_cap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case  R.id.itemUno:
                System.out.println("Item 1 seleccionado");
                sendeEmail();
                return true;

            case  R.id.itemDos:
                System.out.println("Item 2 seleccionado");
                goToSecondView();
                return true;

            default:
                return false;
        }


    }

    private boolean sendeEmail(){

        try {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT,"Prueba: ");
            intent.putExtra(Intent.EXTRA_TEXT, "Correo de prueba");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "penalozadaniel00@gmial.com"});
            startActivity(intent);
            return true;

        }catch (Exception e){
            return false;
        }

    }

    private void goToSecondView(){

        Intent gotoSecond = new Intent(MainActivity2.this,MainActivity.class);
        startActivity(gotoSecond);

    }



}