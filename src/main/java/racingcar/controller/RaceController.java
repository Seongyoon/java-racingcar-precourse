package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Car;
import racingcar.Race;

public class RaceController {
    private final Race race;

    public RaceController() {
        race = new Race();
    }

    public void raceStart() {
        do {
            initCars();
        } while (!race.isCarReady());

        do {
            initLaps();
        } while (!race.isRaceReady());

        System.out.println("실행 결과");
        race.race();

        printResult(race.getWinner());
    }

    private void initCars() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            race.setCarList(Console.readLine());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private void initLaps() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            race.setLap(Console.readLine());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private void printResult(List<Car> winner) {
        List<String> winnerNames = new ArrayList<>();
        for(Car car : winner) {
            winnerNames.add(car.getName());
        }

        System.out.print("최종 우승자: " + String.join(",", winnerNames));
    }
}
