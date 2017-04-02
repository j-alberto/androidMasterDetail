package com.jar.recyclerview.fragment;

import com.jar.recyclerview.adapter.ContactoAdapter;
import com.jar.recyclerview.pojo.Contacto;

import java.util.List;

/**
 * Created by jarojas on 1/04/17.
 */

public interface IRecyclerWiewFragmentView {
    void createVerticalLayout();

    ContactoAdapter createAdapter(List<Contacto> contactoList);

    void initAdapterRecyclerView(ContactoAdapter contactoAdapter);
}
