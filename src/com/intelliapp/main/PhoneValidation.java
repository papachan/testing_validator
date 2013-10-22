package com.intelliapp.main;

import java.util.regex.Matcher;

public class PhoneValidation {
	
	private String indicative;

	public PhoneValidation(String country) {
		super();
		this.indicative = country;
	}
	
    public boolean isCelularPhone(String phoneNumber) {
        if (phoneNumber.isEmpty()) {
            return false;
        }
        String clean = phoneNumber.replaceAll("[^\\d.]", "");
        if(clean.length() >= PhoneNumberUtils.PHONE_NUMBER_LENGTH 
        		&& phoneNumber.startsWith(this.indicative.substring(0,1))) {
        	clean = phoneNumber.replaceAll("[\\+()+]","").replaceAll("\\s+", "");
        	Matcher match = PhoneNumberUtils.GLOBAL_PHONE_NUMBER_PATTERN.matcher(clean);
            return match.matches();
        }
        return false;
    }

}
