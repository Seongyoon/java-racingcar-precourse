package racingcar.util;

public class ValidationUtil {
    private ValidationUtil() {
    }

    public static void validateNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage("입력된 값이 없습니다."));
        }
    }

    public static void validateRestrictString(String input, String restrictString) {
        if (input.contains(restrictString)) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format("'%s'는 허용되지 않은 문자입니다. input: %s", restrictString, input)));
        }
    }

    public static void validateLength(String input, int minLength, int maxLength) {
        String trimmedName = input.trim();
        if (minLength > trimmedName.length() || trimmedName.length() > maxLength) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format("앞뒤 공백을 제외하고 %d~%d 사이의 길이의 값을 입력해주세요. input: %s", minLength, maxLength,
                            input)));
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format("0보다 크고 %d보다 작은 수를 입력해주세요. input: %s", Integer.MAX_VALUE, input)));
        }
    }

    public static void validatePositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format("양수를 입력해주세요. input: %s", input)));
        }
    }
}
