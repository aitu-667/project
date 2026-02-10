package util;

public class Validators {
    public static boolean notEmpty(String s) {
        return s != null && !s.isBlank();
    }
}
