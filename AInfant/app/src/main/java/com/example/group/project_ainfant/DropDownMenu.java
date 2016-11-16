package com.example.group.project_ainfant;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import com.example.group.project_ainfant.PartsOfSpeech.*;

public class DropDownMenu extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner, spinner2;
    private ArrayList<String> parts_of_speech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down_menu);
        spinner = (Spinner) findViewById(R.id.spin);
        spinner2 = (Spinner) findViewById(R.id.spin2);
        spinner.setOnItemSelectedListener(this);

        // Initial drop down menu items, stored as a String array
        parts_of_speech = new ArrayList<>();
        parts_of_speech.add("Adjective");
        parts_of_speech.add("Adverb");
        parts_of_speech.add("Determiner");
        parts_of_speech.add("Interjection");
        parts_of_speech.add("Noun");
        parts_of_speech.add("Pronoun");
        parts_of_speech.add("Verb");

        // To populate the spinner with a list of choices, you need to specify a SpinnerAdapter in your Activity or Fragment
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, parts_of_speech);
        // Set the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // To Get the selected item:
        // Since the spinner items are stored inside an array
        // we can get the selected item text such as item.get(position)
        String word = spinner.getSelectedItem().toString();
        if ( word.contentEquals("Adjective") ) {
            ArrayList<String> options = new ArrayList<>();

            Adjective adj = new Adjective(word, -1); // Set initial value to null
            options.add("Positive");
            options.add("Negative");
            options.add("Neutral");

            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
            String tag = spinner2.getSelectedItem().toString();

            // Sets Adjective's connotation
            if ( tag.equals("Positive") ) {
                adj.posNegNeu = 0;
            } else if ( tag.equals("Negative")){
                adj.posNegNeu = 1;
            } else if ( tag.equals("Neutral")){
                adj.posNegNeu = 2;
            }
            //adj is the finished adjective
            //CODE FOR ADDING TO DATABASE *** myDB.add(adj);
        }
        if (word.contentEquals("Adverb")) {
            ArrayList<String> options = new ArrayList<>();
            options.add(0, "Positive");
            options.add(1, "Negative");
            options.add(2, "Neutral");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (word.contentEquals("Determiner")) {
            ArrayList<String> options = new ArrayList<>();
            options.add(0, "Plural");
            options.add(1, "Singular");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (word.contentEquals("Interjection")) {
            ArrayList<String> options = new ArrayList<>();
            options.add(0, "Greeting");
            options.add(1, "Exclamation");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (word.contentEquals("Noun")) {
            ArrayList<String> options = new ArrayList<>();
            options.add(0, "Thing");
            options.add(1, "Person");
            options.add(2, "Place");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (word.contentEquals("Pronoun")) {
            ArrayList<String> options = new ArrayList<>();
            options.add(0, "Subject");
            options.add(1, "Object");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (word.contentEquals("Verb")) {
            ArrayList<String> options = new ArrayList<>();
            options.add(0, "Active");
            options.add(1, "Passive");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drop_down_menu, menu);
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


}

