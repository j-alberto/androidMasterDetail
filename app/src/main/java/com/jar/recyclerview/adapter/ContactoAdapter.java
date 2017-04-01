package com.jar.recyclerview.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jar.recyclerview.pojo.Contacto;
import com.jar.recyclerview.DetalleContactoActivity;
import com.jar.recyclerview.R;

import java.util.List;

/**
 * Created by jarojas on 12/03/17.
 */

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>{

    public static final String EXTRA_NAME = "com.jar.recyclerview.name";
    public static final String EXTRA_TELEPHONE = "com.jar.recyclerview.telephone";
    public static final String EXTRA_EMAIL = "com.jar.recyclerview.email";
    public static final String EXTRA_PHOTO_ID = "com.jar.recyclerview.photo_id";

    private List<Contacto> contactos;

    public ContactoAdapter(List<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contact, parent, false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);

        holder.ivFoto.setImageResource(contacto.getFoto());
        holder.tvTelefono.setText(contacto.getTelefono());
        holder.tvNombre.setText(contacto.getNombre());

        holder.ivFoto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), contacto.getNombre(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(v.getContext(), DetalleContactoActivity.class);
                intent.putExtra(EXTRA_NAME,contacto.getNombre());
                intent.putExtra(EXTRA_TELEPHONE, contacto.getTelefono());
                intent.putExtra(EXTRA_EMAIL, contacto.getEmail());
                intent.putExtra(EXTRA_PHOTO_ID, contacto.getFoto());

                v.getContext().startActivity(intent);
            }
        });

        holder.ibLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Diste Meguta a "+ contacto.getNombre(), Toast.LENGTH_LONG);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivFoto;
        private TextView tvNombre;
        private TextView tvTelefono;
        private ImageButton ibLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            ivFoto = (ImageView) itemView.findViewById(R.id.ivPhoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvTelefono = (TextView) itemView.findViewById(R.id.tvTelefono);
            ibLike = (ImageButton) itemView.findViewById(R.id.ibLike);
        }
    }
}
