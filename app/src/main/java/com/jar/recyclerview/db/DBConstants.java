package com.jar.recyclerview.db;

/**
 * Created by jarojas on 1/04/17.
 */

public class DBConstants {
    public static final String DB_NAME = "contactos";
    public static final int DB_VERSION = 1;
    public static final String TABLE_CONTACT = "contacto";
    public static final String CONTACT_ID = "id";
    public static final String CONTACT_NAME = "name";
    public static final String CONTACT_PHONE = "phone";
    public static final String CONTACT_EMAIL = "email";
    public static final String CONTACT_PHOTO = "photo";

    public static final String TABLE_CONTACT_LIKE = "contacto_likes";
    public static final String CLIKE_ID = "id";
    public static final String CLIKE_CONTACT_ID = "contact_id";
    public static final String CLIKE_COUNT = "likes";

    public static final String QUERY_CREATE_CONTACT = String.format(
            "CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT,%s TEXT,%s TEXT,%s TEXT,%s INTEGER)",
            DBConstants.TABLE_CONTACT, DBConstants.CONTACT_ID, DBConstants.CONTACT_NAME,
            DBConstants.CONTACT_PHONE, DBConstants.CONTACT_EMAIL, DBConstants.CONTACT_PHOTO);
    public static final String QUERY_CREATE_CONTACT_LIKE = String.format("CREATE TABLE %s (" +
                    "%s INTEGER PRIMARY KEY AUTOINCREMENT,%s INTEGER,%s INTEGER" +
                    ",FOREIGN KEY (%s) REFERENCES %s(%s))",
            DBConstants.TABLE_CONTACT_LIKE, DBConstants.CLIKE_ID, DBConstants.CLIKE_CONTACT_ID, DBConstants.CLIKE_COUNT,
            DBConstants.CLIKE_CONTACT_ID, DBConstants.TABLE_CONTACT, DBConstants.CONTACT_ID);

    public static final String QUERY_DROPIF_CONTACT = "drop table if exists "+ TABLE_CONTACT;
    public static final String QUERY_DROPIF_CONTACT_LIKE = "drop table if exists "+ TABLE_CONTACT_LIKE;

    public static final String QUERY_CONTACTS_FIND_ALL = "select * from " + TABLE_CONTACT;
//    public static final String QUERY_CLIKE_FIND_BY_CONTACT = "select * from " + TABLE_CONTACT_LIKE+" where " +CONTACT_ID+" = ";

}
