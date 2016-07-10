package es.esy.kinketkuena.test_fire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profil extends AppCompatActivity {


    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        final TextView  nama = (TextView) findViewById(R.id.nama);
        final TextView  emaill = (TextView) findViewById(R.id.emaill);
        final TextView  uidd = (TextView) findViewById(R.id.uid);


        auth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            String name = user.getDisplayName();
            String email = user.getEmail();
            String uid    = user.getUid();
            nama.setText(name);
            emaill.setText(email);
            uidd.setText(uid);

        }
    }
}
