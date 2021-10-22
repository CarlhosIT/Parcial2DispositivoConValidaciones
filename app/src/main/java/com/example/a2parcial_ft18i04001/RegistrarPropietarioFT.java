package com.example.a2parcial_ft18i04001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarPropietarioFT extends AppCompatActivity {


    public static SharedPreferences sharedPreferences;
    EditText nombre,numero;
    Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_propietario_ft);

        sharedPreferences = getSharedPreferences("Configuracion", MODE_PRIVATE);



        nombre=(EditText) findViewById(R.id.Nombre);
        numero=(EditText) findViewById(R.id.Telefono);
        aceptar=(Button) findViewById(R.id.enviar);

         nombre.setText(sharedPreferences.getString("Nombre", " "));
         numero.setText(sharedPreferences.getString("Numero", " "));

    }

    public void Actualizar(View view)
    {

        if(!nombre.getText().toString().isEmpty() && !numero.getText().toString().isEmpty() ){
            SharedPreferences.Editor editorConfig = sharedPreferences.edit();
            editorConfig.putString("Nombre", nombre.getText().toString());
            editorConfig.putString("Numero", numero.getText().toString());

            editorConfig.commit();

            Intent intent= new Intent (RegistrarPropietarioFT.this, MainActivityFT.class);
            startActivity(intent);
            finish();
        }else
            {
                Toast.makeText(RegistrarPropietarioFT.this, "El numero y nombre no pueden ser nulos", Toast.LENGTH_LONG).show();
            }


    }

}