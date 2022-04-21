package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RaceTest {
    private final static String MAX_INTEGER_STRING = String.valueOf(Integer.MIN_VALUE);

    @Test
    void 자동차_등록성공() {
        Race race = new Race();
        Assertions.assertDoesNotThrow(() -> race.carRegistration("app, bob, curry"));
        Assertions.assertDoesNotThrow(() -> race.carRegistration("app,bob,curry"));
    }

    @Test
    void 자동차_등록실패() {
        Race race = new Race();
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.carRegistration("appapp, bob, curry"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.carRegistration("app,bob,,curry"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.carRegistration("app,bob,cu ry"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.carRegistration(null));
    }

    @Test
    void 자동차_정상등록_확인() {
        Race race = new Race();
        race.carRegistration("app, bob, curry");
        Assertions.assertEquals(race.getRegisteredCarCount(), ("app, bob, curry".split(",")).length);
    }

    @Test
    void 전진횟수_등록_성공() {
        Race race = new Race();
        Assertions.assertDoesNotThrow(() -> race.setRaceCount("1"));
        Assertions.assertDoesNotThrow(() -> race.setRaceCount(String.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    void 전진횟수_등록_실패() {
        Race race = new Race();
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.setRaceCount("0"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> race.setRaceCount(MAX_INTEGER_STRING));
    }
}
