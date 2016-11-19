package com.example.group.project_ainfant;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.group.project_ainfant.PartsOfSpeech.Adjective;
import com.example.group.project_ainfant.PartsOfSpeech.Adverb;
import com.example.group.project_ainfant.PartsOfSpeech.Conjunction;
import com.example.group.project_ainfant.PartsOfSpeech.Determiner;
import com.example.group.project_ainfant.PartsOfSpeech.Interjection;
import com.example.group.project_ainfant.PartsOfSpeech.Noun;
import com.example.group.project_ainfant.PartsOfSpeech.Preposition;
import com.example.group.project_ainfant.PartsOfSpeech.Pronoun;
import com.example.group.project_ainfant.PartsOfSpeech.Verb;



import java.util.ArrayList;

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

        //Select PoS and continue to add options for constructor
        String PoS = spinner.getSelectedItem().toString();

        //Chooses which constructor to use
        if ( PoS.contentEquals("Adjective") ) {
            ArrayList<String> options = new ArrayList<>();

            Adjective adj = new Adjective(PoS, -1); // Set initial value to null
            options.add("Positive");
            options.add("Negative");
            options.add("Neutral");

            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            // Initialize selected item in second drop down menu
            String tag = spinner2.getSelectedItem().toString();

            // Sets Adjective's connotation
            if ( tag.equals("Positive") ) {
                adj.posNegNeu = 0;
            } else if ( tag.equals("Negative")){
                adj.posNegNeu = 1;
            } else if ( tag.equals("Neutral")){
                adj.posNegNeu = 2;
            }
            // adj is the finished adjective
            //addAdjective(adj);

        } else if (PoS.contentEquals("Adverb")) {
            ArrayList<String> options = new ArrayList<>();

            Adverb adv = new Adverb(PoS, -1);
            options.add("Positive");
            options.add("Negative");
            options.add("Neutral");


            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            String tag = spinner2.getSelectedItem().toString();

            if ( tag.equals("Positive") ) {
                adv.posNegNeu = 0;
            } else if ( tag.equals("Negative")){
                adv.posNegNeu = 1;
            } else if ( tag.equals("Neutral")){
                adv.posNegNeu = 2;
            }

        } else if (PoS.contentEquals("Conjunction")) {
            ArrayList<String> options = new ArrayList<>();

            
            options.add("Coordinating");
            options.add("Subordinating");
            options.add("AND, OR, NOR");
            options.add("BUT, FOR, YET");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (PoS.contentEquals("Determiner")) {
            ArrayList<String> options = new ArrayList<>();

            options.add("Plural");
            options.add("Singular");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (PoS.contentEquals("Interjection")) {
            ArrayList<String> options = new ArrayList<>();
            options.add("Greeting");
            options.add("Exclamation");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (PoS.contentEquals("Noun")) {
            ArrayList<String> options = new ArrayList<>();
            options.add("Thing");
            options.add("Person");
            options.add("Place");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (PoS.contentEquals("Preposition")) {
            ArrayList<String> options = new ArrayList<>();
            options.add("Location");
            options.add("Time");
            options.add("Other");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (PoS.contentEquals("Pronoun")) {
            ArrayList<String> options = new ArrayList<>();
            options.add("Subject");
            options.add("Object");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        }
        if (PoS.contentEquals("Verb")) {
            ArrayList<String> options = new ArrayList<>();
            options.add("Active");
            options.add("Passive");
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

