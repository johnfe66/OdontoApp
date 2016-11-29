package com.johnfe.odontoapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroOdontologoActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText txtNombre;
    private EditText txtEmail;
    private EditText txtConfirmarEmail;
    private EditText txtPassword;
    private EditText txtTelefono;

    private Button btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtConfirmarEmail= (EditText) findViewById(R.id.txtConfirmarEmail);
        txtEmail=(EditText) findViewById(R.id.txtEmail);
        txtNombre=(EditText) findViewById(R.id.txtNombre);
        txtPassword=(EditText) findViewById(R.id.txtPassword);
        txtTelefono= (EditText) findViewById(R.id.txtTelefono);
        btnRegistrar= (Button) findViewById(R.id.btnRegistrarRegistro);

        mAuth= FirebaseAuth.getInstance();
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

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(txtEmail.getText().toString().trim().equals(txtConfirmarEmail.getText().toString().trim())){
                    mAuth.createUserWithEmailAndPassword(txtEmail.getText().toString().trim(), txtPassword.getText().toString().trim())
                            .addOnCompleteListener(RegistroOdontologoActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        Toast.makeText(RegistroOdontologoActivity.this, "Registro Fallido :"+task.getException().getMessage(),
                                                Toast.LENGTH_SHORT).show();
                                    }else{

                                        Toast.makeText(RegistroOdontologoActivity.this, "Registro Exitoso :",
                                                Toast.LENGTH_SHORT).show();
                                        mAuth.getCurrentUser().sendEmailVerification()
                                                .addOnCompleteListener(RegistroOdontologoActivity.this, new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        if(!task.isSuccessful()){
                                                            Toast.makeText(RegistroOdontologoActivity.this, "Error al enviar email. "+task.getException().getMessage(),
                                                                    Toast.LENGTH_SHORT).show();
                                                            System.out.println(task.getException().getMessage());
                                                        }else{

                                                            Toast.makeText(RegistroOdontologoActivity.this, "Recuerde validar su email validar su email",
                                                                    Toast.LENGTH_SHORT).show();

                                                        }
                                                    }
                                                });

                                        UserProfileChangeRequest usuario = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(txtNombre.getText().toString().trim())
                                                //.setPhotoUri(Uri.parse("https://fbcdn-sphotos-e-a.akamaihd.net/hphotos-ak-xaf1/v/t1.0-9/30382_10151143006550458_1277185577_n.jpg?oh=75fd5ad8033c23b7deb3f30fbec965c1&oe=58CC7890&__gda__=1490377027_e3d19a221bbcaded909296e7fab737fe"))
                                                .build();

                                        mAuth.getCurrentUser().updateProfile(usuario);

                                        FirebaseDatabase database = FirebaseDatabase.getInstance();
                                        DatabaseReference usuariosRef = database.getReference("odontologos").child(mAuth.getCurrentUser().getUid());


                                        usuariosRef.child("nombre").setValue(txtNombre.getText().toString().trim());
                                        usuariosRef.child("email").setValue(txtEmail.getText().toString().trim());
                                        usuariosRef.child("telefono").setValue(txtTelefono.getText().toString().trim());
                                        usuariosRef.child("uid").setValue(mAuth.getCurrentUser().getUid());


                                        txtEmail.setText("");
                                        txtPassword.setText("");
                                        txtTelefono.setText("");
                                        txtNombre.setText("");
                                        txtConfirmarEmail.setText("");
                                        Intent intent = new Intent(RegistroOdontologoActivity.this,RegistroPacienteActivity.class);
                                        startActivity(intent);

                                    }

                                    // ...
                                }
                            });
                }

            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
}