package com.example.group.project_ainfant;

/**
 * Created by eronj on 11/14/2016.
 */

public class SyntaxRules {

    public SyntaxRules(){}

    public boolean checkRules(ParseTree.Node cur_node, ParseTree.Node next_node){

        String cur_node_PoS = cur_node.getPartOfSpeech();
        String next_node_PoS = next_node.getPartOfSpeech();

        //this line returns a string for the part of speech
        switch (cur_node_PoS){
            case "Noun":
                switch (next_node_PoS) {
                    case "Compound_Noun_Part":
                        return true;
                    case "Noun":
                        return true;
                    default:
                        return false;
                }
            case "Adjective":
                switch (next_node_PoS) {
                    case "Compound_Noun_Part":
                        return true;
                    case "Noun":
                        return true;
                    default:
                        return false;
                }
            case "Conjunction":
                if (next_node_PoS.equals("Noun")){
                    return true;
                }else {
                    return false;
                }
            case "Determiner":
                switch (next_node_PoS) {
                    case "Noun":
                        return true;
                    case "Compound_Noun_Part":
                        return true;
                    case "Adjective":
                        return true;
                    case "Verb":
                        return true;
                    default:
                        return false;
                }
            case "Verb":
                if (next_node_PoS.equals("Prepositional_Phrase")){
                    return true;
                }else {
                    return false;
                }
            case "Adverb":
                switch (next_node_PoS) {
                    case "Verb":
                        return true;
                    case "Adjective":
                        return true;
                    default:
                        return false;
                }
            case "Preposition":
                return next_node_PoS.equals("Noun");

        }
        return false;
    }

    public String getShiftReduceName(ParseTree.Node cur_node, ParseTree.Node next_node){

        String cur_node_PoS = cur_node.getPartOfSpeech();
        String next_node_PoS = next_node.getPartOfSpeech();

        //this line returns a string for the part of speech
        switch (cur_node_PoS){
            case "Noun":
                switch (next_node_PoS) {
                    case "Compound_Noun_Part":
                        return "Noun";
                    case "Noun":
                        return "Compound_Noun_Part";
                    default:
                        return "Error in Noun Case";
                }
            case "Adjective":
                switch (next_node_PoS) {
                    case "Compound_Noun_Part":
                        return "Compound_Noun_Part";
                    case "Noun":
                        return "Noun";
                    default:
                        return "Error in Adjective Case";
                }
            case "Conjunction":
                if (next_node_PoS.equals("Noun")){
                    return "Compound_Noun_Part";
                }else {
                    return "Error in Conjunction Case";
                }
            case "Determiner":
                switch (next_node_PoS) {
                    case "Noun":
                        return "Determiner";
                    case "Compound_Noun_Part":
                        return "Compound_Noun_Part";
                    case "Adjective":
                        return "Adjective";
                    case "Verb":
                        return "Noun";
                    default:
                        return "Error in Determiner Case";
                }
            case "Verb":
                if (next_node_PoS.equals("Prepositional_Phrase")){
                    return "Verb";
                }else {
                    return "Error in Verb Case";
                }
            case "Adverb":
                switch (next_node_PoS) {
                    case "Verb":
                        return "Verb";
                    case "Adjective":
                        return "Adjective";
                    default:
                        return "Error in Adverb Case";
                }
            case "Preposition":
                if (next_node_PoS.equals("Noun")){
                    return "Noun";
                }else {
                    return "Error in Preposition Case";
                }
        }
        return "Error: the first node type is not recognized";
    }

}
