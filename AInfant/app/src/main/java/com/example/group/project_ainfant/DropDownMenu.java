package com.example.group.project_ainfant;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    public static String sentence = "";
    String [] tok = sentence.split("\\s+");
    public static int counter= 0;
    public static String alreadyIn = "";


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
                          /*
                            ADVERB--------------------------------------------------
                             */
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

                            if(counter == (tok.length-1) ) {
                                myDb.addAdverb(adv);
                                finish();
                            }else{

                                myDb.addAdverb(adv);
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                              /*
                            ADJECTIVE--------------------------------------------------
                             */
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

                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                            /*
                            DETERMINER--------------------------------------------------
                             */
                        } else if (pos.equals("Determiner")) {
                            Determiner det = new Determiner(word, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.equals("Plural")) {
                                det.singVPlur = 0;
                            } else if (tag.equals("Singular")) {
                                det.singVPlur = 1;
                            }
                            Log.d("det name", det.name);
                            Log.d("det type", Integer.toString(det.singVPlur));
                            myDb.addDeterminer(det);
                            if (counter == (tok.length - 1)) {
                                finish();
                            } else {
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                              /*
                            CONJUNCTION--------------------------------------------------
                             */
                        } else if (pos.equals("Conjunction")) {
                            Conjunction conj = new Conjunction(word, -1, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.equals("Coordinating")) {
                                conj.cordVSub = 0;
                            } else if (tag.equals("Subordinating")) {
                                conj.cordVSub = 1;
                            }

                            String tag2 = spinner3.getSelectedItem().toString();
                            if (tag2.equals("And")) {
                                conj.andVBut = 2;
                            } else if (tag2.equals("But")) {
                                conj.andVBut = 3;
                            }
                            myDb.addConjunction(conj);
                            if (counter == (tok.length - 1)) {
                                finish();
                            } else {
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                          /*
                            Interjection--------------------------------------------------
                             */
                        } else if (pos.equals("Interjection")) {
                            Interjection inject = new Interjection(word, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.equals("Greeting")) {
                                inject.type = 0;
                            } else if (tag.equals("Exclamation")) {
                                inject.type = 1;
                            }
                            myDb.addInterjection(inject);
                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                            /*
                            NOUN--------------------------------------------------
                             */
                        } else if (pos.equals("Noun")) {
                            Noun noun = new Noun(word, -1,-1,-1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.equals("Thing")) {
                                noun.type = 0;
                            } else if (tag.equals("Person")) {
                                noun.type = 1;
                            } else if (tag.equals("Place")) {
                                noun.type = 2;
                            }

                            String tag2 = spinner3.getSelectedItem().toString();
                            if (tag2.equals("Proper")) {
                                noun.propVImp = 3;
                            } else if (tag2.equals("Improper")) {
                                noun.propVImp = 4;
                            }

                            String tag3 = spinner4.getSelectedItem().toString();
                            if (tag3.equals("Plural")) {
                                noun.singVPlur = 5;
                            } else if (tag3.equals("Singular")) {
                                noun.singVPlur = 6;
                            }
                            myDb.addNoun(noun);
                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                            /*
                            PREPOSITION--------------------------------------------------
                             */
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
                            myDb.addPreposition(prep);
                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                            /*
                            PRONOUN--------------------------------------------------
                             */
                        } else if (pos.equals("Pronoun")) {
                           Pronoun pron = new Pronoun(word, -1, -1, -1);
                            String tag = spinner2.getSelectedItem().toString();
                            if (tag.equals("Subject")) {
                                pron.subVObj = 0;
                            } else if (tag.equals("Object")) {
                                pron.subVObj = 1;
                            }

                            String tag2 = spinner3.getSelectedItem().toString();
                            if (tag2.equals("Male")) {
                                pron.gender = 2;
                            } else if (tag2.equals("Female")) {
                                pron.gender = 3;
                            } else if (tag2.equals("Other")) {
                                pron.gender = 4;
                            }

                            String tag3 = spinner4.getSelectedItem().toString();
                            if (tag3.equals("Plural")) {
                                pron.singVPlur = 5;
                            } else if (tag.equals("Singular")) {
                                pron.singVPlur = 6;
                            }
                            myDb.addPronoun(pron);
                            if(counter == (tok.length-1) ) {
                                finish();
                            }else{
                                counter++;
                                word = tok[counter];
                                output.setText(word);
                            }
                              /*
                            VERB--------------------------------------------------
                             */
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
            // Flood menu with options
            options.add("Positive");
            options.add("Negative");
            options.add("Neutral");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            // Initialize selection options for listener method above
            /*spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);*/

            ArrayList<String> options2 = new ArrayList<>();
            // Flood menu with options
            options2.add("");
            // Create third drop down menu
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);
            // Initialize selection options for listener method above
            /*spinner3.setSelection(position, false);
            spinner3.setOnItemSelectedListener(this);*/

            ArrayList<String> options3 = new ArrayList<>();
            // Flood menu with options
            options3.add("");
            // Create fourth drop down menu
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);
            // Initialize selection options for listener method above
            /*spinner4.setSelection(position, false);
            spinner4.setOnItemSelectedListener(this);*/

        } else if (PoS.contentEquals("Adverb")) {

            ArrayList<String> options = new ArrayList<>();
            // Flood menu with options
            options.add("Positive");
            options.add("Negative");
            options.add("Neutral");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
            // Initialize selection options for listener method above

            /*spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);*/

            ArrayList<String> options2 = new ArrayList<>();
            // Flood menu with options
            options2.add("");
            // Create third drop down menu
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);
            // Initialize selection options for listener method above
            /*spinner3.setSelection(position, false);
            spinner3.setOnItemSelectedListener(this);*/

            ArrayList<String> options3 = new ArrayList<>();
            // Flood menu with options
            options3.add("");
            // Create fourth drop down menu
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);
            // Initialize selection options for listener method above
            /*spinner4.setSelection(position, false);
            spinner4.setOnItemSelectedListener(this);*/

            spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);


        } else if (PoS.contentEquals("Conjunction")) {


            ArrayList<String> options = new ArrayList<>();
            // Flood menu with options
            options.add("Coordinating");
            options.add("Subordinating");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
            // Initialize selection options for listener method above
            /*spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);*/

            ArrayList<String> options2 = new ArrayList<>();
            // Flood menu with options
            options2.add("AND, OR, NOR");
            options2.add("BUT, FOR, YET");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);

            // Initialize selection options for listener method above
            /*spinner3.setSelection(position, false);
            spinner3.setOnItemSelectedListener(this);*/

            ArrayList<String> options3 = new ArrayList<>();
            // Flood menu with options
            options3.add("");
            // Create fourth drop down menu
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);
            // Initialize selection options for listener method above
            /*spinner4.setSelection(position, false);
            spinner4.setOnItemSelectedListener(this);*/

        } else if (PoS.contentEquals("Determiner")) {

            ArrayList<String> options = new ArrayList<>();
            // Flood menu with options
            options.add("Plural");
            options.add("Singular");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            // Initialize selection options for listener method above
           /* spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);*/

            ArrayList<String> options2 = new ArrayList<>();
            // Flood menu with options
            options2.add("");
            // Create third drop down menu
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);
            // Initialize selection options for listener method above
            /*spinner3.setSelection(position, false);
            spinner3.setOnItemSelectedListener(this);*/

            ArrayList<String> options3 = new ArrayList<>();
            // Flood menu with options
            options3.add("");
            // Create fourth drop down menu
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);
            // Initialize selection options for listener method above
            /*spinner4.setSelection(position, false);
            spinner4.setOnItemSelectedListener(this);*/

        } else if (PoS.contentEquals("Interjection")) {

            ArrayList<String> options = new ArrayList<>();
            // Flood menu with options
            options.add("Greeting");
            options.add("Exclamation");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);

            // Initialize selection options for listener method above
            /*spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);*/

            ArrayList<String> options2 = new ArrayList<>();
            // Flood menu with options
            options2.add("");
            // Create third drop down menu
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);
            // Initialize selection options for listener method above
            /*spinner3.setSelection(position, false);
            spinner3.setOnItemSelectedListener(this);*/

            ArrayList<String> options3 = new ArrayList<>();
            // Flood menu with options
            options3.add("");
            // Create fourth drop down menu
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);
            // Initialize selection options for listener method above
            /*spinner4.setSelection(position, false);
            spinner4.setOnItemSelectedListener(this);*/

        }else if (PoS.contentEquals("Noun")) {

            ArrayList<String> options = new ArrayList<>();
            // Flood menu with options
            options.add("Thing");
            options.add("Person");
            options.add("Place");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);


            ArrayList<String> options2 = new ArrayList<>();
            // Flood menu with options
            options2.add("Proper");
            options2.add("Improper");
            // Create third drop down menu
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);


            ArrayList<String> options3 = new ArrayList<>();
            // Flood menu with options
            options3.add("Plural");
            options3.add("Singular");
            // Create fourth drop down menu
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);

        } else if (PoS.contentEquals("Preposition")) {

            ArrayList<String> options = new ArrayList<>();
            // Flood menu with options
            options.add("Location");
            options.add("Time");
            options.add("Other");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
            // Initialize selection options for listener method above
            /*spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);*/

            ArrayList<String> options2 = new ArrayList<>();
            // Flood menu with options
            options2.add("");
            // Create third drop down menu
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);
            // Initialize selection options for listener method above
            /*spinner3.setSelection(position, false);
            spinner3.setOnItemSelectedListener(this);*/

            ArrayList<String> options3 = new ArrayList<>();
            // Flood menu with options
            options3.add("");
            // Create fourth drop down menu
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);
            // Initialize selection options for listener method above
            /*spinner4.setSelection(position, false);
            spinner4.setOnItemSelectedListener(this);*/
        } else if (PoS.contentEquals("Pronoun")) {

            ArrayList<String> options = new ArrayList<>();
            // Flood menu with options
            options.add("Subject");
            options.add("Object");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
            // Initialize selection options for listener method above
            /*spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);*/

            ArrayList<String> options2 = new ArrayList<>();
            // Flood menu with options
            options2.add("");
            // Create third drop down menu
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);
            // Initialize selection options for listener method above
            /*spinner3.setSelection(position, false);
            spinner3.setOnItemSelectedListener(this);*/

            ArrayList<String> options3 = new ArrayList<>();
            // Flood menu with options
            options3.add("");
            // Create fourth drop down menu
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);
            // Initialize selection options for listener method above
            /*spinner4.setSelection(position, false);
            spinner4.setOnItemSelectedListener(this);*/
        } else if (PoS.contentEquals("Verb")) {

            ArrayList<String> options = new ArrayList<>();
            // Flood menu with options
            options.add("Active");
            options.add("Passive");
            // Create second drop down menu
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            spinner2.setAdapter(dataAdapter);
            // Initialize selection options for listener method above
            /*spinner2.setSelection(position, false);
            spinner2.setOnItemSelectedListener(this);*/

            ArrayList<String> options2 = new ArrayList<>();
            // Flood menu with options
            options2.add("");
            // Create third drop down menu
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options2);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            spinner3.setAdapter(dataAdapter2);
            // Initialize selection options for listener method above
            /*spinner3.setSelection(position, false);
            spinner3.setOnItemSelectedListener(this);*/

            ArrayList<String> options3 = new ArrayList<>();
            // Flood menu with options
            options3.add("");
            // Create fourth drop down menu
            ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, options3);
            dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter3.notifyDataSetChanged();
            spinner4.setAdapter(dataAdapter3);
            // Initialize selection options for listener method above
            /*spinner4.setSelection(position, false);
            spinner4.setOnItemSelectedListener(this);*/
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

