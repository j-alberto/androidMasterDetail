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
import com.jar.recyclerview.presenter.IRecyclerViewFragmentPresenter;
import com.jar.recyclerview.presenter.RecyclerViewFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainRecyclerViewFragment extends Fragment implements IRecyclerWiewFragmentView{


    private List<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter fragmentPresenter;

    public MainRecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_recycler_view, container, false);
        rvContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        fragmentPresenter = new RecyclerViewFragmentPresenter(this, getContext());
        return v;
    }


    @Override
    public void createVerticalLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdapter createAdapter(List<Contacto> contactos) {
        return new ContactoAdapter(contactos);//getActivity()???

    }

    @Override
    public void initAdapterRecyclerView(ContactoAdapter contactoAdapter) {
        rvContactos.setAdapter(contactoAdapter);
    }
}
