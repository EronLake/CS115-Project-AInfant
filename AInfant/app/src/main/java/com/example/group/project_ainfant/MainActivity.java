package com.example.group.project_ainfant;

import android.content.DialogInterface;
import android.content.Intent;
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
    // checks if input already exists before adding into the database
    public void addData() {
        buttonAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!myDb.ifExists(input.getText().toString())) {
                            boolean isInserted = myDb.insertData(input.getText().toString());
                            Intent myIntent = new Intent(v.getContext(), DropDownMenu.class);
                            startActivityForResult(myIntent, 0);

                            //showMessage2("What part of speech is that new word?");
                            /*if (isInserted = true)
                                Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();*/
                        } else {
                            showMessage("Error", "Already in database");
                        }
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

    public void showMessage2(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setItems(new CharSequence[]
                        {"button 1", "button 2", "button 3", "button 4", "button 5", "button 6"},
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        switch (which) {
                            case 0:
                                Toast.makeText(MainActivity.this, "Noun", Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this, "Adjective", Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(MainActivity.this, "Adverb", Toast.LENGTH_LONG).show();
                                break;
                            case 3:
                                Toast.makeText(MainActivity.this, "Determiner", Toast.LENGTH_LONG).show();
                                break;
                            case 4:
                                Toast.makeText(MainActivity.this, "Interjection", Toast.LENGTH_LONG).show();
                                break;
                            case 5:
                                Toast.makeText(MainActivity.this, "Pronoun", Toast.LENGTH_LONG).show();
                                break;
                            case 6:
                                Toast.makeText(MainActivity.this, "Verb", Toast.LENGTH_LONG).show();
                        }
                    }
                });
        builder.create().show();
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


