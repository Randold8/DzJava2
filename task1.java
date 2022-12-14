
import java.util.Scanner;
import java.util.regex.Pattern;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern datePattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");

        System.out.print("Введите дату: ");
        String userInput = scanner.nextLine();

        if (datePattern.matcher(userInput).matches()) {
            String[] dateParts = userInput.split("/");
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            if (isValidDate(day, month, year)) {
                System.out.println("Строка является валидной датой в формате dd/mm/yyyy.");
            } else {
                System.out.println("Строка не является валидной датой в формате dd/mm/yyyy.");
            }
        } else {
            System.out.println("Строка не является датой в формате dd/mm/yyyy.");
        }
    }
    private static boolean isValidDate(int day, int month, int year) {
        // Проверяем, является ли год високосным
        boolean isLeapYear = ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);

        // Проверяем, содержит ли месяц 31 день
        boolean has31Days = (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12);
                // Проверяем, содержит ли месяц 30 дней
                boolean has30Days = (month == 4 || month == 6 || month == 9 || month == 11);

                // Проверяем, содержит ли месяц 29 дней в високосном году
                boolean has29DaysInLeapYear = (month == 2 && isLeapYear);
        
                // Проверяем, содержит ли месяц 28 дней в невисокосном году
                boolean has28DaysInNonLeapYear = (month == 2 && !isLeapYear);
        
                // Проверяем, является ли день допустимым для указанного месяца
                return (day >= 1 && day <= 31 && has31Days) ||
                       (day >= 1 && day <= 30 && has30Days) ||
                       (day >= 1 && day <= 29 && has29DaysInLeapYear) ||
                       (day >= 1 && day <= 28 && has28DaysInNonLeapYear);
            }
        }



