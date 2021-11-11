package com.misiontic.todo_cap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

            case R.id.itemTres:
                showAlertD();

            case R.id.itemCuatro:
                showToast();

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

        Intent gotoSecond = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(gotoSecond);

    }

    public void showAlertD(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Solicitud de permiso");
        builder.setMessage("Sin el permiso no se puede detener la emisora al llegar una llamada");

        builder.setIcon(R.drawable.ic_android_black_24dp);

        builder.setNeutralButton("No molestar",(dialogInterface, i) -> {});

        builder.setNegativeButton("Cancel",(dialogInterface, i) -> {

        });

        builder.setPositiveButton("OK" , new DialogInterface.OnClickListener(){
                    @Override public void onClick(DialogInterface dialog ,int which){
                       goToSecondView();
                    }
                }
        );
        builder.show();

    }


    public void showToast(){

        Context context = getApplicationContext();
        CharSequence txt  = "Hola soy un Toast";
        int duration  = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context,txt,duration);
        toast.show();



    }



}