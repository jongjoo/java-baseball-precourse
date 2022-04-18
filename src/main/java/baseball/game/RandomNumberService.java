package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberService {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> selectRandomNumber() {
        while (!isLimitSize()) {
            int randomNumber = Randoms.pickNumberInRange(GameConst.RANDOM_MIN_NUMBER, GameConst.RANDOM_MAX_NUMBER);
            addNumber(randomNumber);
        }
        return list;
    }

    private boolean isLimitSize() {
        return list.size() == GameConst.SIZE_NUMBER;
    }

    private void addNumber(int number) {
        if (!isContainNumber(number)) {
            list.add((int) String.valueOf(number).charAt(0));
        }
    }

    private boolean isContainNumber(int number) {
        return list.contains((int) String.valueOf(number).charAt(0));
    }
}
