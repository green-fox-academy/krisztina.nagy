package com.greenfoxacademy.week10day1rest.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SithText {


    private String sith_text = "";

    public SithText() {
    }

    private void addRandomShit(List<String> sentenceArray){
        String[] randomFillerSentences = {"Err..err.err..", "Arrgh.", "Uhmm.", "MINE!Mine!!", "Chikin?"};
        Random r = new Random();

        for (int i=0; i<r.nextInt(5); i++){
            sentenceArray.add(randomFillerSentences[r.nextInt(randomFillerSentences.length)]);
        }

    }
    private String doSith(String text) {
        text = text.toLowerCase();
        ArrayList<String> resultSentences = new ArrayList<>();
        String[] sentences = text.split("\\.\\s*");

        for (String s : sentences) {
            resultSentences.add(yodafySentence(s));
            addRandomShit(resultSentences);
        }
        return String.join(" ", resultSentences);
    }

    private String yodafySentence(String inputSentence) {
        String resultSentence;
        String[] words = inputSentence.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }

        for (int i = 0; i < words.length-1; i++) {
                String tmp = words[i];
                words[i] = words[i + 1];
                words[i + 1] = tmp;
                i++;
        }

        resultSentence = String.join(" ", words) + ".";

            /*for (String w : words) {
                sb.append(w);
            }

            sb.append(".");
            resultStr += sb.toString();*/
        resultSentence = firstCharUpper(resultSentence);
        return resultSentence;
    }

    private String firstCharUpper(String resultSentence) {
        return resultSentence.substring(0,1).toUpperCase() + resultSentence.substring(1);
    }

    public SithText(String text) {
        this.sith_text = this.doSith(text);
    }

    public String getSith_text() {
        return sith_text;
    }

    public void setSith_text(String sith_text) {
        this.sith_text = sith_text;
    }
}
