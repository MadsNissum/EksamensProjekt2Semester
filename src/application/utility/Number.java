package application.utility;

public class Number {
    public static int checker(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            number = -1;
        }
        return number;
    }
}
