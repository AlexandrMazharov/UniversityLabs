package com.example.m2;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ReggActivity extends AppCompatActivity {
    private TextView twEmail;
    private TextView twPass1;
    private TextView twPass2;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regg);
        mAuth = FirebaseAuth.getInstance();
        twEmail = (TextView) findViewById(R.id.email_reg);
        twPass1 = (TextView) findViewById(R.id.pass_reg);
        twPass2 = (TextView) findViewById(R.id.pass2_reg);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {


                } else {
                    // User is signed out

                }
                mAuthListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        if (user != null) {
                        } else {
                            // User is signed out
                        }
                    }
                };
            }
        };
    }

    private boolean checkTE() {
        if (twEmail.getText().toString().isEmpty()) return false;
        if (twPass1.getText().toString().isEmpty()) return false;
        if (twPass2.getText().toString().isEmpty()) return false;
        else return true;
    }
    public void OnClickRegistration(View view) {
        if (checkTE()) {
            String email = twEmail.getText().toString();
            String password = twPass1.getText().toString();
            String password2 = twPass2.getText().toString();
            if (password.equals(password2)) {
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ReggActivity.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ReggActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else
                            Toast.makeText(ReggActivity.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Toast.makeText(ReggActivity.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            }
        }
        else{       Toast.makeText(ReggActivity.this, "Заполните все поля", Toast.LENGTH_SHORT).show();}
    }
}


