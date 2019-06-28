package com.example.banking.util;

import android.text.TextUtils;

public class Utils {

    public static boolean isFullNameValid(String fullName) {
        return fullName != null && !TextUtils.isEmpty(fullName.trim());
    }

    public static boolean isNationalIdNumberValid(String nationalIdNumber) {
        return TextUtils.isEmpty(nationalIdNumber) || nationalIdNumber.length() == 9 || nationalIdNumber.length() == 12;
    }


    public static boolean isPhoneNumberValid(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) return false;
        for (String pre : Constants.PHONE_NUMBER_PREX) {
            if (phoneNumber.startsWith(pre) && phoneNumber.length() == 7 + pre.length()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isProvinceValid(String Province) {
        return Province != null && !TextUtils.isEmpty(Province.trim());
    }

    public static boolean isMonthlyIncomeValid(int monthlyIncome) {
        return monthlyIncome > Constants.MONTHLY_INCOME_1;
    }
}
