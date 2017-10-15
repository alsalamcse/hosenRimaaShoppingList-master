package aghacom.rimaa.rimaashoppinglist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etRePassword;
    private EditText etPhone;
    private Button btnSave;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etName= (EditText) findViewById(R.id.etName);
        etEmail= (EditText) findViewById(R.id.etEmail);
        etPassword= (EditText) findViewById(R.id.etPassword);
        etRePassword= (EditText) findViewById(R.id.etRePassword);
        etPhone= (EditText) findViewById(R.id.etPhone);
        btnSave= (Button) findViewById(R.id.btnSave);

        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();

        auth = FirebaseAuth.getInstance();
        firebaseUser =auth.getCurrentUser();
        if (firebaseUser == null) {
            //not signed in, launch the sign in activity
            startActivity(new Intent(this, LogInActivity.class));
            finish();
            return;
        }else {
            String userName = firebaseUser.getDisplayName();
            if (firebaseUser.getPhotoUrl()!= null){
                String photoUrl = firebaseUser.getPhotoUrl().toString();
            }
        }

    }

private void createAccount(String email , String passw)
{
    auth.createUserWithEmailAndPassword(email,passw).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful())
            {
                Toast.makeText(SignUpActivity.this,"Authentication Successful",Toast.LENGTH_SHORT.());
                finish();
            }
            else
​{
                Toast.makeText(SignUpActivity.this, "Authentication failed."​+task.getException().getMessage(),
                        LENGTH_SHORT​).show();
                task.getException().printStackTrace();
            }
        }
    });
}

    private void show() {
    }

    private class LENGTH_SHORT​ {
    }
}
    })
}

    @Override
    public void onClick(View view) {

    }
}
