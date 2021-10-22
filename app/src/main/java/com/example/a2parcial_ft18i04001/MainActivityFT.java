package com.example.a2parcial_ft18i04001;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a2parcial_ft18i04001.adapterFT.ContactoFTadapter;
import com.example.a2parcial_ft18i04001.daoFT.ContactoFTDAO;
import com.example.a2parcial_ft18i04001.daoFT.ContactoFTDAOImpRoom;
import com.example.a2parcial_ft18i04001.modelFT.ContactoFT;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivityFT extends AppCompatActivity {

    String nombre= null;
    String numero=null;
    TextView Bienvenida;
    Button Actualziar;

    FloatingActionButton btnNuevaTarea;
    RecyclerView rwTareas;
    List<ContactoFT> tareas;


    ContactoFTDAO dao;

    public static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            sharedPreferences = getSharedPreferences("Configuracion", MODE_PRIVATE);
            nombre= (sharedPreferences.getString("Nombre", null));
            numero=(sharedPreferences.getString("Numero", null));
            if(nombre==null && numero== null){

                Intent intent= new Intent (this, RegistrarPropietarioFT.class);
                startActivity(intent);

            }else{
                Bienvenida=(TextView) findViewById(R.id.Bienvenida);
                Bienvenida.setText("Bienvenido "+nombre);


                dao=new ContactoFTDAOImpRoom(getApplicationContext());

                //instancias a componentes graficos
                this.btnNuevaTarea=(FloatingActionButton) findViewById(R.id.btnNuevaTarea);
                this.rwTareas=(RecyclerView) findViewById(R.id.rwTareas);

                Intent intent=new Intent(this, NuecoContactoFT.class);

                //eventos
                this.btnNuevaTarea.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(intent);
                    }
                });

                //cargando datos
                this.cargarDatos();

                //configurando recyclerview
                //instancia del adaptador
                ContactoFTadapter adapter=new ContactoFTadapter(this.tareas,getApplicationContext(),dao);

                rwTareas.setLayoutManager(new LinearLayoutManager(this));

                //config del adaptador
                rwTareas.setAdapter(adapter);


            }
        }catch (Exception e)
        {
            Toast.makeText(this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    void  cargarDatos(){
        tareas=new ArrayList<ContactoFT>();
        tareas=dao.getAll();
    }


    public  void IrActualizar(View view)
    {
        Intent intent= new Intent (this, RegistrarPropietarioFT.class);
        startActivity(intent);
    }

}