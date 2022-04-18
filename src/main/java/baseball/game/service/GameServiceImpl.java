package baseball.game.service;

import baseball.game.constant.GameConst;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameServiceImpl implements GameService {

    public void run() {
        String input = "";
        do {
            RandomNumberService randomNumberService = new RandomNumberService();
            List<Integer> randomList = randomNumberService.selectRandomNumber();
            gameCore(randomList);
            printStartMessage();
            input = Console.readLine();
        } while ("1".equals(input));
        printEndMessage();
    }

    private void gameCore(List<Integer> randomList) {
        ClientScanService clientScanService = new ClientScanService();
        GameCoreService gameCoreService = new GameCoreService();
        List<Integer> clientList = new ArrayList<>();
        do {
            clientList = clientScanService.scannerClientNumber();
        } while (gameCoreService.compareGameNumber(randomList, clientList));
    }

    private void printStartMessage() {
        System.out.println(GameConst.CORRECT_ANSWER_MESSAGE);
        System.out.println(GameConst.RESTART_MESSAGE);
    }

    private void printEndMessage() {
        System.out.println(GameConst.GAME_OVER_MESSAGE);
    }


}
