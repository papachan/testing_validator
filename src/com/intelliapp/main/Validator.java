package com.intelliapp.main;


public class Validator {
	
	private static final int PLATES_MIN = 6;
	
	public static final String ALPHANUMERIC = "^[a-zA-Z0-9]*$";
	
//	public static final String FIRST_STRING = "[a-zA-Z]{3,}|[\\d]+";
	private static final String ONLY_LETTERS = "[a-zA-Z]+";

	public static boolean checkCarPlates(final String plates) {

		if(plates.length() == PLATES_MIN) {
			if(plates.matches(ALPHANUMERIC)) {
				String pos = plates.substring(0,3);
				String last = plates.substring(3);
				return pos.matches(ONLY_LETTERS) && isInteger(last);

			}
		}

		return false;
	}

	private static boolean isInteger(String str) {
		int size = str.length();
		
		for(int i=0; i<size;i++) {
			if(!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return size>0;
	}

}
