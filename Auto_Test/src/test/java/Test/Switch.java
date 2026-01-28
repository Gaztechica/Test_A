package Test;

import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {

    }
    public static void test() {

        /**
         * switch case работает со значениями переменной
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("какого вам размера пиццу?");
        if (scanner.hasNextInt()) {
            System.out.println("вы ввели число, а надо строку");

        } else if (scanner.hasNextLine()) {
            System.out.println("строка");
        }
        String pizzaSise = scanner.nextLine();
        int price = 0;
        switch (pizzaSise) {
            case "среднюю":
                price = 750;
                break;
            case "маленькую":
                price = 500;
                break;
            case "большую":
                price = 1000;
                break;
            default:
                System.out.println("нет такого размера пиццы");
        }
        System.out.println("За " + pizzaSise + " с вас " + price + " рублей");




    }
}
