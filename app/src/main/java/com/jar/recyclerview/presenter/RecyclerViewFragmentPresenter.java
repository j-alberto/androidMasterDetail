package com.jar.recyclerview.presenter;

import android.content.Context;

import com.jar.recyclerview.db.ContactBuilder;
import com.jar.recyclerview.fragment.IRecyclerWiewFragmentView;
import com.jar.recyclerview.pojo.Contacto;

import java.util.List;

/**
 * Created by jarojas on 1/04/17.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerWiewFragmentView recyclerWiewFragmentView;
    private Context context;
    private List<Contacto> contactos;
    private ContactBuilder contactBuilder;

    public RecyclerViewFragmentPresenter(IRecyclerWiewFragmentView recyclerWiewFragmentView, Context context) {
        this.recyclerWiewFragmentView = recyclerWiewFragmentView;
        this.context = context;
        findContacts();
    }

    @Override
    public void findContacts() { //obtener contactos BD
        contactBuilder = new ContactBuilder(context);
        contactos = contactBuilder.findContacts();
        showContactsRecyclerView();
    }

    @Override
    public void showContactsRecyclerView() {
        recyclerWiewFragmentView.initAdapterRecyclerView(
                recyclerWiewFragmentView.createAdapter(contactos)
        );
        recyclerWiewFragmentView.createVerticalLayout();
    }
}
