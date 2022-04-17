package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberServiceTest {



    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @DisplayName("랜덤한 리스트의 크기를 확인한다.")
    @Test
    void selectRandomNumberSize() {
        // given

        // when
        selectRandomNumber();

        // then
        assertEquals(GameConst.SIZE_NUMBER, list.size(), "리스트 크기가 올바르지 않습니다.");
    }

    @DisplayName("서로 다른 랜덤한 3개의 숫자를 출력한다.")
    @Test
    void selectRandomNumberValid() {
        // given

        // when
        selectRandomNumber();
        Set<Integer> set = new HashSet<>(list);

        // then
        assertEquals(GameConst.SIZE_NUMBER, set.size(), "서로 다른 값이 존재하지 않습니다.");
    }

    public void selectRandomNumber() {
        while (!isLimitSize()) {
            int randomNumber = Randoms.pickNumberInRange(GameConst.RANDOM_MIN_NUMBER, GameConst.RANDOM_MAX_NUMBER);
            addNumber(randomNumber);
        }
    }


    public boolean isLimitSize() {
        return list.size() == GameConst.SIZE_NUMBER;
    }

    public void addNumber(int number) {
        if (!isContainNumber(number)) {
            list.add(number);
        }
    }

    public boolean isContainNumber(int number) {
        return list.contains(number);
    }
}