package com.johnfe.odontoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.annotation.NonNull;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText email;
    private EditText password;
    private Button btnEntrar;
    private Button btnRegistro;
    private Button btnRecordarPsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email= (EditText) findViewById(R.id.txtEmail);
        password= (EditText) findViewById(R.id.txtPassword);
        btnEntrar= (Button) findViewById(R.id.btnEntrar);
        btnRegistro= (Button) findViewById(R.id.btnRegistroLogin);
        btnRecordarPsw= (Button) findViewById(R.id.btnContrasena);

        auth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("LoginActivity", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("LoginActivity", "onAuthStateChanged:signed_out");
                }
            }
        };

        btnRecordarPsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().trim().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Debe ingresar un Email valido en la caja de texto Email",
                            Toast.LENGTH_SHORT).show();
                }else {
                    auth.sendPasswordResetEmail(email.getText().toString().trim())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Se envio un link de Reestablecer contraseña a su email",
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Error de reestablecer contraseña:" + task.getException().getMessage(),
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this,RegistroOdontologoActivity.class);
                startActivity(intent);
            }
        });
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signInWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString().trim())
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("Inicio Sesion", "signInWithEmail:onComplete:" + task.isSuccessful());

                                if (!task.isSuccessful()) {

                                    if(task.getException().getMessage().equals("There is no user record corresponding to this identifier. The user may have been deleted.")){

                                        System.out.println("Usuario no existe");
                                        Toast.makeText(LoginActivity.this, "Inicio de sesion Fallida: Usuario no existe... registrese por favor",
                                                Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, RegistroOdontologoActivity.class);
                                        startActivity(intent);
                                    }

                                }else{

                                    // if(auth.getCurrentUser().isEmailVerified()){

                                        /**/
                                    Intent intent = new Intent(LoginActivity.this, RegistroPacienteActivity.class);
                                    startActivity(intent);
                                    //}else{
                                    //  Toast.makeText(LoginActivity.this, "Debe Validar Email",
                                    //        Toast.LENGTH_SHORT).show();
                                    // }


                                }

                            }
                        });

            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            auth.removeAuthStateListener(mAuthListener);
        }
    }
}

