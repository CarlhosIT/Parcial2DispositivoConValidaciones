package com.example.a2parcial_ft18i04001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a2parcial_ft18i04001.modelFT.ContactoFT;
import com.example.a2parcial_ft18i04001.daoFT.ContactoFTDAO;
import com.example.a2parcial_ft18i04001.daoFT.ContactoFTDAOImpRoom;


public class NuecoContactoFT extends AppCompatActivity {

    TextView txtNombre,txtNumero;
    Button btnRegresar;
    Button btnGuardar;
    public static SharedPreferences sharedPreferences;

    ContactoFTDAO dao;
    ContactoFT Contacto;
    String propietario;
    int estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueco_contacto_ft);
        sharedPreferences = getSharedPreferences("Configuracion", MODE_PRIVATE);
        estado=0;

        //instancias a los componentes graficos
        this.txtNombre=(TextView) findViewById(R.id.txtNOMBRE);
        this.txtNumero=(TextView) findViewById(R.id.txtNUMERO);
        this.btnRegresar=(Button) findViewById(R.id.btnRegresar);
        this.btnGuardar=(Button) findViewById(R.id.btnGuardarTarea);
        propietario = sharedPreferences.getString("Nombre", "No se obtuvo propietario");


        Intent intent =new Intent(this,MainActivityFT.class);

        dao=new ContactoFTDAOImpRoom(getApplicationContext());

        cargar();

        //eventos
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
                startActivity(intent);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(estado==0){
                    guardar();
                }else{
                    actualizar();

                }

                reset();
                startActivity(intent);
            }
        });

    }

    void  guardar(){
        Contacto=new ContactoFT();
        //tarea.setId(0);

        Contacto.setNombre(txtNombre.getText().toString());
        Contacto.setNumero(txtNumero.getText().toString());
        Contacto.setPropietario(propietario);
        dao.save(Contacto);

    }

    void actualizar(){
        Contacto.setNombre(txtNombre.getText().toString());
        Contacto.setNumero(txtNumero.getText().toString());

        dao.update(Contacto);
    }

    void  reset(){
        txtNombre.setText("");
        txtNumero.setText("");
        btnGuardar.setText("Guardar");
    }

    void cargar(){
        Intent intent;
        try {
            intent=getIntent();
            Contacto=(ContactoFT) intent.getSerializableExtra("contacto");
            estado=intent.getIntExtra("estado",0);
            txtNombre.setText(Contacto.getNombre());
            txtNumero.setText(Contacto.getNumero());
            btnGuardar.setText("Actualizar");

        }catch (Exception e){
            estado=0;

        }
    }



}