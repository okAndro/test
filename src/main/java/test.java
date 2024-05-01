import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args) {
        // Создаем экземпляр Scanner для чтения входных данных от пользователя
        Scanner scanner = new Scanner(System.in);

        // Просим пользователя ввести арифметическое выражение
        System.out.println("Введите арифметическое выражение (например, '1 + 2'):");

        // Считываем строку введенную пользователем
        String input = scanner.nextLine();

        // Вызываем метод проверки и вычисления
        checkAndCalculate(input);
    }

    // Метод для проверки и вычисления арифметического выражения
    public static void checkAndCalculate(String input) {
        // Удаляем пробелы с начала и конца строки
        input = input.trim();

        // Создаем шаблон поиска для нахождения двух чисел, разделенных оператором
        Pattern pattern = Pattern.compile("^(\\d+)\\s*([+\\-*/])\\s*(\\d+)$");
        Matcher matcher = pattern.matcher(input);

        // Проверяем соответствие строки шаблону
        if (matcher.find()) {
            // Извлекаем числа и оператор
            int number1 = Integer.parseInt(matcher.group(1));
            int number2 = Integer.parseInt(matcher.group(3));
            String operator = matcher.group(2);

            // Вычисляем результат используя извлеченные числа и оператор
            try {
                int result = calculate(number1, number2, operator);
                System.out.println("Результат выражения: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Ошибка арифметических вычислений: " + e.getMessage());
            }

        } else {
            // Если шаблон не совпал, вывести пользователю ошибку
            System.out.println("Ошибка: выражение не соответствует формату 'ЧИСЛО оператор ЧИСЛО'.");
        }
    }

    // Метод для вычисления результата
    public static int calculate(int num1, int num2, String op) {
        switch (op) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":

                return num1 / num2;
            default:
                throw new IllegalArgumentException("Неизвестный оператор: " + op);
        }
    }
}