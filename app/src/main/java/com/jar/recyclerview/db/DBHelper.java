package com.jar.recyclerview.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.jar.recyclerview.R;
import com.jar.recyclerview.pojo.Contacto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jarojas on 1/04/17.
 */

public class DBHelper extends SQLiteOpenHelper {

    private Context context;


    public DBHelper(Context context) {
        super(context, DBConstants.DB_NAME, null, DBConstants.DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DBConstants.QUERY_CREATE_CONTACT);
        db.execSQL(DBConstants.QUERY_CREATE_CONTACT_LIKE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBConstants.QUERY_DROPIF_CONTACT);
        db.execSQL(DBConstants.QUERY_DROPIF_CONTACT_LIKE);
        onCreate(db);
    }

    public List<Contacto> findAllContacts() {
        List<Contacto> contactos = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery(DBConstants.QUERY_CONTACTS_FIND_ALL, null);



        while (cur.moveToNext()) {
            Contacto c = new Contacto(
                    cur.getInt(0),
                    cur.getString(1),
                    cur.getString(2),
                    cur.getString(3),
                    cur.getInt(4),
                    0
            );
            int likes = findLikesByContact(c);
            c.setLikes(likes);
            contactos.add(c);
        }
        return contactos;
    }

    public void insertContact(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DBConstants.TABLE_CONTACT, null, contentValues);
        db.close();
    }

    public void initContacts() {
        ContentValues cv = new ContentValues();
        cv.put(DBConstants.CONTACT_NAME,"pke");
        cv.put(DBConstants.CONTACT_PHONE,"31375297");
        cv.put(DBConstants.CONTACT_EMAIL,"pkepke@pke.com");
        cv.put(DBConstants.CONTACT_PHOTO, R.drawable.chococat);
        insertContact(cv);
        cv.clear();

        cv.put(DBConstants.CONTACT_NAME,"Garrito");
        cv.put(DBConstants.CONTACT_PHONE,"99999999");
        cv.put(DBConstants.CONTACT_EMAIL,"garrito@pke.com");
        cv.put(DBConstants.CONTACT_PHOTO, R.drawable.android2);
        insertContact(cv);
        cv.clear();

        cv.put(DBConstants.CONTACT_NAME,"Shredder");
        cv.put(DBConstants.CONTACT_PHONE,"31369845");
        cv.put(DBConstants.CONTACT_EMAIL,"sh.tonto@pke.com");
        cv.put(DBConstants.CONTACT_PHOTO, R.drawable.android3);
        insertContact(cv);
        cv.clear();

        cv.put(DBConstants.CONTACT_NAME,"Chocky");
        cv.put(DBConstants.CONTACT_PHONE,"77777777");
        cv.put(DBConstants.CONTACT_EMAIL,"chocol@pke.com");
        cv.put(DBConstants.CONTACT_PHOTO, R.drawable.android);
        insertContact(cv);

    }

    public void insertContactLikes(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(DBConstants.TABLE_CONTACT_LIKE, null, contentValues);
        db.close();
    }

    public int findLikesByContact(Contacto contact) {
        int likes = 0;

        String query = "select count(1) from "+DBConstants.TABLE_CONTACT_LIKE+" where "+DBConstants.CLIKE_CONTACT_ID +" = " +contact.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery(query,null);

        if(cur.moveToNext()) {
            likes = cur.getInt(0);
        }
        return likes;
    }

}
