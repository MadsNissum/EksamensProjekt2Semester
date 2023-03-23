package application.utility;

public class Number {
    public static int checkerInt(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            number = -1;
        }
        return number;
    }

    public static double checkerDouble(String str) {
        double number;
        try {
            number = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            number = -1;
        }
        return number;
    }
}
