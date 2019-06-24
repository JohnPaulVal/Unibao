package com.example.unibao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;




public class BDuni extends SQLiteOpenHelper {
////////constructor
    public BDuni(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
////////creacion de la estructura de las tablas
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(codigo text primary key,contrasena text)");
        db.execSQL( "insert into usuarios values('1','2')" );
    }
//////////MODIFICAR LA ESTRUCTURA
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    ////ABRIR LA BD
    public void abrir(){this.getWritableDatabase();}
    ///CERRA LA BD
    public void cerrar(){this.close();}


    /////METODO VALIDAR USUARIO
    public Cursor ConsultarUsuYPas(String usu,String pas) throws SQLException{
        Cursor mcursor=null;
        mcursor = this.getReadableDatabase().query("usuarios",new String[]{"codigo","contrasena"},"codigo like'"+usu+"' and contrasena like '"+pas+"'",null,null,null,null);
        return mcursor;
    }


}
