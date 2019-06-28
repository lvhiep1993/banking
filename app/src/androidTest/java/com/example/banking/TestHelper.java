package com.example.banking;


import java.util.Random;

public class TestHelper {

    public static String randomNumberStr(int count) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

    public static String randomNumberStrWithPrefix(String prefix, int count) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        builder.append(prefix);
        for (int i = 0; i < count; i++) {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }

    public static String randomNumberStrWithoutPrefix(String[] prefixList, int count) {
        Random random = new Random();
        String result;
        boolean isMatched;
        do {
            isMatched = false;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < count; i++) {
                builder.append(random.nextInt(10));
            }
            result = builder.toString();
            for (String prefix : prefixList) {
                if (result.startsWith(prefix)) {
                    isMatched = true;
                    break;
                }
            }

        } while (isMatched);
        return result;
    }
}