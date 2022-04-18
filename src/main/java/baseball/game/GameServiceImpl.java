package baseball.game;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService{

    public void run() {
        String input = "";
        do {
            RandomNumberService randomNumberService = new RandomNumberService();
            List<Integer> randomList = randomNumberService.selectRandomNumber();
            gameCore(randomList);
            System.out.println(GameConst.CORRECT_ANSWER_MESSAGE);
            System.out.println(GameConst.RESTART_MESSAGE);
            input = Console.readLine();
        } while ("1".equals(input));
    }

    public void gameCore(List<Integer> randomList) {
        ClientScanService clientScanService = new ClientScanService();
        GameUtil gameUtil = new GameUtil();
        List<Integer> clientList = new ArrayList<>();
        do {
            clientList = clientScanService.scannerClientNumber();
        } while (gameUtil.compareGameNumber(randomList, clientList));

    }


}
