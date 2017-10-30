package aghacom.rimaa.rimaashoppinglist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener
{
    private EditText etEmail;
    private EditText etPassw;
    private Button btnIn;
    private Button btnUp;
    private Button btnForget;
    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassw = (EditText) findViewById(R.id.etPassw);
        btnIn=(Button) findViewById(R.id.btnIn);
        btnIn.setOnClickListener(this);
        btnUp=(Button) findViewById(R.id.btnUp);
        btnUp.setOnClickListener(this);

    }


    public void dataHandler(){
        String name=etEmail.getText().toString();
        String passw=etPassw.getText().toString();
        signIn(name,passw);
    }


        private void signIn(String email, String passw) {
        auth.signInWithEmailAndPassword(email,passw).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(LogInActivity.this, "signIn Successful.", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LogInActivity.this,MainListActivity.class);
                  startActivity(intent);
                  finish();
                }
                else
                {
                    Toast.makeText(LogInActivity.this, "signIn failed."+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }


    @Override
    public void onClick(View view) {
        if (view==btnIn){
            dataHandler();

    }

    if (view==btnUp){
        Intent i = new Intent(this,SignUpActivity.class);
        startActivity(i);
    }
}



    }

