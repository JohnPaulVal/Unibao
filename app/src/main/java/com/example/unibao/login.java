package com.example.unibao;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {

    Button btnIngresar;


    BDuni h = new BDuni(this,"BD1",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnIngresar = findViewById(R.id.button3);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtCuenta =(EditText)findViewById(R.id.cuenta);
                EditText txtPass =(EditText)findViewById(R.id.pass);

                Cursor cursor = h.ConsultarUsuYPas(txtCuenta.getText().toString(),txtPass.getText().toString());
                if(cursor.getCount()>0){
                    Toast.makeText(getApplicationContext(),"BIENVENIDO",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this , contenido.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"usuario y/o password Incorrectos",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext()," 5",Toast.LENGTH_LONG).show();
                }
                txtPass.setText("");
                txtCuenta.setText("");
                txtCuenta.findFocus();

            }
        });


    }
    ///LOGIN BUTTON ENTRAR
    /*public void entrar(View view){

        Intent intent = new Intent(login.this , contenido.class);
        startActivity(intent);

    }*/






    ////////////////IMAGEBUTTONS FUNCIONES
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
