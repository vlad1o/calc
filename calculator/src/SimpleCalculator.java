import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите арифметическое выражение (например, 3+5) или 'exit' для завершения:");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String result = calc(input);
            System.out.println("Результат: " + result);
        }

        scanner.close();
    }

    public static String calc(String input) {
        // Разделяем входную строку на части, используя пробел в качестве разделителя
        String[] tokens = input.split(" ");

        // Проверяем, что количество частей ровно 3 (два числа и оператор)
        if (tokens.length != 3) {
            return "throws Exception";
        }

        try {
            // Пытаемся преобразовать первую и третью части в целые числа
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[2]);

            // Проверяем, что числа находятся в диапазоне от 1 до 10 включительно
            if (a < 1 || a > 10 || b < 1 || b > 10) {
                return "throws Exception";
            }

            // В зависимости от оператора выполняем соответствующую арифметическую операцию
            return switch (tokens[1]) {
                case "+" -> String.valueOf(a + b);
                case "-" -> String.valueOf(a - b);
                case "*" -> String.valueOf(a * b);
                case "/" -> String.valueOf(a / b);
                default -> throw new IllegalArgumentException("Invalid operator");
            };
        } catch (NumberFormatException e) {
            // Если не удалось преобразовать строки в числа, выбрасываем исключение
            return "throws Exception";
        } catch (ArithmeticException | IllegalArgumentException e) {
            // Обрабатываем исключения, связанные с арифметическими операциями и некорректными операторами
            return "throws Exception";
        }
    }
}
