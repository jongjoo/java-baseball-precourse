package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientScanService {

    public List<Integer> scannerClientNumber() {
//        Scanner scanner = new Scanner(System.in);
//        String inputs = scanner.next();
        System.out.println("숫자를 입력해주세요");
        String inputs = Console.readLine();

        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < inputs.length(); i++) {
            inputList.add(Integer.valueOf(inputs.charAt(i)));
        }
        validCorrect(inputList);

        return inputList;
    }

    private void validCorrect(List<Integer> inputList) {
        validCorrectNumber(inputList);
        validCorrectInteger(inputList);
    }

    private void validCorrectNumber(List<Integer> inputList) {
        if (isDuplicateNumber(inputList)) {
            throw new IllegalArgumentException("서로 다른 값이 존재하지 않습니다");
        }
    }

    private boolean isDuplicateNumber(List<Integer> inputList) {
        Set<Integer> set = new HashSet<>(inputList);
        if (set.size() == GameConst.SIZE_NUMBER) {
            return false;
        }
        return true;
    }

    private void validCorrectInteger(List<Integer> inputList) {
        int size = 0;
        for (int i = 0; i < inputList.size(); i++) {
            size += isInteger(inputList.get(i));
        }
        if (size < GameConst.SIZE_NUMBER) {
            throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
        }
    }

    private int isInteger(int number) {
        if (number > GameConst.ASCII_ZERO_NUMBER && number < GameConst.ASCII_TEN_NUMBER) {
            return 1;
        }
        return 0;
    }
}
