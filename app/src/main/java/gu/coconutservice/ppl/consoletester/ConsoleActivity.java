package gu.coconutservice.ppl.consoletester;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleActivity extends AppCompatActivity {

    String username;
    String password;
    String[] listViewItems_STRING;// = {"Bacon", "Eggs", "Potatos", "Waffles", "More", "Food", "Names", "Because", "Scrolling", "Might", "Be", "An", "Issue"};
    List<String> listViewItems_LIST;
    ArrayAdapter<String> listAdapter;
    ListView listView;
    Button submitButton;
    EditText inputBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_console);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            username = getIntent().getStringExtra("USERNAME");
            password = getIntent().getStringExtra("PASSWORD");
            // create a new String[] array
            listViewItems_STRING = new String[] {"Got login info"}; //"Eggs", "Potatos", "Waffles", "More", "Food", "Names", "Because", "Scrolling", "Might", "Be", "An", "Issue"
            // create a list from the String[] array
            listViewItems_LIST = new ArrayList<String>(Arrays.asList(listViewItems_STRING));
            // create an ArrayAdapter from the list
            listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listViewItems_LIST);
            listView = (ListView) findViewById(R.id.listView);
            listViewItems_LIST.add("Username: " + username);
            listViewItems_LIST.add("Password: " + password);
            listView.setAdapter(listAdapter);
            listViewItems_LIST.add("Now we'll attempt to start a new thread...");
            
        } else {
            // do nothing
        }

        submitButton = (Button)findViewById(R.id.submitButton);
        inputBar = (EditText)findViewById(R.id.editText);
        submitButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                listViewItems_LIST.add(inputBar.getText().toString());
                listAdapter.notifyDataSetChanged();
                listView.setSelection(listAdapter.getCount() - 1);
                inputBar.setText("");
            }
        });

    }
}

//listView.setSelection(listAdapter.getCount() - 1);