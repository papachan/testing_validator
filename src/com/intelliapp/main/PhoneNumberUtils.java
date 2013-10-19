package com.intelliapp.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberUtils {

    static final String LOG_TAG = "PhoneNumberUtils";
    
    private static final Pattern GLOBAL_PHONE_NUMBER_PATTERN =
            Pattern.compile("[\\+]?[0-9.-]+");
    
    public static boolean isGlobalPhoneNumber(String phoneNumber) {
        if (phoneNumber.isEmpty()) {
            return false;
        }

        Matcher match = GLOBAL_PHONE_NUMBER_PATTERN.matcher(phoneNumber);
        return match.matches();
    }

}
