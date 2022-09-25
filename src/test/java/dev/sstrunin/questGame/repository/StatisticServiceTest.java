package dev.sstrunin.questGame.repository;

import dev.sstrunin.questGame.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatisticServiceTest {
    StatisticService statisticService = new StatisticService();
    User testUser = new User("testUser");


    @Test
    void testChangingResultString() {
        addTestData();
        String expected = "testUser : 5 1";
        String actual = statisticService.getUserStatistic(testUser);

        assertEquals(expected,actual);
    }
    @Test
    void testWinLoseCount(){
        addTestData();
        int expectedWin = 5;
        int expectedLose = 1;
        int actualWin = statisticService.winCount(testUser);
        int actualLose = statisticService.loseCount(testUser);
        assertEquals(expectedWin,actualWin);
        assertEquals(expectedLose,actualLose);
    }

    @Test
    void checkCountAttempt() {
        addTestData();
        int actual = statisticService.countOfAttempt(testUser);
        int expected = 6;
        assertEquals(expected,actual);
    }
    private void addTestData(){
        statisticService.addUserToStatistic(testUser);
        for (int i = 0; i < 5 ; i++){
            statisticService.addStatistic(testUser, StatisticService.Result.WIN);
        }
        statisticService.addStatistic(testUser, StatisticService.Result.LOSE);
    }

}