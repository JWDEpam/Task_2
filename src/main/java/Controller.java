import java.util.Scanner;

public class Controller {
    public static double calculate(){
        System.out.println("Введите пример типа xY(xYx)Y(xY(xYx)), где x-цифры, Y-операторы");
        Scanner scanner = new Scanner(System.in);
        Double ans = Logic.solvePrimer(scanner.nextLine());
        return ans;
    }
}
