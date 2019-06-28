package com.example.banking.util;

import android.support.test.runner.AndroidJUnit4;

import com.example.banking.TestHelper;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class UtilsTest {

    @Test
    public void isFullNameValidTest() {
        boolean result = Utils.isFullNameValid("");
        assertFalse(result);
        boolean result1 = Utils.isFullNameValid(null);
        assertFalse(result1);
        boolean result2 = Utils.isFullNameValid("fsa");
        assertTrue(result2);
        boolean result3 = Utils.isFullNameValid("  ");
        assertFalse(result3);
    }

    @Test
    public void isNationalIdNumberValidTest() {
        boolean result = Utils.isNationalIdNumberValid("");
        assertTrue(result);
        boolean result1 = Utils.isNationalIdNumberValid(null);
        assertTrue(result1);
        boolean result2 = Utils.isNationalIdNumberValid(TestHelper.randomNumberStr(1));
        assertFalse(result2);
        boolean result3 = Utils.isNationalIdNumberValid(TestHelper.randomNumberStr(8));
        assertFalse(result3);
        boolean result4 = Utils.isNationalIdNumberValid(TestHelper.randomNumberStr(9));
        assertTrue(result4);
        boolean result5 = Utils.isNationalIdNumberValid(TestHelper.randomNumberStr(10));
        assertFalse(result5);
        boolean result6 = Utils.isNationalIdNumberValid(TestHelper.randomNumberStr(11));
        assertFalse(result6);
        boolean result7 = Utils.isNationalIdNumberValid(TestHelper.randomNumberStr(12));
        assertTrue(result7);
        boolean result8 = Utils.isNationalIdNumberValid(TestHelper.randomNumberStr(13));
        assertFalse(result8);
        boolean result9 = Utils.isNationalIdNumberValid(TestHelper.randomNumberStr(20));
        assertFalse(result9);
    }

    @Test
    public void isPhoneValid_WithoutPrefix_Test() {
        boolean result = Utils.isPhoneNumberValid("");
        assertFalse(result);
        boolean result1 = Utils.isPhoneNumberValid(null);
        assertFalse(result1);
        boolean result2 = Utils.isPhoneNumberValid(TestHelper.randomNumberStrWithoutPrefix(Constants.PHONE_NUMBER_PREX, 1));
        assertFalse(result2);
        boolean result3 = Utils.isPhoneNumberValid(TestHelper.randomNumberStrWithoutPrefix(Constants.PHONE_NUMBER_PREX, 10));
        assertFalse(result3);
    }

    @Test
    public void isPhoneValid_WithPrefix_Test() {
        for (String prefix : Constants.PHONE_NUMBER_PREX) {
            boolean result1 = Utils.isPhoneNumberValid(TestHelper.randomNumberStrWithPrefix(prefix, 0));
            assertFalse(result1);
            boolean result2 = Utils.isPhoneNumberValid(TestHelper.randomNumberStrWithPrefix(prefix, 6));
            assertFalse(result2);
            boolean result3 = Utils.isPhoneNumberValid(TestHelper.randomNumberStrWithPrefix(prefix, 7));
            assertTrue(result3);
            boolean result4 = Utils.isPhoneNumberValid(TestHelper.randomNumberStrWithPrefix(prefix, 8));
            assertFalse(result4);
            boolean result5 = Utils.isPhoneNumberValid(TestHelper.randomNumberStrWithPrefix(prefix, 10));
            assertFalse(result5);
        }
    }

    @Test
    public void isProvinceValidTest() {
        boolean result = Utils.isProvinceValid("");
        assertFalse(result);
        boolean result1 = Utils.isProvinceValid(null);
        assertFalse(result1);
        boolean result2 = Utils.isProvinceValid("fsa");
        assertTrue(result2);
        boolean result3 = Utils.isProvinceValid("  ");
        assertFalse(result3);
    }

    @Test
    public void isMonthlyIncomeValidTest() {
        boolean result = Utils.isMonthlyIncomeValid(Constants.MONTHLY_INCOME_1);
        assertFalse(result);
        boolean result1 = Utils.isMonthlyIncomeValid(Constants.MONTHLY_INCOME_3000001);
        assertTrue(result1);
        boolean result2 = Utils.isMonthlyIncomeValid(Constants.MONTHLY_INCOME_1000001);
        assertTrue(result2);
    }
}
