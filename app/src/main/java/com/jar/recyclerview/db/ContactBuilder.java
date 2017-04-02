package com.jar.recyclerview.db;

import android.content.ContentValues;
import android.content.Context;

import com.jar.recyclerview.R;
import com.jar.recyclerview.pojo.Contacto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarojas on 1/04/17.
 */

public class ContactBuilder {

    private static final int A_LIKE = 1;
    private Context context;

    public ContactBuilder(Context context) {
        this.context = context;
    }

    public List<Contacto> findContacts() { //obtener datos
        List<Contacto> contactos = new ArrayList<>();
        DBHelper dbHelper = new DBHelper(context);
        dbHelper.initContacts();

        return dbHelper.findAllContacts();
    }

    public void doLikeContact(Contacto contact) {
        DBHelper dbHelper = new DBHelper(context);
        ContentValues cv = new ContentValues();
        cv.put(DBConstants.CLIKE_CONTACT_ID, contact.getId());
        cv.put(DBConstants.CLIKE_COUNT, A_LIKE);

        dbHelper.insertContactLikes(cv);

    }

    public int countLikesForContact(Contacto contact) {
        DBHelper dbHelper = new DBHelper(context);
        return dbHelper.findLikesByContact(contact);
    }
}
