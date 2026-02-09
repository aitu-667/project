package util;

public class InputValidator {

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isPositiveInteger(String input) {
        try {
            int val = Integer.parseInt(input);
            return val > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
