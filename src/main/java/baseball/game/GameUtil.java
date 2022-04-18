package baseball.game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameUtil {

    public boolean compareGameNumber(List<Integer> randomList, List<Integer> inputList) {
        int strike = 0;
        int ball = 0;
        Set<Integer> randomSet = new HashSet<>(randomList);
        strike = compareTwoArray(randomList, inputList);
        ball = containListInSet(randomSet, inputList);
        ball -= strike;

        System.out.println(randomList + " - " + inputList);

        sendMessage(strike, ball);
        return sendResult(strike);
    }

    private List<Integer> builderListInteger(String input) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            list.add((int) input.charAt(i));
        }

        return list;
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

        if (strike > 0) {
            stringBuilder.append(strike).append("스트라이크");
        }
        if (ball > 0) {
            stringBuilder.append(ball).append("볼");
        }
        if (strike == 0 && ball == 0) {
            stringBuilder.append("낫싱");
        }
        System.out.println(stringBuilder);
    }

    private boolean sendResult(int strike) {
        if (strike == 3) {
            return false;
        }
        return true;
    }
}
