package com.misiontic.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    private Context context;

    private static final  String DB = "todos.db";
    private static final  int DB_VERSION = 1;

    private static final  String TABLA  = "todos";
    private static final  String COL_ID = "id";
    private static final  String COL_DESCRIPCION = "descripcion";
    private static final  String COL_NOMBRE = "nombre";


    public DataBase(@Nullable Context context) {
        super(context, DB, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql =
                "CREATE TABLE " + TABLA +
                        " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COL_DESCRIPCION + " TEXT, "+
                        COL_NOMBRE + " TEXT);";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLA);
        onCreate(db);
    }

    public void addTodos(String desc, String nom){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_NOMBRE,nom);
        cv.put(COL_DESCRIPCION,desc);

        long res = db.insert(TABLA,null,cv);

        if (res == -1){
            Toast.makeText(context,"Error al registrar tarea",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Se registró la tarea",Toast.LENGTH_SHORT).show();
        }

    }

    Cursor readTodos(){
        String sql = "SELECT * FROM "+TABLA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;

        if (db!= null){
            cursor  = db.rawQuery(sql,null);
        }
        return  cursor;
    }

   /* void updateData(String id,String precio,String desc){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_DESCRIPCION,desc);
        cv.put(COL_PRECIO,Double.parseDouble(precio));

        long rst = db.update(TABLA,cv,"codigo=?",new String[]{id});

        System.out.println("ID -> " + id);
        System.out.println("DESCRIPCION -> " + desc);
        System.out.println("PRECIO -> " + precio);

        if (rst == -1){
            Toast.makeText(context, "No se pudo actualizar el producto", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Datos Actualizados", Toast.LENGTH_SHORT).show();

        }

    }

    void  deleteProduct(String id){
        SQLiteDatabase db  =  this.getWritableDatabase();

        long rst = db.delete(TABLA,"codigo=?",new String[]{id});
        if (rst == -1){
            Toast.makeText(context, "No se ha podido eliminar el producto", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Producto eiminado ", Toast.LENGTH_SHORT).show();
        }
    }*/



}
