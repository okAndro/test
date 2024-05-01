import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Введите в одну строку арифметическое выражение(например, 2+2):");
                String input = scanner.nextLine();
                String result = calc(input);
                System.out.println("Результат: " + result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    public static String calc(String input) throws Exception {
        String allAround = input.replaceAll("\\s+", "");
        String[] operands = allAround.split("[+\\-*/]");
        String operator = allAround.replaceAll("[0-9]", "");

        if (operands.length != 2 || operator.length() != 1) {
            throw new Exception("Упс..программа завершена. Некорректный формат ввода. Нужно 'число оператор('+';'-';'*';'/') число'.");
        }

        int number1 = Integer.parseInt(operands[0]);
        int number2 = Integer.parseInt(operands[1]);

        if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10) {
            throw new Exception("Упс..программа завершена. Числа должны быть в диапазоне от 1 до 10 включительно.");
        }

        int result = performOperation(number1, number2, operator.charAt(0));
        return String.valueOf(result);
    }

    private static int performOperation(int num1, int num2, char op) throws Exception {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new Exception("Упс..программа завершена. Неподдерживаемый оператор: " + op);
        }
    }
}