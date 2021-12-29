/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuclh.utils;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Acer
 */
public class HelpUtils implements Serializable{
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String ALPHAUPPERCASE = ALPHA.toUpperCase(); // A-Z
    private static final String DIGITS = "0123456789"; // 0-9
    private static final String ALPHA_NUMERIC = ALPHA + ALPHAUPPERCASE + DIGITS;

    private static Random generator = new Random();

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    public static String randomAlphaNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
    
    public static String randomNumeric(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, DIGITS.length() - 1);
            char ch = DIGITS.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }
    
    public static String subStringCategoryID (String categoryID) {
        String s1 = categoryID.substring(0, 2);
        String s2 = categoryID.substring(2);
        
        int i = Integer.parseInt(s2) + randomNumber(0, 9);
        s2 = Integer.toString(i);
        s1 = s1.concat(s2);
        return s1;
    }
}
