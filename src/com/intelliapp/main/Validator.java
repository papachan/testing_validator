package com.intelliapp.main;

public class Validator {

	private static final int PLATES_MIN = 6;
	private static final int PLATES_MAX = 7;

	public static boolean checkPlates(final String plates) {
		if(plates.length() >= PLATES_MIN && plates.length() < PLATES_MAX) {
			 return (Character.isLetter(plates.charAt(0))
					 && Character.isLetter(plates.charAt(1))
					 && Character.isLetter(plates.charAt(2))
					 && Character.isDigit(plates.charAt(3))
					&& Character.isDigit(plates.charAt(4))
					&& Character.isDigit(plates.charAt(5)));
		}
		return false;
	}

}
