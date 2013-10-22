package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.intelliapp.main.PhoneNumberUtils;
import com.intelliapp.main.PhoneValidation;
import com.intelliapp.main.StringUtils;
import com.intelliapp.main.Validator;

public class PhoneValidatorTest {
	
	private static final String COLOMBIA = "57";
	private static final String INDEX_COUNTRY = "31";
	
	PhoneValidation v;

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
	
	
	@DataProvider
	public Object[][] ValidCellPhoneNumberProvider() {
		return new Object[][] { { new String[] {
				"3132182065"
		} } };
	}
	
	@DataProvider
	public Object[][] InvalidCellPhoneNumProvider() {
		return new Object[][] { { new String[] {
				"5478561212",
				"422.335.1616",
		} } };
	}
	
	@BeforeTest
	public void beforeTest() {
		v = new PhoneValidation(INDEX_COUNTRY);
	}
	
    @Test(dataProvider = "PhoneNumberProvider")
    public void ValidPhoneNumber(String[] s) {
		for (String temp : s) {
			boolean valid = PhoneNumberUtils.isGlobalPhoneNumber(temp);
			System.out.println("PhoneNumber is valid : " + temp + " , " + valid);
			Assert.assertEquals(valid, true);
		
		}
    }
    
    @Test(dataProvider = "InvalidPhoneNumberProvider")
    public void InvalidPhoneNumber(String[] s) {
		for (String temp : s) {
			boolean valid = PhoneNumberUtils.isGlobalPhoneNumber(temp);
			System.out.println("PhoneNumber is invalid : " + temp + " , " + valid);
			Assert.assertEquals(valid, false);
		}
    }
    
    @Test(dataProvider = "ValidCellPhoneNumberProvider")
    public void ValidCellPhoneNumber(String[] s) {
		for (String temp : s) {
			boolean valid = v.isCelularPhone(temp);
			System.out.println("PhoneNumber is valid : " + temp + " , " + valid);
			Assert.assertEquals(valid, true);
		}
    }
    
    @Test(dataProvider = "InvalidCellPhoneNumProvider")
    public void InvalidCellPhoneNumber(String[] s) {
		for (String temp : s) {
			boolean valid = v.isCelularPhone(temp);
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
