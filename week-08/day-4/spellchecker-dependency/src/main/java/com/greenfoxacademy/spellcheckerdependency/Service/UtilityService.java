package com.greenfoxacademy.spellcheckerdependency.Service;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UtilityService {
    ArrayList<String> colors;
    Random random;

    public UtilityService() {
        colors = new ArrayList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("lime");
        colors.add("orange");
        colors.add("magenta");
        random = new Random();
    }

    public String randomColor() {
        return colors.get(random.nextInt(colors.size()));
    }
    public Boolean validateEmail(String email) {
        if(email.contains("@") && email.charAt(0) != '@' && email.contains(".") && email.charAt(email.length()-1)!='.') {
            //return MessageFormat.format("{0} is a valid e-mail address.", email);
            return true;
        }
        else{
            //return MessageFormat.format("{0} is a valid e-mail address.", email);
            return false;
        }

    }
}
