package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.ValidationUtil;

public class CarList {
    private static final String NAME_DELIMITER = ",";

    private List<Car> cars;

    public CarList() {
        init();
    }

    public CarList(String carNames) {
        init();
        validateCars(carNames);
        for (String carName : carNames.split(NAME_DELIMITER)) {
            cars.add(new Car(carName.trim()));
        }
    }

    public void init() {
        cars = new ArrayList<>();
    }

    public int size() {
        return cars.size();
    }

    public void race(int lap) {
        for (int i = 0; i < lap; i++) {
            raceOneLap();
        }
    }

    public void raceOneLap() {
        for (Car car : cars) {
            car.goForwardAndPrint();
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    private void validateCars(String carNames) {
        ValidationUtil.validateNull(carNames);
    }
}
