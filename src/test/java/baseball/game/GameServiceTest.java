package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    public void selectRandomNumber() {
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


    @DisplayName("사용자에게 올바른 3개의 숫자를 받았는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "126", "513"})
    void scannerClientNumber(String inputs) {

        // given
        // when
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < inputs.length(); i++){
            inputList.add((int) inputs.charAt(i));
        }
        isDuplicateNumber(inputList);

        // then
        assertEquals(SIZE_NUMBER, inputList.size(), "서로 다른 값이 존재하지 않습니다.");
    }

    public boolean isDuplicateNumber(List<Integer> inputList){
        Set<Integer> set = new HashSet<>(inputList);
        if(set.size() == SIZE_NUMBER){
            return true;
        }
        return false;
    }

    @DisplayName("두값을 비교한다.")
    @ParameterizedTest
    @CsvSource(value = {"123:567", "123:153", "123:172", "123:325", "123:123"}, delimiter = ':')
    void compareGameNumber(String randomNumber, String inputNumber) {

        
    }
}