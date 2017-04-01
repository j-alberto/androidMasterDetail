package com.jar.recyclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jar.recyclerview.R;
import com.jar.recyclerview.adapter.ContactoAdapter;
import com.jar.recyclerview.pojo.Contacto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainRecyclerViewFragment extends Fragment {


    private List<Contacto> contactos;
    private RecyclerView rvContactos;

    public MainRecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_recycler_view, container, false);
        initContacts();

        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvContactos.setLayoutManager(llm);

        initAdapter();

        return v;
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
