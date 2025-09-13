package tddmicroexercises.leaderboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tddmicroexercises.leaderboard.TestData.*;

import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    public void isShouldCalculateDriverPoints() {
        // setup

        // act
        Race race1 = new Race("test race", driver1, driver2, driver3);

        // verify
        assertEquals(25, TestData.race1.getPoints(TestData.driver1));
        assertEquals(18, TestData.race1.getPoints(driver2));
        assertEquals(15, TestData.race1.getPoints(TestData.driver3));
    }

}
