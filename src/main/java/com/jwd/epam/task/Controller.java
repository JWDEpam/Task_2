package com.jwd.epam.task;

import java.util.Scanner;

public class Controller {
    public static Integer calculate(){
        System.out.println("Введите пример:");
        Scanner scanner = new Scanner(System.in);
        int ans = Logic.solvePrimer(scanner.nextLine());
        return ans;
    }
}
