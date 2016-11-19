package com.example.group.project_ainfant;

/**
 * Created by eronj on 11/14/2016.
 */

public class SyntaxRules {

    public SyntaxRules(){}

    public boolean checkRules(ParseTree.Node cur_node, ParseTree.Node next_node){

        String cur_node_PoS = cur_node.getPartOfSpeech();
        String next_node_PoS = next_node.getPartOfSpeech();

        //this line returns a boolean for if you can shift reduce
        switch (cur_node_PoS) {
            case "Noun":
                switch (next_node_PoS) {
                    case "Noun":
                        return true;
                    case "Compound_Noun":
                        return true;
                    case "Compound_Noun_Back":
                        return true;
                    case "Compound_Noun_Front":
                        return true;

                    default:
                        return false;
                }
            case "Adjective":
                switch (next_node_PoS) {
                    case "Noun":
                        return true;
                    case "Compound_Noun":
                        return true;
                    case "Compound_Noun_Front":
                        return true;
                    default:
                        return false;
                }
            case "Conjunction":
                if (next_node_PoS.equals("Noun")) {
                    return true;
                } else {
                    return false;
                }
            case "Determiner":
                switch (next_node_PoS) {
                    case "Noun":
                        return true;
                    case "Compound_Noun_Front":
                        return true;
                    case "Adjective":
                        return true;
                    case "Verb":
                        return true;
                    default:
                        return false;
                }
            case "Verb":
                switch (next_node_PoS) {
                    case "Prepositional_Phrase":
                        return true;
                    case "Noun":
                        return true;
                    default:
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
                if (next_node_PoS.equals("Noun")) {
                    return true;
                } else {
                    return false;
                }
            case "Compound_Noun":
                switch (next_node_PoS) {
                    default:
                        return false;
                }
            case "Compound_Noun_Front":
                switch (next_node_PoS) {
                    case "Noun":
                        return true;
                    case "Compound_Noun":
                        return true;
                    case "Compound_Noun_Front":
                        return true;
                    case "Compound_Noun_Back":
                        return true;
                    default:
                        return false;
                }
            case "Compound_Noun_Back":
                switch (next_node_PoS) {
                    default:
                        return false;
                }
            case "Verb_Phrase":
                switch (next_node_PoS) {
                    default:
                        return false;
                }
        }
        return false;
    }

    public String getShiftReduceName(ParseTree.Node cur_node, ParseTree.Node next_node){

        String cur_node_PoS = cur_node.getPartOfSpeech();
        String next_node_PoS = next_node.getPartOfSpeech();

        //this line returns a string for the part of speech
        switch (cur_node_PoS) {
            case "Noun":
                switch (next_node_PoS) {
                    case "Noun":
                        return "Compound_Noun_Front";
                    case "Compound_Noun":
                        return "Compound_Noun";
                    case "Compound_Noun_Back":
                        return "Compound_Noun";
                    case "Compound_Noun_Front":
                        return "Compound_Noun_Front";

                    default:
                        return "Error in Noun Case";
                }
            case "Adjective":
                switch (next_node_PoS) {
                    case "Noun":
                        return "Noun";
                    case "Compound_Noun":
                        return "Compound_Noun";
                    case "Compound_Noun_Front":
                        return "Compound_Noun_Front";
                    default:
                        return "Error in Adjective Case";
                }
            case "Conjunction":
                if (next_node_PoS.equals("Noun")) {
                    return "Compound_Noun_Back";
                } else {
                    return "Error in Conjunction Case";
                }
            case "Determiner":
                switch (next_node_PoS) {
                    case "Noun":
                        return "Noun";
                    case "Compound_Noun_Front":
                        return "Compound_Noun_Front";
                    case "Adjective":
                        return "Adjective";
                    case "Verb":
                        return "Noun";
                    default:
                        return "Error in Determiner Case";
                }
            case "Verb":
                switch (next_node_PoS) {
                    case "Prepositional_Phrase":
                        return "Verb_Phrase";
                    case "Noun":
                        return "Verb_Phrase";
                    default:
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
                if (next_node_PoS.equals("Noun")) {
                    return "Prepositional_Phrase";
                } else {
                    return "Error in Preposition Case";
                }
            case "Compound_Noun":
                switch (next_node_PoS) {
                    default:
                        return "Error in Compound_Noun Case";
                }
            case "Compound_Noun_Front":
                switch (next_node_PoS) {
                    case "Noun":
                        return "Compound_Noun_Front";
                    case "Compound_Noun":
                        return "Compound_Noun";
                    case "Compound_Noun_Front":
                        return "Compound_Noun_Front";
                    case "Compound_Noun_Back":
                        return "Compound_Noun";
                    default:
                        return "Error in Adverb Case";
                }
            case "Compound_Noun_Back":
                switch (next_node_PoS) {
                    default:
                        return "Error in Compound_Noun_Back Case";
                }
            case "Prepositional_Phrase":
                switch (next_node_PoS) {
                    case "Verb":
                        return "Verb_Phrase";
                    default:
                        return "Error in Adverb Case";
                }
            case "Verb_Phrase":
                switch (next_node_PoS) {
                    default:
                        return "Error in Verb_Phrase Case";
                }
        }
        return "Error: the first node type is not recognized";
    }

}
