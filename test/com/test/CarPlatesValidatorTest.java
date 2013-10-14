package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import com.intelliapp.main.Validator;

public class CarPlatesValidatorTest {

    @Test(dataProvider = "CarPlatesProvider")
    public void ValidCarPlatesTest(String[] s) {
        for (String temp : s) {
            boolean valid = Validator.checkCarPlates(temp);
            System.out.println("Car Plate is valid : " + temp + " , " + valid);
            Assert.assertEquals(valid, true);
        }
    }

    @Test(dataProvider = "InvalidCarPlatesProvider")
    public void InvalidCarPlatesTest(String[] s) {
        for (String temp : s) {
            boolean valid = Validator.checkCarPlates(temp);
            System.out.println("Car Plate is valid : " + temp + " , " + valid);
            Assert.assertEquals(valid, false);
        }
    }

    @DataProvider
    public Object[][] CarPlatesProvider() {
        return new Object[][] { { new String[] {
                    "DDD999",
                    "XXX123",
                    "ABC000"
                }
            }
        };
    }

    @DataProvider
    public Object[][] InvalidCarPlatesProvider() {
        return new Object[][] { { new String[] {
                    "123456",
                    "WW2345",
                    "W23456",
                    "111222",
                    "232XXX",
                    "AAAAAA",
                    "12",
                    "12345689"
                }
            }
        };
    }


    @BeforeTest
    public void beforeTest() {

    }

}