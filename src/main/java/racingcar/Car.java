package racingcar;

import racingcar.util.ErrorMessageUtil;

public class Car {
    private static final int NAME_LENGTH_MIN = 1;
    private static final int NAME_LENGTH_MAX = 5;
    private static final String NAME_DELIMITER = ",";
    private static final String DISTANCE_CHARACTER = "-";
    private final String name;
    private final Engine engine;
    private int distance;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.distance = 0;
        this.engine = new Engine();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void goForward() {
        if (engine.isWorking()) {
            distance += 1;
        }
    }

    public String getCurrentResult() {
        return String.format("%s: %s", name, getDistanceCharacter());
    }

    private String getDistanceCharacter() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            sb.append(DISTANCE_CHARACTER);
        }
        return sb.toString();
    }


    private void validate(String name) {
        validateNull(name);
        validateDelimiter(name);
        validateLength(name);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage("주어진 이름이 없습니다."));
        }
    }

    private void validateDelimiter(String name) {
        if (name.contains(NAME_DELIMITER)) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format("이름에 구분자(콤마)가 들어가면 안됩니다. name: %s", name)));
        }
    }

    private void validateLength(String name) {
        String trimmedName = name.trim();
        if (NAME_LENGTH_MIN > trimmedName.length() || trimmedName.length() > NAME_LENGTH_MAX) {
            throw new IllegalArgumentException(ErrorMessageUtil.getMessage(
                    String.format("앞뒤 공백을 제거한 이름의 길이는 %d~%d 사이여야 합니다. name: %s", NAME_LENGTH_MIN, NAME_LENGTH_MAX,
                            name)));
        }
    }
}
