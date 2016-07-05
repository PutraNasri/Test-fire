package es.esy.kinketkuena.test_fire;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.AuthData;

import java.util.Map;



public class signup extends Activity implements View.OnClickListener {




    private EditText mEmailField;
    private EditText mPasswordField;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mEmailField = (EditText) findViewById(R.id.field_email);
        mPasswordField = (EditText) findViewById(R.id.field_password);

        findViewById(R.id.email_create_account_button).setOnClickListener(this);


    }





    private void createAccount(String email, String password) {

        Firebase ref = new Firebase("https://test-c5f96.firebaseio.com");

        ref.createUser(email, password,new Firebase.ValueResultHandler<Map<String, Object>>() {

            @Override
            public void onSuccess(Map<String, Object> result) {
                System.out.println("Successfully created user account with uid: " + result.get("uid"));
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                // there was an error]
                Toast.makeText(getApplicationContext(), "Fail",
                        Toast.LENGTH_LONG).show();
            }
        });

    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.email_create_account_button:
                createAccount(mEmailField.getText().toString(), mPasswordField.getText().toString());
                break;
        }
    }
}