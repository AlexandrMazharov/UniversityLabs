package com.example.m2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.m2.DBHelper.KEY_ID;
import static com.example.m2.DBHelper.TABLE_NAME;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    //для отображения карточек
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<RecyclerItem> listItems;
    //для черновиков
    private RecyclerView recyclerViewDraft;
    private MyAdapter adapterDraft;
    private List<RecyclerItem> getListItemsDraft;

    ///
    FloatingActionButton button_add_r;

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private String userID;

    private List<Request> ListRequest;
    private List<String> listRe;

    private ListView mListView;

    DBHelper dbHelper; //for bd

    Request r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // для карточек
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //для черновиков
        recyclerViewDraft = findViewById(R.id.recyclerViewDraft);
        recyclerViewDraft.setHasFixedSize(true);
        recyclerViewDraft.setLayoutManager(new LinearLayoutManager(this));

        // для БД sqlite
        dbHelper = new DBHelper(this);
        //mListView = (ListView) findViewById(R.id.listview);

        button_add_r = (FloatingActionButton) findViewById(R.id.button_add_r);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                   showDataFromFirebase(dataSnapshot);
              showDataFromBd();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void showDataFromFirebase(DataSnapshot dataSnapshot) {
        listItems = new ArrayList<>();
        for (DataSnapshot ds : dataSnapshot.child("request").getChildren()) {
            Request r = new Request();
            r.setName_work(ds.getValue(Request.class).getName_work());
            r.setFio(ds.getValue(Request.class).getFio());
            r.setPhone(ds.getValue(Request.class).getPhone());
            r.setEmail(ds.getValue(Request.class).getEmail());
            r.setUrl_file(ds.getValue(Request.class).getUrl_file());
            r.setUser_id(ds.getValue(Request.class).getUser_id());
            r.setStatus(ds.getValue(Request.class).getStatus());
            listItems.add(new RecyclerItem(r.getName_work(),
                    r.getFio(),
                    r.getPhone(),
                    r.getEmail(),
                    r.getUrl_file(),
                    r.getStatus(),
                    r.getUser_id()));
        }
        adapter = new MyAdapter(listItems, this);
        recyclerView.setAdapter(adapter);
    }


    private void showDataFromBd() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        r = new Request();


        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        //Cursor cursor = database.rawQuery("select * from  + "where"+TABLE_NAME.KEY_USER_ID+"="+userID,null);//query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.getCount() != -1) {
            if (cursor.moveToFirst()) {
                int id_index = cursor.getColumnIndex(dbHelper.KEY_ID);
                int name_work_index = cursor.getColumnIndex(dbHelper.KEY_NAME_WORK);
                int fio_index = cursor.getColumnIndex(dbHelper.KEY_FIO);
                int email_index = cursor.getColumnIndex(dbHelper.KEY_EMAIL);
                int tel_index = cursor.getColumnIndex(dbHelper.KEY_PHONE);
                int file_uri_index = cursor.getColumnIndex(dbHelper.KEY_FILE_URI);
                int status_index = cursor.getColumnIndex(dbHelper.KEY_STATUS);
                int user_id_index = cursor.getColumnIndex(dbHelper.KEY_USER_ID);
                do {
                    String id = cursor.getString(user_id_index);
                    if (id.equals(userID)) {
                        Request r = new Request();
                        r.setId_request(cursor.getInt(id_index));
                        r.setName_work(cursor.getString(name_work_index));
                        r.setFio(cursor.getString(fio_index));
                        r.setPhone(cursor.getString(tel_index));
                        r.setEmail(cursor.getString(email_index));
                        r.setUrl_file(cursor.getString(file_uri_index));
                        r.setStatus(cursor.getString(status_index));
                        listItems.add(new RecyclerItem(
                                r.getName_work(),
                                r.getFio(),
                                r.getPhone(),
                                r.getEmail(),
                                r.getUrl_file(),
                                r.getStatus(),
                                r.getUser_id()));
                    } else Log.d("mLog ", "0 rows with id = id");

                }
                while (cursor.moveToNext());
            } else
                Log.d("mLog ", "0 rows");
        }
        else    Log.d("mLog ", "курсор пустой");
        cursor.close();
        dbHelper.close();


        adapterDraft = new MyAdapter(listItems, this);
        recyclerViewDraft.setAdapter(adapter);

    }

    private String getStatusRu(String stengl) {
        if (stengl == "") return "Отправлено";
        else if (stengl == "") return "Черновик";
        else return "Ошибка статуса";

    }



    @Override
    public void onStart() {
        super.onStart();
        // mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }


    /**
     * customizable toast
     *
     * @param message
     */
    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }

    public void OcCkickAdd(View view) {

        Intent intent = new Intent(ListActivity.this, AddRequestActivity.class);
        startActivity(intent);
    }

    public void openMyMaps(View view) {
        Intent intent = new Intent(ListActivity.this, MapsActivity.class);
        startActivity(intent);
    }
}