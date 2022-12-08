import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern datePattern = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");

        System.out.print("Enter a date: ");
        String userInput = scanner.nextLine();

        if (datePattern.matcher(userInput).matches()) {
            String[] dateParts = userInput.split("/");
            int day = Integer.parseInt(dateParts[0]);
            int month = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);

            if (isValidDate(day, month, year)) {
                System.out.println("The string is a valid date in the format dd/mm/yyyy.");
            } else {
                System.out.println("The string is not a valid date in the format dd/mm/yyyy.");
            }
        } else {
            System.out.println("The string is not a date in the format dd/mm/yyyy.");
        }
    }

    private static boolean isValidDate(int day, int month, int year) {
        // Check if year is a leap year
        boolean isLeapYear = LocalDate.of(year, 1, 1).isLeapYear();

        // Check if month has 31 days
        boolean has31Days = (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12);

        // Check if month has 30 days
        boolean has30Days = (month == 4 || month == 6 || month == 9 || month == 11);

        // Check if month has 29 days in a leap year
        boolean has29DaysInLeapYear = (month == 2 && isLeapYear);

        // Check if month has 28 days in a non-leap year
        boolean has28DaysInNonLeapYear = (month == 2 && !isLeapYear);

        // Check if day is valid for the specified month
        return (day >= 1 && day <= 31 && has31Days) ||
               (day >= 1 && day <= 30 && has30Days) ||
               (day >= 1 && day <= 29 && has29DaysInLeapYear) ||
               (day >= 1 && day <= 28 && has28DaysInNonLeapYear);
    }
}