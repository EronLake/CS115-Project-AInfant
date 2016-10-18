package com.example.group.project_ainfant;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    DatabaseHelper myDb;
    EditText input;
    Button buttonAddData, buttonViewAll;


    /** called when activity is first created */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        input = (EditText)findViewById(R.id.inputText);
        buttonAddData = (Button)findViewById(R.id.button_add);
        buttonViewAll = (Button) findViewById(R.id.view_all);
        addData();
        viewAll();
    }

    //change so that the onClickListener is defined in activity_main.xml
    public void addData() {
        buttonAddData.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = myDb.insertData(input.getText().toString());
                    if(isInserted =true)
                        Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        );
    }

    //change so that the onClickListener is defined in activity_main.xml
    public void viewAll() {
        buttonViewAll.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Cursor res = myDb.getAllData();
                    if(res.getCount() == 0) {
                        // show message
                        showMessage("Error","Nothing found");
                        return;
                    }

                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        buffer.append("Id :"+ res.getString(0)+"\n");
                        buffer.append("Input :"+ res.getString(1)+"\n");
                    }

                    // Show all data
                    showMessage("Data",buffer.toString());
                }
            }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private TextView output;

    public void buttonOnClick(View v){
        Button button = (Button) v;
        input = (EditText) findViewById(R.id.inputText);
        output = (TextView) findViewById(R.id.outputText);
        output.setText(input.getText());
    }
}


