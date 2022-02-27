package com.jwd.epam.task;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.regex.*;
public class Logic {
    protected static Integer solvePrimer(String s){
        int answer;
        ArrayList<Integer> skobki = new ArrayList<>();
        ArrayList<Integer> skobki_reshenie = new ArrayList<>();
        final Pattern zero = Pattern.compile("/0"); // проверка на входной ноль
        final Pattern p = Pattern.compile("(\\((\\d+)([+\\-*/])(\\d+)\\))");// раскрытие скобок
        final Pattern p2 = Pattern.compile("((\\d+)([*/])(\\d+))"); // умножение и деление
        final Pattern p3 = Pattern.compile("((\\d+)([+\\-])(\\d+))"); // сложение и вычитание
        Matcher m = zero.matcher(s);
        if (m.matches()){
            throw new RuntimeException("Деление на ноль в примере");
        }
        s = doMath(p,s);
        s = doMath(p2,s);
        s = doMath(p3,s);
        answer = Integer.parseInt(s);
        return answer;
    }



    private static int solve(int a, int b, String c){
        int answer = 0;
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

    private static String doMath(Pattern p, String s){
        String s1 = s;
        Matcher m = p.matcher(s1);
        for (int i =0;i<m.groupCount();i++){
            m = p.matcher(s1);
            while(m.find()) {
                int a = Integer.parseInt(m.group(2));// 1 число
                String operator = m.group(3);// оператор
                int b = Integer.parseInt(m.group(4));// 2 число
                int solve = solve(a,b,operator);
                s1 =s1.replace(m.group(1),String.valueOf(solve));
            }
        }
        return s1;
    }

}
