package baseball.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameUtilTest {

    @BeforeEach
    void setUp() {
    }


    @DisplayName("두값을 비교한다.")
    @ParameterizedTest
    @CsvSource(value = {"123:567", "123:153", "123:172", "123:312", "123:123"}, delimiter = ':')
    void compareGameNumber(String randomNumber, String inputNumber) {

        // given
        int strike = 0;
        int ball = 0;
        List<Integer> randomList = builderListInteger(randomNumber);
        List<Integer> inputList = builderListInteger(inputNumber);
        Set<Integer> randomSet = new HashSet<>(randomList);

        // when
        strike = compareTwoArray(randomList, inputList);
        ball = containListInSet(randomSet, inputList);
        ball -= strike;

        assertTrue(strike < 4, "스트라이크가 4보다 큽니다.");
        assertTrue(ball < 4, "볼이 4보다 큽니다.");
        assertTrue(strike > -1, "스트라이크가 -1보다 작습니다.");
        assertTrue(ball > -1, "볼이 -1보다 작습니다.");
    }

    public List<Integer> builderListInteger(String input) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            list.add((int) input.charAt(i));
        }

        return list;
    }

    public int compareTwoArray(List<Integer> firstList, List<Integer> secondList) {
        int count = 0;
        for (int i = 0; i < firstList.size(); i++) {
            count += compareTwoNumber(firstList.get(i), secondList.get(i));
        }
        return count;
    }

    public int compareTwoNumber(int i, int k) {
        if (i == k) {
            return 1;
        }
        return 0;
    }

    public int containListInSet(Set<Integer> randomSet, List<Integer> inputList) {
        int count = 0;
        for (Integer i : inputList) {
            count += containSetNumber(randomSet, i);
        }
        return count;
    }

    public int containSetNumber(Set<Integer> set, int i) {
        if (set.contains(i)) {
            return 1;
        }
        return 0;
    }
}