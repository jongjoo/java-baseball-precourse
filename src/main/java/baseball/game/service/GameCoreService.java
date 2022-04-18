package baseball.game.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameCoreService {

    public boolean compareGameNumber(List<Integer> randomList, List<Integer> inputList) {
        int strike = 0;
        int ball = 0;
        Set<Integer> randomSet = new HashSet<>(randomList);
        strike = compareTwoArray(randomList, inputList);
        ball = containListInSet(randomSet, inputList);
        ball -= strike;
        sendMessage(strike, ball);
        return sendResult(strike);
    }

    private int compareTwoArray(List<Integer> firstList, List<Integer> secondList) {
        int count = 0;
        for (int i = 0; i < firstList.size(); i++) {
            count += compareTwoNumber(firstList.get(i), secondList.get(i));
        }
        return count;
    }

    private int compareTwoNumber(int i, int k) {
        if (i == k) {
            return 1;
        }
        return 0;
    }

    private int containListInSet(Set<Integer> randomSet, List<Integer> inputList) {
        int count = 0;
        for (Integer i : inputList) {
            count += containSetNumber(randomSet, i);
        }
        return count;
    }

    private int containSetNumber(Set<Integer> set, int i) {
        if (set.contains(i)) {
            return 1;
        }
        return 0;
    }

    private void sendMessage(int strike, int ball) {
        StringBuilder stringBuilder = new StringBuilder();
        builderBallMessage(stringBuilder, ball);
        builderStrikeMessage(stringBuilder, strike, ball);
        builderNotThingMessage(stringBuilder, strike, ball);
        System.out.println(stringBuilder);
    }

    private StringBuilder builderBallMessage(StringBuilder stringBuilder, int ball) {
        if (ball > 0) {
            stringBuilder.append(ball).append("볼");
        }
        return stringBuilder;
    }

    private StringBuilder builderStrikeMessage(StringBuilder stringBuilder, int strike, int ball) {
        if (strike > 0) {
            builderEmptyMessage(stringBuilder, ball);
            stringBuilder.append(strike).append("스트라이크");
        }
        return stringBuilder;
    }

    private StringBuilder builderEmptyMessage(StringBuilder stringBuilder, int ball) {
        if (ball > 0) {
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }

    private StringBuilder builderNotThingMessage(StringBuilder stringBuilder, int strike, int ball) {
        if (strike == 0 && ball == 0) {
            stringBuilder.append("낫싱");
        }
        return stringBuilder;
    }

    private boolean sendResult(int strike) {
        if (strike == 3) {
            return false;
        }
        return true;
    }
}
