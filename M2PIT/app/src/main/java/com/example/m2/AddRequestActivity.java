package com.example.m2;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.Serializable;

import static com.example.m2.DBHelper.TABLE_NAME;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class AddRequestActivity extends AppCompatActivity implements Serializable, LocationListener {

    private EditText fio;
    private EditText work_name;
    private EditText tel;
    private EditText email;
    private FirebaseAuth mAuth;


    private Long maxid;
    Button inDraft;
    Button selectFile, uploadFile;
    TextView notification;
    Uri pdfUri;
    Request r;
    FirebaseStorage storage;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    DBHelper dbHelper;
    DatabaseReference refff;
    String userID;
    String lathitude;
    String longitude;

    LocationManager locationManager;
    private static final String TAG = AddRequestActivity.class.getName();

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);

        //LocationListener loclis;
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();
        r = new Request();
        checkPermission();
        dbHelper = new DBHelper(this);

        refff = FirebaseDatabase.getInstance().getReference().child("request");
        refff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                    maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        selectFile = findViewById(R.id.button_selectFile);

        uploadFile = findViewById(R.id.buttonUploadFile);
        inDraft = findViewById(R.id.button_in_draft);
        notification = findViewById(R.id.notification);
        fio = findViewById(R.id.editText_fio);
        tel = findViewById(R.id.editText_tel);
        email = findViewById(R.id.editText_email);
        work_name = findViewById(R.id.editText_wn);

        dbHelper = new DBHelper(this);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        selectFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(AddRequestActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    selectPdf();
                } else
                    ActivityCompat.requestPermissions(AddRequestActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 9);
            }
        });

        uploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pdfUri != null) {
                    if (checkTE()) {
                        Toast.makeText(AddRequestActivity.this, "Загружаю", Toast.LENGTH_SHORT).show();
                        uploadFile(pdfUri);
                        System.out.println(pdfUri.toString());
                    } else
                        Toast.makeText(AddRequestActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(AddRequestActivity.this, "Выбери файл", Toast.LENGTH_SHORT).show();
            }
        });

        inDraft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pdfUri != null) {
                    if (checkTE()) {
                        insertToBd(pdfUri);
                        Toast.makeText(AddRequestActivity.this, "Сохранено", Toast.LENGTH_SHORT).show();

                    } else
                        Toast.makeText(AddRequestActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(AddRequestActivity.this, "Выбери файл", Toast.LENGTH_SHORT).show();
            }
        });
    }
    ///

    ///////
    private void insertToBd(Uri pdfUri) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        String email_str = email.getText().toString();
        String fio_str = fio.getText().toString();
        String name_work_str = work_name.getText().toString();
        String phone_str = tel.getText().toString();
        String uri_file_str = pdfUri.toString();

        contentValues.put(dbHelper.KEY_NAME_WORK, name_work_str);
        contentValues.put(dbHelper.KEY_FIO, fio_str);
        contentValues.put(dbHelper.KEY_PHONE, phone_str);
        contentValues.put(dbHelper.KEY_EMAIL, email_str);
        contentValues.put(dbHelper.KEY_FILE_URI, uri_file_str);
        contentValues.put(dbHelper.KEY_STATUS, "draft");
        contentValues.put(dbHelper.KEY_USER_ID, userID);
        database.insert(DBHelper.TABLE_NAME, null, contentValues);

        Toast.makeText(AddRequestActivity.this, "Успешно!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddRequestActivity.this, ListActivity.class);
        startActivity(intent);


    }

    private boolean checkTE() {

        if (fio.getText().toString().isEmpty()) return false;
        if (work_name.getText().toString().isEmpty()) return false;
        if (tel.getText().toString().isEmpty()) return false;
        if (email.getText().toString().isEmpty()) return false;
        else return true;
    }


    private void uploadFile(final Uri pdfUri) {
        progressDialog = new ProgressDialog(this);

        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Загрузка...");
        progressDialog.setProgress(0);
        progressDialog.show();

        final String fileName = System.currentTimeMillis() + "";
        final StorageReference storageReference = storage.getReference();

        storageReference.child("Uploads").child(fileName).putFile(pdfUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        String url = taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();
                        mAuth = FirebaseAuth.getInstance();
                        FirebaseUser user = mAuth.getCurrentUser();

                        DatabaseReference reference = database.getReference();
                        //Request r = new Request();
                        r.fio = fio.getText().toString();
                        r.email = email.getText().toString();//"email";
                        r.name_work = work_name.getText().toString();//"email";
                        r.phone = tel.getText().toString();//"999";
                        r.url_file = url;//pdfUri.toString();
                        r.status = "shipped";
                        r.user_id = user.getUid();

                        r.lathitude = lathitude;
                        r.longitude = longitude;

//                        reference.child("request").child(String.valueOf(1)).setValue(r).addOnCompleteListener(new OnCompleteListener<Void>() {
                        reference.child("request").child(String.valueOf(maxid + 1)).setValue(r).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(AddRequestActivity.this, "Успешно!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(AddRequestActivity.this, ListActivity.class);
                                    startActivity(intent);
                                } else
                                    Toast.makeText(AddRequestActivity.this, "Ошибка загрузки!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddRequestActivity.this, "Загружен!", Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentProgress = (int) (100 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == 9 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            selectPdf();
        } else
            Toast.makeText(AddRequestActivity.this, "Выберите файл!!!", Toast.LENGTH_SHORT).show();
    }

    private void selectPdf() {
        //
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 86);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 86 && resultCode == RESULT_OK && data != null) {
            pdfUri = data.getData();
            notification.setText("Выбран" + data.getData().getLastPathSegment());
        } else {
            Toast.makeText(AddRequestActivity.this, "Выбери файл!", Toast.LENGTH_SHORT).show();
        }
    }

    public void OnCkickAdd(View view) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        getLocation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }

    private static final int PERMISSION_REQUEST = 1;

    public void getLocation() {


        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST);
        } else {
            //startActivity(); или вызов метода
        }
        try {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 5, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkPermission() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 101);
        }

    }

    @Override
    public void onLocationChanged(Location location) {
        lathitude = String.valueOf(location.getLatitude());
        longitude = String.valueOf(location.getLongitude());

    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {
        //Toast.makeText(AddRequestActivity.this,getString(R.string.tonOnGps),Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Enabled new provider" + provider, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(AddRequestActivity.this, getString(R.string.tonOnGps), Toast.LENGTH_SHORT).show();
    }

    //////////////////

}