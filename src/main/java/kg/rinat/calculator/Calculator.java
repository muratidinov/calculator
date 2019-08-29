package kg.rinat.calculator;

public class Calculator {

    public int solveExpression(int numberOne, int numberTwo, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = plus(numberOne, numberTwo);
                break;
            case '-':
                result = minus(numberOne, numberTwo);
                break;
            case '*':
                result = multiply(numberOne, numberTwo);
                break;
            case '/':
                result = divide(numberOne, numberTwo);
                break;
        }
        return result;
    }

    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int divide(int a, int b) {
        if (a < b) {
            System.out.println("Делимое меньше делителя!");
        }
        return a / b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public String getGreetingAndRulesMessage() {
        return "Привет!!!\n" +
                "Это простой калькулятор, который плюс ещё умеет работать с римскими цифрами.\n" +
                "В каком формате писать: (первый номер) (операция) (второй номер)\n" +
                "Пробелы не учитываются.\n" +
                "Чтобы выйти, наберите 'exit'\n";
    }

    public String getErrorMessage() {
        return "";
    }
}
