package com.example.group.project_ainfant;

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
import android.util.Log;

import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.ArrayList;
import java.util.List;

import static com.example.group.project_ainfant.R.id.input_text;


public class MainActivity extends ActionBarActivity {
    SyntaxCheck s;
    DatabaseHelper myDb;
    EditText input;
    TextView output;
    Button buttonAddData, buttonUserInput;


    /** called when activity is first created */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //runs all unit tests on app startup
        Test testRunner = new Test();
        testRunner.runUnitTests();


        myDb = new DatabaseHelper(this);

        input = (EditText)findViewById(input_text);
        buttonUserInput = (Button)findViewById(R.id.button_enter);
        buttonAddData = (Button)findViewById(R.id.button_add);
        addData();
        userInput();


    }


    // function that will allow user to talk to AI
    // need to change so the input goes to parser instead of just echoing

    public void userInput() {
        buttonUserInput.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String sentence = input.getText().toString();

                        if(sentence.equals("")){
                            Toast.makeText(getApplicationContext(), "Please put something in the textbox", Toast.LENGTH_LONG).show();

                        }else{
                            boolean check = false;
                            ArrayList<String> wordsNotAdded = new ArrayList<String>();

                            String[] tok = sentence.split("\\s+");
                            output = (TextView) findViewById(R.id.outputText);
                            String[] structure = new String[tok.length];

                            for (int i = 0; i < structure.length; i++) {
                                if(myDb.ifExists(tok[i])){
                                    structure[i] = myDb.findSpeech(tok[i]);
                                }else{
                                    wordsNotAdded.add(tok[i]);
                                    check = true;
                                }
                            }
                            if(check == true){
                                String wordNotAdded = "";
                                if(wordsNotAdded.size() == 1){
                                    wordNotAdded = wordNotAdded + wordsNotAdded.get(0);
                                }else{
                                    wordNotAdded = wordNotAdded + wordsNotAdded.get(0);
                                    for (int i = 1; i < wordsNotAdded.size(); i++) {
                                        wordNotAdded = wordNotAdded + "," + wordsNotAdded.get(i);
                                    }
                                }
                                if(wordsNotAdded.size() == 1){
                                    wordNotAdded = wordNotAdded + " has not been added to the database";
                                }else{
                                    wordNotAdded = wordNotAdded + " have not been added to the database";
                                }

                                Toast.makeText(getApplicationContext(), wordNotAdded, Toast.LENGTH_LONG).show();

                            }else {

                                String structureString = "";
                                for (int i = 0; i < structure.length; i++) {
                                    structureString = structureString + " " + (structure[i]);
                                }
                                //output.setText("test2: " + structureString);

                                //code that creates word list
                                //create empty list of words
                                List<Word> input_list = new ArrayList<Word>();
                                Word word_constructor = new Word();

                                //input the words with the corresponding type
                                for (int i = 0; i < tok.length; i++) {
                                    input_list.add(word_constructor.constructObjectNoTags(tok[i], structure[i]));
                                    Log.d("structure(i)", structure[i]);
                                }
                                Log.d("length", Integer.toString(input_list.size()));

                                // calls syntax check
                                SyntaxCheck syntax_checker = new SyntaxCheck(input_list);
                                boolean results = syntax_checker.isValidSentence();
                                Log.d("result", Boolean.toString(results));
                                if (results) {
                                    Toast.makeText(getApplicationContext(), "This is a valid sentence.", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(getApplicationContext(), "This is a invalid sentence.", Toast.LENGTH_LONG).show();

                                }
                            }
                        }
                    }
                }
        );
    }


    // checks if input already exists before adding into the database
    public void addData() {
        buttonAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!myDb.ifExists(input.getText().toString())) {
                            //boolean isInserted = myDb.insertData(input.getText().toString());
                            String sentence = input.getText().toString();
                            String [] tok = sentence.split("\\s+");

                            /*
                            for(int i=0;i<tok.length;i++){
                                if(myDb.ifExists(tok[i])==false) {
                                    myDb.insertData(tok[i]);
                                }
                            }
                            */
                            DropDownMenu.sentence = sentence;
                            List<Word> structure = new ArrayList<Word>();
                            Intent drop_menu = new Intent(v.getContext(), DropDownMenu.class);
                            startActivityForResult(drop_menu, 0);
                            DropDownMenu.counter = 0;



                        } else {
                            showMessage("Error", "Already in database");
                        }

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

/*    private TextView output;
    public void buttonOnClick(View v){
        Button button = (Button) v;
        input = (EditText) findViewById(R.id.inputText);
        output = (TextView) findViewById(R.id.outputText);
        output.setText(input.getText());
        validateInput(tokenize(input.getText().toString().trim()));
    }*/






}


