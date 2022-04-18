package baseball.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ClientScanServiceTest {



    @BeforeEach
    void setUp() {
    }

    @DisplayName("사용자에게 올바른 3개의 숫자를 받았는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789", "126", "513"})
    void validCorrectNumber(String inputs) {

        // given
        // when
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < inputs.length(); i++) {
            inputList.add((int) inputs.charAt(i));
        }
        isDuplicateNumber(inputList);

        // then
        assertEquals(GameConst.SIZE_NUMBER, inputList.size(), "서로 다른 값이 존재하지 않습니다.");
    }

    public boolean isDuplicateNumber(List<Integer> inputList) {
        Set<Integer> set = new HashSet<>(inputList);
        if (set.size() == GameConst.SIZE_NUMBER) {
            return true;
        }
        return false;
    }

    @DisplayName("사용자에게 올바른 3개의 숫자를 받았는지 확인한다. - Integer")
    @ParameterizedTest
    @ValueSource(strings = {"우테프", "야구겜", "승리한", "문자다"})
    public void validCorrectInteger(String inputList) {
        int size = 0;
        for (int i = 0; i < inputList.length(); i++) {
            size += isInteger(inputList.charAt(i));
        }

        final int finalSize = size;
        assertThatThrownBy(() -> {
            if (finalSize < GameConst.SIZE_NUMBER) {
                throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자가 아닌 값이 입력되었습니다.");
    }

    public int isInteger(int number) {
        if (number > GameConst.ASCII_ZERO_NUMBER && number < GameConst.ASCII_TEN_NUMBER) {
            return 1;
        }
        return 0;
    }
}