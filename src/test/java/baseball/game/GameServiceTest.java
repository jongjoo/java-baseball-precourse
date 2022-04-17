package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private final int SIZE_NUMBER = 3;
    private final int RANDOM_MIN_NUMBER = 1;
    private final int RANDOM_MAX_NUMBER = 9;
    private List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void gameCore() {
    }

    @DisplayName("랜덤한 리스트의 크기를 확인한다.")
    @Test
    void selectRandomNumberSize() {
        // given

        // when
        selectRandomNumber();

        // then
        assertEquals(SIZE_NUMBER, list.size(), "리스트 크기가 올바르지 않습니다.");
    }

    @DisplayName("서로 다른 랜덤한 3개의 숫자를 출력한다.")
    @Test
    void selectRandomNumberValid() {
        // given

        // when
        selectRandomNumber();
        Set<Integer> set = new HashSet<>(list);

        // then
        assertEquals(SIZE_NUMBER, set.size(), "서로 다른 값이 존재하지 않습니다.");
    }

    public void selectRandomNumber(){
        while (!isLimitSize()) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUMBER, RANDOM_MAX_NUMBER);
            addNumber(randomNumber);
        }
    }

    public boolean isLimitSize() {
        return list.size() == SIZE_NUMBER;
    }

    public void addNumber(int number) {
        if (!isContainNumber(number)) {
            list.add(number);
        }
    }

    public boolean isContainNumber(int number) {
        return list.contains(number);
    }


    @DisplayName("")
    @Test
    void scannerClientNumber() {


    }

    @Test
    void compareGameNumber() {
    }
}