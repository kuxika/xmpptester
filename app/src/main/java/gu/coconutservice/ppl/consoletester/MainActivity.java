package gu.coconutservice.ppl.consoletester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameField;
    EditText passwordField;
    Button loginButton;
    Intent intent_switchTo_ConsoleActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameField = (EditText) findViewById(R.id.usernameField);
        passwordField = (EditText) findViewById(R.id.passwordField);
        loginButton = (Button) findViewById(R.id.login_button);
        intent_switchTo_ConsoleActivity = new Intent(this, ConsoleActivity.class); // can also use getBaseContext() in place of "this"
        //intent_switchTo_ConsoleActivity.putExtra("USERNAME", "admin");
        //intent_switchTo_ConsoleActivity.putExtra("PASSWORD", "idiot212");
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick (View view) {
                //Log.i("appLogs", "geez");
                if (usernameField.getText().toString().trim().length() == 0 || passwordField.getText().toString().trim().length() == 0){
                    Toast badToast = Toast.makeText(getApplicationContext(), "Enter username and password, dimwit.", Toast.LENGTH_LONG);
                    badToast.show();
                    //Log.i("appLogs", usernameField.toString());
                    //intent_switchTo_ConsoleActivity.putExtra("USERNAME", usernameField.getText().toString());
                    //intent_switchTo_ConsoleActivity.putExtra("PASSWORD", passwordField.getText().toString());
                    //MainActivity.this.startActivity(intent_switchTo_ConsoleActivity);
                    //finish();
                }else{
                    //String username = usernameField.getText().toString();
                    //String password = passwordField.getText().toString();
                    //Toast toast = Toast.makeText(getApplicationContext(), "Username: " + username + " Password: " + password, Toast.LENGTH_LONG);
                    //toast.show();
                    intent_switchTo_ConsoleActivity.putExtra("USERNAME", usernameField.getText().toString());
                    intent_switchTo_ConsoleActivity.putExtra("PASSWORD", passwordField.getText().toString());
                    MainActivity.this.startActivity(intent_switchTo_ConsoleActivity);
                }
                // finish(); can kill the activity and prevent user from returning to it
                //usernameField.setVisibility(View.GONE);
                //passwordField.setVisibility(View.GONE);
                //loginButton.setVisibility(View.GONE);
            }
        });
    }
}