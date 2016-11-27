package com.example.group.project_ainfant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;


import com.example.group.project_ainfant.PartsOfSpeech.Adjective;
import com.example.group.project_ainfant.PartsOfSpeech.Adverb;
import com.example.group.project_ainfant.PartsOfSpeech.Determiner;
import com.example.group.project_ainfant.PartsOfSpeech.Conjunction;
import com.example.group.project_ainfant.PartsOfSpeech.Interjection;
import com.example.group.project_ainfant.PartsOfSpeech.Noun;
import com.example.group.project_ainfant.PartsOfSpeech.Preposition;
import com.example.group.project_ainfant.PartsOfSpeech.Pronoun;
import com.example.group.project_ainfant.PartsOfSpeech.Verb;
import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.ArrayList;
import java.util.List;

public class DropDownMenu extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    //public static String word = "";


    public static String sentence = "";
    String [] tok = sentence.split("\\s+");
    public static int counter= 0;

    String word = tok[counter];


    private Spinner spinner, spinner2, spinner3, spinner4;
    private ArrayList<String> parts_of_speech;
    private TextView output;
    DatabaseHelper myDb;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        counter = 0;



        myDb = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_down_menu);
        spinner = (Spinner) findViewById(R.id.spin);
        spinner2 = (Spinner) findViewById(R.id.spin2);
        spinner3 = (Spinner) findViewById(R.id.spin3);
        spinner4 = (Spinner) findViewById(R.id.spin4);
        spinner.setOnItemSelectedListener(this);

        output = (TextView) findViewById(R.id.outputText);
        output.setText(word);


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
        addListenerOnButton();

    }

    public void addListenerOnButton() {
        button = (Button) findViewById(R.id.button_add2);



        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String pos = spinner.getSelectedItem().toString();
                        //Log.d("tag",pos);
                        if (pos.equals("Adverb")) {
                            Adverb adv = new Adverb(word, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.contentEquals("Positive")) {
                                adv.posNegNeu = 0;
                            } else if (tag.contentEquals("Negative")) {
                                adv.posNegNeu = 1;
                            } else if (tag.contentEquals("Neutral")) {
                                adv.posNegNeu = 2;
                            }
                            Log.d("adverb name", adv.name);
                            Log.d("adverb type", Integer.toString(adv.posNegNeu));
                            myDb.addAdverb(adv);



                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }


                        } else if (pos.equals("Adjective")) {
                            Adjective adj = new Adjective(word, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.contentEquals("Positive")) {
                                adj.posNegNeu = 0;
                            } else if (tag.contentEquals("Negative")) {
                                adj.posNegNeu = 1;
                            } else if (tag.contentEquals("Neutral")) {
                                adj.posNegNeu = 2;
                            }
                            Log.d("adj name", adj.name);
                            Log.d("adj type", Integer.toString(adj.posNegNeu));
                            myDb.addAdjective(adj);
                            //finish();


                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }

                        } else if (pos.equals("Determiner")) {
                            Determiner det = new Determiner(word, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.equals("Plural")) {
                                det.singVPlur = 0;
                            } else if (tag.equals("Singular")) {
                                det.singVPlur = 1;
                            }
                            Log.d("adj name", det.name);
                            Log.d("adj type", Integer.toString(det.singVPlur));
                            myDb.addDeterminer(det);
                            //finish();

                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                            }

                        } else if (pos.equals("Interjection")) {
                            Interjection inject = new Interjection(word, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.equals("Greeting")) {
                                inject.type = 0;
                            } else if (tag.equals("Exclamation")) {
                                inject.type = 1;
                            }
                            myDb.addInterjection(inject);
                            finish();
                        } else if (pos.equals("Preposition")) {
                            Preposition prep = new Preposition(word, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.equals("Location")) {
                                prep.type = 0;
                            } else if (tag.equals("Time")) {
                                prep.type = 1;
                            } else if (tag.equals("Other")) {
                                prep.type = 2;
                            }
                            //myDb.addPrepostion(prep);
                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                        } else if (pos.equals("Verb")) {
                            Verb verb = new Verb(word, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.equals("Active")) {
                                verb.actVPass = 0;
                            } else if (tag.equals("Passive")) {
                                verb.actVPass = 1;
                            }
                            myDb.addVerb(verb);
                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                        }
                    }
                }
        );
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



        } else if (PoS.contentEquals("Adverb")) {
            ArrayList<String> options = new ArrayList<>();


            options.add("Positive");
            options.add("Negative");
            options.add("Neutral");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
            spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);


          } else if (PoS.contentEquals("Conjunction")) {
            ArrayList<String> options = new ArrayList<>();

            Conjunction conj = new Conjunction(PoS, -1, -1);
            options.add("Coordinating");
            options.add("Subordinating");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);




            ArrayList<String> options2 = new ArrayList<>();

            options2.add("AND, OR, NOR");
            options2.add("BUT, FOR, YET");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);



        } else if (PoS.contentEquals("Determiner")) {
            ArrayList<String> options = new ArrayList<>();


            options.add("Plural");
            options.add("Singular");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);


        } else if (PoS.contentEquals("Interjection")) {
            ArrayList<String> options = new ArrayList<>();



            options.add("Greeting");
            options.add("Exclamation");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);


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

            ArrayList<String> options2 = new ArrayList<>();

            options2.add("Proper");
            options2.add("Improper");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);


            ArrayList<String> options3 = new ArrayList<>();

            options3.add("Plural");
            options3.add("Singular");

            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);

        } else if (PoS.contentEquals("Preposition")) {
            ArrayList<String> options = new ArrayList<>();

            options.add("Location");
            options.add("Time");
            options.add("Other");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);


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

