package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import com.intelliapp.main.Validator;

public class PlatesValidatorTest {

    @Test(dataProvider = "CarPlatesProvider")
    public void ValidCarPlatesTest(String[] s) {
    for (String temp : s) {
      boolean valid = Validator.checkPlates(temp);
      System.out.println("Car Plate is valid : " + temp + " , " + valid);
      Assert.assertEquals(valid, true);
    }
    }

    @Test(dataProvider = "InvalidCarPlatesProvider")
    public void InvalidCarPlatesTest(String[] s) {
    for (String temp : s) {
      boolean valid = Validator.checkPlates(temp);
      System.out.println("Car Plate is invalid : " + temp + " , " + valid);
      Assert.assertEquals(valid, false);
    }
    }

  @DataProvider
  public Object[][] CarPlatesProvider() {
    return new Object[][] { { new String[] {
        "DDD999"
    } } };
  }

  @DataProvider
  public Object[][] InvalidCarPlatesProvider() {
    return new Object[][] { { new String[] {
        "123456",
        "WW2345",
        "W23456"
    } } };
  }


  @BeforeTest
  public void beforeTest() {

  }

}