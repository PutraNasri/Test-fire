package es.esy.kinketkuena.test_fire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {
private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        Button ok = (Button)findViewById(R.id.buttonok);
        Button bad = (Button)findViewById(R.id.buttonbad);
        final TextView mtext = (TextView) findViewById(R.id.textView);

        mRef = new Firebase("https://test-c5f96.firebaseio.com/condition");

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String newcondition = (String) dataSnapshot.getValue();
                mtext.setText(newcondition);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mRef.setValue("ok");
    }
});

        bad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRef.setValue("bad");
            }
        });
    }
    public void signup(View view){
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }

}
