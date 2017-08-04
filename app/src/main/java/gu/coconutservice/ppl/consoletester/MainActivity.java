package gu.coconutservice.ppl.consoletester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usernameField;
    EditText passwordField;
    Button loginButton;
    Intent switchToLoginActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameField = (EditText) findViewById(R.id.usernameField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        loginButton = (Button) findViewById(R.id.login_button);
        //switchToLoginActivity = new Intent(this, .class); // can also use getBaseContext() in place of "this"
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                //MainActivity.this.startActivity(switchToLoginActivity);
                // finish(); can kill the activity and prevent user from returning to it
                usernameField.setVisibility(View.GONE);
                passwordField.setVisibility(View.GONE);
                loginButton.setVisibility(View.GONE);
            }
        });
    }
}