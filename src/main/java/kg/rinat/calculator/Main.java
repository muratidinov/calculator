package kg.rinat.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        ArabicRomanParser arabicRomanParser = new ArabicRomanParser();

        System.out.println(calculator.getGreetingAndRulesMessage());

        while (true) {
            System.out.print("> ");
            String expression = scanner.nextLine();

            if (expression.equals("exit")) break;
            expression = expression.toUpperCase();
            expression = expression.replaceAll("\\s+", "");
            String[] numbers;
            int numberOne, numberTwo;

            if (expression.matches("[iIvVxXlLcCdDmM]+[\\s]*[+/ -/ */ /][\\s]*[iIvVxXlLcCdDmM]+")) {
                numbers = expression.split("[+/ -/ */ /]");
                numberOne = arabicRomanParser.romeToArab(numbers[0]);
                numberTwo = arabicRomanParser.romeToArab(numbers[1]);
                char operation = expression.substring(numbers[0].length()).charAt(0);
                int result = calculator.solveExpression(numberOne, numberTwo, operation);
                System.out.println("Результат: " + arabicRomanParser.arabicToRome(result));
                continue;
            }
            if (expression.matches("\\d+[\\s]*[+/ -/ */ /][\\s]*\\d+")) {
                numbers = expression.split("[+/ -/ */ /]");
                numberOne = Integer.parseInt(numbers[0]);
                numberTwo = Integer.parseInt(numbers[1]);
                char operation = expression.substring(numbers[0].length()).charAt(0);
                System.out.println("Результат: " + calculator.solveExpression(numberOne, numberTwo, operation));
            } else System.out.println("Вы написали в неверном формате!");
        }
    }

}
