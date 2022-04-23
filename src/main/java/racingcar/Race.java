package racingcar;

import java.util.List;
import racingcar.util.ErrorMessageUtil;
import racingcar.util.ValidationUtil;

public class Race {
    private RaceStatus raceStatus;
    private CarList cars;
    private int lap;

    public Race() {
        init();
    }

    public void setCarList(String carNames) {
        cars = new CarList(carNames);
        changeRaceStatus();
    }

    public void setLap(String lap) {
        ValidationUtil.validateInteger(lap);
        ValidationUtil.validatePositive(lap);
        this.lap = Integer.parseInt(lap);
        changeRaceStatus();
    }

    public void race() {
        checkRaceCondition();
        cars.race(lap);
        raceStatus = RaceStatus.RACE_END;
    }

    public List<Car> getWinner() {
        return cars.getTopRankers();
    }

    public boolean isCarReady() {
        return raceStatus.isCarReady();
    }

    public boolean isRaceReady() {
        return raceStatus.isRaceReady();
    }

    private void init() {
        raceStatus = RaceStatus.INIT;
        cars = new CarList();
        lap = 0;
    }

    private void changeRaceStatus() {
        if (!cars.isEmpty() && lap > 0) {
            raceStatus = RaceStatus.RACE_READY;
            return;
        }

        if (!cars.isEmpty()) {
            raceStatus = RaceStatus.CAR_READY;
            return;
        }

        if (lap > 0) {
            raceStatus = RaceStatus.LAP_READY;
        }
    }

    private void checkRaceCondition() {
        if (!raceStatus.isRaceReady()) {
            throw new IllegalStateException(ErrorMessageUtil.getMessage(
                    String.format("경주를 할 수 있는 상태가 아닙니다. carSize: %d, lap: %d", cars.size(), lap)));
        }
    }
}
