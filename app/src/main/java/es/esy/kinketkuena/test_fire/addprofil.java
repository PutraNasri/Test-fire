package es.esy.kinketkuena.test_fire;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class addprofil extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener authListener;

    private EditText namalField;
    private Button save;

    private ProgressBar progressBar;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addprofil);

        auth = FirebaseAuth.getInstance();
        namalField = (EditText) findViewById(R.id.nama);
        save = (Button) findViewById(R.id.btnsave);
        progressBar = (ProgressBar) findViewById(R.id.progressBar3);
    }

    public void Save (View view){

        String Nama = namalField.getText().toString().trim();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(Nama)
                .build();

        user.updateProfile(profileUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                           // Log.d(TAG, "User profile updated.");

                            startActivity(new Intent(addprofil.this, MainActivity.class));
                            finish();

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
