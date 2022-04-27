package machine;

import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Scanner;


enum UserStatus {
    BUY, FILL, TAKE, REMAINING, EXIT
}

public class CoffeeMachine {


    public static int minimum(int water, int milk, int coffee) {
        int minimum = 0;


        int[] arr1 = {water, milk, coffee};
        Arrays.sort(arr1);
        minimum = arr1[0];
        return minimum;

    }

    public static int maximum(int water, int milk, int coffee) {
        int maximum = 0;


        int[] arr1 = {water, milk, coffee};
        Arrays.sort(arr1);
        maximum = arr1[arr1.length - 1];
        return maximum;

    }

    public static int waterHasMachine = 400;
    public static int milkHasMachine = 540;

    public static int coffeeBeansHasMachine = 120;
    public static int disposableCupsHasMachine = 9;
    public static int totalCost = 550;


    public static int waterCupOfCoffee = 0;
    public static int milkCupOfCoffee = 0;
    public static int coffeeBeansCupOfCoffee = 0;
    public static int costEsspresso = 4;
    public static int costLatte = 7;
    public static int costCappuccino = 6;
    public static int cost = 0;

    public static void hasMachinePrint() {
        System.out.println("The coffee machine has:");
        System.out.println(waterHasMachine + " ml of water");
        System.out.println(milkHasMachine + " ml of milk");
        System.out.println(coffeeBeansHasMachine + " g of coffee beans");
        System.out.println(disposableCupsHasMachine + " disposable cups");
        System.out.println("$" + totalCost + " of money");
        System.out.println();


    }

    public static void CoffeePrint(int waterCupOfCoffee, int coffeeBeansCupOfCoffee, int cost, int milkCupOfCoffee) {
        if (milkHasMachine >= milkCupOfCoffee) {
            if (waterHasMachine >= waterCupOfCoffee) {
                if (coffeeBeansHasMachine >= coffeeBeansCupOfCoffee) {
                    if (disposableCupsHasMachine > 0) {
                        System.out.println("I have enough resources, making you a coffee!");
                        waterHasMachine -= waterCupOfCoffee;
                        coffeeBeansHasMachine -= coffeeBeansCupOfCoffee;
                        milkHasMachine -= milkCupOfCoffee;
                        totalCost += cost;
                        disposableCupsHasMachine--;
                    } else {
                        System.out.println("Sorry, not enough disposable cup");
                    }
                } else {
                    System.out.println("Sorry, not enough coffee!");
                    System.out.println();
                }


            } else {
                System.out.println("Sorry, not enough water!");
                System.out.println();
            }
        } else {
            System.out.println("Sorry, not enough milk!");
            System.out.println();
        }

    }


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int howManyCups = 0;
//        hasMachinePrint();
        System.out.println();


//        System.out.println("Write how many ml of water the coffee machine has: ");

//        System.out.println("Write how many ml of milk the coffee machine has: ");

//        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//        System.out.println("Write how many cups of coffee you will need: ");
//        int howManyCupsYouNeed = scanner.nextInt();
//        int enoughWater = waterHasMachine / waterCupOfCoffee;
//        int enoughMilk = milkHasMachine / milkCupOfCoffee;
//        int enoughCoffee = coffeeBeansHasMachine / coffeeBeansCupOfCoffee;
//        int min = minimum(enoughWater, enoughMilk, enoughCoffee);
        String select = scanner.nextLine();

        UserStatus buy = UserStatus.BUY;
        UserStatus fill = UserStatus.FILL;
        UserStatus take = UserStatus.TAKE;
        UserStatus remaining = UserStatus.REMAINING;
        UserStatus exit = UserStatus.EXIT;

        switch (status) {
            case BUY:
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String chooseCoffee = scanner.next();
                switch (chooseCoffee) {
                    case "back":
                        break;

                    case "1":
                        waterCupOfCoffee = 250;
                        coffeeBeansCupOfCoffee = 16;
                        cost = 4;
                        milkCupOfCoffee = 0;

                        CoffeePrint(waterCupOfCoffee, coffeeBeansCupOfCoffee, cost, milkCupOfCoffee);

                        break;
                    case "2":
                        waterCupOfCoffee = 350;
                        milkCupOfCoffee = 75;
                        coffeeBeansCupOfCoffee = 20;
                        cost = 7;
                        CoffeePrint(waterCupOfCoffee, coffeeBeansCupOfCoffee, cost, milkCupOfCoffee);

                        break;
                    case "3":
                        waterCupOfCoffee = 200;
                        milkCupOfCoffee = 100;
                        coffeeBeansCupOfCoffee = 12;
                        cost = 6;
                        CoffeePrint(waterCupOfCoffee, coffeeBeansCupOfCoffee, cost, milkCupOfCoffee);
                        break;
                }
                break;
            break;
            case FILL:
                System.out.println("Write how many ml of water you want to add: ");
                waterHasMachine += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                milkHasMachine += scanner.nextInt();

                System.out.println("Write how many grams of coffee beans you want to add: ");
                coffeeBeansHasMachine += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add: ");
                disposableCupsHasMachine += scanner.nextInt();
                System.out.println();
                break;
            case TAKE:
                System.out.println("I gave you $" + totalCost);
                System.out.println();
                totalCost = 0;
                break;
            case REMAINING:
                hasMachinePrint();
                break;
            case EXIT:
                System.exit(0);
                break;
            default:

        }
    }

        while(select !="exit")

    {

        System.out.println("Write action (buy, fill, take, remaining, exit): ");

        select = scanner.next();
        System.out.println();


//        if (min >= howManyCupsYouNeed) {
//            if (howManyCupsYouNeed == 0) {
//                System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", min);
//            }
//            if (min - howManyCupsYouNeed >= 0) {
//                System.out.print("Yes, I can make that amount of coffee");
//            }
//            if (min - howManyCupsYouNeed >= 1) {
//                System.out.printf(" (and even %d more than that)", min - howManyCupsYouNeed);
//            }
//
//        } else {
//            System.out.printf("No, I can make only %d cup(s) of coffee", min);
//        }


    }

}
}


//
//        int water = waterCupOfCoffee * howManyCups;
//        int milk = milkCupOfCoffee * howManyCups;
//        int coffeeBeans = coffeeBeansCupOfCoffee * howManyCups;
//        int CupOfCoffee = (water + milk + coffeeBeans);
//
//            System.out.println("Yes, I can make that amount of coffee");
//          System.out.println("No, I can make only 0 cup(s) of coffee");
//        }

//

//        System.out.printf("For %d cups of coffee you will need:\n", howManyCups);
//        System.out.printf("%d ml of water\n%d ml of milk\n%d g of coffee beans"
//                , water, milk, coffeeBeans);
//
//
//        System.out.println("Starting to make a coffee\n" +
//                "Grinding coffee beans\n" +
//                "Boiling water\n" +
//                "Mixing boiled water with crushed coffee beans\n" +
//                "Pouring coffee into the cup\n" +
//                "Pouring some milk into the cup\n" +
//                "Coffee is ready!");