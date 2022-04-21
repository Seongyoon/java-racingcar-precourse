package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.ValidationUtil;

public class Race {
    private static final String NAME_DELIMITER = ",";
    private List<Car> list;
    private int raceCount;

    public Race() {
        init();
    }

    public int getRegisteredCarCount() {
        return this.list.size();
    }

    private void init() {
        list = new ArrayList<>();
        raceCount = 0;
    }

    void carRegistration(String cars) {
        validateCars(cars);
        for(String carName : cars.split(NAME_DELIMITER)) {
            list.add(new Car(carName.trim()));
        }
    }

    void setRaceCount(String raceCount) {
        ValidationUtil.validateInteger(raceCount);
        ValidationUtil.validatePositive(raceCount);
        this.raceCount = Integer.parseInt(raceCount);
    }

    private void validateCars(String cars) {
        ValidationUtil.validateNull(cars);
    }
}
