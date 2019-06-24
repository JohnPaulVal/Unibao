package com.example.unibao;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void entrar(View view){

        Intent intent = new Intent(login.this , contenido.class);
        startActivity(intent);

    }
    public void refresh(View view){

        Intent intent = new Intent(login.this , MainActivity.class);
        startActivity(intent);

    }

    public void salir(View view){
        moveTaskToBack(true);

    }

    public void pagina(View view){
        Uri uri = Uri.parse("https://enlace.univalle.edu/san/webform/PAutenticar.aspx");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }




}
