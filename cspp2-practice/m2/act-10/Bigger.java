import java.lang.*;
import java.util.Scanner;
public class Bigger {
        public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int var_a = input.nextInt();
        int var_b = input.nextInt();
        System.out.println((var_a > var_b) ? "Bigger" : (var_a < var_b) ? "Smaller": "Equal");

        }
    }
