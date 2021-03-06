package com.example.a2parcial_ft18i04001.adapterFT;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2parcial_ft18i04001.NuecoContactoFT;
import com.example.a2parcial_ft18i04001.R;
import com.example.a2parcial_ft18i04001.daoFT.ContactoFTDAOImpRoom;
import com.example.a2parcial_ft18i04001.modelFT.ContactoFT;

import com.example.a2parcial_ft18i04001.daoFT.ContactoFTDAO;


import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ContactoFTadapter extends RecyclerView.Adapter<ContactoFTadapter.ViewHolder>{
    List<ContactoFT> contactos;
    Context context;
    ContactoFTDAO dao;


    @NotNull
    @Override
    public ContactoFTadapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto,parent,false);
        ViewHolder vh = new ViewHolder(v, context);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ContactoFTadapter.ViewHolder holder, int position) {
        ContactoFT p = contactos.get(position);
        holder.tvId.setText(""+p.getId());
        holder.tvNombre.setText(p.getNombre());
        holder.tvNumero.setText(p.getNumero());
        holder.tvPropietario.setText(p.getPropietario());

        holder.btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dao.delete(p);
                contactos = dao.getAll();
                notifyDataSetChanged();
                Toast.makeText(context.getApplicationContext(),"ELiminado",Toast.LENGTH_SHORT).show();
            }
        });

        holder.btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NuecoContactoFT.class);
                intent.putExtra("estado",1);
                intent.putExtra("contacto", p);
                intent.putExtra("numero", p);
                intent.putExtra("propietario", p);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView tvId, tvNombre, tvNumero, tvPropietario;
        private Button btnModificar, btnEliminar;
        private Context context;

        public  ViewHolder(View view,Context context){
            super(view);
            tvId=(TextView) view.findViewById(R.id.txtId);
            tvNombre=(TextView) view.findViewById(R.id.txtNombre);
            tvNumero=(TextView) view.findViewById(R.id.txtNumero);
            tvPropietario=(TextView) view.findViewById(R.id.txtPropietario);
            btnModificar=(Button) view.findViewById(R.id.btnModificar);

            btnEliminar=(Button) view.findViewById(R.id.btnEliminar);

            this.context=context;

            //enlazando
            //  btnModificar.setOnClickListener(this);
            //  btnEliminar.setOnClickListener(this);
        }


       /* @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btnEliminar:
                        Toast.makeText(view.getContext(),"Tarea: "+txtTarea.getText(),Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btnModificar:
                    Intent intent = new Intent(view.getContext(), NuevaTareaActivity.class);
                    intent.putExtra("estado",1);
                    view.getContext().startActivity(intent);

                    break;

            }
        }*/
    }


    public ContactoFTadapter(List<ContactoFT> contacts, Context context, ContactoFTDAO dao) {
        this.context = context;
        this.contactos = contacts;
        this.dao = dao;
    }





}
