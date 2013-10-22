package com.intelliapp.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtils {

    static final String LOG_TAG = "PhoneNumberUtils";
    
    public static final Pattern GLOBAL_PHONE_NUMBER_PATTERN =
            Pattern.compile("^[+]?[0-9]{10,13}$");

    public static final int PHONE_NUMBER_LENGTH = 10;
    
    public static boolean isGlobalPhoneNumber(String phoneNumber) {
        if (phoneNumber.isEmpty()) {
            return false;
        }
        String clean = phoneNumber.replaceAll("[^\\d.]", "");
        if(clean.length() >= PHONE_NUMBER_LENGTH) {
        	clean = phoneNumber.replaceAll("[\\+()+]","").replaceAll("\\s+", "");
        	Matcher match = GLOBAL_PHONE_NUMBER_PATTERN.matcher(clean);
            return match.matches();
        }
        return false;

    }
    


}
