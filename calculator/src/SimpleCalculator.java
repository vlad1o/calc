import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("Введите выражение в формате 'a оператор b' (например, 5 + 3): ");
                String input = scanner.nextLine();

                // Выход из цикла при пустом вводе
                if (input.isEmpty()) {
                    break;
                }

                // Разделение строки на операнды и оператор
                String[] parts = input.split(" ");
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Неверный формат выражения");
                }

                int a = parseOperand(parts[0]);
                String operator = parts[1];
                int b = parseOperand(parts[2]);

                // Выполнение операции в зависимости от оператора
                int result = 0;
                switch (operator) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        if (b == 0) {
                            throw new ArithmeticException("Деление на ноль");
                        }
                        result = a / b;
                        break;
                    default:
                        throw new IllegalArgumentException("Неподдерживаемая арифметическая операция");
                }

                // Вывод результата
                System.out.println("Результат: " + result);

                // Очистка буфера ввода
                scanner.nextLine();
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введены некорректные числа");
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Парсинг операнда и проверка на целое число
    private static int parseOperand(String operand) {
        try {
            return Integer.parseInt(operand);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Некорректный формат числа: " + operand);
        }
    }
}
