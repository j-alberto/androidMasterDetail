package com.jar.recyclerview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetalleContactoActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private ImageView ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        initActionBar();

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        ivFoto = (ImageView) findViewById(R.id.ivPhoto);

        tvEmail.setText( getIntent().getStringExtra(ContactoAdapter.EXTRA_EMAIL));
        tvNombre.setText( getIntent().getStringExtra(ContactoAdapter.EXTRA_NAME));
        tvTelefono.setText( getIntent().getStringExtra(ContactoAdapter.EXTRA_TELEPHONE));
        ivFoto.setImageResource(getIntent().getIntExtra(ContactoAdapter.EXTRA_PHOTO_ID,0));
    }

    private void initActionBar() {
        Toolbar tb = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(tb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
