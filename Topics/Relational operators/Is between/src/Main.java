import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();   // put your code here
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        boolean result = false;


        if (num2 <= num1 && num1 <= num3 || num1 <= num2 && num1 >= num3) {
            result = true;
        } else {
            result = false;
        }
        System.out.println(result);
    }
}