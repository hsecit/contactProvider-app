package com.example.contactprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Layout;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     ArrayList<String> contacts = new ArrayList<>();
     ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fetchContat_with_provider();


    }
    void fetchContat_with_provider(){
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String[] projection = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};


        ContentResolver resolver= getContentResolver();
        Cursor cursor =resolver.query(uri,projection,null,null,null);

        while (cursor.moveToNext()){
            String nom = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String tel = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts.add(nom+"\n\t\t\t\t"+tel);
        }
        lst = (ListView) findViewById(R.id.listContact);
        lst.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts));
    }
}
