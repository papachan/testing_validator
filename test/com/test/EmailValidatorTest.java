package com.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import com.intelliapp.main.EmailValidator;

public class EmailValidatorTest {

	private EmailValidator emailValidator;

	@BeforeClass
	public void initData() {
		emailValidator = new EmailValidator();
	}

	@DataProvider
	public Object[][] ValidEmailProvider() {
		return new Object[][] { { new String[] {
				"john@yahoo.com",
				"x@gmail.com",
				"ten.10@hotmail.com",
				"c@c.com"
		} } };
	}

	@DataProvider
	public Object[][] InvalidEmailProvider() {
		return new Object[][] { { new String[] {
				"dan",
				"yu@.com.ar",
				"mail.com"
		} } };
	}

	@Test(dataProvider = "ValidEmailProvider")
	public void ValidEmailTest(String[] Email) {

		for (String temp : Email) {
			boolean valid = emailValidator.validate(temp);
			System.out.println("Email is valid : " + temp + " , " + valid);
			Assert.assertEquals(valid, true);
		}

	}

	@Test(dataProvider = "InvalidEmailProvider", dependsOnMethods = "ValidEmailTest")
	public void InValidEmailTest(String[] Email) {

		for (String temp : Email) {
			boolean valid = emailValidator.validate(temp);
			System.out.println("Email is invalid : " + temp + " , " + valid);
			Assert.assertEquals(valid, false);
		}
	}

}