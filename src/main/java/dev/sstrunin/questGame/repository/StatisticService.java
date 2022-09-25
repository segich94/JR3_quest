package dev.sstrunin.questGame.repository;

import dev.sstrunin.questGame.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;

public class StatisticService {
    private static final Logger LOGGER = LogManager.getLogger(StatisticService.class);
    private static final HashMap<String, String> statistic = new HashMap<>();

    public void addUserToStatistic(User user){
        statistic.put(user.getUsername(), "0 0");
    }

    public void addStatistic(User user, Result result) {
        statistic.put(user.getUsername(),
                changeResultString(statistic.getOrDefault(user.getUsername(), "0 0"), result));
        LOGGER.info("Add to statistic - " + user.getUsername() + ":" + result);
    }

    public String getUserStatistic(User user) {
        if (statistic.containsKey(user.getUsername())) {
            return user.getUsername() + " : " + statistic.get(user.getUsername());
        } else {
            return user.getUsername() + " : 0 0";
        }
    }

    private String changeResultString(String fromMap, Result result) {
        String[] parseResult = fromMap.split(" ");
        int win = Integer.parseInt(parseResult[0]);
        int lose = Integer.parseInt(parseResult[1]);

        if (result == Result.WIN) {
            win++;
        } else {
            lose++;
        }
        return win + " " + lose;
    }

    public int winCount(User user) {
        return countResult(user, Result.WIN);
    }

    public int loseCount(User user) {
        return countResult(user, Result.LOSE);
    }

    private int countResult(User user, Result result) {
        String[] attempts;
        if (!statistic.containsKey(user.getUsername())) {
            return 0;
        } else {
            attempts = statistic.get(user.getUsername()).split(" ");
            if (result.equals(Result.WIN)) {
                return Integer.parseInt(attempts[0]);
            } else {
                return Integer.parseInt(attempts[1]);
            }
        }
    }

    public int countOfAttempt(User user) {
        return winCount(user) + loseCount(user);
    }

    public enum Result {
        WIN,
        LOSE
    }
}
