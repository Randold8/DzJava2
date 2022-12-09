import java.util.regex.Pattern;
import java.util.Scanner;

public class task2 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
String password;
// Проверка надежности пароля
do {
System.out.println("Введите пароль: ");
password = sc.nextLine();

if (password.length() < 8) {
System.out.println("Пароль слишком короткий. Введите пароль, содержащий не менее 8 символов.");
} else if (!Pattern.matches("^[0-9a-zA-Z_]+$", password)) {
System.out.println("Пароль может состоять только из цифр, букв и знака подчеркивания.");
} else if (!Pattern.matches("^(.*[a-z])(.*[A-Z])(.*[0-9]).*$", password)) {
System.out.println("Пароль должен содержать хотя бы одну маленькую букву, одну заглавную букву и одну цифру.");
}
} while (password.length() < 8 || !Pattern.matches("^[0-9a-zA-Z_]+$", password) || !Pattern.matches("^(.*[a-z])(.*[A-Z])(.*[0-9]).*$", password));

System.out.println("Ваш пароль надежный.");
}
} 
