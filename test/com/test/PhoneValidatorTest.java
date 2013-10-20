package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.intelliapp.main.PhoneNumberUtils;
import com.intelliapp.main.StringUtils;
import com.intelliapp.main.Validator;

public class PhoneValidatorTest {


	@DataProvider
	public Object[][] PhoneNumberProvider() {
		return new Object[][] { { new String[] {
				"3106545000",
				"5714557882",
				" (+54) 1 17772 8882  ",
				" +1 552233466"



		} } };
	}

	@DataProvider
	public Object[][] InvalidPhoneNumberProvider() {
		return new Object[][] { { new String[] {
				"123456",
				"522.435.1616",
				"+1",
				"*611",
				"test"
		} } };
	}

    @Test(dataProvider = "PhoneNumberProvider")
    public void ValidCarPhoneNumber(String[] s) {
		for (String temp : s) {
			boolean valid = PhoneNumberUtils.isGlobalPhoneNumber(temp);
			System.out.println("PhoneNumber is valid : " + temp + " , " + valid);
			Assert.assertEquals(valid, true);

		}
    }

    @Test(dataProvider = "InvalidPhoneNumberProvider")
    public void InvalidCarPhoneNumber(String[] s) {
		for (String temp : s) {
			boolean valid = PhoneNumberUtils.isGlobalPhoneNumber(temp);
			System.out.println("PhoneNumber is invalid : " + temp + " , " + valid);
			Assert.assertEquals(valid, false);
		}
    }

    private String stripWhiteSpaces(String one) {
        StringBuilder stripped = new StringBuilder();

        for (char c : one.toCharArray()) {
                if (!Character.isWhitespace(c)) {
                        stripped.append(c);
                }
        }


        return stripped.toString();
    }

}
