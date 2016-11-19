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
import com.example.group.project_ainfant.PartsOfSpeech.Determiner;
import com.example.group.project_ainfant.PartsOfSpeech.Interjection;
import com.example.group.project_ainfant.PartsOfSpeech.Noun;
import com.example.group.project_ainfant.PartsOfSpeech.Preposition;
import com.example.group.project_ainfant.PartsOfSpeech.Verb;

import java.util.ArrayList;

public class DropDownMenu extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner, spinner2, spinner3;
    private ArrayList<String> parts_of_speech;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myDb = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down_menu);
        spinner = (Spinner) findViewById(R.id.spin);
        spinner2 = (Spinner) findViewById(R.id.spin2);
        spinner.setOnItemSelectedListener(this);

        // Initial drop down menu items, stored as a String array
        parts_of_speech = new ArrayList<>();
        parts_of_speech.add("Adjective");
        parts_of_speech.add("Adverb");
        parts_of_speech.add("Conjunction");
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
            myDb.addAdjective(adj);

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
            // adv is the finished Adverb
            myDb.addAdverb(adv);

//Conjunction makes AInfant crash. Needs fix to the multiple drop down menus.
/* --------- beginning of crash
            E/AndroidRuntime: FATAL EXCEPTION: main
            java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.Spinner.setAdapter(android.widget.SpinnerAdapter)' on a null object reference
            at com.example.group.project_ainfant.DropDownMenu.onItemSelected(DropDownMenu.java:150)*/

        /*} else if (PoS.contentEquals("Conjunction")) {
            ArrayList<String> options = new ArrayList<>();

            Conjunction conj = new Conjunction(PoS, -1, -1);
            options.add("Coordinating");
            options.add("Subordinating");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            String tag1 = spinner2.getSelectedItem().toString();

            if(tag1.equals("Coordinating")){
                conj.cordVSub = 0;
            } else if (tag1.equals("Subordinating")){
                conj.cordVSub = 1;
            }

            ArrayList<String> options2 = new ArrayList<>();

            options2.add("AND, OR, NOR");
            options2.add("BUT, FOR, YET");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);

            String tag2 = spinner3.getSelectedItem().toString();

            if (tag2.equals("AND, OR, NOR")){
                conj.andVBut = 2;
            } else if (tag2.equals("BUT, FOR, YET")){
                conj.andVBut = 3;
            }*/
            // myDb.addConjuction(conj);

        } else if (PoS.contentEquals("Determiner")) {
            ArrayList<String> options = new ArrayList<>();

            Determiner det = new Determiner(PoS, -1);

            options.add("Plural");
            options.add("Singular");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            String tag = spinner2.getSelectedItem().toString();

            if (tag.equals("Plural")) {
                det.singVPlur = 0;
            } else if (tag.equals("Singular")) {
                det.singVPlur = 1;
            }
        } else if (PoS.contentEquals("Interjection")) {
            ArrayList<String> options = new ArrayList<>();

            Interjection inject = new Interjection(PoS, -1);

            options.add("Greeting");
            options.add("Exclamation");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            String tag = spinner2.getSelectedItem().toString();

            if (tag.equals("Greeting")){
                inject.type = 0;
            } else if (tag.equals("Exclamation")){
                inject.type = 1;
            }
            myDb.addInterjection(inject);

        }else if (PoS.contentEquals("Noun")) {
            ArrayList<String> options = new ArrayList<>();

            Noun noun = new Noun(PoS, -1, -1, -1);

            options.add("Thing");
            options.add("Person");
            options.add("Place");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
            // Add multiple drop down menus
        } else if (PoS.contentEquals("Preposition")) {
            ArrayList<String> options = new ArrayList<>();

            Preposition prep = new Preposition(PoS, -1);

            options.add("Location");
            options.add("Time");
            options.add("Other");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            String tag = spinner2.getSelectedItem().toString();

            if (tag.equals("Location")){
                prep.type = 0;
            } else if (tag.equals("Time")){
                prep.type = 1;
            } else if (tag.equals("Other")){
                prep.type = 2;
            }
            //myDb.addPrepostion;
        } else if (PoS.contentEquals("Pronoun")) {
            ArrayList<String> options = new ArrayList<>();
            options.add("Subject");
            options.add("Object");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
        } else if (PoS.contentEquals("Verb")) {
            ArrayList<String> options = new ArrayList<>();

            Verb verb = new Verb(PoS, -1);

            options.add("Active");
            options.add("Passive");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            String tag = spinner2.getSelectedItem().toString();

            if (tag.equals("Active")){
                verb.actVPass = 0;
            } else if (tag.equals("Passive")){
                verb.actVPass = 1;
            }
            myDb.addVerb(verb);
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

