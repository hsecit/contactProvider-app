# contactProvider-app

## screen of the result
![alt text](https://github.com/hsecit/contactProvider-app/blob/master/ressources_rapport/ezgif.com-optimize.gif "test the app")
## code
```java
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
            contacts.add(nom+"\n"+tel);
        }
        lst = (ListView) findViewById(R.id.listContact);
        lst.setAdapter(new ArrayAdapter<>(this, R.layout.card_contact,R.id.info_contact,contacts));
    }
}
```
