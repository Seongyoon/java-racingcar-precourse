package racingcar;

import java.util.List;
import racingcar.util.ErrorMessageUtil;
import racingcar.util.ValidationUtil;

public class Race {
    private CarList cars;
    private int lap;

    public Race() {
        init();
    }

    public void race() {
        checkRaceCondition();
        cars.race(lap);
    }

    public List<Car> getWinner() {
        return cars.getTopRankers();
    }

    private void init() {
        cars = new CarList();
        lap = 0;
    }

    void setCarList(String carNames) {
        cars = new CarList(carNames);
    }

    void setLap(String lap) {
        ValidationUtil.validateInteger(lap);
        ValidationUtil.validatePositive(lap);
        this.lap = Integer.parseInt(lap);
    }

    private void checkRaceCondition() {
        if (cars.isEmpty() || lap < 1) {
            throw new IllegalStateException(ErrorMessageUtil.getMessage(
                    String.format("경주를 할 수 있는 상태가 아닙니다. carSize: %d, lap: %d", cars.size(), lap)));
        }
    }
}
