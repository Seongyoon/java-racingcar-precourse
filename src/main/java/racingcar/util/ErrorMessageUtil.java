package racingcar.util;

public class ErrorMessageUtil {
    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]";

    private ErrorMessageUtil() {
    }

    public static String getMessage(String message) {
        return String.format("%s %s", ERROR_MESSAGE_PREFIX, message);
    }
}
