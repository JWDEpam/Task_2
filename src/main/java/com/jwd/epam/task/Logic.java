package com.jwd.epam.task;

import java.util.regex.*;
public class Logic {
    protected static double solvePrimer(String s){
        double group9_10_11;
        double group7_8_9_10_11;
        double group3_4_5;
        double group1_2_3_4_5;
        double answer;
        final Pattern p = Pattern.compile("^(\\d+)([+\\-*/])\\((\\d+)([+\\-*/])(\\d+)\\)([*/\\-+])\\((\\d+)([+\\-/*])\\((\\d+)([+\\-*/])(\\d+)\\)\\)");
        Matcher m = p.matcher(s);
        boolean matches = m.matches();
        if (!matches){
            throw new RuntimeException("Неправильный вид примера");
        }
        //1 действие
        double group9 = Double.parseDouble(m.group(9));
        String group10 = m.group(10); //знак
        double group11 = Double.parseDouble(m.group(11));
        group9_10_11 =solve(group9,group11,group10);
        //2
        double group7 = Double.parseDouble(m.group(7));
        String group8 = m.group(8); //знак
        group7_8_9_10_11 = solve(group7,group9_10_11,group8);
        //3
        double group3 = Double.parseDouble(m.group(3));
        String group4 = m.group(4); //знак
        double group5 = Double.parseDouble(m.group(5));
        group3_4_5 = solve(group3,group5,group4);
        //4
        double group1 = Double.parseDouble(m.group(1));
        String group2 = m.group(2); //знак
        group1_2_3_4_5 = solve(group1,group3_4_5,group2);
        //5
        String group6 = m.group(6); //знак
        answer = solve(group1_2_3_4_5,group7_8_9_10_11,group6);

        return answer;
    }


    private static double solve(double a, double b, String c){
        double answer = 0;
        switch (c){
            case "+":
                answer = a + b;
                break;
            case "*":
                answer = a * b;
                break;
            case "-":
                answer = a - b;
                break;
            case "/":
                if (b == 0){
                    throw new RuntimeException("Деление на ноль");

                } else {
                    answer = a / b;
                }
                break;
        }
        return answer;


    }



}
