package com.jar.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private List<Contacto> contactos;
    private RecyclerView rvContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initActionBar();
        initContacts();

        rvContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvContactos.setLayoutManager(llm);

        initAdapter();

    }

    private void initActionBar() {
        Toolbar tb = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(tb);
    }

    private void initContacts() {
        contactos = new ArrayList<>();
        contactos.add(new Contacto("pke", "31375297","pkepke@pke.com", R.drawable.chococat));
        contactos.add(new Contacto("Garrito", "99999999","garrito@pke.com", R.drawable.android2));
        contactos.add(new Contacto("Shredder", "31369845","sh.tonto@pke.com", R.drawable.android3));
        contactos.add(new Contacto("Chocky", "77777777","chocol@pke.com", R.drawable.android));
    }

    private void initAdapter() {
        ContactoAdapter adapter = new ContactoAdapter(contactos);
        rvContactos.setAdapter(adapter);
    }
}
